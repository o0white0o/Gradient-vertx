package com.o0white0o.gradientdescent;

import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class GradientDescent {

    public static void printThetas(List<Double> thetas) {
        System.out.print("Thetas: ");
        for (Double theta: thetas)
            System.out.print(theta.toString()+"\t");
    }

    public static boolean isConvergence(double oldCostFunction, double newCostFunction, double convergence) {
        return Math.abs(newCostFunction - oldCostFunction) < convergence;
    }

    public static double calculationCostFunction(List<Double> thetas, Tuple2<List<List<Double>>,List<Double>> setOfPoints) {
        double residualSquareSum = 0;
        List<List<Double>> vectorRegressors = setOfPoints._1();
        List<Double> vectorValues = setOfPoints._2();
        for(int i = 0; i < vectorValues.size();i++){
            double residual = calculationDifferenceValue(thetas, vectorRegressors.get(i),vectorValues.get(i));
            residualSquareSum += residual * residual;
        }
        return residualSquareSum / 2 * vectorValues.size();
    }

    private static double calculationDifferenceValue(List<Double> thetas, List<Double> regressors, Double value){
        double presentValue = 0;
        for(int i = 0; i < regressors.size(); i++){
            presentValue += thetas.get(i)*regressors.get(i);
        }
        presentValue+=thetas.get(thetas.size()-1);
        return presentValue - value;
    }

    public static double updateGradientStep(List<Double> oldThetas, List<Double> newThetas,
                                            List<Double> oldGradient, List<Double> newGradient) {
        return Math.abs(
                dotProduct(difference(newThetas, oldThetas), difference(newGradient, oldGradient))
                        / distanceSquare(newGradient, oldGradient)
        );
    }



    private static double dotProduct(List<Double> xs, List<Double> ys) {
        return zipWith(xs, ys, (x, y) -> x * y).stream().reduce(0.0, Double::sum);
    }

    private static double distanceSquare(List<Double> xs, List<Double> ys) {
        return zipWith(xs, ys, (x, y) -> (x - y) * (x - y)).stream().reduce(0.0, Double::sum);
    }

    private static List<Double> difference(List<Double> xs, List<Double> ys) {
        return zipWith(xs, ys, (x, y) -> x - y);
    }

    private static <A, B, R> List<R> zipWith(List<A> x, List<B> y, BiFunction<A, B, R> function) {
        assert x.size() == y.size();

        List<R> result = new ArrayList<>(x.size());
        for (int i = 0; i < x.size(); i++) {
            result.add(function.apply(x.get(i), y.get(i)));
        }
        return result;
    }

}

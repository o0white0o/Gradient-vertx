package com.o0white0o.gradientdescent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class GradientDescent {

    public static boolean isConvergence(double oldCostFunction, double newCostFunction, double convergence) {
        return Math.abs(newCostFunction - oldCostFunction) < convergence;
    }

    public static double dotProduct(List<Double> xs, List<Double> ys) {
        return zipWith(xs, ys, (x, y) -> x * y).stream().reduce(0.0, Double::sum);
    }

    private static double distanceSquare(List<Double> xs, List<Double> ys) {
        return zipWith(xs, ys, (x, y) -> (x - y) * (x - y)).stream().reduce(0.0, Double::sum);
    }

    private static List<Double> difference(List<Double> xs, List<Double> ys) {
        return zipWith(xs, ys, (x, y) -> x - y);
    }

    public static <A, B, R> List<R> zipWith(List<A> x, List<B> y, BiFunction<A, B, R> function) {
        assert x.size() == y.size();

        List<R> result = new ArrayList<>(x.size());
        for (int i = 0; i < x.size(); i++) {
            result.add(function.apply(x.get(i), y.get(i)));
        }
        return result;
    }
}

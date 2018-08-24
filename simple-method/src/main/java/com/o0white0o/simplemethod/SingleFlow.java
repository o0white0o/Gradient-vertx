package com.o0white0o.simplemethod;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import scala.Tuple2;
import com.o0white0o.functions.LoadData;
import com.o0white0o.gradientdescent.GradientDescent;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleFlow extends AbstractVerticle {
    private Tuple2<List<List<Double>>,List<Double>> setOfPoints;
    private static double CONVERGENCE = 0.000001;


    @Override
    public void start(Future<Void> future) throws Exception {
        long startTime = System.currentTimeMillis();
        setOfPoints = new LoadData("../set_of_points.data").getSetOfPoints();
        List<List<Double>> vectorRegressors = setOfPoints._1();
        List<Double> vectorValues = setOfPoints._2();
        List<Double> newTheta
                = new ArrayList<>(Collections.nCopies(vectorRegressors.get(0).size()+1,1.0));
        double newCostValue = GradientDescent.calculationCostFunction(newTheta,setOfPoints);
        List<Double> newGradient = null;
        List<Double> oldWeights = null;
        double oldCostValue;
        List<Double> oldGradient;
        int iterations = 0;
        do{
            ++iterations;
            oldGradient = newGradient;
            newGradient =new ArrayList<>();
            for(int i = 0; i < newTheta.size(); i++){
                List<Double> copyTheta = newTheta;
                //
                //
                //
                //
            }
            oldCostValue = newCostValue;
            newCostValue = GradientDescent.calculationCostFunction(newTheta,setOfPoints);
        }while (!GradientDescent.isConvergence(oldCostValue,newCostValue,CONVERGENCE));
        printResult(newTheta, startTime, iterations);
    }
    public static void printResult(List<Double> thetas, long startTime, int iterations) {
        System.out.printf("Optimizing finished (%d ms)\n\n", System.currentTimeMillis() - startTime);
        System.out.println("Amount of iterations: " + iterations +"\n");
        GradientDescent.printThetas(thetas);
    }

}

package com.o0white0o.simplemethod;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import scala.Tuple2;
import com.o0white0o.functions.LoadData;


import java.util.List;

public class SingleFlow extends AbstractVerticle {
    private Tuple2<List<List<Double>>,List<Double>> setOfPoints;


    @Override
    public void start(Future<Void> future) throws Exception {
        setOfPoints = new LoadData("../set_of_points.data").getSetOfPoints();
        List<List<Double>> vectorRegressors = setOfPoints._1();
        List<Double> vectorValues = setOfPoints._2();
        long startTime = System.currentTimeMillis();
        for (Double value:vectorValues) {

        }

    }

}

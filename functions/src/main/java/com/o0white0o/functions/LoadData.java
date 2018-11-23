package com.o0white0o.functions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import scala.Tuple2;

public class LoadData {
    private String nameInputFile;
    private Tuple2<List<List<Double>>,List<Double>> setOfPoints;

    public LoadData(String nameInputFile) throws IOException {
        this.nameInputFile = nameInputFile;
            DataInputStream stream =
                    new DataInputStream(new BufferedInputStream(new FileInputStream(nameInputFile)));
            int dataLenght = stream.readInt();
            int numberOfRegressors = stream.readInt();

            List<List<Double>> vectorRegressors = new ArrayList<>();
            List<Double> vectorValues= new ArrayList<>();

            for(int i=0; i< dataLenght; i++) {
                List<Double> currentRegressors = new ArrayList<>();
                for (int j = 0; j < numberOfRegressors; j++) {
                    currentRegressors.add(stream.readDouble());
                }
                vectorValues.add(stream.readDouble());
            }
            this.setOfPoints = new Tuple2<>(vectorRegressors,vectorValues);

    }

    public Tuple2<List<List<Double>>,List<Double>> getSetOfPoints(){
        return setOfPoints;
    }
}

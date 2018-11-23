package com.o0white0o.pointgenerator;

import java.io.*;
import java.util.Random;
import java.util.Vector;

public class PointGenerator {
    private static String NAME_OUTPUT_FILES = "set_of_points.data";
    private static int DATA_LENGHT = 1000000;
    private static int NUMBER_OF_REGRESSORS = 5;
    private static double MAX_THETA = 100.0;
    private static double MAX_REGRESSOR = 100.0;
    private String nameOutputFiles;
    private int dataLenght;
    private int numberOfRegressors;
    private double maxTheta;
    private double maxRegressor;


    private PointGenerator(String nameOutputFiles,
                           int dataLenght,
                           int numberOfRegressors,
                           double maxTheta,
                           double maxRegressor){
        this.dataLenght = dataLenght;
        this.numberOfRegressors = numberOfRegressors;
        this.maxTheta = maxTheta;
        this.maxRegressor = maxRegressor;
        this.nameOutputFiles = nameOutputFiles;
    }

    public static void main (String[] args){
        PointGenerator newSequence = parsingCommandLineArguments(args);
        try {
            newSequence.generateOutputData();
        } catch (FileNotFoundException e) {
            System.err.println("Could not create a file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception happened while writing to the file: " + e.getLocalizedMessage());
        }
    }

    private static PointGenerator parsingCommandLineArguments(String[] args){
        String nameOutputFiles = (args.length > 0) ? args[0] : NAME_OUTPUT_FILES;
        int dataLenght = (args.length > 1) ? Integer.parseInt(args[1]) : DATA_LENGHT;
        int numberOfRegressors = (args.length > 2) ? Integer.parseInt(args[2]) : NUMBER_OF_REGRESSORS;
        double maxTheta = (args.length > 3) ? Double.parseDouble(args[3]) : MAX_THETA;
        double maxRegressor = (args.length > 4) ? Double.parseDouble(args[4]) : MAX_REGRESSOR;
        return new PointGenerator(nameOutputFiles,
                dataLenght,
                numberOfRegressors,
                maxTheta,
                maxRegressor);
    }

    private void generateOutputData() throws IOException  {
        Vector<Double> theta = generatePoints(numberOfRegressors+1,maxTheta);
        try (DataOutputStream stream =
                     new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nameOutputFiles)))) {
            stream.writeInt(dataLenght);
            stream.writeInt(numberOfRegressors);
            for(int i = 0; i < dataLenght; i++) {
                Vector<Double> regressors = generatePoints(numberOfRegressors, maxRegressor);
                regressors.add(getSolution(theta,regressors));
                for(int j = 0; j< regressors.size(); j++)
                    stream.writeDouble(regressors.get(j));
            }
        }
        System.out.println("Successful");
        System.out.println("Data lenght: " + dataLenght);
        System.out.print("Theta: ");
        for(int i = 0; i<theta.size();i++)
            System.out.print(theta.get(i).toString()+"\t");
        System.out.println("");
    }

    private static Vector<Double> generatePoints(int number, double maxValue ){
        Random random = new Random();
        Vector<Double> point = new Vector<Double>();
        for(int i = 0; i < number; i++) {
            double nextDouble = -maxValue +(maxValue*2)*random.nextDouble();
            point.add(nextDouble);
        }
        return point;
    }

    private static double getSolution(Vector<Double> theta, Vector<Double> regressors){
        double sum = 0.0;
        for(int i = 0; i < regressors.size(); i++){
            sum += theta.get(i) * regressors.get(i);
        }
        sum += theta.get(theta.size()-1);
        return sum;
    }
}



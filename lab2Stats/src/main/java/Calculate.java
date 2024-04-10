/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2stats;

import java.util.ArrayList;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.correlation.Covariance;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


/**
 *
 * @author annamutovkina
 */
public class Calculate {
    private DescriptiveStatistics addToDescroptoinStat(ArrayList<Double> data){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Double value : data) {
            stats.addValue(value);
        }
        return stats;
    }
    private Double calculateGeomMean(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getGeometricMean();
    }
    private Double calculateMean(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getMean();
    }
    private Double calculateVariance(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getVariance();
    }
    private Double calculateSd(ArrayList<Double> array) {
      return addToDescroptoinStat(array).getStandardDeviation();
    }
    private Double calculateMin(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getMin();
    }
    private Double calculateMax(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getMax();
    }
    private Integer calculateLenght(ArrayList<Double> array) {
        return array.size();
    }
    private Double calculateScope(ArrayList<Double> array){
        return calculateMax(array) - calculateMin(array);
    }
    private Double calculateVarianceСoefficient(ArrayList<Double> array){
        return calculateSd(array) / calculateMean(array);
    }
    private Double calculateCovariation(ArrayList<Double> array, ArrayList<Double> array2) {
        Covariance cov = new Covariance();
        double[] x = new double[array.size()];
        double[] y = new double[array2.size()];
        for (int i = 0; i < array.size(); i++) {
            x[i] = array.get(i);
            y[i] = array2.get(i);
        }
        return cov.covariance(x, y);
    }

    private double[] calculateConfidenceInterval(ArrayList<Double> array) {
        double mean = calculateMean(array);
        double sd = calculateSd(array);
        NormalDistribution normalDistribution = new NormalDistribution();
        int sampleSize = calculateLenght(array);
        double confidenceLevel = 0.95;
        double z = normalDistribution.inverseCumulativeProbability(1.0 - confidenceLevel / 2.0);
        double lowerBound = mean - z * sd / Math.sqrt(sampleSize);
        double upperBound = mean + z * sd / Math.sqrt(sampleSize);
        return new double[]{lowerBound,upperBound};
    }
    public ArrayList<ArrayList<Double>> addStatisticToList(ArrayList<ArrayList<Double>> array) {
        ArrayList<ArrayList<Double>> stats = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            ArrayList<Double> currentStats = new ArrayList<>();
            currentStats.add(calculateGeomMean(array.get(i)));
            currentStats.add(calculateMean(array.get(i)));
            currentStats.add(calculateSd(array.get(i)));
            currentStats.add(calculateScope(array.get(i)));
            currentStats.add(calculateLenght(array.get(i)).doubleValue());
            currentStats.add(calculateVarianceСoefficient(array.get(i)));
            currentStats.add(calculateConfidenceInterval(array.get(i))[0]);
            currentStats.add(calculateConfidenceInterval(array.get(i))[1]);
            currentStats.add(calculateVariance(array.get(i)));
            currentStats.add(calculateMax(array.get(i)));
            currentStats.add(calculateMin(array.get(i)));
            for (int j = 0; j < array.size(); j++) {
                currentStats.add(calculateCovariation(array.get(i), array.get(j)));

            }

            stats.add(currentStats);
        }
        return stats;
    }

}

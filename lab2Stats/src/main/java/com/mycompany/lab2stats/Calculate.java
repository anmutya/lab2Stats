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
    public Double calculateGeomMean(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getGeometricMean();
    }
    public Double calculateMean(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getMean();
    }
    public Double calculateVariance(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getVariance();
    }
    public Double calculateSd(ArrayList<Double> array) {
      return addToDescroptoinStat(array).getStandardDeviation();
    }
    public Double calculateMin(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getMin();
    }
    public Double calculateMax(ArrayList<Double> array) {
        return addToDescroptoinStat(array).getMax();
    }
    public Integer calculateLenght(ArrayList<Double> array) {
        return array.size();
    }
    public Double calculateScope(ArrayList<Double> array){
        return calculateMax(array) - calculateMin(array);
    }
      public Double calculateVarianceСoefficient(ArrayList<Double> array){
        return calculateSd(array) / calculateMean(array);
    }
    public Double calculateCovariation(ArrayList<Double> array, ArrayList<Double> array2) {
        Covariance cov = new Covariance();
        double[] x = new double[array.size()];
        double[] y = new double[array2.size()];
        for (int i = 0; i < array.size(); i++) {
            x[i] = array.get(i);
            y[i] = array2.get(i);
        }
        return cov.covariance(x, y);
    }

    public double[] calculateConfidenceInterval(ArrayList<Double> array) {
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
    
}

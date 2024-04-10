/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2stats;
import java.util.ArrayList;
/**
 *
 * @author annamutovkina
 */
public class Samples {
    private ArrayList<ArrayList<Double>> samples;
    public void setSamples(ArrayList<ArrayList<Double>> samples){
        this.samples = samples;
    }
 
    public ArrayList<ArrayList<Double>> getSamples() {
          return this.samples;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2stats;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annamutovkina
 */
public class Manager {
    private Samples samples = new Samples();
    private Calculate calculator = new Calculate();
    private ExcelProvider provider = new ExcelProvider();
    public void importExcel(String path){
        try {
            ArrayList<ArrayList<Double>> list = provider.readFromXLSX(path);
            this.samples.setSamples(list);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exportFile(){
        ArrayList<ArrayList<Double>> stats = calculator.addStatisticToList(samples.getSamples());
        try {
            provider.expotExcel(stats);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

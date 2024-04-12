/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2stats;

import java.io.File;
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
    private Calculator calculator = new Calculator();
    private ExcelProvider provider = new ExcelProvider();
    private File file;
    public void importExcel(String path, String name) throws IOException{
        ArrayList<ArrayList<Double>> list = provider.readSheetFromXLSX(path,name);
        this.samples.setSamples(list);
    }
    public void importExcel(String path, int index) throws IOException{
        ArrayList<ArrayList<Double>> list = provider.readSheetFromXLSX(path,index);
        this.samples.setSamples(list);
    }
    public void exportFile(){
        ArrayList<ArrayList<Double>> stats = calculator.addStatisticToList(samples.getSamples());
        ArrayList<ArrayList<Double>> cov = calculator.addCovToList(samples.getSamples());
        try {
            provider.expotExcel(stats, cov);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setFile(File file){
        this.file = file;
    }
    public File getFile(){
        return file;
    }
}

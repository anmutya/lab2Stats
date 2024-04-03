/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2stats;

import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author annamutovkina
 */
public class Samples {
    private ArrayList<Double> sampleX= new ArrayList<>();
    private ArrayList<Double> sampleY= new ArrayList<>();
    private ArrayList<Double> sampleZ= new ArrayList<>();
    
    public void importToArrays(XSSFSheet myExcelSheet) {

        for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
            XSSFRow row = myExcelSheet.getRow(i);
            sampleX.add(row.getCell(0).getNumericCellValue());
            sampleY.add(row.getCell(1).getNumericCellValue());
            sampleZ.add(row.getCell(2).getNumericCellValue());
            
        }
    }
    public ArrayList<Double> getSampleX() {
          return this.sampleX;
    }
    public ArrayList<Double> getSampleY() {
        return this.sampleY;
    }
    public ArrayList<Double> getSampleZ() {
        return this.sampleX;
    }

}

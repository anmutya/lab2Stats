/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author annamutovkina
 */
public class ExcelProvider {

    public static void readFromXLSX(String path, Samples samp) throws IOException {
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet("Вариант 1");
            samp.importToArrays(myExcelSheet);
            myExcelFWorkbook.close();
        }
    }
    public static void expotExcel(Samples samp) throws IOException{
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Calculations");
        craateTitles(sheet);
        calculateRow(sheet.getRow(1), samp.getSampleX());
        calculateRow(sheet.getRow(2), samp.getSampleY());
        calculateRow(sheet.getRow(3), samp.getSampleZ());
         XSSFSheet sheet2 = wb.createSheet("Covariance Matrix");
        covarianceMatrix(sheet2, samp.getSampleX(), samp.getSampleY(), samp.getSampleZ());
        try {
            wb.write(new FileOutputStream(new File("/Users/annamutovkina/Downloads/Calculations.xlsx")));
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void craateTitles(XSSFSheet sheet){
        XSSFRow row = sheet.createRow(0);
        XSSFRow row1 = sheet.createRow(1);
        XSSFRow row2 = sheet.createRow(2);
        XSSFRow row3 = sheet.createRow(3);
        row1.createCell(0).setCellValue("X");
        row2.createCell(0).setCellValue("Y");
        row3.createCell(0).setCellValue("Z");
        String[] headers = new String[]{"Geometric Mean", "Mean", "Standard Deviation", 
            "Sample Size", "Number of Items", "Variance Coefficient", "Confidence Interval", 
            "Variance", "Maximum", "Minimum"};
        for (int i = 1; i < headers.length + 1; i++) {
            row.createCell(i).setCellValue(headers[i - 1]);
        } 

    }
    private static void calculateRow(XSSFRow row, ArrayList<Double> array){
        Calculate calc = new Calculate();
        row.createCell(1).setCellValue(calc.calculateGeomMean(array));
        row.createCell(2).setCellValue(calc.calculateMean(array));
        row.createCell(3).setCellValue(calc.calculateSd(array));
        row.createCell(4).setCellValue(calc.calculateScope(array));
        row.createCell(5).setCellValue(calc.calculateLenght(array));
        row.createCell(6).setCellValue(calc.calculateVarianceСoefficient(array));
        row.createCell(7).setCellValue("(" + calc.calculateConfidenceInterval(array)[0] + ";" + calc.calculateConfidenceInterval(array)[1] + ")");
        row.createCell(8).setCellValue(calc.calculateVariance(array));
        row.createCell(9).setCellValue(calc.calculateMax(array));
        row.createCell(10).setCellValue(calc.calculateMin(array));
   }
   private static void covarianceMatrix(XSSFSheet sheet, ArrayList<Double> arrayX, ArrayList<Double> arrayY, ArrayList<Double> arrayZ){
        Calculate calc = new Calculate();
       String[] headers = new String[]{"X", "Y", "Z"};
       XSSFRow row = sheet.createRow(0);
       for (int i = 1; i < headers.length + 1; i++) {
           row.createCell(i).setCellValue(headers[i - 1]);
       }
       for (int i = 1; i < headers.length + 1; i++) {
           sheet.createRow(i).createCell(0).setCellValue(headers[i - 1]);
           if(i ==1){
               sheet.getRow(i).createCell(i).setCellValue(calc.calculateCovariation(arrayX, arrayX));
               sheet.getRow(i).createCell(2).setCellValue(calc.calculateCovariation(arrayX, arrayY));
               sheet.getRow(i).createCell(3).setCellValue(calc.calculateCovariation(arrayX, arrayZ));
           }
           else if(i == 2){
               sheet.getRow(i).createCell(i).setCellValue(calc.calculateCovariation(arrayY, arrayY));
               sheet.getRow(i).createCell(1).setCellValue(calc.calculateCovariation(arrayY, arrayX));
               sheet.getRow(i).createCell(3).setCellValue(calc.calculateCovariation(arrayY, arrayZ));
           }
           else {
               sheet.getRow(i).createCell(2).setCellValue(calc.calculateCovariation(arrayZ, arrayY));
               sheet.getRow(i).createCell(1).setCellValue(calc.calculateCovariation(arrayZ, arrayX));
               sheet.getRow(i).createCell(3).setCellValue(calc.calculateCovariation(arrayZ, arrayZ));
           }

       }
    }
   
  
}

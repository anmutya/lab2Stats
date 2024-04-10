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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author annamutovkina
 */
public class ExcelProvider {

    public ArrayList<ArrayList<Double>> readFromXLSX(String path) throws IOException {
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet("Вариант 1");

            int numRows = myExcelSheet.getPhysicalNumberOfRows();
            int numCols = myExcelSheet.getRow(0).getLastCellNum();

            for (int col = 0; col < numCols; col++) {
                ArrayList<Double> columnData = new ArrayList<>();
                for (int row = 1; row < numRows; row++) {
                    XSSFRow currentRow = myExcelSheet.getRow(row);
                    if (currentRow != null) {
                        XSSFCell cell = currentRow.getCell(col);
                        if (cell != null) {
                            columnData.add(cell.getNumericCellValue());
                        } else {
                            columnData.add(0.0);
                        }
                    }
                }
                data.add(columnData);
            }
            myExcelFWorkbook.close();
        }
        return data;
    }

    public void expotExcel(ArrayList<ArrayList<Double>> stats) throws IOException{
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Calculations");
        craateTitles(sheet);
        addStatsToRow(sheet.getRow(1), stats.get(0));
        addStatsToRow(sheet.getRow(2), stats.get(1));
        addStatsToRow(sheet.getRow(3), stats.get(2));
        XSSFSheet sheet2 = wb.createSheet("Covariance Matrix");
        covarianceMatrix(sheet2, stats);
        try {
            wb.write(new FileOutputStream(new File("/Users/annamutovkina/Downloads/Calculations.xlsx")));
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void craateTitles(XSSFSheet sheet){
        XSSFRow row = sheet.createRow(0);
        XSSFRow row1 = sheet.createRow(1);
        XSSFRow row2 = sheet.createRow(2);
        XSSFRow row3 = sheet.createRow(3);
        row1.createCell(0).setCellValue("X");
        row2.createCell(0).setCellValue("Y");
        row3.createCell(0).setCellValue("Z");
        String[] headers = new String[]{"Geometric Mean", "Mean", "Standard Deviation", 
            "Sample Size", "Number of Items", "Variance Coefficient", "Lower Confidence Bound", "Upper Confidence Bound", 
            "Variance", "Maximum", "Minimum"};
        for (int i = 1; i < headers.length + 1; i++) {
            row.createCell(i).setCellValue(headers[i - 1]);
        } 

    }
    private void addStatsToRow(XSSFRow row, ArrayList<Double> array){
        for(int i = 1; i<array.size()-2; i++){
            row.createCell(i).setCellValue(array.get(i-1));
        }
        
   }
   private static void covarianceMatrix(XSSFSheet sheet, ArrayList<ArrayList<Double>> stats){
       String[] headers = new String[]{"X", "Y", "Z"};
       XSSFRow row = sheet.createRow(0);
       for (int i = 1; i <= headers.length; i++) {
           sheet.createRow(i).createCell(0).setCellValue(headers[i - 1]);
       }
       for (int i = 1; i <= headers.length; i++) {
           row.createCell(i).setCellValue(headers[i - 1]);
       }
       for(int i = 1; i <= headers.length; i++){
           int arrayNumber = i-1;
           for(int j = 1; j<= headers.length; j++){
               int indexInArrayNumber = 10 + j;
               sheet.getRow(i).createCell(j).setCellValue(stats.get(arrayNumber).get(indexInArrayNumber));
           }
       }
       
    }
}

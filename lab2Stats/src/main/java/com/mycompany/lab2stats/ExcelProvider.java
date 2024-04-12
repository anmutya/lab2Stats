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
    private ArrayList<ArrayList<Double>> exportSheetToList(XSSFSheet myExcelSheet){
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
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
            return data;
    }
    public ArrayList<ArrayList<Double>> readSheetFromXLSX(String path, int index) throws IOException {
         ArrayList<ArrayList<Double>> data = new ArrayList<>();
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheetAt(index-1);
            data = exportSheetToList(myExcelSheet);
            myExcelFWorkbook.close();
        }
        return data;
    }
     public ArrayList<ArrayList<Double>> readSheetFromXLSX(String path, String nameSheet) throws IOException{
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            data = exportSheetToList(myExcelSheet);
            myExcelFWorkbook.close();
        }
        return data;
     }

    public void expotExcel(ArrayList<ArrayList<Double>> stats, ArrayList<ArrayList<Double>> cov ) throws IOException{
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Calculations");
        int stats_size = stats.size();
        craateTitles(sheet, stats_size);
        for(int i = 1; i <= stats_size; i++){
            addStatsToRow(sheet.getRow(i), stats.get(i-1));
        }
        XSSFSheet sheet2 = wb.createSheet("Covariance Matrix");
        covarianceMatrix(sheet2, cov);
        try {
            wb.write(new FileOutputStream(new File("./Calculations.xlsx")));
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void craateTitles(XSSFSheet sheet, int stats){

        for(int i = 1; i <= stats ; i++){
            XSSFRow row = sheet.createRow(i);
            XSSFCell cell = row.createCell(0);
            cell.setCellValue("Выборка " + i);
        }
        String[] headers = new String[]{"Geometric Mean", "Mean", "Standard Deviation", 
            "Sample Size", "Number of Items", "Variance Coefficient", "Lower Confidence Bound", "Upper Confidence Bound", 
            "Variance", "Maximum", "Minimum"};
        XSSFRow row = sheet.createRow(0);
        for (int i = 1; i <= headers.length; i++) {
            row.createCell(i).setCellValue(headers[i - 1]);
        } 

    }
    private void addStatsToRow(XSSFRow row, ArrayList<Double> array){
        for(int i = 1; i<=array.size(); i++){
            row.createCell(i).setCellValue(array.get(i-1));
        }
   }
   private void covarianceMatrix(XSSFSheet sheet, ArrayList<ArrayList<Double>> stats){
       XSSFRow row = sheet.createRow(0);
       for (int i = 1; i <= stats.size(); i++) {
           sheet.createRow(i).createCell(0).setCellValue("Выборка "+ i);
       }
       for (int i = 1; i <= stats.size(); i++) {
           row.createCell(i).setCellValue("Выборка " + i);
       }
       for(int i = 1; i <= stats.size(); i++){
           int arrayNumber = i-1;
           for(int j = 1; j<= stats.size(); j++){
               int indexInArrayNumber =  j-1;
               sheet.getRow(i).createCell(j).setCellValue(stats.get(arrayNumber).get(indexInArrayNumber));
           }
       }
       
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2stats;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author annamutovkina
 */
public class ExcelProvider {
    private static final String pathForInput = "src/main/resources/ДЗ4.xlsx";
     Calculate calc = new Calculate();
    private double[] arrayX;
    private double[] arrayY;
    private double[] arrayZ;

    public void importFromExcel() throws IOException{
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(this.pathForInput)) {
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet("Вариант 1");
            this.arrayX = new double[myExcelSheet.getLastRowNum()];
            this.arrayY = new double[myExcelSheet.getLastRowNum()];
            this.arrayZ = new double[myExcelSheet.getLastRowNum()];
            int j = 0;
            for(int i = 1; i<=myExcelSheet.getLastRowNum(); i++){
                XSSFRow row = myExcelSheet.getRow(i);
                this.arrayX[j] = row.getCell(0).getNumericCellValue();
                this.arrayY[j] = row.getCell(1).getNumericCellValue();
                this.arrayZ[j] = row.getCell(2).getNumericCellValue();
                j++;
            }printArray();
        }
    }


    public void readFromXLSX(String path) throws IOException {
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet("Вариант 1");
            this.arrayX = new double[myExcelSheet.getLastRowNum()];
            this.arrayY = new double[myExcelSheet.getLastRowNum()];
            this.arrayZ = new double[myExcelSheet.getLastRowNum()];
            int j = 0;
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                XSSFRow row = myExcelSheet.getRow(i);
                this.arrayX[j] = row.getCell(0).getNumericCellValue();
                this.arrayY[j] = row.getCell(1).getNumericCellValue();
                this.arrayZ[j] = row.getCell(2).getNumericCellValue();
                j++;
            }
            myExcelFWorkbook.close();
        }
    }

    public double[] getArrayX() {
        return this.arrayX;
    }

    public double[] getArrayY() {
        return this.arrayY;
    }

    public double[] getArrayZ() {
        return this.arrayZ;
    }
    public void printArray(){
        for(Double s : arrayX){
            System.out.println(s);
        }
    }
    public double getGeometryMeanX(){
        return calc.calculateGeomMeanFix(this.arrayX);
    }
    public double getGeometryMeanY(){
        return calc.calculateGeomMeanFix(this.arrayY);
    }
    public double getGeometryMeanZ() {
        return calc.calculateGeomMeanFix(this.arrayZ);
    }
    
    
}

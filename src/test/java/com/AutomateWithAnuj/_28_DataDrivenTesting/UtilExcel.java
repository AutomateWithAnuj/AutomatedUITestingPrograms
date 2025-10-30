package com.AutomateWithAnuj._28_DataDrivenTesting;

import org.apache.poi.ss.usermodel.Workbook; //workbook is coming from this
import org.apache.poi.ss.usermodel.Sheet; //sheet is coming from this
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {
    //Apache POI - which we can put inside the pom.xml file

    static Workbook book;
    static Sheet sheet;
    public static String Sheet_Path = System.getProperty("user.dir") + "/src/test/Resource/MOCK_DATA.xlsx";

    public static Object[][] getTestDataFromExcel(String sheetName){

        //Read the file - xlsx - FileInputStream (Java)
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Sheet_Path);

            //WorkBook - WorkbookFactory
            book = WorkbookFactory.create(fis); //OS creates the file temporarily in it's memory

            //Sheet -> book
            sheet = book.getSheet(sheetName);

        } catch (FileNotFoundException e) {
            System.out.println("Either File Not Found or workbook not created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[][] testData = new Object[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];

        //R, C -> sheet
        for(int i=0;i<sheet.getLastRowNum();i++){ // i from 0 to 19
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) { //0 and 1
                //skip header
                testData[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
            }
        }
        //object[][] data → all the values in cell → data[][] → For loop.
        return testData;
    }
}

package com.codecool.selenium.testKwDDPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class DataHandling {
    private HSSFSheet sheet;

    /*
    https://stackoverflow.com/questions/1516144/how-to-read-and-write-excel-file#
     */

    public void getDataFromExcelFile() {
        String excelPath = "/home/reka/4_test_modul/seleniumTest_3SI_week/data/seleniumWebSiteTestData.xls";
        try {
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(excelPath));
            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);
            this.sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getListSingleInputFieldMessages() {
        getDataFromExcelFile();
        Short singleInputMessagesNrCol = 0;
        List<String> listSingleInputFieldMessages = new ArrayList<>();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            String message = sheet.getRow(i).getCell(singleInputMessagesNrCol).getStringCellValue();
            if (message!=null) {
                listSingleInputFieldMessages.add(message);
            } else {
                break;
            }
        }
        return listSingleInputFieldMessages;
    }

    public List<String> getListTwoInputFieldsNumbersFromExcel(Short cellNumber) {
        getDataFromExcelFile();
        List<String> listForNumbers = new ArrayList();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            String cellValue = (String.valueOf(sheet.getRow(i).getCell(cellNumber).getNumericCellValue()));
            String[] splitCellValue = cellValue.split("\\.");

            if (splitCellValue[1].equals("0")) {
                listForNumbers.add(splitCellValue[0]);
            } else {
                listForNumbers.add(cellValue);
            }
        }
        return listForNumbers;
    }

    public List<String> getListTwoInputFieldsNumber1() {
        Short twoFieldCellNumber1  = 1;
        return getListTwoInputFieldsNumbersFromExcel(twoFieldCellNumber1);
    }

    public List<String> getListTwoInputFieldsNumber2() {
        Short twoFieldCellNumber2  = 2;
        return getListTwoInputFieldsNumbersFromExcel(twoFieldCellNumber2);
    }

    public List<String> getListTwoInputFieldsTotal() {
        Short twoFieldCellTotal  = 3;
        return getListTwoInputFieldsNumbersFromExcel(twoFieldCellTotal);
    }

    public List<String> getListOfVariationMultipleCheckBox() {
        getDataFromExcelFile();
        List<String> listOfVariationMultipleCheckBox = new ArrayList<>();
        Short cellStartNumber = 4;

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            for (int j = cellStartNumber; j < cellStartNumber+4; j++) {
                listOfVariationMultipleCheckBox.add((String.valueOf((int)sheet.getRow(i).getCell((short)j).getNumericCellValue())));
            }
        }
        return listOfVariationMultipleCheckBox;
    }

    public List<String> getListOfDaysFromExcel() {
        getDataFromExcelFile();
        List<String> listOfDays = new ArrayList<>();
        Short cellNumber = 8;

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            listOfDays.add(sheet.getRow(i).getCell(cellNumber).getStringCellValue());
        }
        return listOfDays;
    }
}

package com.codecool.selenium.testKwDDPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class DataHandling {
    private POIFSFileSystem poifsFileSystem;
    private String excelPath = "/home/reka/4_test_modul/seleniumTest_3SI_week/data/seleniumWebSiteTestData.xls";
    private HSSFSheet sheet;
    private List<String> listSingleInputFieldMessages = new ArrayList<>();
    private Short singleInputMessagesNrCol = 0;
    private Short twoFieldNumber1  = 1;
    private Short twoFieldNumber2  = 2;
    private Short twoFieldTotal  = 3;

    public void getDataFromExcelFile() {
        try {
            poifsFileSystem = new POIFSFileSystem(new FileInputStream(excelPath));
            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);
            this.sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getListSingleInputFieldMessages() {
        getDataFromExcelFile();
        int rows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rows; i++) {
            String message = sheet.getRow(i).getCell(singleInputMessagesNrCol).getStringCellValue();
            if (message!=null) {
                this.listSingleInputFieldMessages.add(message);
            } else {
                break;
            }
        }
        return listSingleInputFieldMessages;
    }
}

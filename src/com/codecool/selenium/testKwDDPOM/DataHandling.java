package com.codecool.selenium.testKwDDPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class DataHandling {
    POIFSFileSystem poifsFileSystem;
    List<String> listSingleInputFieldMessages = new ArrayList<>();

    public void getDataFromExcelFile() {
        try {
            poifsFileSystem = new POIFSFileSystem(new FileInputStream("/home/reka/4_test_modul/seleniumTest_3SI_week/data/seleniumWebSiteTestData.xls"));
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            int rows = hssfSheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rows; i++) {
                String message = hssfSheet.getRow(i).getCell((short) 0).getStringCellValue();
                this.listSingleInputFieldMessages.add(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getListSingleInputFieldMessages() {
        getDataFromExcelFile();
        return listSingleInputFieldMessages;
    }
}

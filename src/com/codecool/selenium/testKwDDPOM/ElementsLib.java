package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;

import java.util.List;

class ElementsLib {
    String baseURL = "https://www.seleniumeasy.com/test/";
    String textForInputField = "Hello world!";
    DataHandling dataHandling = new DataHandling();
    List<String> listSingleInputFieldMessages = dataHandling.getListSingleInputFieldMessages();

    By selectInputFormsMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Input Forms')]");
    By selectSimpleFormDemoMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Simple Form Demo')]");
    By inputSingleInputField = By.xpath("//*[@id=\"user-message\"]");
    By buttonShowMessage = By.xpath("//*[@id=\"get-input\"]/button");
    By locationTypedText = By.xpath("//*[@id=\"display\"]");
}

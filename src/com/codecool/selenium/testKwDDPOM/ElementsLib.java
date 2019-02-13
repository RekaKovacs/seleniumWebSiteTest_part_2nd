package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;

import java.util.List;

class ElementsLib {
    String baseURL = "https://www.seleniumeasy.com/test/";
    String textForInputField = "Hello world!";
    DataHandling dataHandling = new DataHandling();
    List<String> listSingleInputFieldMessages = dataHandling.getListSingleInputFieldMessages();
    String number1 = "10";
    String number2 = "100";
    String expectedTotal = "110";
    List<String> listTwoInputFieldsNumber1 = dataHandling.getListTwoInputFieldsNumber1();
    List<String> listTwoInputFieldsNumber2 = dataHandling.getListTwoInputFieldsNumber2();
    List<String> listTwoInputFieldsTotal = dataHandling.getListTwoInputFieldsTotal();

    By selectInputFormsMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Input Forms')]");
    By selectSimpleFormDemoMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Simple Form Demo')]");
    By inputSingleInputField = By.xpath("//*[@id=\"user-message\"]");
    By buttonShowMessage = By.xpath("//*[@id=\"get-input\"]/button");
    By locationTypedText = By.xpath("//*[@id=\"display\"]");
    By inputTwoInputFields1 = By.xpath("//*[@id=\"sum1\"]");
    By inputTwoInputFields2 = By.xpath("//*[@id=\"sum2\"]");
    By buttonGetTotal = By.xpath("//*[@id=\"gettotal\"]/button");
    By locationGetTotalAmount = By.xpath("//*[@id=\"displayvalue\"]");
}

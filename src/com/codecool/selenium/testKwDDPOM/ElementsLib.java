package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;

class ElementsLib {
    String baseURL = "https://www.seleniumeasy.com/test/";
    String textForInputField = "Hello world!";

    By selectInputFormsMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Input Forms')]");
    By selectSimpleFormDemoMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Simple Form Demo')]");
    By inputSingleInputField = By.xpath("//*[@id=\"user-message\"]");
    By buttonShowMessage = By.xpath("//*[@id=\"get-input\"]/button");
    By locationTypedText = By.xpath("//*[@id=\"display\"]");
}

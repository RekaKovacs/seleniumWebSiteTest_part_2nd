package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;

public class ElementsLib {
    public String baseURL = "https://www.seleniumeasy.com/test/";
    public String textForInputField = "Hello world!";

    public By selectInputFormsMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Input Forms')]");
    public By selectSimpleFormDemoMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Simple Form Demo')]");
    public By inputSingleInputField = By.xpath("//*[@id=\"user-message\"]");
    public By buttonShowMessage = By.xpath("//*[@id=\"get-input\"]/button");
    public By locationTypedText = By.xpath("//*[@id=\"display\"]");
}

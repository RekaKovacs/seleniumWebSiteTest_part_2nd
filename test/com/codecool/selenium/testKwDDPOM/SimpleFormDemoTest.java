package com.codecool.selenium.testKwDDPOM;

import com.codecool.selenium.testKwDDPOM.KeyWords;
import com.codecool.selenium.testKwDDPOM.ElementsLib;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleFormDemoTest {
    ElementsLib elementsLib = new ElementsLib();
    KeyWords keyWords = new KeyWords();

    @BeforeEach
    public void setup() {
        keyWords.iniFireFoxDriver();
        keyWords.setUrl(elementsLib.baseURL);

    }

    @Test
    public void fillInputFieldWithText() {
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectSimpleFormDemoMenuList);
        keyWords.sendKeys(elementsLib.inputSingleInputField, elementsLib.textForInputField);
        keyWords.clickElement(elementsLib.buttonShowMessage);
        assertEquals(elementsLib.textForInputField, keyWords.getInnerText(elementsLib.locationTypedText));
    }

    @AfterEach
    public void tearDown() {
        keyWords.closeDriver();
    }
}

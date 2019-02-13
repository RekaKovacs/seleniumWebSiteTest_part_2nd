package com.codecool.selenium.testKwDDPOM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleFormDemoTest {
    ElementsLib elementsLib = new ElementsLib();
    KeyWords keyWords = new KeyWords();

    /*
    First exercise - Navigation:
        Open the base url. Using the "Menu List" navigate to All Examples/Input Forms/Simpe Form Demo
        Base url: https://www.seleniumeasy.com/test/
        Extension: Create reusable navigation keyword (and reuse it :])
     */
    @BeforeEach
    public void setup() {
        keyWords.iniFireFoxDriver();
        keyWords.setUrl(elementsLib.baseURL);
    }

    /*
    Second exercise - Single field & Button:
        Navigate to Simpe Form Demo. In "Single Input Field" enter a message into the field and click "Show Message" button.
        Validate that the message appeared.
        Extension: fill the field data-driven way, use a source file for it
     */
    @Test
    public void fillSingleInputFieldWithText() {
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectSimpleFormDemoMenuList);
        keyWords.sendKeys(elementsLib.inputSingleInputField, elementsLib.textForInputField);
        keyWords.clickElement(elementsLib.buttonShowMessage);
        assertEquals(elementsLib.textForInputField, keyWords.getInnerText(elementsLib.locationTypedText));
    }

    @Test
    public void fillSingleInputFieldWithMessagesFromExcel() {
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectSimpleFormDemoMenuList);
        for (int i = 0; i < elementsLib.listSingleInputFieldMessages.size(); i++) {
                keyWords.sendKeys(elementsLib.inputSingleInputField, elementsLib.listSingleInputFieldMessages.get(i));
                keyWords.clickElement(elementsLib.buttonShowMessage);
                assertEquals(elementsLib.listSingleInputFieldMessages.get(i), keyWords.getInnerText(elementsLib.locationTypedText));
        }
    }

    /*
    Third exercise - Two fields & Output:
        Navigate to Simpe Form Demo. In "Two Input Fields" enter value A and B and click the "Get Total" button. Validate that the
        answer is correct.
        Does your test works even when you enter very large numbers? !!!No!!!
        Extension: use at least 5 rows from data source with expected results, make positive and negative tests
         Method can not handle this case (1, a, expected 1a -failing test)
     */
    @Test
    public void fillTwoInputFieldsWithNumber() {
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectSimpleFormDemoMenuList);
        keyWords.sendKeys(elementsLib.inputTwoInputFields1, elementsLib.number1);
        keyWords.sendKeys(elementsLib.inputTwoInputFields2, elementsLib.number2);
        keyWords.clickElement(elementsLib.buttonGetTotal);
        assertEquals(elementsLib.expectedTotal, keyWords.getInnerText(elementsLib.locationGetTotalAmount));
    }

    @Test
    public void fillTwoInputFieldsWithNumbersFromExcel() {
        List<String> listResult = new ArrayList<>();
        List<AssertionError> assertionErrorList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            keyWords.clickElement(elementsLib.selectInputFormsMenuList);
            keyWords.clickElement(elementsLib.selectSimpleFormDemoMenuList);
            keyWords.sendKeys(elementsLib.inputTwoInputFields1, elementsLib.listTwoInputFieldsNumber1.get(i));
            keyWords.sendKeys(elementsLib.inputTwoInputFields2, elementsLib.listTwoInputFieldsNumber2.get(i));
            keyWords.clickElement(elementsLib.buttonGetTotal);

            try {
                assertEquals(elementsLib.listTwoInputFieldsTotal.get(i), keyWords.getInnerText(elementsLib.locationGetTotalAmount));

            } catch (AssertionError error) {
                assertionErrorList.add(error);
                System.out.println("The test failed in this case: " + elementsLib.listTwoInputFieldsNumber1.get(i) + " and "
                        + elementsLib.listTwoInputFieldsNumber2.get(i) + " the total: " + elementsLib.listTwoInputFieldsTotal.get(i));
            }
        }

        if (!assertionErrorList.isEmpty()) {throw new AssertionError();}
    }

    @AfterEach
    public void tearDown() {
        keyWords.closeDriver();
    }
}

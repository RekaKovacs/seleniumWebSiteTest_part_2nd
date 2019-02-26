package com.codecool.selenium.testKwDDPOM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBox {
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
    Fourth exercise - Checkbox:
        Navigate to Checkbox Demo. In "Single Checkbox Demo" check the checkbox and validate the message.
        Bonus if you write a test for "Multiple Checkbox Demo" and find the bug which is present on the webpage.
        Extension: create a data source with at least 5 rows, with input combinations for checkbox (something like 1,0,1,0 should
        tick the 2nd and 4th checkboxes), dont forget validations
     */
    @Test
    public void checkedSingleCheckbox() {
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectCheckBoxDemoMenuList);
        keyWords.clickElement(elementsLib.checkboxSingle);
        assertEquals("Success - Check box is checked", keyWords.getInnerText(elementsLib.locationSingleCheckedMessage));
    }

    @Test
    public void checkedMultipleCheckBox() {
        List<AssertionError> assertionErrorList = new ArrayList<>();
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectCheckBoxDemoMenuList);

        try {
            keyWords.clickElement(elementsLib.option1CheckBox);
            assertEquals("Check All", keyWords.getValueAttribute(elementsLib.buttonCheckUncheckAll));
            keyWords.clickElement(elementsLib.option2CheckBox);
            assertEquals("Check All", keyWords.getValueAttribute(elementsLib.buttonCheckUncheckAll));
            keyWords.clickElement(elementsLib.option3CheckBox);
            assertEquals("Check All", keyWords.getValueAttribute(elementsLib.buttonCheckUncheckAll));
            keyWords.clickElement(elementsLib.option4CheckBox);
            assertEquals("Uncheck All", keyWords.getValueAttribute(elementsLib.buttonCheckUncheckAll));
        } catch (AssertionError error) {
            assertionErrorList.add(error);
        }
        if (!assertionErrorList.isEmpty()) {throw new AssertionError();}
    }

    @Test
    public void checkedMultipleCheckBoxWithVariationFromExcel() {
        List<String> listOfVariationMultipleCheckBox = elementsLib.listOfVariationMultipleCheckBox;
        List<AssertionError> assertionErrorList = new ArrayList<>();
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectCheckBoxDemoMenuList);

        for (int i = 0; i < listOfVariationMultipleCheckBox.size(); i+=4) {
            int counter = 0;

            if (listOfVariationMultipleCheckBox.get(i).equals("1")) {
                keyWords.clickElement(elementsLib.option1CheckBox);
                counter++;
            }
            if  (listOfVariationMultipleCheckBox.get(i+1).equals("1")) {
                keyWords.clickElement(elementsLib.option2CheckBox);
                counter++;
            }
            if  (listOfVariationMultipleCheckBox.get(i+2).equals("1")) {
                keyWords.clickElement(elementsLib.option3CheckBox);
                counter++;
            }
            if  (listOfVariationMultipleCheckBox.get(i+3).equals("1")) {
                keyWords.clickElement(elementsLib.option4CheckBox);
                counter++;
            }

            try {
                if (counter == 4) {
                    assertEquals("Uncheck All", keyWords.getValueAttribute(elementsLib.buttonCheckUncheckAll));
                    keyWords.clickElement(elementsLib.buttonCheckUncheckAll);
                } else {
                    assertEquals("Check All", keyWords.getValueAttribute(elementsLib.buttonCheckUncheckAll));
                    keyWords.clickElement(elementsLib.buttonCheckUncheckAll);
                    keyWords.clickElement(elementsLib.buttonCheckUncheckAll);
                }

            } catch (AssertionError error) {
                assertionErrorList.add(error);
            }
        }
        if (!assertionErrorList.isEmpty()) {throw new AssertionError();}
    }




    @AfterEach
    public void tearDown() {
        keyWords.closeDriver();
    }
}

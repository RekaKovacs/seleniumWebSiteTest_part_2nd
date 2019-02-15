package com.codecool.selenium.testKwDDPOM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioButton {
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
    Navigate to Radio buttons Demo. In "Group Radio Buttons Demo" select a combination and click the "Get values" button.
        Validate the result.
        Try to run several combinations in one test.
        Extension: create and validate all possible combinations once, use data source and keywords  !!! not implemented yet!!!
     */
    @Test
    public void groupRadioButtonOneCombinationTest() {
        List<AssertionError> assertionErrorList = new ArrayList<>();

        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectRadioButtonsDemoMenuList);
        Map<String,String> textExpectedResult = keyWords.clickRdbAllCombination(elementsLib.rdbSexGroupButtonsDemo,
                elementsLib.rdbAgeGroupButtonDemo, elementsLib.buttonRdbGetValues, elementsLib.locationGetSexAndAgeGroupRdbText);

        textExpectedResult.forEach((expected, result)->{
            try {
                assertEquals(expected, result);
            } catch (AssertionError error) {
                assertionErrorList.add(error);
            }
        });

        if (!assertionErrorList.isEmpty()) {
            throw new AssertionError();
        }
    }

    @AfterEach
    public void tearDown() {
        keyWords.closeDriver();
    }
}

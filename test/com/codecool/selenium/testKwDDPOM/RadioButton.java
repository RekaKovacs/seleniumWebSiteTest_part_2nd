package com.codecool.selenium.testKwDDPOM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

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
        Group Sex:
        0 = Male, 1 = Female
        Age group:
        0 = 0 to 5, 1 = 5 to 15, 2 = 15 to 50

     */
    @Test
    public void groupRadioButtonSeveralCombinationTest() {
        List<AssertionError> assertionErrorList = new ArrayList<>();

        Integer[] comb1 = {0,2};
        Integer[] comb2 = {1,0};
        Integer[] comb3 = {1,1};
        List<Integer[]> combinations = new ArrayList<>();
            combinations.add(comb1);
            combinations.add(comb2);
            combinations.add(comb3);

        List<String> listExpectedText = new ArrayList<>();
        listExpectedText.add("Sex : Male\nAge group: 15 - 50");
        listExpectedText.add("Sex : Female\nAge group: 0 - 5");
        listExpectedText.add("Sex : Female\nAge group: 5 - 15");

        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectRadioButtonsDemoMenuList);
        List<String> textResult = keyWords.clickRdbSeveralCombination(combinations, elementsLib.rdbSexGroupButtonsDemo,
                elementsLib.rdbAgeGroupButtonDemo, elementsLib.buttonRdbGetValues, elementsLib.locationGetSexAndAgeGroupRdbText);

        for (int i = 0; i < listExpectedText.size(); i++) {
            try {
                assertEquals(listExpectedText.get(i), textResult.get(i));
            } catch (AssertionError error) {
                assertionErrorList.add(error);
            }
        }

        if (!assertionErrorList.isEmpty()) {
            throw new AssertionError();
        }
    }

    @AfterEach
    public void tearDown() {
        keyWords.closeDriver();
    }
}

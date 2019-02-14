package com.codecool.selenium.testKwDDPOM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectList {
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
    Navigate to Select Dropdown List. In "Select List Demo" select the current day from the dropdown and validate that it's
        selected.
        Try out all the way you can select a day.
        Extension: select each days after each other twice (14 in total), use keywords and data source obviously
     */
    @Test
    public void checkedSingleCheckbox() {
        keyWords.clickElement(elementsLib.selectInputFormsMenuList);
        keyWords.clickElement(elementsLib.selectDropDownList);
        keyWords.selectDropDownByValue(elementsLib.dropDownSingleSelect, elementsLib.dayOfWeek);
        assertEquals(elementsLib.expectedDayOfWeek, keyWords.getInnerText(elementsLib.locationDropdownSelectedText));
    }

//    @AfterEach
//    public void tearDown() {
//        keyWords.closeDriver();
//    }
}

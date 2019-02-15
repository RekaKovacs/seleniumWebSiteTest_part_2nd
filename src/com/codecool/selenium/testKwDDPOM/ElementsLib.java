package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    String expectedMessagesingleCheckBox = "Success - Check box is checked";

    List<String> listOfVariationMultipleCheckBox = dataHandling.getListOfVariationMultipleCheckBox();

    String dayOfWeek = getDayOfWeek();
    String expectedDayOfWeek = "Day selected :- " + dayOfWeek;
    List<String> listOfDaysFromExcel = dataHandling.getListOfDaysFromExcel();


    By selectInputFormsMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Input Forms')]");
    By selectSimpleFormDemoMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Simple Form Demo')]");
    By inputSingleInputField = By.xpath("//*[@id=\"user-message\"]");
    By buttonShowMessage = By.xpath("//*[@id=\"get-input\"]/button");
    By locationTypedText = By.xpath("//*[@id=\"display\"]");

    By inputTwoInputFields1 = By.xpath("//*[@id=\"sum1\"]");
    By inputTwoInputFields2 = By.xpath("//*[@id=\"sum2\"]");
    By buttonGetTotal = By.xpath("//*[@id=\"gettotal\"]/button");
    By locationGetTotalAmount = By.xpath("//*[@id=\"displayvalue\"]");

    By selectCheckBoxDemoMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Checkbox Demo')]");
    By checkboxSingle = By.xpath("//*[@id=\"isAgeSelected\"]");
    By locationSingleCheckedMessage = By.xpath("//*[@id=\"txtAge\"]");

    By option1CheckBox = By.xpath("(//input[@value=''])[2]");
    By option2CheckBox = By.xpath("(//input[@value=''])[3]");
    By option3CheckBox = By.xpath("(//input[@value=''])[4]");
    By option4CheckBox = By.xpath("(//input[@value=''])[5]");
    By buttonCheckUncheckAll = By.xpath("//*[@id=\"check1\"]");

    By selectDropDownList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Select Dropdown List')]");
    By dropDownSingleSelect = By.xpath("//*[@id=\"select-demo\"]");
    By locationDropdownSelectedText = By.xpath("//*[@class=\"selected-value\"]");

    By selectRadioButtonsDemoMenuList = By.xpath("//*[@id=\"treemenu\"]//*[contains(text(),'Radio Buttons Demo')]");
    By rdbSexGroupButtonsDemo = By.xpath("//input[@name='gender']");
    By rdbAgeGroupButtonDemo = By.xpath("//input[@name='ageGroup']");
    By buttonRdbGetValues = By.xpath("(//button[@type='button'])[3]");
    By locationGetSexAndAgeGroupRdbText = By.xpath("//*[@class=\"groupradiobutton\"]");

    private String getDayOfWeek() {
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
    }
}

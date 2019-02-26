package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class DataPickerPOMTest {
    WebDriver driver;
    WebDriverWait wait;
    DataPickerPOM dataPickerPOM;


    /*
    Navigate to the Bootstrap Date picker in Date Pickers demo
    */
    @BeforeTest
    public void setup(){
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    /*
    Open the "Select Date" picker and validate if 2019 January 14 was a Monday
    */
    @Test
    public void getNameOfDayByAddDate() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/");
//        By inputSelectDate = By.xpath("//*[@id=\"sandbox-container1\"]/div/input");
//        String date = "14/01/2019";
//        driver.findElement(inputSelectDate).sendKeys(date);

//        dataPickerPOM = new DataPickerPOM(driver);
//        dataPickerPOM.setDate("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html","14/01/2019");
//        assertEquals("Mo", dataPickerPOM.getday());
    }


    /*
    Make your test configurable:Make it possible to select any previous date and validate which day of the week was it e.g.:
            2017 Dec 8 and 2015, Jan May 5
    Extension: Create a huge data excel manually (~100 rows), with dates, and add days to the next columns randomly
(example: 2019 January 14, Monday). Verify how many rows have correct days next to them (should be around 14% pass
            rate with pure random)
    Tip for creating test data: use bottom right of a cell in excel, and drag down for 100 rows for column A, and use random for
    column B)
     */

}

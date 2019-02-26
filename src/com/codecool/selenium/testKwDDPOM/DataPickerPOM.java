package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataPickerPOM {
    WebDriver driver;
    int index = 0;

    By inputSelectDate = By.xpath("//*[@id=\"sandbox-container1\"]/div/input");
    By buttonShowCalendar = By.xpath("//*[@id=\"sandbox-container1\"]/div/span/i");
    By locationDaysOfWeekHeadTable = By.xpath("/html/body/div[3]/div[1]/table/thead/tr[3]/th[" + index + "]");
    By locationNumberOfCalendar = By.xpath("//*[@className='table-condensed']//td");


    public DataPickerPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void setDate(String url, String date) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(inputSelectDate).sendKeys(date);
    }

    public String getday() {
        driver.findElement(buttonShowCalendar).click();

        List<WebElement> numbersOfCalendar = driver.findElements(locationNumberOfCalendar);
        for (WebElement number : numbersOfCalendar) {
            index++;
            if (number.getAttribute("class").equals("active day")) {
                index = (index%7)+1;
                break;
            }
        }

        return driver.findElement(locationDaysOfWeekHeadTable).getText();
    }
}

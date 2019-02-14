package com.codecool.selenium.testKwDDPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyWords {
    WebDriverWait webDriverWait;
    WebDriver driver;

    public void iniFireFoxDriver() {
        System.setProperty("webdriver.gecko.driver", "/home/reka/4_test_modul/selenium_for_java/geckodriver" );
        this.driver = new FirefoxDriver();
        this.webDriverWait = new WebDriverWait(driver, 5);
    }

    public void closeDriver() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setUrl(String url) {
        driver.get(url);
    }

    public void clickElement(By setElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(setElement)).click();
    }

    public void sendKeys(By inputField, String message) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(inputField)).clear();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(inputField)).sendKeys(message);
    }

    public String getInnerText(By locationOfInnerText) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locationOfInnerText)).getText();
    }

    public String getValueAttribute(By locationOfValue) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locationOfValue)).getAttribute("value");
    }

    public void selectDropDownByValue (By locationOfDropdown, String dayOfWeek) {
        Select select = new Select(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locationOfDropdown)));
        select.selectByValue(dayOfWeek);
    }
}

package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\firefox\\geckodriver.exe");
        return new FirefoxDriver();
    }

    public static String getBaseUrl(){
        return "https://www.saucedemo.com/";
    }
}

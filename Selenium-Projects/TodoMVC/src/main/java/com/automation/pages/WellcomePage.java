package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WellcomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[text()='React']/parent::a")
    WebElement reactLink;

    @FindBy(xpath = "//span[text()='Preact']/parent::a")
    WebElement preactLink;

    @FindBy(xpath = "//span[text()='Ember.js']/parent::a")
    WebElement emberLink;

    public WellcomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickOnReactLink() {
        wait.until(ExpectedConditions.visibilityOf(reactLink)).click();
    }

    public void clickOnPreactLink() {
        wait.until(ExpectedConditions.visibilityOf(preactLink)).click();
    }

    public void clickOnEmberLink() {
        wait.until(ExpectedConditions.visibilityOf(emberLink)).click();
    }

}

package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement textBoxFirstName;

    @FindBy(id = "last-name")
    WebElement textBoxLastName;

    @FindBy(id = "postal-code")
    WebElement textBoxPostalCode;

    @FindBy(id = "continue")
    WebElement buttonContinue;


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fieldForm(String firstName, String lastName, String zipCode){
        textBoxFirstName.sendKeys(firstName);
        textBoxLastName.sendKeys(lastName);
        textBoxPostalCode.sendKeys(zipCode);

    }

    public void clickButtonContinue(){
        buttonContinue.click();
    }
}

package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class BackgroundSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("^the user is logged in with (.+) and (.+)")
    public void the_user_is_logged_in_with_standard_user_and_secret_sauce(String user, String password) {
        driver.get(DriverFactory.getBaseUrl());
        loginPage.enterUsername(user);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

}
















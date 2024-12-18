package com.automation.steps;

import com.automation.pages.*;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(DriverFactory.getBaseUrl());
    }
    @When("^the user enters (.+) and (.+)")
    public void the_user_enters_credentials(String user, String password) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(password);
    }
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLogin();
    }
    @Then("the user is redirected to the products page")
    public void the_user_is_redirected_to_the_products_page() {
        assertTrue(productsPage.isProductsPage());
        DriverFactory.quitDriver();
    }

    @Then("an error message of {string} is displayed")
    public void an_error_message_of_is_displayed(String message) {
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains(message));
        DriverFactory.quitDriver();
    }
}

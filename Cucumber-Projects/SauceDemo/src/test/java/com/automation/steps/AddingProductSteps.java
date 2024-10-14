package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddingProductSteps {
    WebDriver driver;

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    String productNameInProducts;


    @Given("^the user is logged in with (.+) and (.+)")
    public void the_user_is_logged_in_with_standard_user_and_secret_sauce(String user, String password) {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        driver.get(DriverFactory.getBaseUrl());
        loginPage.enterUsername(user);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {
        productsPage = new ProductsPage(driver);


        productNameInProducts = productsPage.getFirstProductName();
        productsPage.clickFirstAddCartButton();

    }
    @Then("the product should appear in the shopping cart")
    public void the_product_should_appear_in_the_shopping_cart() {
        productsPage.clickCartLink();
        cartPage = new CartPage(driver);
        assertEquals(productNameInProducts,cartPage.getFirstProductName());
        driver.quit();
    }
}
















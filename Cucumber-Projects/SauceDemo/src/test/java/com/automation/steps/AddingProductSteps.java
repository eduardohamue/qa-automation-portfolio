package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.pages.ProductsPage;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class AddingProductSteps {
    WebDriver driver = DriverFactory.getDriver();

    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);
    String productNameInProducts;


    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {

        productNameInProducts = productsPage.getFirstProductName();
        productsPage.clickMultipleAddCartButtons(1);
    }
    @Then("the product should appear in the shopping cart")
    public void the_product_should_appear_in_the_shopping_cart() {
        productsPage.clickCartLink();
        assertEquals(productNameInProducts,cartPage.getFirstProductName());
        DriverFactory.quitDriver();
    }
}
















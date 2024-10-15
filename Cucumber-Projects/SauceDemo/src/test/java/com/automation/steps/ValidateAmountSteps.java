package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.pages.CheckoutOverviewPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.ProductsPage;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ValidateAmountSteps {
    WebDriver driver = DriverFactory.getDriver();

    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    double productsAmount;

    @When("the user adds {int} products to the cart")
    public void the_user_adds_products_to_the_cart(Integer n) {
        productsPage.clickMultipleAddCartButtons(n);

        // Sum all the cost of the products that was added to cart
        productsAmount = productsPage.getSumAmountProductsAdded();
    }

    @Then("the user proceeds to the cart")
    public void the_user_proceeds_to_the_cart() {
        productsPage.clickCartLink();

        // Sum all the cost of the products that are in the cart page
        double cartAmount = cartPage.getSumAmountProductsInCart();

        // Validate that the sum of the products get in the last page is the same that the products in the current
        assertEquals(cartAmount, productsAmount,0);

    }
    @Then("the user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        cartPage.clickCheckoutButton();
    }
    @Then("the user field {string}, {string}, and {string}")
    public void the_user_field(String firstName, String lastName, String zipCode) {
        checkoutPage.fieldForm(firstName, lastName, zipCode);
    }
    @When("the user clicks the continue button")
    public void the_user_clicks_the_continue_button() {
        checkoutPage.clickButtonContinue();

    }
    @Then("the total amount should be the sum of the prices of both products")
    public void the_total_amount_should_be_the_sum_of_the_prices_of_both_products() {

        // Sum all the cost of the products that are in the overview page
        double overviewAmounmt = checkoutOverviewPage.getSumAmountProductsOverview();

        // Validate that the sum of the products get in the last page is the same that the products in the current
        assertEquals(overviewAmounmt, productsAmount,0);

        // Get the value that the web site calculate about the sum of the cost of the products
        double amountGenerated = checkoutOverviewPage.getItemTotal();

        // Validate that the sum of the products get in the last page is the same that the web site show us
        assertEquals(amountGenerated,productsAmount,0);
        
        DriverFactory.quitDriver();
    }

}
















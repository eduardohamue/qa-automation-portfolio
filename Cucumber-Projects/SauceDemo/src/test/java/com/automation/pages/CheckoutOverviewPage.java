package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage {
    WebDriver driver;

    @FindBy(className = "cart_item")
    List<WebElement> productsOverview;

    @FindBy(className = "summary_subtotal_label")
    WebElement subtotalLabel;

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public double getSumAmountProductsOverview(){
        double amount = 0;
        for (WebElement product : productsOverview) {

            //Get the cost of the product
            WebElement poductMoney = product.findElement(By.className("inventory_item_price"));
            String priceString = poductMoney.getText();

            //Convert the cost to a double
            double price = Double.parseDouble(priceString.replace("$", ""));

            //Add the cost of the products
            amount += price;
        }

        //Return the sum of the products
        return amount;
    }

    public double getItemTotal(){
        String itemTotalText = subtotalLabel.getText();
        String priceString = itemTotalText.replaceAll("[^0-9.]", "");
        return Double.parseDouble(priceString);
    }
}

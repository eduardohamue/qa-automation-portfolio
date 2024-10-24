package com.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    WebDriver driver;

    @FindBy(className = "inventory_list")
    WebElement inventoryList;


    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    @FindBy(xpath = "//button[text()='Add to cart']/ancestor::div[@class='inventory_item']")
    List<WebElement> productsCabBeAdded;

    @FindBy(xpath = "//button[text()='Remove']/ancestor::div[@class='inventory_item']")
    List<WebElement> productsAddedToCar;



    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstProductName(){
        WebElement itemName = productsCabBeAdded.getFirst().findElement(By.className("inventory_item_name"));
        return itemName.getText();
    }

    public boolean isProductsPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public void clickCartLink(){
        cartLink.click();
    }

    //Add to the cart amount n of products
    public void clickMultipleAddCartButtons(int n){
        for(int i = 0; i < n; i++){
            WebElement buttonAddProduct= productsCabBeAdded.get(i).findElement(By.xpath("//button[text()='Add to cart']"));
            buttonAddProduct.click();
        }
    }

    public double getSumAmountProductsAdded(){
        double amount = 0;

        //The variable productsAddedToCar is called for first time so its going to get all the products that was added to teh cart in previous steps
        for (WebElement product : productsAddedToCar) {

            //Get the cost of the product
            WebElement poductMoney = product.findElement(By.className("inventory_item_price"));
            String priceString = poductMoney.getText();

            //Convert the cost to a double
            double price = Double.parseDouble(priceString.replace("$", ""));

            //Add the cost of the productsAddedToCar
            amount += price;
        }

        //Return the sum of the productsAddedToCar
        return amount;
    }
}

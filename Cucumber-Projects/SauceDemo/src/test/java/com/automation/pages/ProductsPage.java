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

    public void clickMultipleAddCartButtons(int n){
        for(int i = 0; i < n; i++){
            WebElement buttonAddProduct= productsCabBeAdded.get(i).findElement(By.xpath("//button[text()='Add to cart']"));
            buttonAddProduct.click();
        }
    }

    public double getSumAmountProductsAdded(){
        List<WebElement> products = driver.findElements(By.xpath("//button[text()='Remove']/ancestor::div[@class='inventory_item']"));

        double amount = 0;

        for (WebElement product : products) {
            WebElement poductMoney = product.findElement(By.className("inventory_item_price"));
            String priceString = poductMoney.getText();
            double price = Double.parseDouble(priceString.replace("$", ""));
            amount += price;
        }
        return amount;
    }
}

package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(className = "cart_list")
    WebElement cartList;

    private final WebElement firstCartItem;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

        //Get the first product of the cart
        firstCartItem = cartList.findElement(By.className("cart_item"));

    }
    public String getFirstProductName(){
        WebElement itemName = firstCartItem.findElement(By.className("inventory_item_name"));
        return itemName.getText();
    }
}

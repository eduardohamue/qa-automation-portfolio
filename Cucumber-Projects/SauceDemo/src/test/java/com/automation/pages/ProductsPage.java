package com.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;

    @FindBy(className = "inventory_list")
    WebElement inventoryList;


    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    private final WebElement firstInventoryItem;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        //Get the first product of the page
        firstInventoryItem = inventoryList.findElement(By.className("inventory_item"));
    }

    public String getFirstProductName(){
        WebElement itemName = firstInventoryItem.findElement(By.className("inventory_item_name"));
        return itemName.getText();
    }

    public boolean isProductsPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public void clickFirstAddCartButton(){
        WebElement buttonAddProduct= firstInventoryItem.findElement(By.xpath("//button[text()='Add to cart']"));
        buttonAddProduct.click();
    }

    public void clickCartLink(){
        cartLink.click();
    }


}

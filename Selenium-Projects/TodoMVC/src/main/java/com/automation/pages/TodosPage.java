package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.time.Duration;

public class TodosPage {
    private final Logger logger = LogManager.getLogger(TodosPage.class);
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='todo-input']")
    WebElement tasksInputReact;

    @FindBy(xpath = "//input[@class='new-todo']")
    WebElement tasksInputGeneral;

    // Dynamic locators to be formatted with specific task names
    private final String dinamicTaskLocator = "//label[text()='%s']";
    private final String dinamicCheckBoxLocator = "//label[text()='%s']/preceding-sibling::input[@type='checkbox']";
    private final String dinamicDeleteButton = "//label[text()='%s']/following-sibling::button[@class='destroy']";

    public TodosPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to select the correct input field based on the page and add a task
    public void fillOnTodosInput(String taskName, String page) {
        WebElement todosInput = page.equals("React") ? tasksInputReact : tasksInputGeneral;
        fillOnTodosInput(todosInput, taskName);
    }

    // Method to fill in a to-do task in the input field and verify if the task was added
    public void fillOnTodosInput(WebElement todosInput, String taskName) {
        wait.until(ExpectedConditions.visibilityOf(todosInput));
        todosInput.sendKeys(taskName + Keys.ENTER);
        boolean isTaskOnePresent = isTaskPresent(taskName);
        if (isTaskOnePresent) {
            logger.info(String.format("Task '%s' was added successfully.", taskName));
        } else {
            logger.error(String.format("Task '%s' was not found.", taskName));
        }
    }

    // Method to check if a task is present in the to-do list by locator based in task name
    public boolean isTaskPresent(String taskName) {
        By taskLocator = By.xpath(String.format(dinamicTaskLocator, taskName));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(taskLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to locate and click the checkbox of a task to mark it as complete
    public void clickOnToCompleteCheckbox(String taskName) {
        String checkBoxLocator = String.format(dinamicCheckBoxLocator,taskName);

        WebElement toCompleteCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkBoxLocator)));

        // Now click on the element
        toCompleteCheckbox.click();

        boolean isTaskCompleted = isTaskCompleted(toCompleteCheckbox);

        if (isTaskCompleted) {
            logger.info("Task completed successfully.");
        } else {
            logger.error("Task not completed.");
        }
    }

    private boolean isTaskCompleted(WebElement task){
        return validateComplete(task);
    }

    public boolean isTaskCompleted(String taskName){
        WebElement task = getTaskWebElement(taskName);
        return validateComplete(task);
    }

    //Validate if the grand parent element has marked as complete
    private boolean validateComplete(WebElement task){
        WebElement grandparent = task.findElement(By.xpath("./ancestor::li"));
        String className = grandparent.getAttribute("class");
        return className.equals("completed");
    }

    public void mouseOverTask(String taskName){
        WebElement task = getTaskWebElement(taskName);
        Actions actions = new Actions(driver);
        actions.moveToElement(task).perform();
    }

    private WebElement getTaskWebElement(String taskName){
        // Locate the task based on its name
        String taskLocator = String.format(dinamicTaskLocator,taskName);
        return driver.findElement(By.xpath(taskLocator));
    }

    public void clickOnDeleteButton(String taskName) {
        String deleteButtonLocator = String.format(dinamicDeleteButton, taskName);

        WebElement deleteCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(deleteButtonLocator)));

        // Now click on the element
        deleteCheckbox.click();
    }
}

package com.automation.tests;

import com.automation.pages.TodosPage;
import com.automation.pages.WellcomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public static WebDriver driver;
    public static WellcomePage wellcomePage;
    public static TodosPage todosPage;

    // Initialize WebDriver before all tests
    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
    }


    @BeforeEach
    public void initializeTest() {
        //Open browser in the Web Site
        driver.get("https://todomvc.com/");
        // Set up page objects before each test
        wellcomePage = new WellcomePage(driver);
        todosPage = new TodosPage(driver);
    }

    //Give a moment to see the final result and close the browser
    @AfterAll
    public static void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

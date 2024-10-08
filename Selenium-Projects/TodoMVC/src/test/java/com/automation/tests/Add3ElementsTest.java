package com.automation.tests;

import com.automation.pages.TodosPage;
import com.automation.pages.WellcomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Add3ElementsTest {

    public static WebDriver driver;
    public static WellcomePage wellcomePage;
    public static TodosPage todosPage;

    // Initialize WebDriver before all tests
    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\firefox\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    // Set up page objects before each test
    @BeforeEach
    public void initializeTest() {
        // Load the initial URL for the test
        driver.get("https://todomvc.com/");
        wellcomePage = new WellcomePage(driver);
        todosPage = new TodosPage(driver);
    }

    // Test to add three tasks to the to-do list and verify their presence
    @Test
    public void test1() {


        wellcomePage.clickOnReactLink();

        todosPage.fillOnTodosInput("one","React");
        todosPage.fillOnTodosInput("two","React");
        todosPage.fillOnTodosInput("three","React");

        // Validate that all tasks are present in the to-do list
        Assertions.assertTrue(todosPage.isTaskPresent("one"),"Task 'one' should be present");
        Assertions.assertTrue(todosPage.isTaskPresent("two"),"Task 'two' should be present");
        Assertions.assertTrue(todosPage.isTaskPresent("three"),"Task 'three' should be present");
    }

    @AfterAll
    public static void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

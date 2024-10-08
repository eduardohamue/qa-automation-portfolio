package com.automation.tests;

import com.automation.pages.TodosPage;
import com.automation.pages.WellcomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MarkTaskAsCompletedTest {

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
        String taskName = "To Complete";

        wellcomePage.clickOnPreactLink();

        todosPage.fillOnTodosInput(taskName, "Preact");

        // Validate that the task is present in the to-do list
        Assertions.assertTrue(todosPage.isTaskPresent(taskName),"Task '" + taskName + "' should be present");

        todosPage.clickOnToCompleteCheckbox(taskName);
        // Validate that the task is complete
        Assertions.assertTrue(todosPage.isTaskCompleted(taskName), "Task '" + taskName + "' should be complete");

    }

    @AfterAll
    public static void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

package com.automation.tests;

import org.junit.jupiter.api.*;

public class Add3ElementsTest extends BaseTest {

    @Test
    public void testAddThreeTasks() {
        // Go to task page
        wellcomePage.clickOnReactLink();

        //Indicate the name of the tasks that we want to add and specify the page
        todosPage.fillOnTodosInput("one", "React");
        todosPage.fillOnTodosInput("two", "React");
        todosPage.fillOnTodosInput("three", "React");


        //Validate that all the tasks are in the page
        Assertions.assertTrue(todosPage.isTaskPresent("one"), "Task 'one' should be present");
        Assertions.assertTrue(todosPage.isTaskPresent("two"), "Task 'two' should be present");
        Assertions.assertTrue(todosPage.isTaskPresent("three"), "Task 'three' should be present");
    }
}

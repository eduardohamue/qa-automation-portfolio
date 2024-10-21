package com.automation.tests;

import org.junit.jupiter.api.*;

public class MarkTaskAsCompletedTest extends BaseTest {

    @Test
    public void testMarkTaskAsCompleted() {
        String taskName = "To Complete";

        // Go to task page
        wellcomePage.clickOnPreactLink();

        //Indicate the name of the tasks that we want to add and specify the page
        todosPage.fillOnTodosInput(taskName, "Preact");

        //Validate that the task is on the page
        Assertions.assertTrue(todosPage.isTaskPresent(taskName), "Task '" + taskName + "' should be present");

        // Complete the task
        todosPage.clickOnToCompleteCheckbox(taskName);

        // Validate that the task is completed
        Assertions.assertTrue(todosPage.isTaskCompleted(taskName), "Task '" + taskName + "' should be complete");
    }
}

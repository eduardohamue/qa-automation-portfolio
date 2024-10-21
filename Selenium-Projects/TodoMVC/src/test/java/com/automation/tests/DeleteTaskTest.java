package com.automation.tests;

import org.junit.jupiter.api.*;

public class DeleteTaskTest extends BaseTest {

    @Test
    public void testDeleteTask() {
        String taskName = "To Delete";

        // Go to task page
        wellcomePage.clickOnEmberLink();

        //Indicate the name of the tasks that we want to add and specify the page
        todosPage.fillOnTodosInput(taskName, "Preact");

        //Validate that the task is on the page
        Assertions.assertTrue(todosPage.isTaskPresent(taskName), "Task '" + taskName + "' should be present");

        todosPage.mouseOverTask(taskName);
        todosPage.clickOnDeleteButton(taskName);


        //Validate that the task is not on the page
        Assertions.assertFalse(todosPage.isTaskPresent(taskName), "Task '" + taskName + "' should be deleted");
    }
}

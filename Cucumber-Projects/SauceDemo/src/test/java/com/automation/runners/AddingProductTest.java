package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/addingProduct.feature", glue = "com.automation.steps",
        plugin = {"pretty", "html:target/addingProductReport.html"})
public class AddingProductTest {

}

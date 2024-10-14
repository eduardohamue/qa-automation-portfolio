package com.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/login.feature", glue = "com.automation.steps",
        plugin = {"pretty", "html:target/loginReport.html"})
public class RunLoginTest {

}

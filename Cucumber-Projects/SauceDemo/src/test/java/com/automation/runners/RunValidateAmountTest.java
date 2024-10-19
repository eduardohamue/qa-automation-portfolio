package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/validateAmount.feature", glue = "com.automation.steps",
        plugin = {"pretty", "html:target/ValidateAmountReport.html"})
public class RunValidateAmountTest {

}

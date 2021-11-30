package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "resources", glue= {"stepDefinitions"}, plugin = { "pretty", "html:target/cucumber-report.html" }, monochrome = true)
public class TestRunner {

}

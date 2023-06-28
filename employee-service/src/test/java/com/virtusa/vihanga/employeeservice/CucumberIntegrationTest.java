package com.virtusa.vihanga.employeeservice;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "classpath:/features", glue = "com.virtusa.vihanga.employeeservice.cucumberglue", plugin = { "pretty", "html:target/cucumber-reports.html" },
            monochrome = true)
    public class CucumberIntegrationTest {
    }

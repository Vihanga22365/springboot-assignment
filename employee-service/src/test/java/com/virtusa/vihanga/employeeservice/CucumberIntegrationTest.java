package com.virtusa.vihanga.employeeservice;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "classpath:/features", glue = "com.virtusa.vihanga.employeeservice.cucumberglue", plugin = {
            "junit:target/cucumber-results.xml",
            "html:target/cucumber-html-report"
            },
            monochrome = true)
    public class CucumberIntegrationTest {
    }

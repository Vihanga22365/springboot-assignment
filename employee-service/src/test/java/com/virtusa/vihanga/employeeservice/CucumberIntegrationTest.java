package com.virtusa.vihanga.employeeservice;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features", glue = "com.virtusa.vihanga.employeeservice.cucumberglue")
public class CucumberIntegrationTest {
}

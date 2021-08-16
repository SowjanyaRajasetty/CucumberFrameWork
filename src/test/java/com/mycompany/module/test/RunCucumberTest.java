package com.mycompany.module.test;

import org.junit.runner.RunWith;
import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/main/resources/Features/"},
		glue= {"com.mycompany.glue.runnables"},
		tags= "@FlightBookingwithLogin",
		plugin= {
//				"html:target/cucumber-reports/Cucumber.html", 
				"json:target/cucumber/cucumber.json"},
		monochrome = true
		)
public class RunCucumberTest {

}

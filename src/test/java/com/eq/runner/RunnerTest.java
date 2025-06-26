package com.eq.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/feature/Login.feature"}
		,glue = {"com.eq.steps"}
		//,dryRun = true
//		,publish = true
		,plugin = {"html:target/cucumber-report.html"}
		,tags = "@invalid"
	    
		)

public class RunnerTest extends AbstractTestNGCucumberTests
{

}

package com.eq.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/feature"}
		,glue = {"com.eq.steps","com.eq.base"}
		//,dryRun = true
//		,publish = true
		,plugin = {"html:target/cucumber-report.html"}
		,tags = "@valid" 
		)

public class RunnerTest extends AbstractTestNGCucumberTests
{

}

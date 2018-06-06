package uk.nhs.nhsbsa.ccchs.steps.hooks;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class Hooks
{
	@Before("@smoke")
	public void beforeScenario1(Scenario scenario) throws IOException
	{
		System.out.println("***** START of Scenario: " + scenario.getName() + " *****");
		System.out.println("Test setup - insert any test setup here");
	}

	@After("@smoke")
	public void tearDown1(Scenario scenario) throws Exception
	{
		System.out.println("***** END of Scenario: " + scenario.getName() + " *****");
		System.out.println("Test teardown - insert any post test activities here");
	}

}	

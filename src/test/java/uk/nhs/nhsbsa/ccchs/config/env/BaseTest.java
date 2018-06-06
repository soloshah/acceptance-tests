package uk.nhs.nhsbsa.ccchs.config.env;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.AssertionMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.ClickElementsMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.ConfigurationMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.InputMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.JavascriptHandlingMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.MiscMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.NavigateMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.ProgressMethods;
import uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods.ScreenShotMethods;

public interface BaseTest
{
	public static WebDriver driver = Env.CreateWebDriver(Env.getBrowserName());
	public static WebDriverWait wait = new WebDriverWait(driver, 30);

	MiscMethods miscmethodObj = new MiscMethods();
	NavigateMethods navigationObj = new NavigateMethods();
	AssertionMethods assertionObj = new AssertionMethods();
	ClickElementsMethods clickObj = new ClickElementsMethods();
	ConfigurationMethods configObj = new ConfigurationMethods();
	InputMethods inputObj = new InputMethods();
	ProgressMethods progressObj = new ProgressMethods();
	JavascriptHandlingMethods javascriptObj = new JavascriptHandlingMethods();
	ScreenShotMethods screenshotObj = new ScreenShotMethods();

	public static boolean retryingFindClick(String str)
	{
		boolean result = false;
		int attempts = 0;
		while (attempts < 5000)
		{
			try
			{
				WebElement el = driver.findElement(By.linkText(str));
				scrollToElement(el);
				el.click();
				result = true;
				break;
			}
			catch (StaleElementReferenceException e)
			{
				System.out.println("Stale element");
			}
			attempts++;
		}
		return result;
	}

	public static boolean retryingFindClass(String str)
	{
		boolean result = false;
		int attempts = 0;
		while (attempts < 5000)
		{
			try
			{
				WebElement el = driver.findElement(By.className(str));
				scrollToElement(el);
				el.click();
				result = true;
				break;
			}
			catch (StaleElementReferenceException e)
			{
				System.out.println("Stale element");
			}
			attempts++;
		}
		return result;
	}

	public static void scrollToElement(WebElement el)
	{
		if (driver instanceof JavascriptExecutor)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
		}
	}
	
	
}

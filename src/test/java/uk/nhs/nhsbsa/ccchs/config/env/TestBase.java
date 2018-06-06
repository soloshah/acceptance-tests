package uk.nhs.nhsbsa.ccchs.config.env;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.nhs.nhsbsa.ccchs.utils.TestLogger;

import java.util.concurrent.TimeUnit;

public class TestBase {

	public WebDriver driver;
    
	private static int impWaitTimeout;

//    static {
//        if (driver == null) {
//            try {
//                InitDriver.initialize();
//                driver = WebDriverConfig.getDriver();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void mouseOver(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }
    
	public boolean isElementVisible(By by) {

		TestLogger.Info("looking for element " + by);

		if (driver.findElement(by).isDisplayed() == true) {
			return true;
		} else {
			return false;
		}
	}
    
    public boolean isElementPresent(By by) {

		try {

			TestLogger.Info("looking for element " + by);

			driver.findElement(by);

			return true;

		} catch (NoSuchElementException ex) {

			TestLogger.Error("could not find element " + by, ex);

			return false;
		}
	}
	
	public boolean waitForElement(String locator) {

		WebDriverWait wait = new WebDriverWait(driver, getImpWaitTimeout());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

		return true;
	}
	
	public static int getImpWaitTimeout() {
		return impWaitTimeout;
	}
	
	public void ReduceTimeout(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public void DefaultTimeout() {
		driver.manage().timeouts().implicitlyWait(getImpWaitTimeout(), TimeUnit.SECONDS);
	}
	
	public void Wait(int seconds) {

		long sleep = seconds * 1000;

		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			TestLogger.Error("Interrupted Exception: ", e);
		}
	}
}

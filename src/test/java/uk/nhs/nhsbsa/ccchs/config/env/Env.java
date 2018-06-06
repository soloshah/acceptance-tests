package uk.nhs.nhsbsa.ccchs.config.env;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Env
{
	static WebDriver driver = null;
	static String browserName = null;
	static String gridHostName = null;
	static String osName = null;
	
	public static final String USERNAME = "shabh";
	public static final String ACCESS_KEY = "bc5d483b-2d8f-4fd1-8090-4d70d16fdd15";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	protected static String sessionId;
	
	private static String hubUrl = EnvConfig.getGridHostName();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Env.class);
	
	
	public static String getHostName()
	{
		gridHostName = EnvConfig.getGridHostName();
		System.out.println("gridHostName: " + gridHostName);
		
		if (gridHostName == null)
			gridHostName = "http://192.168.99.100:5555/wd/hub";
		return gridHostName;
				
	}
	

	public static String getBrowserName()
	{
		browserName = EnvConfig.getBrowser();

		if (browserName == null)
			browserName = "ff";
		return browserName;
	}
	
	
	public static String findOS()
	{
		String space = " ";
		String aaa = null;
		
		osName = EnvConfig.getOperatingSystem_SauceLab();
		System.out.println("osName: " + osName);

		if (osName.contains("Windows")) {
			
			String os[]  = (EnvConfig.getOperatingSystem_SauceLab()).split("_");
			System.out.println("OS: " + os[0]);
			System.out.println("OS: " + os[1]);
			
			aaa = os[0] + space + os[1];
			System.out.println("aaa: " + aaa);
			
		}
		
		if (osName.matches("Linux")) {
			
			aaa = osName;
			
		}
		
		if (osName.contains("macOS")) {
			
			String os[]  = (EnvConfig.getOperatingSystem_SauceLab()).split("_");
			System.out.println("OS: " + os[0]);
			System.out.println("OS: " + os[1]);
			
			aaa = os[0] + space + os[1];
			System.out.println("aaa: " + aaa);
			
		}
		
		if (osName.contains("OS_X")) {
			
			String os[]  = (EnvConfig.getOperatingSystem_SauceLab()).split("_");
			System.out.println("OS: " + os[0]);
			System.out.println("OS: " + os[1]);
			System.out.println("OS: " + os[2]);
			
			aaa = os[0] + space + os[1] + space + os[2];
			System.out.println("aaa: " + aaa);
			
		}
		

		return aaa;
				
	}
	

	public static WebDriver CreateWebDriver(String browser)
	{
		System.out.println("Browser: " + browser);
		System.out.println("GridHostName: " + EnvConfig.getGridHostName());
		
		DesiredCapabilities dc = null;
		
		try {
		

		switch (browser.toLowerCase())
		{
			case "ff":
			case "firefox":
				String geckoDriverPath = "src//test//resources//drivers//geckodriver.exe";
				System.setProperty("webdriver.firefox.driver", geckoDriverPath);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;

			case "ch":
			case "chrome":
				String chromeDriverPath = "src//test//resources//drivers//chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				options.addArguments("start-maximized");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();    
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				driver.manage().window().maximize();
				break;
				
			case "ph":
			case "phantomjs":
				String phantomjsDriverPath = "src//test//resources//drivers//phantomjs.exe";
	    		DesiredCapabilities caps = new DesiredCapabilities();
	    		caps.setJavascriptEnabled(true); 
	    		caps.setCapability("cssSelectorsEnabled", false);
	    		caps.setCapability("takesScreenshot", true); 
	    		caps.setCapability("applicationCacheEnabled", true);
	    		caps.setCapability("acceptSslCerts",true);
	    		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjsDriverPath);
	    		driver = new  PhantomJSDriver(caps);
	    		driver.manage().window().maximize();
	    		break;
		
			case "ie":
			case "internetexplorer":
				String ieDriverPath = "src//test//resources//drivers//IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", ieDriverPath);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;
				
				/* Added new config for chrome and Phantomjs drivers for Linux platform */
				
			case "firefox_linux":
				String geckoDriverLinuxPath = "src//test//resources//drivers//geckodriver_linux";
				System.setProperty("webdriver.gecko.driver", geckoDriverLinuxPath);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
				
			case "chrome_linux":
				String chromeDriverPath_linux = "src//test//resources//drivers//chromedriver_linux";
				System.setProperty("webdriver.chrome.driver", chromeDriverPath_linux);
				ChromeOptions options_linux = new ChromeOptions();
				options_linux.addArguments("disable-infobars");
				options_linux.addArguments("start-maximized");
				DesiredCapabilities capabilities_linux = DesiredCapabilities.chrome();    
				capabilities_linux.setCapability(ChromeOptions.CAPABILITY, options_linux);
				driver = new ChromeDriver(capabilities_linux);
				break;
				
			case "phantomjs_linux":
				String phantomjsDriverPath_linux = "src//test//resources//drivers//phantomjs_linux";
	    		DesiredCapabilities caps_linux = new DesiredCapabilities();
	    		caps_linux.setJavascriptEnabled(true); 
	    		caps_linux.setCapability("cssSelectorsEnabled", false);
	    		caps_linux.setCapability("takesScreenshot", true); 
	    		caps_linux.setCapability("applicationCacheEnabled", true);
	    		caps_linux.setCapability("acceptSslCerts",true);
	    		caps_linux.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjsDriverPath_linux);
	    		driver = new  PhantomJSDriver(caps_linux);
	    		break;
	    		
	    		/* Added Selenium Grid browser config */
	    		
			case "chrome_grid":
				System.out.println("Create Chrome DesiredCapabilities object.");
				ChromeOptions options_grid = new ChromeOptions();
				options_grid.addArguments("--start-maximized");
				dc = DesiredCapabilities.chrome();
				dc.setBrowserName("chrome");
				dc.setPlatform(Platform.LINUX);
				DesiredCapabilities capabilities_grid = DesiredCapabilities.chrome();    
				capabilities_grid.setCapability(ChromeOptions.CAPABILITY, options_grid);
				driver = new RemoteWebDriver(new URL(hubUrl), dc);
				System.out.println("DRIVER CREATED");
				break;
				 
			case "firefox_grid":
				System.out.println("Create Firefox DesiredCapabilities object.");
				dc = DesiredCapabilities.firefox();
				dc.setBrowserName("firefox");
				dc.setPlatform(Platform.LINUX);
				
				driver = new RemoteWebDriver(new URL(hubUrl), dc);
				driver.manage().window().maximize();
				break;

			case "ie_grid":
				System.out.println("Create IE DesiredCapabilities object.");
				
				dc = DesiredCapabilities.internetExplorer();
				dc.setBrowserName("internetExplorer");
				dc.setPlatform(Platform.WINDOWS);
				
				driver = new RemoteWebDriver(new URL(hubUrl), dc);
				driver.manage().window().maximize();
				break;
				
			case "phantomjs_grid":
				System.out.println("Create Firefox DesiredCapabilities object.");
				dc = DesiredCapabilities.phantomjs();
				dc.setBrowserName("phantomjs");
				
				driver = new RemoteWebDriver(new URL(hubUrl), dc);
				driver.manage().window().maximize();
				break;

				
				/* SAUCELAB*/
				
			case "saucelab_chrome":
				DesiredCapabilities chrome_caps = DesiredCapabilities.chrome();
				chrome_caps.setCapability("platform", findOS());
				chrome_caps.setCapability("version", EnvConfig.getBrowserVersion_Saucelab());

			    driver = new RemoteWebDriver(new URL(URL), chrome_caps);

			    sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
				String message_chrome = String.format("SauceOnDemandSessionID=%1$s", sessionId);
			    System.out.println(message_chrome);

				break;
				
			case "saucelab_ie":
				DesiredCapabilities ie_caps = DesiredCapabilities.internetExplorer();
				ie_caps.setCapability("platform", "Windows 10");
				ie_caps.setCapability("version", "11.103");

			    driver = new RemoteWebDriver(new URL(URL), ie_caps);

			    sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
				String message_ie = String.format("SauceOnDemandSessionID=%1$s", sessionId);
			    System.out.println(message_ie);

				break;
				
			case "saucelab_firefox":			
				DesiredCapabilities firefox_caps = DesiredCapabilities.firefox();
				firefox_caps.setCapability("platform", EnvConfig.getOperatingSystem_SauceLab());
				firefox_caps.setCapability("version", EnvConfig.getBrowserVersion_Saucelab());

			    driver = new RemoteWebDriver(new URL(URL), firefox_caps);

			    sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
				String message_firefox = String.format("SauceOnDemandSessionID=%1$s", sessionId);
			    System.out.println(message_firefox);

				break;
				

			case "safari":
				// TODO
				driver = new SafariDriver();
				break;

			default:
				System.out.println("Invalid browser name " + browser);
				System.exit(0);
				break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run()
			{
				Env.initSeleniumEnd();
			}
		});
		
		}
		 catch (MalformedURLException ex) 
		{
			 /* If huburl is not formated correctly. */
			 ex.printStackTrace();
			 
		} 


		return driver;
	}
	

	private static void initSeleniumEnd()
	{
		LOGGER.info("===============================================================");
		LOGGER.info("|          Stopping driver (closing browser)                   |");
		LOGGER.info("===============================================================");
		driver.quit();
		LOGGER.debug("===============================================================");
		LOGGER.debug("|         Driver stopped (browser closed)                     |");
		LOGGER.debug("===============================================================\n");
	}
}


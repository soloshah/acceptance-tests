package uk.nhs.nhsbsa.ccchs.config.env;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvConfig extends Properties
{

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(EnvConfig.class);

	public static final String RESOURCES_PATH = "src/test/resources/";
	private static final String INIT_CONFIG_PATH = RESOURCES_PATH + "runConfig.properties";
	private static Properties initProperties;
	static Properties browserProperties;
	//static Properties browserProperties;

	private static String operatingSystem = System.getProperty("os.name");
	private static String testEnvironment;
	private static String testConfigPath;
	private static String browser;
	private static String browserConfigFile;
	private static String gridHostName;
	
	/* SAUCELAB*/
	private static String operatingSystem_SauceLab;
	private static String browserVersion_Saucelab;

	public EnvConfig()
	{
		try
		{
			testEnvironment = System.getProperty(ENV_PROPERTY, DEFAULT_ENV);
			browser = System.getProperty(BROWSER_PROPERTY, DEFAULT_BROWSER);
			gridHostName = System.getProperty(GRIDHOSTNAME_PROPERTY, DEFAULT_GRIDHOSTNAME);
			browserConfigFile = browser + ".properties";
			testConfigPath = RESOURCES_PATH + "environments/" + testEnvironment + "/test-config.properties";

			
			/* SAUCE LAB */
			operatingSystem_SauceLab = System.getProperty(OS_PROPERTY, DEFAULT_OS);
			browserVersion_Saucelab = System.getProperty(VERSION_PROPERTY, DEFAULT_VERSION);
			
			
			
			FileInputStream fileInputStream = new FileInputStream(testConfigPath);
			load(fileInputStream);

			FileInputStream browserPropertiesStream = new FileInputStream(RESOURCES_PATH + browserConfigFile);
			browserProperties = new Properties();
			browserProperties.load(browserPropertiesStream);

			if (browser.equals("chrome"))
			{
				if (SystemUtils.IS_OS_MAC)
				{
					System.setProperty("browser.driver.path", browserProperties.getProperty("browser.driver.path.mac"));
				}
				else if (SystemUtils.IS_OS_LINUX)
				{
					System.setProperty("browser.driver.path",
							browserProperties.getProperty("browser.driver.path.linux"));
				}
			}
		}
		catch (IOException e)
		{
			LOGGER.error(e);
		}
	}

	static
	{
		try
		{
			FileInputStream initPropertiesStream = new FileInputStream(INIT_CONFIG_PATH);
			initProperties = new Properties();
			initProperties.load(initPropertiesStream);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static final String ENV_PROPERTY = "env";
	public static final String BROWSER_PROPERTY = "browser";
	public static final String GRIDHOSTNAME_PROPERTY = "gridhostname";
	public static final String DEFAULT_ENV = initProperties.getProperty(ENV_PROPERTY);
	public static final String DEFAULT_BROWSER = initProperties.getProperty(BROWSER_PROPERTY);
	public static final String DEFAULT_GRIDHOSTNAME = initProperties.getProperty(GRIDHOSTNAME_PROPERTY);

	/* SAUCE LAB */
	public static final String OS_PROPERTY = "os";
	public static final String VERSION_PROPERTY = "version";
	public static final String DEFAULT_OS = initProperties.getProperty(OS_PROPERTY);
	public static final String DEFAULT_VERSION = initProperties.getProperty(VERSION_PROPERTY);
	
	
	
	static EnvConfig envConfig = new EnvConfig();

	public String getProperty(String key, boolean log)
	{
		String property = System.getProperty(key, super.getProperty(key));
		if (log)
			LOGGER.debug("getProperty: " + key + " = " + property);
		return property;
	}

	public String getProperty(String key)
	{
		return getProperty(key, false);
	}

	public static String getOperatingSystem()
	{
		return operatingSystem;
	}

	public static String getTestEnvironment()
	{
		return testEnvironment;
	}

	public static String getTestConfigPath()
	{
		return testConfigPath;
	}

	public static String getBrowser()
	{
		return browser;
	}
	
	public static String getGridHostName()
	{
		return gridHostName;
	}

	public static String getBrowserConfigFile()
	{
		return browserConfigFile;
	}
	
	public static String getOperatingSystem_SauceLab()
	{
		return operatingSystem_SauceLab;
	}
	
	public static String getBrowserVersion_Saucelab()
	{
		return browserVersion_Saucelab;
	}

}

package uk.nhs.nhsbsa.ccchs.config.env;

public enum Browser {
	IE("ie"), FIREFOX("firefox"), CHROME("chrome"), HTMLUNIT("htmlunit"), PHANTOMJS("phantomjs");

	private String driverKey;

	private Browser(String driverKey)
	{
		this.driverKey = driverKey;
	}

	public String getDriverKey()
	{
		return this.driverKey;
	}
}

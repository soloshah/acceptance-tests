package uk.nhs.nhsbsa.ccchs.config.env;

public class TestUtils
{

	public static void sleep(long milliseconds)
	{
		try
		{
			Thread.sleep(milliseconds);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

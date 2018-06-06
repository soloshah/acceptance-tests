package uk.nhs.nhsbsa.ccchs.env.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

public class PropertiesReader extends OrderedProperties
{

	private static final long serialVersionUID = 1L;

	public static String RESOURCES_PATH = "src/test/resources/";

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReader.class);

	public PropertiesReader()
	{
	}

	public PropertiesReader(String resourcePath)
	{
		init(null, getFileAsStream(resourcePath));
	}

	public PropertiesReader(String defaults, String resourcePath)
	{
		init(defaults, getFileAsStream(resourcePath));
	}

	public PropertiesReader(String defaults, InputStream inputStream)
	{
		init(defaults, inputStream);
	}

	protected void init(String defaults, InputStream inputStream)
	{
		if (defaults != null)
		{
			loadDefaults(defaults);
		}
		if (inputStream != null)
		{
			try
			{
				load(inputStream);
			}
			catch (IOException e)
			{
				LOGGER.error("IOException: {}", e);
			}
		}
	}

	protected FileInputStream getFileAsStream(String resourcePath)
	{
		FileInputStream fileInputStream = null;
		if (resourcePath != null)
		{
			try
			{
				fileInputStream = new FileInputStream(resourcePath);
			}
			catch (IOException e)
			{
				LOGGER.error("IOException reading resource {}; {}", resourcePath, e);
			}
		}
		return fileInputStream;
	}

	protected void loadDefaults(String defaults)
	{
		// load string as config if config file not found
		InputStream stream = new ByteArrayInputStream(defaults.getBytes(StandardCharsets.UTF_8));
		try
		{
			load(stream);
		}
		catch (IOException e)
		{
			LOGGER.error("IOException: {}", e);
		}
	}

	@Override
	public String getProperty(String key)
	{
		String property = System.getProperty(key, super.getProperty(key));
		return property;
	}

	public synchronized String toString()
	{
		int max = size() - 1;
		if (max == -1)
		{
			return "\n";
		}

		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();

		sb.append("\n");
		for (int i = 0;; i++)
		{
			Map.Entry<Object, Object> e = it.next();
			Object key = e.getKey();
			Object value = e.getValue();
			sb.append('\t');
			sb.append(key.toString());
			sb.append('=');
			sb.append(value.toString());

			sb.append("\n");
			if (i == max)
			{
				return sb.toString();
			}
		}
	}
}

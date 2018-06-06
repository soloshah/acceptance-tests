package uk.nhs.nhsbsa.ccchs.helpers;

import org.apache.log4j.Logger;

import uk.nhs.nhsbsa.ccchs.config.env.EnvConfig;
import uk.nhs.nhsbsa.ccchs.env.properties.PropertiesReader;

public class GenericData extends PropertiesReader {
    private static final Logger LOGGER = Logger.getLogger(GenericData.class);

    private GenericData() {
        super(EnvConfig.getTestConfigPath());
    }

    static GenericData genericData = new GenericData();

    public static final String HOMEPAGE_LINK_LOCALHOST = genericData.getProperty("env.baseurl");
    public static final String HOMEPAGE_LINK_SYS = genericData.getProperty("env.baseurl");
    public static final String HOMEPAGE_LINK_HERUKO = genericData.getProperty("env.baseurl");
    public static final String HOMEPAGE_LINK_CI = genericData.getProperty("env.baseurl");
}
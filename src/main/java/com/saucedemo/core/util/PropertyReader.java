package com.saucedemo.core.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private final String PROPERTY_FILE;

    public PropertyReader(String PROPERTY_FILE) {
        this.PROPERTY_FILE = PROPERTY_FILE;
    }

    /**
     * If system property is set - return system property value
     * If system property is not set - return property file value
     */
    public String getProperty(String propertyKey) {
        String systemProperty = System.getProperty(propertyKey);
        return StringUtils.isBlank(systemProperty) ? readProperties().getProperty(propertyKey) : systemProperty;
    }

    /**
     * If system property is set - return system property value
     * If system property is not set - return property file value
     * If neither system property nor property file value is set - return default value
     */
    public String getProperty(String propertyKey, String defaultValue) {
        String systemProperty = System.getProperty(propertyKey);
        String propertyFileValue = readProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(systemProperty)) {
            return systemProperty;
        } else if (StringUtils.isNotBlank(propertyFileValue)) {
            return propertyFileValue;
        }

        return defaultValue;
    }

    private Properties readProperties() {
        Properties properties = new Properties();

        try (InputStream fileInputStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(PROPERTY_FILE)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
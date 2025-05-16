package com.saucedemo.core.config;

import com.saucedemo.core.enums.BrowserEnum;
import com.saucedemo.core.util.PropertyReader;
import lombok.Getter;

@Getter
public class RunConfig {

    private final BrowserEnum browser;
    private final String environment;
    private final String chromeVersion;
    private final String firefoxVersion;

    public RunConfig(PropertyReader propertyReader) {
        environment = propertyReader.getProperty("environment");
        browser = BrowserEnum.valueOf(propertyReader.getProperty("browser").toUpperCase());
        chromeVersion = propertyReader.getProperty("chromeVersion");
        firefoxVersion = propertyReader.getProperty("firefoxVersion");
    }

}
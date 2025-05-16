package com.saucedemo.core.config;


import com.saucedemo.core.util.PropertyReader;
import lombok.Getter;

@Getter
public class EnvironmentConfig {

    private final String uiBaseUrl;
    private final String apiBaseUrl;
    private final String password;
    private final String userName;
    private final String lockedUsername;
    private final String problemUsername;

    public EnvironmentConfig(PropertyReader propertyReader) {

        uiBaseUrl = propertyReader.getProperty("ui.base.url");
        apiBaseUrl = propertyReader.getProperty("api.base.url");
        password = propertyReader.getProperty("password");
        userName = propertyReader.getProperty("username");
        lockedUsername = propertyReader.getProperty("lockedUsername");
        problemUsername = propertyReader.getProperty("problemUsername");

    }
}
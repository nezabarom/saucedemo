package com.saucedemo.core.config.manager;

import com.saucedemo.core.config.EnvironmentConfig;
import com.saucedemo.core.config.RunConfig;
import com.saucedemo.core.enums.Environment;
import com.saucedemo.core.util.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Log4j2
public class ConfigManager {
    public static final String RUN_CONFIG_FILE_NAME = "run.properties";
    public static final String ENV_CONFIG_FILE_NAME = "config/environments/%s.properties";
    private static EnvironmentConfig environmentConfig;
    private static RunConfig runConfig;

    private ConfigManager() {
    }

    public static EnvironmentConfig getEnvironmentConfig() {
        if (Objects.isNull(environmentConfig)) {
            PropertyReader propertyReader = getPropertyReaderForFile(getEnvironmentConfigFileName());
            environmentConfig = new EnvironmentConfig(propertyReader);
        }
        return environmentConfig;
    }

    public static RunConfig getRunConfig() {
        if (Objects.isNull(runConfig)) {
            PropertyReader propertyReader = getPropertyReaderForFile(RUN_CONFIG_FILE_NAME);
            runConfig = new RunConfig(propertyReader);
        }
        return runConfig;
    }

    private static String getEnvironmentConfigFileName() {
        String environment = System.getenv("ENV");
        if (environment == null) {
            return String.format(ENV_CONFIG_FILE_NAME, getRunConfig().getEnvironment());
        } else if (StringUtils.equalsAny(environment.toLowerCase().trim(), Environment.QA.getName(), Environment.PREPROD.getName())) {
            return String.format(ENV_CONFIG_FILE_NAME, environment.toLowerCase().trim());
        } else {
            return String.format(ENV_CONFIG_FILE_NAME, getRunConfig().getEnvironment());
        }
    }

    private static PropertyReader getPropertyReaderForFile(String file) {
        return new PropertyReader(file);
    }
}
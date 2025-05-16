package com.saucedemo.businnes.pages;

import com.saucedemo.core.config.EnvironmentConfig;
import com.saucedemo.core.config.manager.ConfigManager;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j2
public abstract class AbstractPage {

    protected static final EnvironmentConfig ENV_CONFIG = ConfigManager.getEnvironmentConfig();

    protected boolean isPageLoaded() {
        return executeJavaScript("return document.readyState").equals("complete");
    }
















}
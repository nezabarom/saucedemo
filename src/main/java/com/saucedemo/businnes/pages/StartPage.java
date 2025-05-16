package com.saucedemo.businnes.pages;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class StartPage extends AbstractPage {

    protected static final String START_PAGE_URL = ENV_CONFIG.getUiBaseUrl() + "/inventory.html";


}
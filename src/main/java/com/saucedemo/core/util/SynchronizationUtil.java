package com.saucedemo.core.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

@Log4j2
public class SynchronizationUtil {

    public static final Duration DEFAULT_WAIT_TIME = ofSeconds(30);

    public static void waitUntilElementIsDisplayed(SelenideElement element) {
        $(element).shouldBe(Condition.exist, DEFAULT_WAIT_TIME);
        $(element).shouldBe(enabled, DEFAULT_WAIT_TIME);
    }

}
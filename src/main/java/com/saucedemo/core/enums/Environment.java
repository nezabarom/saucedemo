package com.saucedemo.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Environment {

    QA("qa"),
    PREPROD("preprod");

    private final String name;
}
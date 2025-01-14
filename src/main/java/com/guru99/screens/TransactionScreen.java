package com.guru99.screens;

import org.openqa.selenium.By;
import naywiz.runner.Driver;

public class TransactionScreen {

    Driver driver;
    private String headerValueXpath = "//div[@class=\"transactions\"]/h3[text()=\"%s\"]";

    public TransactionScreen(Driver driver) {
        this.driver = driver;
    }

    public boolean isHeaderValueVisibleWithHeading(String headerValue) {
        return driver.isDisplayed(By.xpath(String.format(headerValueXpath, headerValue)));
    }
}

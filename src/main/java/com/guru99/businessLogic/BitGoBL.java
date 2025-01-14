package com.guru99.businessLogic;

import com.guru99.screens.TransactionScreen;
import naywiz.runner.CommonDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BitGoBL {

    public CommonDriver driver;

    public BitGoBL(CommonDriver driver) {
        this.driver = driver;
    }

    public void validateHeadingVisible() {
        boolean isHeadingVisible = new TransactionScreen(driver.getDriver())
                .isHeaderValueVisibleWithHeading("25 of 2875 Transactions");
        assertThat(isHeadingVisible).as("The heading value is not visible").isTrue();

    }
}

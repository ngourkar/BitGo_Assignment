package com.guru99.tests.ui;

import com.guru99.businessLogic.BitGoBL;
import naywiz.runner.CommonDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BitGoScenario {

    String BASE_URL = "https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732";
    public CommonDriver cd;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        cd = new CommonDriver("web", "chrome");
        cd.navigateToUrl(BASE_URL);
    }

    @Test
    public void validateHeaderVisible() {
        new BitGoBL(cd).validateHeadingVisible();
    }

    @AfterMethod
    public void tearDown() {
        cd.quit();
    }
}

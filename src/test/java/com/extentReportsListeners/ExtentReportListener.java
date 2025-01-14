package com.extentReportsListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//this ITestListener is interface which we need to implement, this listener is present in the testNg itself
//another way is to extend the TestListenerAdapter

public class ExtentReportListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("This is on start --- Test execution started");
    }

    @Override
    public void onTestStart(ITestResult result) {
       System.out.println("Before start of every method this will test");
    }

    @Override
    public void onTestFailure(ITestResult  result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed....");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Completed once all test is executed.....- On finish");
    }
}

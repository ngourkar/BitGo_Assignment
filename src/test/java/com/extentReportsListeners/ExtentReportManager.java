package com.extentReportsListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter extentSparkReporter; //looks after the UI of the reports like theme colour, font etc
    public ExtentReports extentReports; //populates the common info of the test result like name, environment, timestamp
    public ExtentTest extentTest; //creates entries of the test method and results of the test methods

    @Override
    public void onStart(ITestContext context) {
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
        extentSparkReporter.config().setDocumentTitle("NayWiz Results");
        extentSparkReporter.config().setReportName("googleTestScenarios");
        extentSparkReporter.config().setTheme(Theme.DARK);


        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Browser name", "chrome");
        extentReports.setSystemInfo("Executed by", "Nayan");

    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, "Test case passed is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, "Test case failed is:" + result.getName());
        extentTest.log(Status.FAIL, "Test failed due to reason: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }




}

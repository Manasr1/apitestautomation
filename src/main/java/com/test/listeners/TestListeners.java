package com.test.listeners;

import com.test.annotations.FrameworkAnnotations;
import com.test.reports.ExtentLogger;
import com.test.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
        ExtentReport.addAuthor(authors);

        String[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
        ExtentReport.addAuthor(categories);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+" test is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
    }
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.teardownReport();
    }
}

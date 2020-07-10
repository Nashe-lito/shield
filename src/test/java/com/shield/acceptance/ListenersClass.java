package com.shield.acceptance;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {

  @Override
  public void onStart(ITestContext context) {
    System.out.println("Start" + context.getName());
  }

  public void onFinish(ITestContext context) {
    System.out.println("Finish " + context.getName());
  }

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("Test Start " + result.getName());
  }

  @Override
  public void onTestSkipped(ITestResult arg0) {
    System.out.println("Test Skipped " + arg0.getName());
  }

  @Override
  public void onTestSuccess(ITestResult arg0) {
    System.out.println("Test Success " + arg0.getName());
  }

  @Override
  public void onTestFailure(ITestResult arg0) {
    System.out.println("Test Failure " + arg0.getName());
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

  }

  @Override
  public void onTestFailedWithTimeout(ITestResult arg0) {

  }
}

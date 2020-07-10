package com.shield.login;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class WebDriverSettings {
  public WebDriver driver;
  public WebDriverWait wait;

  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver();
    Dimension d = new Dimension(1400, 800);
    driver.manage().window().setSize(d);
    wait = new WebDriverWait(driver, 10);
    driver.get("https://shield.whileweb.com/");
    String title = driver.getTitle();
    Assert.assertTrue(title.equals("Shield"));
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  @AfterMethod
  public void failed(ITestResult arg0){
    if (arg0.FAILURE == arg0.getStatus()){
      screenFailure();
    }
  }

  public void screenFailure() {
    long now = System.currentTimeMillis();

    try {
      TakesScreenshot ts = (TakesScreenshot)driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(source, new File("src/test/screenshots/screen" + now + ".png" ));
      System.out.println("The screen is taken");
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}

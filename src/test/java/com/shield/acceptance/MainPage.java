package com.shield.acceptance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {
  private WebDriver driver;
  private WebDriverWait wait;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  public void openMainPage() {
    driver.get("https://shield.whileweb.com");
    String title = driver.getTitle();
    Assert.assertTrue(title.equals("Shield"));
  }

}

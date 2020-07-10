package com.shield.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
  private WebDriver driver;
  private WebDriverWait wait;

  public LogInPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(css = "[class=\"user__name\"]")
  WebElement wcabinetButton;

  By cabinetButton = By.cssSelector("[class=\"user__name\"]");
  By registerButton = By.cssSelector("a[href=\"https://shield.whileweb.com/register/\"]");

  public void openLoginPage() {
    driver.findElement(cabinetButton).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
  }
}

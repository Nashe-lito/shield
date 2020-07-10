package com.shield.login;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends WebDriverSettings{
  @Test
  public void loginTest() {
  driver.findElement(By.xpath("//div[@class=\"topnav__user --desktop-only\"]//a[@class=\"user__name\"]")).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

  driver.findElement(By.id("email")).sendKeys("test@test.test");
  driver.findElement(By.id("input-password")).sendKeys("12345678");
  driver.findElement(By.xpath("//button[@class='btn']")).click();

  String url = driver.getCurrentUrl();
  Assert.assertTrue(url.equals("https://shield.whileweb.com/my-account/"));
  }
}

package com.shield.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage {
  private WebDriver driver;
  private WebDriverWait wait;

  public RegistrationPage(WebDriver driver){
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(id = "register_firstname")
  WebElement firstname;

  @FindBy(id = "register_lastname")
  WebElement lastname;

  @FindBy(id = "register_email")
  WebElement email;

  @FindBy(xpath = "//input[@id='register_telephone']")
  WebElement telephone;

  @FindBy(id = "register_password")
  WebElement password;

  @FindBy(id = "register_confirm_password")
  WebElement confirm_password;

  //@FindBy( class="simpleregister-button-block buttons")

  By openRegisterPageButton = By.cssSelector("a[href=\"https://shield.whileweb.com/register/\"]");
  By registerForm = By.cssSelector("[class=\"simple-content form-page__content\"]");
  By registerUserButton = By.id("simpleregister_button_confirm");
  By checkoutResult = By.cssSelector("[class=\"checkout-result-page__info\"]");

  public void openRegisterPage() {
    driver.findElement(openRegisterPageButton).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(registerForm));
  }

  public void fillFirstName(String nameFirst) {
    firstname.click();
    firstname.sendKeys(nameFirst);
  }

  public void fillLastName(String nameLast) {
    lastname.sendKeys(nameLast);
  }

  public void fillEmail(String emailText) {
    email.sendKeys(emailText);
  }

  public void  fillTelephone(String tel) {
    telephone.click();
 //   telephone.sendKeys(tel);

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("document.getElementById('register_telephone').value=987165555");
   // jse.executeAsyncScript("document.getElementById('register_telephone').focus()");
  }

  public void fillPassword(String pass) {
    password.sendKeys(pass);
  }

  public void fillConfirmPassword(String confirmPass) {
    confirm_password.sendKeys(confirmPass);
  }

  public void clickRegButton() {
    driver.findElement(registerUserButton).click();
  }

  public void checkSuccessRegister() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutResult));
    String url = driver.getCurrentUrl();
    Assert.assertTrue(url.equals("https://shield.whileweb.com/index.php?route=account/success"));
  }
}

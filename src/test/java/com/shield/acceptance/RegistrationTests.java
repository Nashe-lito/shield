package com.shield.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends WebDriverSettings {
  Random random = new Random();
  int n = random.nextInt(100) + 1;

  String email = "test" + n + "@test.test";

  @BeforeMethod
  public void openRegisterForm() {
    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
    RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

    mainPage.openMainPage();
    logInPage.openLoginPage();
    registrationPage.openRegisterPage();
  }

  @Test// (enabled = false)
  public void testRegistrationWithValidData() {
    RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    Random random = new Random();
    int n = random.nextInt(100) + 1;

    String email = "test" + n + "@test.test";

    registrationPage.fillFirstName("Firstname");
    registrationPage.fillLastName("Lastname");
    registrationPage.fillEmail(email);
    registrationPage.fillTelephone("987165555");
    registrationPage.fillPassword("1qaz@WSX3edc");
    registrationPage.fillConfirmPassword("1qaz@WSX3edc");

    registrationPage.clickRegButton();
    registrationPage.checkSuccessRegister();
  }


  @Test(dataProvider = "getPositiveData")
  public void testPositiveData(String firstname, String lastname, String email, String telephone, String password, String confirm_password){
    RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);


  }

  @DataProvider (name = "getPositiveData")
  Object[][] getPositiveData() {
    String userData[][] = {
            {"Lin", "Лин", email, "987165555", "1234", "1234"},
            {"Ea eos harum eripuit '``enit exв", "Ea eos harum eripuit '``enit exв", email, "987165555", "1qaz@WSX3edc$RFV5tgb", "1qaz@WSX3edc$RFV5tgb"},
    };
    return (userData);
  }

  @Test(dataProvider = "getNegativeData")
  public void testNegative(String email, String tel, String firstname, String lastname, String password, String confirm_password) {
    RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

    registrationPage.fillEmail(email);
    registrationPage.fillTelephone(tel);

    registrationPage.fillFirstName(firstname);
    registrationPage.fillLastName(lastname);

    registrationPage.fillPassword(password);
    registrationPage.fillConfirmPassword(confirm_password);

    registrationPage.clickRegButton();

    //  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='simplecheckout-error-text simplecheckout-rule error-message']")));

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"simple-content form-page__content\"]")));
  }

  @DataProvider(name = "getNegativeData")
  Object[][] getNegativeData() {
    String userData[][] = {
            {email, "987165555", "Firstname", "Lastname", "1qaz@WSX3edc", "1qaz@WSX3edC"},
           /* {"Firstname", "Lastname", email, "987165555", "1qa", "1qa"},
            {"Firstname", "Lastname", email, "987165555", "1qaz@WSX3edc$RFV5tgb%", "1qaz@WSX3edc$RFV5tgb%"},
            {"Ea eos harum eripuit delenit exвв", "Lww", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Пупкин_Иван", "Lww", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Jy", "Lww", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"L!#$%&*+/=?^{|}~.l", "Lww", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"П2пкин И1ан", "Lww", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"<script>alert('XSS injections')</script>", "Lww", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Пупкин_Иван", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Ea eos harum eripuit delenit exвв", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Ea", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "L!#$%&*+/=?^{|}~.l", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "П2пкин И1ан", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "<script>alert('XSS injections')</script>", email, "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "email@googlecom", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "email@goo_gle.com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "email@google..com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", ".email@google.com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "email@google.com.", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "email@@google.com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "@email@google.com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "email@google.com@", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "em ail@google.com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "email@goo gle.com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "@google.com", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", "<script>alert(\'XSS injections\')</script>", "987165555", "1qaz@WSX3edc", "1qaz@WSX3edc"},
            {"Юля", "Lww", email, "987165555", "12345", "12345"},
            {"Юля", "Lww", email, "987165555", "1qaz@WSX3edc$RFV5tgbn", "1qaz@WSX3edc$RFV5tgbn"},*/

    };
    return (userData);
  }
}

package com.sena.tecmiecommercebackend.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Acceptance")
@Tag("Web")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserWebBrowserTest {
  private WebDriver driver;
  private ChromeOptions options;

  @BeforeAll
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.setBinary("/opt/google/chrome/google-chrome");
    options.addArguments("start-maximized");
    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    options.setExperimentalOption("useAutomationExtension", false);
    driver = new ChromeDriver(options);
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  @DisplayName("Cria uma conta de usuario")
  public void shoudCreateAccountTest() throws InterruptedException {
    driver.get("http://localhost:9191/");
    driver.manage().window().setSize(new Dimension(1920, 1053));
    driver.findElement(By.linkText("Accounts")).click();
    driver.findElement(By.linkText("Sign Up")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".text-center > .form-group:nth-child(1) > .form-control")).click();
    driver.findElement(By.cssSelector(".text-center > .form-group:nth-child(1) > .form-control")).sendKeys("luis1@email.com");
    driver.findElement(By.cssSelector(".col:nth-child(1) .form-control")).click();
    driver.findElement(By.cssSelector(".col:nth-child(1) .form-control")).sendKeys("luis");
    driver.findElement(By.cssSelector(".col:nth-child(2) .form-control")).click();
    driver.findElement(By.cssSelector(".col:nth-child(2) .form-control")).sendKeys("lima");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) > .form-control")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(3) > .form-control")).sendKeys("123456789");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) > .form-control")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(4) > .form-control")).sendKeys("123456789");
    driver.findElement(By.cssSelector(".btn-primary")).click();
    Thread.sleep(5000);
    var textoCadastro = driver.findElement(By.cssSelector(".swal-text")).getText();
    driver.findElement(By.cssSelector(".swal-button")).click();
    assertEquals("User signup successful. Please Login", textoCadastro);
  }
}

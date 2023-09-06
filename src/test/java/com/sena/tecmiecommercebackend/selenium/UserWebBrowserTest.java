package com.sena.tecmiecommercebackend.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

@Tag("Selenium")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserWebBrowserTest {
  private WebDriver driver;

  @BeforeAll
  public void setUp() {
    //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
//    driver = new ChromeDriver();
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(new File("src/test/resources/geckodriver").toPath());
    driver = new FirefoxDriver(options);
    driver.manage().window().maximize();
    //driver = WebDriverManager.chromedriver().create();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void shoudCreateAccountTest() {
    // Test name: criar-conta
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("http://localhost:8081/");
    // 2 | setWindowSize | 1920x1053 | 
    driver.manage().window().setSize(new Dimension(1920, 1053));
    // 3 | click | linkText=Accounts | 
    driver.findElement(By.linkText("Accounts")).click();
    // 4 | click | linkText=Sign Up | 
    driver.findElement(By.linkText("Sign Up")).click();
    // 5 | click | css=.text-center > .form-group:nth-child(1) > .form-control | 
    driver.findElement(By.cssSelector(".text-center > .form-group:nth-child(1) > .form-control")).click();
    // 6 | type | css=.text-center > .form-group:nth-child(1) > .form-control | luis@email.com
    driver.findElement(By.cssSelector(".text-center > .form-group:nth-child(1) > .form-control")).sendKeys("luis@email.com");
    // 7 | type | css=.col:nth-child(1) .form-control | Luís
    driver.findElement(By.cssSelector(".col:nth-child(1) .form-control")).sendKeys("Luís");
    // 8 | type | css=.col:nth-child(2) .form-control | Lima
    driver.findElement(By.cssSelector(".col:nth-child(2) .form-control")).sendKeys("Lima");
    // 9 | type | css=.form-group:nth-child(3) > .form-control | 123456789
    driver.findElement(By.cssSelector(".form-group:nth-child(3) > .form-control")).sendKeys("123456789");
    // 10 | type | css=.form-group:nth-child(4) > .form-control | 123456789
    driver.findElement(By.cssSelector(".form-group:nth-child(4) > .form-control")).sendKeys("123456789");
    // 11 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
    // 12 | mouseOver | css=.btn-primary | 
    WebElement element = driver.findElement(By.cssSelector(".btn-primary"));
    Actions builder = new Actions(driver);
    builder.moveToElement(element).perform();
    // 13 | click | css=.swal-button | 
    driver.findElement(By.cssSelector(".swal-button")).click();
  }
}

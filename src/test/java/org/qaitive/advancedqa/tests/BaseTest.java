package org.qaitive.advancedqa.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    private static final String ETSY_COM = "https://www.etsy.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Step
    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();

        driver.navigate().to(ETSY_COM);
        wait = new WebDriverWait(driver, 10, 800);
    }

    @Step
    @AfterEach
    public void tearDown() {
        driver.quit();
    }


//    @BeforeEach
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/linux/chromedriver").getPath());
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-gpu");
////        options.setBinary("/usr/bin/google-chrome");
//        driver = new ChromeDriver(options);
//        driver.manage().window().setSize(new Dimension(1280, 1024));
//        driver.navigate().to(ETSY_COM);
//    }


}

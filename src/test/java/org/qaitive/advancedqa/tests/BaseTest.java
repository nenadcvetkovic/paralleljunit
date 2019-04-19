package org.qaitive.advancedqa.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    private static final String ETSY_COM = "https://www.etsy.com/";
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/linux/chromedriver").getPath());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.setBinary("/usr/bin/google-chrome");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.navigate().to(ETSY_COM);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}

package org.qaitive.advancedqa.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static final String BROWSER = System.getProperty("browser", "chrome");

    public static WebDriver getDriver() {
        if (BROWSER.equalsIgnoreCase("chrome")) {
            return getChrome();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            return getFirefox();
        } else if (BROWSER.equalsIgnoreCase("remote")) {
            return getRemote();
        } else {
            throw new RuntimeException("There is now browser: " + BROWSER);
        }
    }

    private static WebDriver getChrome() {


        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/linux/chromedriver").getPath());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
//        options.setBinary("/usr/bin/google-chrome");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1280, 1024));


//        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-gpu");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().setSize(new Dimension(1280, 1024));


        return driver;
    }

    private static WebDriver getFirefox() {
        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemResource("driver/geckodriver.exe").getPath());

        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);


        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.setCapability("marionette", true);
//        options.setHeadless(true);
        options.setLogLevel(FirefoxDriverLogLevel.INFO);

        return new FirefoxDriver(options);

    }

    private static WebDriver getRemote() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}

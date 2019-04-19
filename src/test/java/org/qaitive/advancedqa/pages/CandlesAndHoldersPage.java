package org.qaitive.advancedqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandlesAndHoldersPage extends PageFactory implements PageObject {
    @FindBy(xpath = "//h1[contains(text() , 'Candles & Holders')]")
    WebElement heading;
    private WebDriver driver;

    public CandlesAndHoldersPage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    public boolean isHeadingVisible() {
        return heading.isDisplayed() && heading.isEnabled();
    }

}

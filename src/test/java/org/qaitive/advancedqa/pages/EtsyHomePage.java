package org.qaitive.advancedqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyHomePage extends PageFactory implements PageObject {

    private WebDriver driver;

    @FindBy(css = ".etsy-icon.etsy-logo-svg-full")
    private WebElement logo;

    @FindBy(id = "desktop-category-nav")
    private WebElement etsyMenu;

    @FindBy(id = "global-enhancements-search-query")
    private WebElement etsySearchQuery;

    @FindBy(css = "[value='Search']")
    private WebElement etsySearchButton;

    public EtsyHomePage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    public SearchResultPage search(String text) {
        etsySearchQuery.clear();
        etsySearchQuery.sendKeys(text);

        etsySearchButton.click();

        return new SearchResultPage(this.driver);
    }

    public CategoryPage clickMenuCategory(String category) {
        WebElement cat = etsyMenu.findElement(By.xpath(".//li[contains(. , '" + category + "')]/a/span"));
        cat.click();

        return new CategoryPage(this.driver);
    }

}

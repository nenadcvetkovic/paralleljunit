package org.qaitive.advancedqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CategoryPage extends PageFactory implements PageObject {
    @FindBy(css = ".search-listings-group .hide-xs.hide-lg > li")
    List<WebElement> categories;
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getVisibleCategories() {
        return categories;
    }
}

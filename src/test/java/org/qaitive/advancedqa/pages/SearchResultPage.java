package org.qaitive.advancedqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SearchResultPage extends PageFactory implements PageObject {
    private WebDriver driver;

    @FindBy(css = "[data-behat-search-results-lg] li")
    private List<WebElement> listSearchResults;

    @FindBy(id = "search-filter-reset-form")
    private WebElement searchFilter;

    public SearchResultPage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getSearchResults() {
        return listSearchResults;
    }

    public SearchResultPage chooseCategory(String category) {
        driver.findElement(By.xpath("//*[@id='search-filter-reset-form']//div[2]//li[contains(. , '" + category + "')]/a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchResultPage(this.driver);
    }

}
package org.qaitive.advancedqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebDriverWait wait = new WebDriverWait(driver, 5, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search-filter-reset-form']//li[contains(. , '" + category + "')]/a"))).click();

        return new SearchResultPage(this.driver);
    }

}

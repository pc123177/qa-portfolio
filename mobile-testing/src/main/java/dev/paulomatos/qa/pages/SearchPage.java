package dev.paulomatos.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    @AndroidFindBy(accessibility = "Search Wikipedia")
    private WebElement searchEntryPoint;

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private WebElement searchInput;

    @AndroidFindBy(id = "org.wikipedia:id/search_results_list")
    private WebElement resultsList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']")
    private java.util.List<WebElement> resultItems;

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void openSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchEntryPoint)).click();
    }

    public void search(String term) {
        wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(term);
    }

    public boolean hasResults() {
        try {
            wait.until(ExpectedConditions.visibilityOf(resultsList));
            return !resultItems.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstResultTitle() {
        wait.until(ExpectedConditions.visibilityOfAllElements(resultItems));
        return resultItems.get(0).getText();
    }
}

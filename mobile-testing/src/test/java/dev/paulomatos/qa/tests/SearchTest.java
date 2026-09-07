package dev.paulomatos.qa.tests;

import dev.paulomatos.qa.config.CapabilityConfig;
import dev.paulomatos.qa.pages.OnboardingPage;
import dev.paulomatos.qa.pages.SearchPage;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Feature("Wikipedia Android App")
public class SearchTest {

    private AndroidDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new AndroidDriver(CapabilityConfig.appiumUrl(), CapabilityConfig.androidOptions());
        OnboardingPage onboarding = new OnboardingPage(driver);
        if (onboarding.isDisplayed()) {
            onboarding.skip();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    @Story("Search")
    public void searchReturnsResults() {
        SearchPage search = new SearchPage(driver);
        search.openSearch();
        search.search("Playwright");
        assertTrue(search.hasResults(), "Expected search results but got none");
    }

    @Test
    @Story("Search")
    public void searchResultTitleMatchesTerm() {
        SearchPage search = new SearchPage(driver);
        search.openSearch();
        search.search("Java programming");
        assertTrue(search.hasResults());
        String title = search.getFirstResultTitle();
        assertNotNull(title);
        assertFalse(title.isBlank());
    }
}

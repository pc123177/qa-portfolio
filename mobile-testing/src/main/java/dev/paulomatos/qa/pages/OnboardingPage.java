package dev.paulomatos.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OnboardingPage extends BasePage {

    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_skip_button")
    private WebElement skipButton;

    public OnboardingPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        try {
            return skipButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void skip() {
        wait.until(ExpectedConditions.elementToBeClickable(skipButton)).click();
    }
}

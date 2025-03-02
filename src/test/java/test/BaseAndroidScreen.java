package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BaseAndroidScreen {
    private final WebDriverWait wait;
    private final AppiumDriver driver;

    public BaseAndroidScreen(AppiumDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }
    public void clickElement(WebElement element) {
        waitUntilElementClickable(element);
        element.click();
    }

    public String getElementText(WebElement element) {
        waitUntilElementVisible(element);
        return element.getText();
    }

    private void waitUntilElementClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Error waiting for element to be clickable: " + e.getMessage());
        }
    }
    public void sendKeys(WebElement element, String value) {
        waitUntilElementVisible(element);
        element.clear();
        element.sendKeys(value);
    }
    public void waitUntilElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Error waiting for element visibility: " + e.getMessage());
        }
    }
}

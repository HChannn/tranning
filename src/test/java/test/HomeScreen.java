package test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends BaseAndroidScreen {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='CNN']")
    private WebElement appIcon;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
    public void openApp() {
        appIcon.click();

    }
}

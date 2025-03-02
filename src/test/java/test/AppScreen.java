package test;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppScreen extends BaseAndroidScreen {
    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private static WebElement settingsBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.cnn.mobile.android.phone:id/layout_create_account']")
    private static WebElement createAccountBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Sign up']")
    private static WebElement signUpBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Email address']/ancestor::android.widget.EditText")
    private static WebElement emailInput;

    @FindBy(xpath = "//android.widget.TextView[@text='Password']/ancestor::android.widget.EditText")
    private static WebElement passwordInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.cnn.mobile.android.phone:id/account_text_view']")
    private static WebElement accountText;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.cnn.mobile.android.phone:id/account_logout_view']")
    private static WebElement logoutBtn;



    public AppScreen(AppiumDriver driver) {
        super(driver);
    }

    public void clickSettings() {
        clickElement(settingsBtn);
    }

    public void clickCreateAccount() {
        clickElement(createAccountBtn);
    }

    public void clickSignUp() {
        clickElement(signUpBtn);
    }


    public void enterEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public String getAccountText() {

        return getElementText(accountText);
    }

    public void clickAccountSetting() {
        clickElement(accountText);
    }

    public void clickLogoutButton() {
        clickElement(logoutBtn);
    }
}

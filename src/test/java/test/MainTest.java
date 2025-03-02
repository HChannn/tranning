package test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest extends BaseClass {

    //    @Test
//    public void runDemo() {
//        System.out.println("Hello Demo");
//    }
    public static final String EMAIL = "xxxxxxxxxxxxx@gmail.com";
    public static final String PASSWORD = "xxxxxxxxxxxx";
    private HomeScreen homeScreen;
    private AppScreen appScreen;

    @BeforeMethod
    public void setUp() throws Exception {
        if (driver == null) {
            setupDriver();
        }
        homeScreen = new HomeScreen(driver);
        appScreen = new AppScreen(driver);
    }


    @Test(priority = 1)
    public void testRegister() {

        homeScreen.openApp();
        appScreen.clickSettings();
        appScreen.clickCreateAccount();
        appScreen.enterEmail(EMAIL);
        appScreen.enterPassword(PASSWORD);
        appScreen.clickSignUp();

        Assert.assertEquals(appScreen.getAccountText(), EMAIL);
    }

    @Test(priority = 2)
    public void testLogout() {
        homeScreen.openApp();
        appScreen.clickSettings();
        appScreen.clickAccountSetting();
        appScreen.clickLogoutButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.terminateApp("com.cnn.mobile.android.phone");
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}

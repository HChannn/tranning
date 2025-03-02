package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService appiumServer;
    protected AppiumDriverLocalService appiumServer2;
    protected AppiumDriverLocalService appiumServer3;

    @BeforeClass
    public void setupDriver() throws Exception {
        appiumServer = new AppiumServiceBuilder() //obj
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File("appium.log"))
                .build();

        appiumServer.start();

        if (appiumServer.isRunning()) {
            System.out.println("Appium Server is running.");
        } else {
            System.out.println("Failed to start Appium Server.");
            return;
        }

        DesiredCapabilities caps = new DesiredCapabilities(); //obj

        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:platformVersion", "15.0");
//        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:automationName", "UiAutomator2");
//        caps.setCapability("appium:udid", "emulator-5554");
        caps.setCapability("appium:avd", "Pixel_9_Pro_API_35");
      //  caps.setCapability("appium:appPackage","com.google.android.apps.nexuslauncher");
      //  caps.setCapability("appium:appActivity", ".NexusLauncherActivity");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        waitForEmulatorToBeReady();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (appiumServer != null) {
            appiumServer.stop();
        }
        System.out.println("Everything are done");
    }

    private void waitForEmulatorToBeReady() throws IOException, InterruptedException {
        System.out.println("Waiting for emulator to be ready...");
        int maxWaitTime = 180; // seconds
        int elapsed = 0;

        while (elapsed < maxWaitTime) {
            Process process = Runtime.getRuntime().exec("adb shell getprop sys.boot_completed");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.readLine();

            if (output != null && output.equals("1")) {
                System.out.println("Emulator is ready!");
                // Additional wait to ensure all services are up
                Thread.sleep(5000);
                return;
            }

            Thread.sleep(1000);
            elapsed++;
        }
        throw new RuntimeException("Emulator failed to start within " + maxWaitTime + " seconds");
    }


}

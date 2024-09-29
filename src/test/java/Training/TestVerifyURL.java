package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class TestVerifyURL {
    public static void main(String[] args) {
        //test push code
        // Set the path to chromedriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Set Chrome options (optional - headless mode)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Step 01 - Navigate to the website
            driver.get("http://live.techpanda.org/");
            System.out.println("Opened website: " + driver.getCurrentUrl());

            // Step 02 - Click the MY ACCOUNT link in the footer
            WebElement myAccountLink = driver.findElement(By.linkText("MY ACCOUNT"));
            myAccountLink.click();
            System.out.println("Clicked MY ACCOUNT");

            // Step 03 - Verify URL of the Login Page
            String expectedLoginUrl = "http://live.techpanda.org/index.php/customer/account/login/";
            String actualLoginUrl = driver.getCurrentUrl();
            Assert.assertEquals("Login URL verification failed!", expectedLoginUrl, actualLoginUrl);
            System.out.println("Login URL verified: " + actualLoginUrl);

            // Step 04 - Click the CREATE AN ACCOUNT button
            WebElement createAccountButton = driver.findElement(By.linkText("CREATE AN ACCOUNT"));
            createAccountButton.click();
            System.out.println("Clicked CREATE AN ACCOUNT");

            // Step 05 - Verify URL of the Register Page
            String expectedRegisterUrl = "http://live.techpanda.org/index.php/customer/account/create/";
            String actualRegisterUrl = driver.getCurrentUrl();
            Assert.assertEquals("Register URL verification failed!", expectedRegisterUrl, actualRegisterUrl);
            System.out.println("Register URL verified: " + actualRegisterUrl);

            System.out.println("Test case passed!");
        } catch (Exception e) {
            System.out.println("Test case failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

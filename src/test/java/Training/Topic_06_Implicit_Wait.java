package Training;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Topic_06_Implicit_Wait extends BaseTest {
    WebDriver driver;
    int timeOut = 10;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeMethod() {
        driver = getBrowserDriver("chrome");

        // Ham nay dung de truyen url muon truy cap
        driver.get("http://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterMethod() {
        // Ham nay de dong browser khi chay xong testcase
        driver.quit();
    }

    @Test
    public void Topic_06_Implicit_Wait() {
        driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr")).click();
        driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr"));
    }

    @Test
    public void Topic_06_Explicit_Wait() {
        explicitWait = new WebDriverWait(driver, timeOut);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("textbox")));
        driver.findElement(By.xpath("textbox")).sendKeys("aaa");

        // Visible
        // Invisible
        // Presence
        // Clickable

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("button")));
    }


}

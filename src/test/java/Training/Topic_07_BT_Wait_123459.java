package Training;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Topic_07_BT_Wait_01 extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getBrowserDriver("chrome");

        // Ham nay dung de truyen url muon truy cap
        driver.get("https://automationfc.github.io/dynamic-loading/");
    }

    @AfterClass
    public void afterClass() {
        // Ham nay de dong browser khi chay xong testcase
        driver.quit();
    }


    // Nên đặt tên cho testcase: ví dụ: TCS_04_Verify error message
    @Test
    public void TC_01_elementStatus() {
        // Visible : Có trong DOM + hiển thị trên UI => User nhìn thấy và thao tác được, dùng Xpath được hightlight
        // Invisible : Không hiển thị trên UI -> Có thể có trong DOM hoặc Không =>
        // Presence : Bắt buộc có trong DOM -> Có thể hiển thị trên UI hoặc không
        // Staleness: Không có trong DOM + không hiển thị trên UI
        // findElement: 0 element -> Throw ra 1 exception/ 1 element -> Tìm khoong thấy sẽ tìm lại, tìm lại được vaanx pass/ > 1 element -> thao tác với element đầu tiên
        //findElements: 0 element -> chạy tiếp step tiếp theo và trả về 1 list rỗng/ 1 element -> Tìm khoong thấy sẽ tìm lại, tìm lại được vaanx pass/ > 1 element -> tr về 1 list
    }
    @Test
    public void TC_02_implicitWait() {
        // Click button Start
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        // Set thời gian chờ
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Check result text "hello world"
        String actualText = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Hello World!";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void TC_03_staticWait() throws InterruptedException {
        // Click button Start
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        // Set thời gian chờ
        Thread.sleep(5000);
        // Wait result text will appear
        boolean status = driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed();
        // Check result text "hello world"
        String actualText = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Hello World!";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void TC_04_explicitWait_invisible(){
        // Click button Start
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        // Wait loading icon invisible
        int timeOut = 5;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='../dynamic-loading/img/ajax-loader.gif']")));
        // Check result text "hello world"
        String actualText = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Hello World!";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void TC_05_explicitWait_visible() {
        // Click button Start
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        // Wait Hello World visible
        int timeOut = 3;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='finish']/h4")));
        // Check result text "hello world"
        String actualText = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Hello World!";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void TC_09_fluentWait() {
        // Click button Start
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        // Kiểm tra Hello World 0,1s 1 lần
        Wait<WebDriver> wait = new WebDriverWait(driver, 1);
        // Check result text "hello world"
        String actualText = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Hello World!";
        Assert.assertEquals(actualText, expectedText);
    }

}

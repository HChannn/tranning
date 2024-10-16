package Training;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;


public class Topic_04_TC02_textbox_textarea extends BaseTest {
    WebDriver driver;
//    String email = "hoangchang"+ getRandomNumber() +"@gmail.com";
    @BeforeClass
    public void beforeMethod() {
        driver = getBrowserDriver("chrome");

        // Ham nay dung de truyen url muon truy cap
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void afterMethod() {
        // Ham nay de dong browser khi chay xong testcase
        driver.quit();
    }


    // Nên đặt tên cho testcase: ví dụ: TCS_04_Verify error message
    @Test
    public void TC_02_Xu_li_textbox_textarea() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hoàng");
        driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Thị Thu");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Chang");
        String employeeID = String.valueOf(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']"));
        driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
        driver.findElement(By.xpath("//label[text()='Username']/ancestor::div[contains(@class, 'oxd-input-group')]/div/input")).sendKeys("Admin123");
        driver.findElement(By.xpath("//label[text()='Password']/ancestor::div[contains(@class, 'oxd-input-group')]/div/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class, 'oxd-input-group')]/div/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String actualFirstName = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']")).getText();
        System.out.println("Text: " + actualFirstName);
        String expectedFirstName = "Hoàng";
        Assert.assertEquals(actualFirstName, expectedFirstName);

        String actualMiddleName = driver.findElement(By.xpath("//input[@name='middleName']")).getText();
        System.out.println("Text: " + actualMiddleName);
        String expectedMiddleName = "Thị Thu";
        Assert.assertEquals(actualFirstName, expectedMiddleName);

        String actualLastName = driver.findElement(By.xpath("//input[@name='lastName']")).getText();
        System.out.println("Text: " + actualLastName);
        String expectedLastName = "Chang";
        Assert.assertEquals(actualLastName, expectedLastName);

        String actualEmployeeID = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).getText();
        System.out.println("Text: " + actualEmployeeID);
        String expectedEmployeeID ;
        expectedEmployeeID = employeeID;
        Assert.assertEquals(actualEmployeeID, expectedEmployeeID);


































        Thread.sleep(5000);
}
}
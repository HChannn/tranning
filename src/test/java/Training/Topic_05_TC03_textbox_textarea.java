package Training;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;


public class Topic_05_TC03_textbox_textarea extends BaseTest {
    WebDriver driver;
//    String UserName = "Chang" + getRandomNumber();
    @BeforeClass
    public void beforeMethod() {
        driver = getBrowserDriver("chrome");

        // Ham nay dung de truyen url muon truy cap
        driver.get("https://demo.guru99.com/v4/");
    }

    @AfterClass
    public void afterMethod() {
        // Ham nay de dong browser khi chay xong testcase
        driver.quit();
    }


    // Nên đặt tên cho testcase: ví dụ: TCS_04_Verify error message
    @Test
    public void TC_01_Xu_li_textbox_textarea() throws InterruptedException {
//step 02 - Login hệ thống
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr598125");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qEvezep");
        driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

        String actualUrlHomePage = driver.getCurrentUrl();
        System.out.println("Url: " + actualUrlHomePage);
        String expectedUrlHomePage = "https://demo.guru99.com/v4/manager/Managerhomepage.php";
        Assert.assertEquals(actualUrlHomePage, expectedUrlHomePage);

//step 03 - Click chọn link New Customer
        driver.findElement(By.xpath("//a[@href='addcustomerpage.php']")).click();

//step 04 - Nhập du liệu -> click submit
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("changhtt");
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys(new Date().toString());
        driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("HN");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("VN");

//step 05 - Nhập thông tin hợp le Add Employee

        Thread.sleep(5000);
    }

    private String getRandomNumber() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(999));
    }
}
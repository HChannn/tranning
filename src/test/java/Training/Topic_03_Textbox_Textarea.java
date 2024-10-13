package Training;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_03_Textbox_Textarea extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        driver = getBrowserDriver("chrome");

        // Ham nay dung de truyen url muon truy cap
        driver.get("http://live.techpanda.org/");
    }

    @AfterClass
    public void afterMethod() {
        // Ham nay de dong browser khi chay xong testcase
        driver.quit();
    }


    // Nên đặt tên cho testcase: ví dụ: TCS_04_Verify error message
    @Test
    public void TC_01_Xu_li_textbox_() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();
        driver.findElement(By.xpath("//input[@id= 'firstname']")).sendKeys("Hoang");
        driver.findElement(By.xpath("//input[@id= 'middlename']")).sendKeys("Thi Thu");
        driver.findElement(By.xpath("//input[@id= 'lastname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//input[@id= 'email_address']")).sendKeys("hoangchang01@gmail.com");
        driver.findElement(By.xpath("//input[@id= 'password']")).sendKeys("123456789aA@");
        driver.findElement(By.xpath("//input[@id= 'confirmation']")).sendKeys("123456789aA@");
        driver.findElement(By.xpath("//button[@title='Register']")).click();

        String actualMessage = driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
        System.out.println("Text: " + actualMessage);
        String expectedMessage = "Thank you for registering with Main Website Store.";
        Assert.assertEquals(actualMessage, expectedMessage);

        String actualName = driver.findElement(By.xpath("//div[@class='col-1']//div[@class='box-content']/p/text()[1]")).getText();
        System.out.println("Text: " + actualName);
        String expectedName = "Hoang Thi Thu Chang" +
                "hoangchang01@gmail.com" + "Change Password";
        Assert.assertEquals(actualName, expectedName);

        String actualEmail = driver.findElement(By.xpath("//div[@class='col-1']//div[@class='box-content']/p/text()[2]")).getText();
        System.out.println("Text: " + actualEmail);
        String expectedEmail = "hoangchang01@gmail.com";
        Assert.assertEquals(actualEmail, expectedEmail);

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.xpath("//input[@type='radio' and @value='5']")).click();
        driver.findElement(By.xpath("//textarea[@id='review_field']")).sendKeys("review");
        driver.findElement(By.xpath("//input[@id='summary_field']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id='nickname_field']")).sendKeys("CHANN");
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();

        String actualMessageReview = driver.findElement(By.xpath("//span[text()='Your review has been accepted for moderation.']")).getText();
        System.out.println("Text: " + actualMessageReview);
        String expectedMessageReview  = "Your review has been accepted for moderation.";
        Assert.assertEquals(actualMessageReview, expectedMessageReview);

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer/account/']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//div[@id='header-account']//a[@title='Log Out']")).click();

        String actualUrlHomePage = driver.getCurrentUrl();
        System.out.println("Url: " + actualUrlHomePage);
        String expectedUrlHomePage = "http://live.techpanda.org/index.php/";
        Assert.assertEquals(actualUrlHomePage, expectedUrlHomePage);

        Thread.sleep(3000);

    }



}

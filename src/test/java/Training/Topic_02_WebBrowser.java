package Training;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Topic_02_WebBrowser extends BaseTest {
    WebDriver driver;

    @Test
    public void TC_01_Verify_url() {
        driver = getBrowserDriver("chrome");
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        String actualUrlLoginPage = driver.getCurrentUrl();
        System.out.println("Url: " + actualUrlLoginPage);
        String expectedUrlLoginPage = "http://live.techpanda.org/index.php/customer/account/login/";
        Assert.assertEquals(actualUrlLoginPage, expectedUrlLoginPage);

        driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();

        String actualUrlRegisterPage = driver.getCurrentUrl();
        System.out.println("Url: " + actualUrlRegisterPage);
        String expectedUrlRegisterPage = "http://live.techpanda.org/index.php/customer/account/create/";
        Assert.assertEquals(actualUrlRegisterPage, expectedUrlRegisterPage);

        driver.quit();
    }

@Test
public void TC_02_Verify_title() {
    driver = getBrowserDriver("chrome");
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

    String actualTitleLoginPage = driver.getTitle();
    System.out.println("Title: " + actualTitleLoginPage);
    String expectedTitleLoginPage = "Customer Login";
    Assert.assertEquals(actualTitleLoginPage, expectedTitleLoginPage);

    driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();

    String actualTitleRigisterPage = driver.getTitle();
    System.out.println("Title: " + actualTitleRigisterPage);
    String expectedTitleRigisterPage = "Create New Customer Account";
    Assert.assertEquals(actualTitleRigisterPage, expectedTitleRigisterPage);

    driver.quit();
    }

@Test
public void TC_03_Navigate_Function() throws InterruptedException {
    driver = getBrowserDriver("chrome");
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();

    String actualUrlRegisterPage = driver.getCurrentUrl();
    System.out.println("Url: " + actualUrlRegisterPage);
    String expectedUrlRegisterPage = "http://live.techpanda.org/index.php/customer/account/create/";
    Assert.assertEquals(actualUrlRegisterPage, expectedUrlRegisterPage);

    driver.navigate().back();

    String actualUrlLoginPage = driver.getCurrentUrl();
    System.out.println("Url: " + actualUrlLoginPage);
    String expectedUrlLoginPage = "http://live.techpanda.org/index.php/customer/account/login/";
    Assert.assertEquals(actualUrlLoginPage, expectedUrlLoginPage);

    driver.navigate().forward();

    String actualTitleRigisterPage = driver.getTitle();
    System.out.println("Title: " + actualTitleRigisterPage);
    String expectedTitleRigisterPage = "Create New Customer Account";
    Assert.assertEquals(actualTitleRigisterPage, expectedTitleRigisterPage);

    driver.quit();
    Thread.sleep(3000);
}

}

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
    public void TC_01_Xu_li_textbox_textarea() throws InterruptedException {
//step 02 - Login hệ thống
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//step 03 - Mở trang PIM
        driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();

//step 04 - Mở trang Add Employee
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

//step 05 - Nhập thông tin hợp le Add Employee
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hoàng");
        driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Thị Thu");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Chang");
        String employeeID = String.valueOf(driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).getAttribute("value"));
        driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
        driver.findElement(By.xpath("//label[text()='Username']/ancestor::div[contains(@class, 'oxd-input-group')]/div/input")).sendKeys("Chang" + getRandomNumber());
        driver.findElement(By.xpath("//label[text()='Password']/ancestor::div[contains(@class, 'oxd-input-group')]/div/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class, 'oxd-input-group')]/div/input")).sendKeys("admin123");

//step 06 - Click Save
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//step 07 - Verify thông tin
        String actualFirstName = driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value");
        System.out.println("Text: " + actualFirstName);
        String expectedFirstName = "Hoàng";
        Assert.assertEquals(actualFirstName, expectedFirstName);

        String actualMiddleName = driver.findElement(By.xpath("//input[@name='middleName']")).getAttribute("value");
        System.out.println("Text: " + actualMiddleName);
        String expectedMiddleName = "Thị Thu";
        Assert.assertEquals(actualMiddleName, expectedMiddleName);

        String actualLastName = driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value");
        System.out.println("Text: " + actualLastName);
        String expectedLastName = "Chang";
        Assert.assertEquals(actualLastName, expectedLastName);

        String actualEmployeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).getAttribute("value");
        System.out.println("Text: " + actualEmployeeID);
        Assert.assertEquals(actualEmployeeID, employeeID);

//step 08 - Click vào tab Immigration
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();

//step 09 - Click add Assigned Immigration Records
        driver.findElement(By.xpath("//div[h6[text()='Assigned Immigration Records']]//button[contains(@class, 'oxd-button') and contains(., 'Add')]")).click();

//step 10 - Nhập dữ liệu vào Number/Comments và click Save button
        driver.findElement(By.xpath("//label[text()='Number']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).sendKeys("0379423909");
        driver.findElement(By.xpath("//label[text()='Comments']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//textarea[@placeholder='Type Comments here']")).sendKeys("comment");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//step 11 - Click vao icon Pencil(Edit)
        driver.findElement(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-pencil-fill']")).click();

//step 12 - Verify dữ liệu đã tạo hiển thị đúng
        Thread.sleep(5000);
        String actualNumber = driver.findElement(By.xpath("//label[text()='Number']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).getAttribute("value");
        System.out.println("Text: " + actualNumber);
        String expectedNumber = "0379423909";
        Assert.assertEquals(actualNumber, expectedNumber);

        String actualComment = driver.findElement(By.xpath("//label[text()='Comments']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//textarea[@placeholder='Type Comments here']")).getAttribute("value");
        System.out.println("Text: " + actualComment);
        String expectedComment = "comment";
        Assert.assertEquals(actualComment, expectedComment);

//step 13 - Click vao icon cancel
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")).click();

//step 14 - Click teen User và chọn Logout
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();

//step 15 - Tại MH Login nhập thông tin đã tạo hợp ệ ở step 05
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Chang03");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//step 16 - Vào MH My Info
        driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']")).click();


//step 17 - Verify các thông tin hiển thị
        String actualFirstName1 = driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value");
        System.out.println("Text: " + actualFirstName1);
        String expectedFirstName1 = "Hoàng";
        Assert.assertEquals(actualFirstName1, expectedFirstName1);

        String actualMiddleName1 = driver.findElement(By.xpath("//input[@name='middleName']")).getAttribute("value");
        System.out.println("Text: " + actualMiddleName1);
        String expectedMiddleName1 = "Thị Thu";
        Assert.assertEquals(actualMiddleName1, expectedMiddleName1);

        String actualLastName1 = driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value");
        System.out.println("Text: " + actualLastName1);
        String expectedLastName1 = "Chang";
        Assert.assertEquals(actualLastName1, expectedLastName1);

        String actualEmployeeID1 = driver.findElement(By.xpath("//label[text()='Employee Id']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).getAttribute("value");
        System.out.println("Text: " + actualEmployeeID);
        Assert.assertEquals(actualEmployeeID1, employeeID);

//step 18 - Click vào tab Immigration ->> Click icon Pencil(Edit)
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        driver.findElement(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-pencil-fill']")).click();

//step 19 - Verify thông tin hien thị
        String actualNumber1 = driver.findElement(By.xpath("//label[text()='Number']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).getAttribute("value");
        System.out.println("Text: " + actualNumber1);
        String expectedNumber1 = "0379423909";
        Assert.assertEquals(actualNumber1, expectedNumber1);

        String actualComment1 = driver.findElement(By.xpath("//label[text()='Comments']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//textarea[@placeholder='Type Comments here']")).getAttribute("value");
        System.out.println("Text: " + actualComment1);
        String expectedComment1 = "comment";
        Assert.assertEquals(actualComment1, expectedComment1);













































        Thread.sleep(5000);
}

    private String getRandomNumber() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(999));
    }
}
package Training;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_00_Format extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getBrowserDriver("chrome");

        // Ham nay dung de truyen url muon truy cap
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @AfterClass
    public void afterClass() {
        // Ham nay de dong browser khi chay xong testcase
        driver.quit();
    }


    // Nên đặt tên cho testcase: ví dụ: TCS_04_Verify error message
    @Test
    public void TC_01_Verify_error_message() {
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@class='btn_pink_sm fs16']")).click();

        // Nên đặt tên cho biến theo element đang xử lí
        // Ví dụ: actualEmail, expectedEmail
        // Rule để đặt tên cho biến, object theo kiểu camelCase, tức là chữ đầu viết thường còn các chữ sau viết hoa.
        // Ví dụ:hoangThiThuTrang thì chữ cái đầu trong tên riêng viết hoa

        // Tại sao xpath của error message lại //div[@class='field']//label[@id='txtEmail-error'], thế //label[@id='txtEmail-error'] này có tìm đc không???
        // Các cái sau cũng vậy nhé, chưa tối ưu đc xpath
        String actualEmail = driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText();
        System.out.println("Text: " + actualEmail);
        String expectedEmail = "Vui lòng nhập email";
        Assert.assertEquals(actualEmail, expectedEmail);

        String actualName = driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText();
        System.out.println("Text: " + actualName);
        String expectedName = "Vui lòng nhập họ tên";
        Assert.assertEquals(actualName, expectedName);

        String actualCEmail = driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText();
        System.out.println("Text: " + actualCEmail);
        String expectedCEmail = "Vui lòng nhập lại địa chỉ email";
        Assert.assertEquals(actualCEmail, expectedCEmail);

        String actualPassword = driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText();
        System.out.println("Text " + actualPassword);
        String expectedPassword = "Vui lòng nhập mật khẩu";
        Assert.assertEquals(actualPassword, expectedPassword);

        String actualCPassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText();
        System.out.println("Text " + actualCPassword);
        String expectedCPassord = "Vui lòng nhập lại mật khẩu";
        Assert.assertEquals(actualCPassword, expectedCPassord);

        String actualPhone = driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText();
        System.out.println("Text " + actualPhone);
        String expectedPhone = "Vui lòng nhập số điện thoại.";
        Assert.assertEquals(actualPhone, expectedPhone);
    }

    @Test
    public void TC_02_Verify_error_message_email() {
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("123@456@789");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("123@456@789");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        String actualEmail = driver.findElement(By.xpath("//label[text()='Vui lòng nhập email hợp lệ']")).getText();
        System.out.println("Text: " + actualEmail);
        String expectedEmail = "Vui lòng nhập email hợp lệ";
        Assert.assertEquals(actualEmail, expectedEmail);

        String actualCEmail = driver.findElement(By.xpath("//label[text()='Email nhập lại không đúng']")).getText();
        System.out.println("Text: " + actualCEmail);
        String expectedCEmail = "Email nhập lại không đúng";
        Assert.assertEquals(actualCEmail, expectedCEmail);

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).clear();
        driver.findElement(By.xpath("//input[@id='txtEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();

    }

    @Test
    public void TC_03_Verify_error_message_Cpassword() {
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.vn");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        String actualCPassword = driver.findElement(By.xpath("//label[text()='Email nhập lại không đúng']")).getText();
        System.out.println("Text: " + actualCPassword);
        String expectedCPassword = "Email nhập lại không đúng";
        Assert.assertEquals(actualCPassword, expectedCPassword);

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).clear();
        driver.findElement(By.xpath("//input[@id='txtEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
    }

    @Test
    public void TC_04_Verify_error_message_password() {
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

//        String actualPassword = driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText();
        String actualPassword = driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText();
        System.out.println("Text Mật khẩu: " + actualPassword);
        String expectedPassword = "Mật khẩu phải có ít nhất 6 ký tự";
        Assert.assertEquals(actualPassword, expectedPassword);

        String actualCPassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText();
        System.out.println("Text Nhập lại Mật khẩu: " + actualCPassword);
        String expectedCPassword = "Mật khẩu phải có ít nhất 6 ký tự";
        Assert.assertEquals(actualCPassword, expectedCPassword);

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).clear();
        driver.findElement(By.xpath("//input[@id='txtEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
    }

    @Test
    public void TC_05_Verify_error_message_Cpassword() {
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123121");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        String actualCPassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText();
        System.out.println("Text: " + actualCPassword);
        String expectedCPassword = "Mật khẩu bạn nhập không khớp";
        Assert.assertEquals(actualCPassword, expectedCPassword);

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).clear();
        driver.findElement(By.xpath("//input[@id='txtEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();

    }

    @Test
    public void TC_06_Verify_error_message_Phone() {
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0379423");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        String actualPhone = driver.findElement(By.xpath("//label[text()='Số điện thoại phải từ 10-11 số. ']")).getText();
        System.out.println("Text: " + actualPhone);
        String expectedPhone = "Số điện thoại phải từ 10-11 số.";
        Assert.assertEquals(actualPhone, expectedPhone);

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).clear();
        driver.findElement(By.xpath("//input[@id='txtEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
    }
}

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

    @Test
    public void Testcase_01() {
        // Ham nay dung de tim kiem locator cua element va get Text cua element do = code .getText()
        String actualText = driver.findElement(By.xpath("//div[@class='field_link']")).getText();
        System.out.println("text là: " + actualText);

        String expectedText = "Tôi đồng ý với các chính sách và thỏa thuận sử dụng của Alada.vn";

        // Ham nay de so sanh 2 text = nhau giua actual result va expected result
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void Testcase_02() {
        String actualText = driver.findElement(By.xpath("//div[@class='columm login_col_8']//p[@class='title_login']")).getText();
        System.out.println("text là: " + actualText);

        String expectedText1 = "Đăng ký tài khoản mới";

        Assert.assertEquals(actualText, expectedText1);
    }

    @Test
    public void Testcase_03() {
        String actualText = driver.findElement(By.xpath("//div[@class='field']//label[text()='Họ và tên']")).getText();
        System.out.println("Text: " + actualText);

        String expectedText = "Họ và tên";
        Assert.assertEquals(actualText, expectedText);
    }

    // Nên đặt tên cho testcase: ví dụ: TCS_04_Verify error message
    @Test
    public void Testcase_04() {
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@class='btn_pink_sm fs16']")).click();

        // Nên đặt tên cho biến theo element đang xử lí
        // Ví dụ: actualEmail, expectedEmail
        // Rule để đặt tên cho biến, object theo kiểu camelCase, tức là chữ đầu viết thường còn các chữ sau viết hoa.
        // Ví dụ:hoangThiThuTrang thì chữ cái đầu trong tên riêng viết hoa
        String actualText = driver.findElement(By.xpath("//div[@class='field']//label[@id='txtEmail-error']")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Vui lòng nhập email";
        Assert.assertEquals(actualText, expectedText);

        String actualText1 = driver.findElement(By.xpath("//div[@class='field']//label[@id='txtFirstname-error']")).getText();
        System.out.println("Text: " + actualText1);
        String expectedText1 = "Vui lòng nhập họ tên";
        Assert.assertEquals(actualText1, expectedText1);

        String actualText2 = driver.findElement(By.xpath("//div[@class='field']//label[@id='txtCEmail-error']")).getText();
        System.out.println("Text: " + actualText2);
        String expectedText2 = "Vui lòng nhập lại địa chỉ email";
        Assert.assertEquals(actualText2, expectedText2);

        String actualText3 = driver.findElement(By.xpath("//div[@class='field']//label[@id='txtPassword-error']")).getText();
        System.out.println("Text " + actualText3);
        String expectedText3 = "Vui lòng nhập mật khẩu";
        Assert.assertEquals(actualText3, expectedText3);

        String actualText4 = driver.findElement(By.xpath("//div[@class='field']//label[@id='txtCPassword-error']")).getText();
        System.out.println("Text " + actualText4);
        String expectedText4 = "Vui lòng nhập lại mật khẩu";
        Assert.assertEquals(actualText4, expectedText4);

        String actualText5 = driver.findElement(By.xpath("//div[@class='field']//label[@id='txtPhone-error']")).getText();
        System.out.println("Text " + actualText5);
        String expectedText5 = "Vui lòng nhập số điện thoại.";
        Assert.assertEquals(actualText5, expectedText5);
    }

    @Test
    public void Testcase_05() {
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtEmail']")).sendKeys("123@456@789");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCEmail']")).sendKeys("123@456@789");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@class='btn_pink_sm fs16']")).click();

        String actualText = driver.findElement(By.xpath("//div[@class='field']//label[text()='Vui lòng nhập email hợp lệ']")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Vui lòng nhập email hợp lệ";
        Assert.assertEquals(actualText, expectedText);

        String actualText1 = driver.findElement(By.xpath("//div[@class='field']//label[text()='Email nhập lại không đúng']")).getText();
        System.out.println("Text: " + actualText1);
        String expectedText1 = "Email nhập lại không đúng";
        Assert.assertEquals(actualText1, expectedText1);
    }

    @Test
    public void Testcase_06() {
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.vn");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCPassword']")).sendKeys("123123aA@");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@class='btn_pink_sm fs16']")).click();

        String actualText = driver.findElement(By.xpath("//div[@class='field']//label[text()='Email nhập lại không đúng']")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Email nhập lại không đúng";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void Testcase_07() {
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPassword']")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCPassword']")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@class='btn_pink_sm fs16']")).click();

        String actualText = driver.findElement(By.xpath("//div[@class='field']//label[text()='Mật khẩu phải có ít nhất 6 ký tự' and @id='txtPassword-error']")).getText();
        System.out.println("Text Mật khẩu: " + actualText);
        String expectedText = "Mật khẩu phải có ít nhất 6 ký tự";
        Assert.assertEquals(actualText, expectedText);

        String actualText1 = driver.findElement(By.xpath("//div[@class='field']//label[text()='Mật khẩu phải có ít nhất 6 ký tự' and @id='txtCPassword-error']")).getText();
        System.out.println("Text Nhập lại Mật khẩu: " + actualText1);
        String expectedText1 = "Mật khẩu phải có ít nhất 6 ký tự";
        Assert.assertEquals(actualText1, expectedText1);
    }

    @Test
    public void Testcase_08() {
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCPassword']")).sendKeys("123121");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPhone']")).sendKeys("0379423906");
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@class='btn_pink_sm fs16']")).click();

        String actualText = driver.findElement(By.xpath("//div[@class='field']//label[text()='Mật khẩu bạn nhập không khớp']")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Mật khẩu bạn nhập không khớp";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void Testcase_09() {
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtFirstname']")).sendKeys("Chang");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCEmail']")).sendKeys("changhtt@icetea.com");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtCPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//div[@class='field']//input[@id='txtPhone']")).sendKeys("0379423");
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@class='btn_pink_sm fs16']")).click();

        String actualText = driver.findElement(By.xpath("//div[@class='field']//label[text()='Số điện thoại phải từ 10-11 số. ']")).getText();
        System.out.println("Text: " + actualText);
        String expectedText = "Số điện thoại phải từ 10-11 số.";
        Assert.assertEquals(actualText, expectedText);
    }
}

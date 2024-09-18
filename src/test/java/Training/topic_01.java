package Training;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic_01 extends BaseTest {
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
    public void topic_01() {

    }
}


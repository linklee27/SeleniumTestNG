package LinhTester.A_Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeMethod
    public void createBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //thời gian chờ đợi ngầm tối đa cho mỗi câu lệnh tìm kiếm driver.findElement với time là 10s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); //chờ đợi trang load xong (trong 30s), nếu trong 30s không load xong lỗi
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }
}

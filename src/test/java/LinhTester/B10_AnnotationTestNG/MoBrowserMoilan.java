package LinhTester.B10_AnnotationTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class MoBrowserMoilan {

    WebDriver driver;
    //BeforeMethod - moi testcase chạy sẽ mở Browser 1 lần
    @BeforeMethod
    public void createBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    @Test(priority = 1)
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void testGoogleSearch1() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@jscontroller='msmzHf'])[1]//h3")).click();
        Thread.sleep(2000);
    }

    //AfterMethod
    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }


}

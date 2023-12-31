package LinhTester.B10_AnnotationTestNG;

import LinhTester.A_Common.BaseTest_OLD;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginCMS extends BaseTest_OLD {


    @Test(priority = 2, description = "Login CMS Test")
    public void LoginCMS() throws InterruptedException {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        System.out.println("runLogin");
        Thread.sleep(2000);
    }

    @Test(priority = 1, description = "Check Blog on Anh Tester ")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

}

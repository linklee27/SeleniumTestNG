package LinhTester.B16_ThucHanhCRM;

import LinhTester.A_Common.BaseTest;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCustomer extends BaseTest {
    //k nhap email, pass
    @Test
    public void LoginCRM1() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //verify message có hiển thị không? và hiển thị đúng hay không?
        //1. viết hàm kiem tra Element tồn tại trong DOM
        boolean emailRequired = WebUI.checkElementExits(driver, "//form/div[1]");  //message email required
        boolean passRequired = WebUI.checkElementExits(driver, "//form/div[2]");  //message pass required
        System.out.println(emailRequired);
        System.out.println(passRequired);
        Assert.assertTrue(WebUI.checkElementExits(driver, "//form/div[1]", "Mes"));
        Assert.assertTrue(WebUI.checkElementExits(driver, "//form/div[2]"));


    }


    @Test
    public void LoginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}




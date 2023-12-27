package LinhTester.B11_Assert;

import LinhTester.A_Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssert extends BaseTest {
//Soft Assert - Nếu sai ở đâu vẫn tiếp tục chạy bước tiếp theo, có class hỗ trợ riêng
    @Test
    public void testSoftAssert(){
        driver.get("https://demo.activeitzone.com/ecommerce/login");

        //lấy ra tiêu đề của header
        String header = driver.findElement(By.xpath("//h1[text()='Welcome to Active eCommerce CMS']")).getText();

        SoftAssert softAssert = new SoftAssert();  //khởi tạo đối tượng softAssert
        softAssert.assertEquals(header, "Welcome to Active eCommerce CMS123", "headerlogin khong dung"); //so sánh bằng

        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebElement menuProduct = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        softAssert.assertTrue(menuProduct.isDisplayed(), "Menu product không hiển thị");



        //cuối cùng của softAssert là dùng assertAll() để chốt các xác nhận bên trên
        softAssert.assertAll();

    }
}

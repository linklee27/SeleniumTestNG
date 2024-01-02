package LinhTester.B13_Alert_Popup_iFrame;

import LinhTester.A_Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

//https://demo.seleniumeasy.com/javascript-alert-box-demo.html
public class Alert extends BaseTest {
//    @Test(priority = 1)
//    public void demoHandleAlertAccept() throws InterruptedException {
//        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
//        Thread.sleep(2000);
//
//        //Mở Alert Message, click vào nút "Click me!" thứ nhất
//        driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
//        Thread.sleep(1000);
//
//        //C1: khởi tạo đối tượng rồi .getText() để lấy message rồi in nó ra
//        String alertMessage = driver.switchTo().alert().getText();
//        System.out.println(alertMessage);
//        Assert.assertEquals(alertMessage, "I am an alert box!", "message sai"); //kiểm tra nội dung message
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();  //nhấn button OK
//
//        //C2: Khởi tạo class Alert và nhấn button OK
//        //Alert alert1 = driver.switchTo().alert();
//        //alert1.accept();
//        Thread.sleep(1000);
//    }

//    @Test(priority = 2)
//    public void demoHandleAlertDismiss() throws InterruptedException {
//        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
//        Thread.sleep(2000);
//
//        //Mở Alert Dismiss, click vào nút "Click me!" thứ 2
//        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
//        Thread.sleep(1000);
//
//        //Khởi tạo class Alert
//        String alertDismiss = driver.switchTo().alert().getText();
//        System.out.println(alertDismiss);
//        driver.switchTo().alert().dismiss();
//        //kiểm tra xem nhấn nút cancel chưa
//        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-demo']")).isDisplayed(), "Chưa nhấn được nút Cancel");
//        Thread.sleep(2000);
//    }

    @Test(priority = 3)
    public void demoHandleAlertInputText() throws InterruptedException{
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);

        //Mở Alert Input text, click nút thứ 3
        driver.findElement(By.xpath("//button[normalize-space()='Click for Prompt Box']")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        String alert3 = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Anh Tester Demo Alert");
        driver.switchTo().alert().accept();



        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText(),
                "You have entered 'Anh Tester Demo Alert' !",
                "Chưa điền được text");

        Thread.sleep(2000);
    }

}

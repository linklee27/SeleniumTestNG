package LinhTester.B13_Alert_Popup_iFrame;

import LinhTester.A_Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//https://anhtester.com/contact  - driver.switchTo().frame()
public class Iframe extends BaseTest {
    @Test
    public void testIFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(10000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Thẻ iframe thứ nhất
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //sau khi lấy được ifrmae rồi thì sẽ thoát ra cái frame chính

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1); //chuyển đến Thẻ iframe thứ hai
        driver.findElement(By.tagName("svg")).click(); //rồi Nhấn icon để ẩn ô messenger chat đi
        Thread.sleep(2000);
    }

}




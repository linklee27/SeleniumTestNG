package LinhTester.B14_JavascriptExcutor;

import LinhTester.A_Common.BaseTest;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExcuteScript extends BaseTest {
    @Test
    public void testScript01(){
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
//        //k thể click được button copy do có 1 element khác che mất nó. sẽ phải tắt element đó trước, sau đó mới nhấn buton copy được
          //cách xử lý ở WebDriver
//        //driver.findElement(By.xpath("//div[@class='aiz-editor-data']/following-sibling::button")).click();
//          driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")).click();
//          driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//          WebUI.sleep(2);


        //Cách xử lý với JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver; //khai bao va khoi tao doi tuong
        //Click Nhấp vào một Element với JavascriptExecutor
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")));
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.sleep(2);

        //Nhập giá trị vào input
        js.executeScript("arguments[0].setAttribute('value',123456');", driver.findElement(By.xpath("//input[@id='password']")));
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.sleep(2);

        //Để cuộn tới 1 phần tử trong trang (này dùng nhiều)
        WebElement pagehome = driver.findElement(By.xpath("(//div[@class='card-body'])[5]")); //xpath chỗ cần cuộn xuống
        js.executeScript("arguments[0].scrollIntoView(true);", pagehome);
        WebUI.sleep(2);

        //Highlight phần tử trên web
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS'])")));
        WebUI.sleep(2);

        //



    }
}

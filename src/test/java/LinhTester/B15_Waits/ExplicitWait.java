package LinhTester.B15_Waits;

import LinhTester.A_Common.BaseTest_OLD;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
//Khác nhau giữa wait và slepp (nên dùng wait)
////sleep: đúng thời gian sẽ chạy tiếp (ví dụ slepp 3s thì sau đúng 3s sẽ chạy tiếp)
////wait chờ cho đến khi có kết quả sẽ chạy(vd set wait 10s, 2s có kết quả rồi thì 2s sẽ chạy tiếp)
//
//        1. Implicit Wait - chờ đợi ngầm:
//        - Áp dụng cho all câu lệnh và với 1 điều kiện chung là tìm thấy locator của element.
//        + Thời gian chờ đợi ngầm tối đa cho mỗi câu lệnh tìm kiếm driver.findElement với time là 10s (cho đến khi reset)
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  (nếu k tìm thấy element trong tối đã 30s sẽ fail
//        + Reset Implicit Wait (thay đổi thời gian chờ đợi)
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        Và có thể bổ sung thêm 2 câu lệnh dưới đây để chờ đợi Trang load xong và Script load xong:
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//
//        *Note: driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); - nếu k tìm thấy element trong tối đa 30s sẽ báo fail
//        Vậy nếu có 100TC => sẽ mất 30x100=3000s = 50 phút chờ cho TC fail (vấn đề chờ đợi quá lâu trong auto)
//        ==> sinh ra Explicit Wait để khắc phục tình trạng này.
//
//        2. Explicit Wait - cố tình đợi:
//        - Chỉ áp dụng cho 1 câu lệnh tìm kiếm chỉ định và với điều kiện riêng
//        - Chỉ dừng lại khi không thỏa mãn điều kiện cụ thể cho từng câu lệnh
//        Đối tượng By, chưa thao tác các action trong Selenium được -> By buttonLogin = By.xpath("");
//        Đổi tượng WebElement, được thao tác các action trong Selenium  --> WebElement buttonLogin = driver.findElement(By.xpath(""));

public class ExplicitWait extends BaseTest_OLD {
    @Test
    public void addBrandCMS() {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        //VD1: Khi bấm Brand bị lỗi do chưa kịp đọc hoặc bị che nên phải xử lý chờ như dưới.
//        //khai báo WebDriverWait = Explicit Wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        //có loading nên thêm cơ chế Chờ đợi menu Brand đến khi sẵn sàng hiển thị để có thể thao tác được
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));

        //có loading nên thêm cơ chế wait, đã viết sẵn ở WebUI, chỉ câ lấy ra (phía trên là TH chưa có sẵn)
        WebUI.waitForElementVisitable(driver, By.xpath("//span[normalize-space()='Brand']"), 5);
        //click vào brand
        driver.findElement(By.xpath("//span[normalize-space()='Brand']")).click();
        //kiểm tra hiển thị text Add New Brand có đúng k
        String header = driver.findElement(By.xpath("//div[@class='card-header']/h5")).getText();
        Assert.assertEquals(header, "Add New Brand", "text khong dung");
        System.out.println(header);



        //VD2: loading chỗ search brand, search có loading nên thêm cơ chế wait thì mới gettext được.
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Demo brand1", Keys.ENTER);
        //sau khi enter có loading, nên thêm cơ chế wait để lấy được giá trị
        WebUI.waitForElementVisitable(driver, By.xpath("//tbody/tr/td[2]"), 7);
        String brandName = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
        System.out.println(brandName);
        Assert.assertEquals(brandName, "Demo brand1", "khon ton tai");


    }
}

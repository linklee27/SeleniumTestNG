package LinhTester.B15_Waits;

import LinhTester.A_Common.BaseTest_OLD;
import keywords.WebUI;
import org.openqa.selenium.By;
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

public class ImplicitWait extends BaseTest_OLD {
    @Test
    public void LoginCRM(){
        driver.get("https://rise.fairsketch.com/signin");
        driver.findElement(By.xpath("//div[normalize-space()='Admin']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        WebUI.sleep(2);

        //thời gian chờ đợi ngầm tối đa cho mỗi câu lệnh tìm kiếm driver.findElement với time là 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //sau câu lệnh này là các câu lệnh tìm kiếm driver.findElement có time chờ ngầm 20s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //sau câu lệnh này là các câu lệnh tìm kiếm driver.findElement sẽ không có time chờ ngầm nữa
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

    }
}

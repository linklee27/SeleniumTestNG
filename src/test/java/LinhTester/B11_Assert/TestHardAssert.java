package LinhTester.B11_Assert;

import LinhTester.A_Common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssert extends BaseTest {
    //1. Hard Assert - Nếu sai ở đâu dừng ở đó
//        - assertEquals(actual, expected) - so sánh bằng, sai chỗ nào, dừng ctrinh chỗ đó
//        assertNotEquals(actual, expected) - so sánh không bằng -
//        - assertTrue(boolean condition) - so sánh đúng sai, sai chỗ nào, dừng ctrinh chỗ đó
//        assertFalse(boolean condition)
//        - assertNull(Object)  - sử dụng trong trường hợp ta mong đợi rằng cái Object ta đang nhắm tới là Null.
//        assertNotNull(Object) - sử dụng trong trường hợp ta mong đợi rằng cái Object ta đang nhắm tới là Not Null.

    //assertEquals - so sánh bằng, sai chỗ nào - dừng ctrinh chỗ đó
    @Test(priority = 1)
    public void TestAssertEquals() {
        driver.get("https://anhtester.com");
        String actualTitle = driver.getTitle();         //khai báo biến thực tế = lấy ra thực tế
        System.out.println("*** Checking For The Title ***");
        Assert.assertEquals(actualTitle, "Anh Tester Automation Testing", "mô tả cho trường hợp sai, TH đúng thì k show ra"); //so sánh, nếu bằng thì pass và tiếp tục, k bằng thì fail và dừng lại.
        System.out.println("lam gì do...");
    }

    //assertTrue - so sánh đúng sai, kết quả mong muốn là TRUE
    @Test(priority = 2)
    public void TestAssertTrue() {
        driver.get("https://anhtester.com");
        String actualTitle = driver.getTitle();         //khai báo biến thực tế = lấy ra thực tế
        System.out.println("*** Checking For The Title ***");
        Assert.assertTrue(actualTitle.contains("Anh Tester")); //so sánh xem title có chứa Anh Tester không, nếu đúng thì tiếp tục, nếu fail thì dừng lại = if(assertTrue(actualTitle.contains("Anh Tester 123"))==TRUE
        System.out.println("lam gì do...");
    }

    @Test(priority = 3)
    public void TestAssertNull(){
        driver.get("https://anhtester.com");
        String actualTitle = driver.getTitle();         //khai báo biến thực tế = lấy ra thực tế
        System.out.println("*** Checking For The Title ***");
        Assert.assertNull(actualTitle, "mo ta TH null"); //kiểm tra xem tiêu đề có đúng là null không
        System.out.println("lam gì do...");
    }
}

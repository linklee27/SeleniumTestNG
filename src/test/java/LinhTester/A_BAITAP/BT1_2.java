package LinhTester.A_BAITAP;

import LinhTester.A_Common.BaseTest_BT1_2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
//BT1 - Add Category
//        + Add hình sẵn vài tấm bằng tay trước khi chạy auto
//        + Chú ý phần chọn hình: click Browse -> search tên hình add bằng tay -> click item hình -> Click Add button
//        - Sau khi add category xong trở về menu Category (trang list)
//        - Search category name vừa add
//        - Get cái Text của item đầu tiên cột Name dưới Table sau khi search xem đúng không
//BT2 - Tách code cũ ở BT Add Category ra theo các ghi chú (annotation):(không dùng hàm main nữa)
//        + Tách đoạn setup Driver ra riêng không để chung trong test case
//        + Tách Login sẽ chạy trước mỗi test case
//        + Optimize code chạy cho ổn định hơn (sleep, xpath)
//        + Tập chạy code trên file suite XML

public class BT1_2 extends BaseTest_BT1_2 {

    @Test(priority = 1)
    public void loginCMS() throws InterruptedException{
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void addCategory() throws InterruptedException{
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Category linh");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[normalize-space()='Physical'])[3]")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        //bỏ qua 1 số trường k bắt buộc, làm upload ảnh 1
        driver.findElement(By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("admin login", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@class='img-fit'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(2000);
        //làm upload ảnh 2
        driver.findElement(By.xpath("//label[normalize-space()='Icon (32x32)']/following-sibling::div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("admin login", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='card-file-thumb']//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(2000);
        //làm upload ảnh 3
        driver.findElement(By.xpath("//label[normalize-space()='Cover Image (360x360)']/following-sibling::div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("admin login", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='card-file-thumb']//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(5000);

        //save và Get cái Text của item đầu tiên cột Name dưới Table sau khi search xem đúng không?
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Category linh", Keys.ENTER);
        String categoryItem = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
        System.out.println("get category" + categoryItem);
        Assert.assertEquals(categoryItem, "Category linh", "category khong dung");
        Thread.sleep(2000);


    }

}

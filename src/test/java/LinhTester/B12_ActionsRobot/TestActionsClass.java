package LinhTester.B12_ActionsRobot;

import LinhTester.A_Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
//   Actions class  - thiên về dreiver (cần chỉ định session cụ thể) - dùng hành động dính tới Element
//        1. sendKeys + click + Keys class (using Keyboard)
//        2. contextClick và doubleClick
//        3. moveToElement : di chuyển xuống dưới chỗ bị khuất
//        4. drag And Drop
//        5. KeyUp và KeyDown
//           a. Chuyển văn bản sang chữ hoa
//           b. Cuộn lên và xuống trang
//           c. Copy & Paste
//           d. Làm mới trang


public class TestActionsClass extends BaseTest {
    @Test
    public void TestSendKeys() throws InterruptedException {

        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Selenium Java").sendKeys(Keys.ENTER).build().perform(); //do có 2 hàm senkey nên phải dùng build để liên kết 2 hàm senkey với nhau. Còn nếu dùng 1 senkey thì k cần dùng build
        Thread.sleep(2000);

        // Dùng action để gọi hàm click điền dữ liệu
        WebElement titleResult = driver.findElement(By.xpath("//h3[text()='[Selenium Java] Bài 4: Cài đặt môi trường Selenium với Java']"));
        action.click(titleResult).perform(); //click vào 1 Element
        Thread.sleep(2000);
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        //element của header page
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));
        Actions action = new Actions(driver);

        //Double chuột trái vào header page
        action.doubleClick(element).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));
        Actions action = new Actions(driver);

        //Click chuột phải
        action.contextClick(element).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));
        Actions action = new Actions(driver);

        //Move to element - di chuyển đến element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Thread.sleep(2000);

        // Bắt element cần kéo
        WebElement From = driver.findElement(By.xpath("//div[@id='box6']"));
        // Bắt element cần thả đến
        WebElement To = driver.findElement(By.xpath("//div[@id='countries']//div[1]"));
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(From, To).build().perform();
        Thread.sleep(2000);

//        //Drag and Frop by Pixel - kéo đến 1 tọa độ nào đó rồi thả ra
//        WebElement from_500 = driver.findElement(By.xpath("//div[@id='box6']"));
//        action.dragAndDropBy(from_500, 168, 40).build().perform();
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));
        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").build().perform(); //keyDown là ấn giữ shift
        action.keyDown(element, Keys.SHIFT).sendKeys("anh").keyUp(Keys.SHIFT).sendKeys("tester").build().perform(); //keyUp(Keys.SHIFT) là thả shift
        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        // Scroll down cuối trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(2000);
        // Scroll up đầu trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + x để copy
        action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);

        //làm mới trang = ctr+f5
        action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
    }

}

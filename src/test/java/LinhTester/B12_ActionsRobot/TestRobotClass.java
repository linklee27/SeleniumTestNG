package LinhTester.B12_ActionsRobot;

import LinhTester.A_Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//Robot class - thuộc Java nên xử lý chung. dùng phím chuột y như ngoài thiệt, sử dụng khi cần dùng phím
//        1. keyPress là hàm hành động/keyEvent là hàm để gọi các nút bàn phím
//        2. Phương pháp chuột (chuột phải, trái, giữa)
//        3. chụp màn hình

public class TestRobotClass extends BaseTest {
    @Test
    public void inputText() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);
        WebElement inputCourseElement = driver.findElement(By.name("key"));
        inputCourseElement.click();

        Robot robot = new Robot();
        robot.delay(1000);  //giống hàm Thread.sleep(2000);
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);  //keyPress là nhấm phím, KeyEvent là hỗ trợ phím(hiển thị all các bàn phím để chọn)
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);  //chọn nhấn enter
        robot.keyRelease(KeyEvent.VK_ENTER); //keyRelease để nhắc phím enter lên

        Thread.sleep(2000);
    }

    @Test
    public void mousePress() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        Robot robot = new Robot();
        //Di chuyển trỏ chuột đến vị trí x,y
        robot.mouseMove(1400, 200);
        robot.delay(1000); //Delay giống sleep
        //Click chuột trái
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //Thả chuột trái ra
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
    }

    @Test
    public void createScreenCapture() throws InterruptedException, AWTException, IOException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);
        Robot robot = new Robot();

        //Dùng Dimension để lấy kích cỡ của màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File("TestImageRobot.png");
        ImageIO.write(image, "png", file);

        Thread.sleep(1000);
    }
}

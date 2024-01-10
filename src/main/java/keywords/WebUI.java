package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {

    public static  void sleep(double second){
        try {
            Thread.sleep((long) (1000*second));
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisitable(WebDriver driver, By by, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Hàm check Element tồn tại trong DOM
    public static boolean checkElementExits(WebDriver driver, String xpath){
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));
        if(listElement.size() > 0) {
            System.out.println("Element" + xpath + "existing");
            return true;
        } else {
            System.out.println("Element" + xpath + "NOT exist");
            return false;
        }
    }
}

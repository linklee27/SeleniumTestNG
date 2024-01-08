package LinhTester.B15_Waits;

import LinhTester.A_Common.BaseTest;
import org.testng.annotations.Test;

public class ExplicitWait extends BaseTest {
    @Test
    public void Login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Website Testing')]")));

        driver.findElement(By.xpath("//h3[contains(text(),'Website Testing')]")).click();
    }
}

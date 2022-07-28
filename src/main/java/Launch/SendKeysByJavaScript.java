package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class SendKeysByJavaScript {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userName =driver.findElement(By.id("txtUsername"));
        JavascriptExecutor executor=  (JavascriptExecutor) driver;
        Thread.sleep(3000);
        executor.executeScript("arguments[0].value='Admin';",userName);
        WebElement password= driver.findElement(By.id("txtPassword"));
        executor.executeScript("arguments[0].value='admin123';",password);
    }
}

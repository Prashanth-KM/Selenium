package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        WebElement element= driver.findElement(By.id("alertButton"));
        element.click();
        Thread.sleep(5000);
        Alert alert= driver.switchTo().alert();
        Thread.sleep(5000);
        alert.accept();
        Thread.sleep(5000);
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(5000);
        alert.dismiss();
    }
}

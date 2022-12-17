package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchDriver {
    public WebDriver driver;

    @Test
    void acceptAlert() throws InterruptedException {
        WebElement element= driver.findElement(By.id("alertButton"));
        element.click();
        Thread.sleep(5000);
        Alert alert= driver.switchTo().alert();
        Thread.sleep(5000);
        alert.accept();
    }

    @BeforeClass
    void launch(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
    }

    @AfterClass
    void close(){
        driver.close();
    }




}

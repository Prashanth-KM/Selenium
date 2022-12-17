package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.navigate().to("");
        driver.close();
        driver.quit();

        WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Test");

        WebElement lastName= driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("user");

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[5]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();


    }
}

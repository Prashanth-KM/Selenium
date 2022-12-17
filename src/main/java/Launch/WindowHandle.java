package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");


        Thread.sleep(2000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(2000);
        Set<String> handles =driver.getWindowHandles();
        Iterator<String> itr= handles.iterator();
        String parentWindow= itr.next();
        String childWindow= itr.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(15000);

        //code to execute in sub tab
        driver.findElement(By.xpath("(//*[text()='Book a Free Demo'])[position()= last()]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("Form_getForm_FullName")).sendKeys("Testing");

        driver.switchTo().window(parentWindow);
        //code to execute in main Tab
        Thread.sleep(3000);
        WebElement userName= driver.findElement(By.xpath("//input[@*='username']"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@*='password']"));
        password.sendKeys("admin123");
        WebElement loginButton= driver.findElement(By.xpath("//*[contains(@class,'oxd-button')]"));
        loginButton.click();
    }
}

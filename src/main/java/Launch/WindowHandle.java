package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");


        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(2000);
        Set<String> handles =driver.getWindowHandles();
        Iterator<String> itr= handles.iterator();
        String parentWindow= itr.next();
        String childWindow= itr.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(15000);

        //code to execute in sub tab
        driver.findElement(By.xpath("//*[@class='btn-orange contact-ohrm ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("Form_submitForm_FullName")).sendKeys("Testing");

        driver.switchTo().window(parentWindow);
        //code to execute in main Tab
        WebElement userName= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
    }
}

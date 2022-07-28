package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userName= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
        List<WebElement> list=driver.findElements(By.xpath("//*[@class='legendLabel']"));
        for(int i=0;i< list.size();i++){
            String label= list.get(i).getText();
            System.out.println(label);
        }
    }
}

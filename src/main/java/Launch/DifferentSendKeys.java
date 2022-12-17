package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class DifferentSendKeys {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.in/");
        WebElement searchBar= driver.findElement(By.id("twotabsearchtextbox"));
        // javascript sendkeys
        JavascriptExecutor executor=  (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='JavaScript';",searchBar);
        Thread.sleep(3000);
        searchBar.clear();
        // normal selenium sendkeys
        searchBar.sendKeys("normal sendkeys");
        Thread.sleep(3000);
        searchBar.clear();

        //actions class sendkeys
        Actions actions= new Actions(driver);
        actions.sendKeys(searchBar,"Action class sendkeys").perform();

        // javascript click
        WebElement element= driver.findElement(By.id("glow-ingress-line2"));
        executor.executeScript("arguments[0].click();", element);




    }
}

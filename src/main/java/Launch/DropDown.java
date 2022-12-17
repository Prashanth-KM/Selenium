package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
    public WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        DropDown dropDown= new DropDown();
        dropDown.launchBrowser();
        dropDown.handleDropDown();
        dropDown.handleBySelectClass();

    }

    void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

    }

    void handleDropDown() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Select Option']")).click();
        //In the Dom Structure-->Event listeners-->blur--> remove
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Group 1, option 2']")).click();
    }

    void handleBySelectClass() throws InterruptedException {
        WebElement element= driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
        select.selectByVisibleText("Indigo");
        Thread.sleep(3000);
        select.selectByValue("3");
        Thread.sleep(3000);
        select.selectByIndex(0);

    }
}

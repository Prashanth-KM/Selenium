package ActionsFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
   public WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        MouseHover mouseHover= new MouseHover();
        mouseHover.launchBrowser();
        mouseHover.handleMouseHover();
    }

    void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }


    void handleMouseHover() throws InterruptedException {
        WebElement signIn= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions actions= new Actions(driver);
        actions.moveToElement(signIn).build().perform();
        Thread.sleep(3000);

        WebElement account= driver.findElement(By.xpath("//span[text()='Your Account']"));
        actions.click(account).perform();
        Thread.sleep(4000);

        WebElement searchBar= driver.findElement(By.id("twotabsearchtextbox"));
        actions.sendKeys(searchBar,"Laptop").perform();


    }
}

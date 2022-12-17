package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        FindElements getTextAndGetAttribute= new FindElements();
        getTextAndGetAttribute.launchBrowser();
        getTextAndGetAttribute.login();
        getTextAndGetAttribute.navigateToMyInfo();

    }

    void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    void login() throws InterruptedException {
        Thread.sleep(3000);
        WebElement userName= driver.findElement(By.xpath("//input[@*='username']"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@*='password']"));
        password.sendKeys("admin123");
        WebElement loginButton= driver.findElement(By.xpath("//button[contains(@class,'oxd-button')]"));
        loginButton.click();
    }

    void navigateToMyInfo() throws NoSuchElementException, InterruptedException {
        Thread.sleep(5000);
        WebElement myInfo=  driver.findElement(By.xpath("//span[text()='My Info']"));

        myInfo.click();
        Thread.sleep(3000);
        WebElement ssnNO= driver.findElement(By.xpath("//label[text()='SSN Number']"));
        String ssnText= ssnNO.getText();
        System.out.println("Text from getText :"+ssnText);
//Find elements
        List<WebElement> menuOptions= driver.findElements(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        for(int i=0;i<menuOptions.size();i++){
            String textValue= menuOptions.get(i).getText();
            System.out.println(textValue);
        }

    }

}
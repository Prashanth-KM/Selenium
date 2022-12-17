package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextAndAttribute {
   static WebDriver driver;
    static void launch(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }
    static void getHeader(){
        WebElement pageHeader= driver.findElement(By.className("main-header"));
        String header=pageHeader.getText();
        System.out.println("Page header :"+header);

    }

    static void getDob(){
        WebElement dob=driver.findElement(By.xpath("//*[@*='dateOfBirthInput']"));
        String dateOfBirth= dob.getAttribute("value");
        System.out.println("DOB :"+dateOfBirth);
        WebElement textArea= driver.findElement(By.id("currentAddress"));
        System.out.println(textArea.getAttribute("placeholder"));
    }

    public static void main(String[] args) {
        launch();
        getHeader();
        getDob();
    }
}

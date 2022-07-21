package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        Login login= new Login();
        login.launchBrowser();
        login.login();
        login.navigateToMyInfo();
    }

    void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    void login(){

        WebElement userName= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
    }

    void navigateToMyInfo() throws InterruptedException {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        WebElement firstName= driver.findElement(By.id("personal_txtEmpFirstName"));
        firstName.clear();
        firstName.sendKeys("test");
        WebElement lastName= driver.findElement(By.id("personal_txtEmpLastName"));
        lastName.clear();
        lastName.sendKeys("testing");
        WebElement smokerChkBox= driver.findElement(By.id("personal_chkSmokeFlag"));
        smokerChkBox.click();
        driver.findElement(By.id("personal_optGender_2")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("personal_optGender_1")).click();

    }
}

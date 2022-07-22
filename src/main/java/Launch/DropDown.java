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
        dropDown.login();
        dropDown.navigateToMyInfo();
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

        WebElement nationalityDropDown= driver.findElement(By.id("personal_cmbNation"));
        Select select= new Select(nationalityDropDown);
        select.selectByVisibleText("British");
        Thread.sleep(4000);
        select.selectByIndex(1);
        Thread.sleep(4000);
        select.selectByValue("82");

        WebElement maritalStatus= driver.findElement(By.xpath("//select[@id='personal_cmbMarital']"));
        Select select1= new Select(maritalStatus);
        select1.selectByVisibleText("Single");
        Thread.sleep(3000);
        select1.selectByValue("Other");

    }
}

package FrameworkA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageClass extends baseClass{


   static void validLogin(String user, String pass) throws InterruptedException {
       Thread.sleep(4000);
        WebElement userName =driver.findElement(By.name("username"));
        CommonFunctions.sendKeysBySelenium(userName,user);
        Thread.sleep(2000);
        WebElement password= driver.findElement(By.name("password"));
        CommonFunctions.sendKeysByActions(password,pass);
        WebElement loginBtn= driver.findElement(By.xpath("//*[contains(@class,'oxd-button oxd-button')]"));
        CommonFunctions.clickOnElement(loginBtn);
    }
    static void navigateToMyInfo(){

    }

    static void enterPersonalDetails(){

    }

    static void contactDetails(){

    }
}

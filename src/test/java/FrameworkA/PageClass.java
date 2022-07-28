package FrameworkA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageClass extends baseClass{


   static void validLogin(String user, String pass) throws InterruptedException {
        WebElement userName =driver.findElement(By.id("txtUsername"));
        CommonFunctions.sendKeysByJavaScript(userName,user);
        WebElement password= driver.findElement(By.id("txtPassword"));
        CommonFunctions.sendKeysByActions(password,pass);
        WebElement loginBtn= driver.findElement(By.id("btnLogin"));
        CommonFunctions.clickOnElement(loginBtn);
    }
}

package FrameworkA;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonFunctions extends baseClass{

    static void sendKeysBySelenium(WebElement element, String data){
        element.clear();
        element.sendKeys(data);
    }

    static void sendKeysByActions(WebElement element, String data){
        Actions actions= new Actions(driver);
        actions.sendKeys(element,data).perform();
    }

    static void sendKeysByJavaScript(WebElement element, String data){
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='"+data+"';",element);
    }

   static void selectFromDropDown(WebElement element,String visibleText){
        Select select= new Select(element);
        select.selectByVisibleText(visibleText);
    }

    static void acceptAlert(){
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }

    static void handleDragAndDrop(WebElement source, WebElement target){
        Actions actions= new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();
    }

    static void clickOnElement(WebElement element){
        element.click();
    }
}

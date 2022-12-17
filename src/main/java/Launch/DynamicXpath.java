package Launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicXpath {
    public  WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        DynamicXpath obj= new DynamicXpath();
        obj.launch();
        obj.selectDateBySelectClass("15","May","2000");
        obj.selectDate("20","June","2024");


    }

    void launch(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/date-picker");

    }

    void selectDateBySelectClass( String dayData,String monthData, String yearData) throws InterruptedException {
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        WebElement month= driver.findElement(By.className("react-datepicker__month-select"));
        WebElement year= driver.findElement(By.className("react-datepicker__year-select"));
        selectFromDropDown(month,monthData);
        Thread.sleep(3000);
        selectFromDropDown(year,yearData);
        Thread.sleep(3000);
        WebElement day= driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='"+dayData+"']"));
        System.out.println("//div[contains(@class,'react-datepicker__day') and text()='"+dayData+"']");
        day.click();

    }

    void selectFromDropDown(WebElement element,String visibleText){
        Select select= new Select(element);
        select.selectByVisibleText(visibleText);
    }

    void selectDate(String dateValue,String monthValue, String yearValue){
        driver.findElement(By.id("dateAndTimePickerInput")).click();
        WebElement month= driver.findElement(By.xpath("//div[@class='react-datepicker__month-read-view']"));
        month.click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__month-option' and text()='"+monthValue+"']")).click();
        WebElement year= driver.findElement(By.xpath("//div[@class='react-datepicker__year-read-view']"));
        year.click();
       driver.findElement(By.xpath("//div[@class='react-datepicker__year-option' and text()='"+yearValue+"']")).click();

        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker') and text()='"+dateValue+"']")).click();
    }

}

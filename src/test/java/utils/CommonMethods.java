package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializers {

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() {
       // ConfigReader.readProperties("C:\\Users\\jeeri\\IdeaProjects\\CucumberFramework");
        //แทนที่จะเรียก ไฟล์ Prop โดยการใช้ direct part (ไม่ dynamic) ก็ให้นำไปเซ็ตที constant แทน
        // เพราะ แต่ละเครื่อง path ช่วงแรกไม่เหมือนกัน แต่ path ช่วงหลังเหมือนกันทุกอย่าง
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        //get driver ใช้ switch เข้ามาช่วย เราสามารถใส่เพิ่มกี่ browser ก็ได้
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
               // WebDriver driver = new ChromeDriver();
                //บางทีอาจจะมีปัญหาเรื่องเวอร์ชั่นของ driver  เลยใช้ webdrivermgr เข้ามาช่วย
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            default:
                throw new RuntimeException("Invalid browser name");
        }
        //driver.get("url");
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();
    }


    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element) {

        getJSExecutor().executeScript("arguments[0].click();", element);
    }
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName
                    + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        //to format the date according to our choice we want to implement in this function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void tearDown(){

        driver.quit();
    }
//check
    public static void verifyErrorMessage(WebElement element){
        System.out.println("Error message is displayed :" +element.isDisplayed());
    }
    //check
    public static void getErrorMessageText (WebElement element){
        System.out.println("Error Message is :"+element.getText());
    }

}

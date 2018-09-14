package Help;import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Help.SQLMan;public class Uitox {
 /*
  * 基本相關
  */
 //基本資訊
 protected static String browserType;
 protected static void BasicInfo(String temp_BrowserType){
  Date date=new Date();
  SimpleDateFormat setDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  System.out.println("日期："+setDateFormat.format(date));
  System.out.println("作業系統："+System.getProperty("os.name")+"("+System.getProperty("os.version")+")");
  switch(temp_BrowserType){
  case "i":
   System.out.println("瀏覽器：Internet Explorer");
   browserType=temp_BrowserType;
   break;
  case "c":
   System.out.println("瀏覽器：Google Chrome");
   browserType=temp_BrowserType;
   break;
  case "f":
   System.out.println("瀏覽器：Mozilla Firefox");
   browserType=temp_BrowserType;
   break;
  }
  System.out.println("BC code："+Area);
  System.out.println("國家："+Country);
  System.out.println("");
  System.out.println("開始執腳本;");
 }
//設定瀏覽器類型
 protected static WebDriver driver;
 protected static Robot robot;
 protected static SQLMan SQLMan;
 protected static void SetBrowser(String Temp_Browser) throws Exception{
  switch(Temp_Browser){
  case "c":
   System.out.println("選用Google Chrome;");
   System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
   //實體化driver
   driver=new ChromeDriver();
   //設定固定等待時間
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   //實體化robot
   robot= new Robot();
   //實體化SQL
   SQLMan=new SQLMan();
   break;
  case "f":
   System.out.println("選用Mozilla Firefox;");
   //實體化driver
   driver=new FirefoxDriver();
   //設定固定等待時間
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   //實體化robot
   robot= new Robot();
   //實體化SQL
   SQLMan=new SQLMan();
   break;
  }
 }
 /*
  * uitox相關
  */
//存取區域的方法預設"a"
 protected static String Area="a";
 protected void Area(String Temp_Area){
  Area=Temp_Area;
  }
 //存取國家的方法預設"TW"
 protected static String Country="tw";
 protected void Country(String Temp_Country){
  Country=Temp_Country;
  }
 //存取平台編號的方法預設"AW000001"
 protected String Platform ="AW000001";
 protected void Platform(String Temp_Platform){
  Platform=Temp_Platform;
  }
 //存取帳號的方法
 protected String User;
 protected void User(String Temp_User){
  Platform=Temp_User;
  }
 //存取密碼的方法
 protected String Password;
 protected void Password(String Temp_Password){
  Platform=Temp_Password;
  }
 //呼叫平台管理系統網址
 protected static String WebSiteUrl(){
  return "http://vendor-"+Country+"1.beta1.ux/login?webdriver";
  }
 //判斷讀取頁面灰色loadmask畫面等待時間
 public static void loadmask() throws Exception {
  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  while (isElementPresent(By.className("loadmask"))) {
   Thread.sleep(100);
   //System.out.println(isElementPresent(By.className("loadmask")));
  }
  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
 }
 /*
  * Junit相關
  */
//錯誤訊息
 protected static StringBuffer verificationErrors=new StringBuffer();
 protected static String verificationErrorString;
 protected static boolean acceptNextAlert=true;
 //
 public static boolean isElementPresent(By by) {
  try {
   driver.findElement(by);
   return true;
  } catch (NoSuchElementException e) {
   return false;
  }
 }
 //
 public boolean isAlertPresent() {
  try {
   driver.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
   return false;
  }
 }
 //
 public String closeAlertAndGetItsText() {
  try {
       Alert alert=driver.switchTo().alert();
       String alertText=alert.getText();
       if (acceptNextAlert) {
         alert.accept();
       } else {
         alert.dismiss();
       }
       return alertText;
     } finally {
       acceptNextAlert=true;
     }
 }
}
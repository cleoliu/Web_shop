package Help;import java.sql.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.Robot;
import java.awt.event.KeyEvent;public class Method {
 //存取區域的方法
 //Area("a")
 protected String Area="a";
 protected void Area(String Temp_Area){Area=Temp_Area;}
 //存取國家的方法
 //Country("tw")
 protected static String Country="tw";
 protected void Country(String Temp_Country){
  Country=Temp_Country;
  }
 //存取平台編號的方法
 //Platform("AW000001")
 protected String Platform ="AW000001";
 protected void Platform(String Temp_Platform){
  Platform=Temp_Platform;
  }
 //存取帳號的方法
 //User("帳號")
 protected String User;
 protected void User(String Temp_User){
  Platform=Temp_User;
  }
 //存取密碼的方法
 //Password("密碼")
 protected String Password;
 protected void Password(String Temp_Password){
  Platform=Temp_Password;
  }
 //連結資料庫的方法
 //Conn_SQL("A");
 protected static String SQL_Area;
 protected static Connection conn;
 protected static void Conn_SQL(String Temp_SQL_Area) throws Exception{
  SQL_Area=Temp_SQL_Area;
switch(SQL_Area){
   case "A":
   case "a":
    System.out.print("連結A區DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:AORD","UAORDWEB","zyarhp3y");
    break;
   case "B":
   case "b": 
    System.out.print("連結B區DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:BORD","UBORDERP","j3yz6drscn");
    break;
   case "D":
   case "d":
    System.out.print("連結C區DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:DORD","UDORDERP","dBK7nYA8Ua");
    break;
   case "E":
   case "e":
    System.out.print("連結D區DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:EORD","UEORDERP","PvpnXIAayq");
    break;
   case "F":
   case "f":
    System.out.print("連結E區DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:FORD","UFORDERP","uW6jETVKSg");
    break;
   case "G":
   case "g":
    System.out.print("連結F區DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:UGORD","UGORDWEB","hp5SdG6nnQ");
    break;
   }
  }
 //設定瀏覽器類型
 protected static WebDriver driver;
 protected static Robot robot;
 protected static void SetBrowser() throws Exception{
  System.out.println("預設使用Firefox Browser;");
  driver=new FirefoxDriver();
  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
  robot=new Robot();
}
 protected void SetBrowser(String Temp_Browser) throws Exception{
  switch(Temp_Browser){
  case "chrome":
   System.out.println("選用Chrome Browser;");
   System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
   driver=new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   robot=new Robot();default:
   break;
  case "firefox":
   System.out.println("選用Firefox Browser;");
   driver=new FirefoxDriver();
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   robot=new Robot();
   break;  
  }
  
 }
 //呼叫平台管理系統網址
 protected static String WebSiteUrl(){
  return "http://vendor-"+Country+"1.beta1.ux/login?webdriver";
  }
 //呼叫商品列表網址
 protected static String List_Show(){
  return "A";
  }
 //設定機器人
 protected static void keyPress(Robot r , int key){//按什麼按鈕
  r.keyPress(key);
  r.keyRelease(key);
  r.delay(100);
 }
 protected static void keyPressWithAlt(Robot r , int key){//Alt+什麼按鈕
  r.keyPress(KeyEvent.VK_ALT);
  r.keyPress(key);
  r.keyRelease(key);
  r.keyRelease(KeyEvent.VK_ALT);
  r.delay(100);
 }
//計算Xpath元素
 //protected int CountXpath(By Temp_Xpath){
  //  List located_elements=driver.findElements(Temp_Xpath);
  //  int countxpath=0;
  //  for(WebElement located_element :located_elements){
  //   countxpath++;
  //  }
 //   return countxpath;
// }
 //每個腳本預設使用的方法暫時還不知道要怎麼註解先這樣
 public static StringBuffer verificationErrors=new StringBuffer();
 public static String verificationErrorString;
 public static boolean acceptNextAlert=true;
 public static boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }
 public boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }
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
 public static void loadmask() throws Exception {
  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
 //判斷讀取頁面灰色loadmask畫面等待時間
 while (isElementPresent(By.className("loadmask"))) {
  Thread.sleep(100);
  //System.out.println(isElementPresent(By.className("loadmask")));
 }
 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
 }
 //String(小數)轉(百分比)   StrDotToPercent(字串,小數點後留幾位)
 public static String StrDotToPercent(String SM_MARGIN,int dots) {
  NumberFormat DotToPercent=NumberFormat.getPercentInstance();
  DotToPercent.setMaximumFractionDigits(dots);
  String StrDotToPercent=String.valueOf(DotToPercent.format(Double.parseDouble(SM_MARGIN)));
  return StrDotToPercent;
 }
}
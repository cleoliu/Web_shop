package Help;import java.sql.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.Robot;
import java.awt.event.KeyEvent;public class Method {
 //�s���ϰ쪺��k
 //Area("a")
 protected String Area="a";
 protected void Area(String Temp_Area){Area=Temp_Area;}
 //�s����a����k
 //Country("tw")
 protected static String Country="tw";
 protected void Country(String Temp_Country){
  Country=Temp_Country;
  }
 //�s�����x�s������k
 //Platform("AW000001")
 protected String Platform ="AW000001";
 protected void Platform(String Temp_Platform){
  Platform=Temp_Platform;
  }
 //�s���b������k
 //User("�b��")
 protected String User;
 protected void User(String Temp_User){
  Platform=Temp_User;
  }
 //�s���K�X����k
 //Password("�K�X")
 protected String Password;
 protected void Password(String Temp_Password){
  Platform=Temp_Password;
  }
 //�s����Ʈw����k
 //Conn_SQL("A");
 protected static String SQL_Area;
 protected static Connection conn;
 protected static void Conn_SQL(String Temp_SQL_Area) throws Exception{
  SQL_Area=Temp_SQL_Area;
switch(SQL_Area){
   case "A":
   case "a":
    System.out.print("�s��A��DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:AORD","UAORDWEB","zyarhp3y");
    break;
   case "B":
   case "b": 
    System.out.print("�s��B��DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:BORD","UBORDERP","j3yz6drscn");
    break;
   case "D":
   case "d":
    System.out.print("�s��C��DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:DORD","UDORDERP","dBK7nYA8Ua");
    break;
   case "E":
   case "e":
    System.out.print("�s��D��DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:EORD","UEORDERP","PvpnXIAayq");
    break;
   case "F":
   case "f":
    System.out.print("�s��E��DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:FORD","UFORDERP","uW6jETVKSg");
    break;
   case "G":
   case "g":
    System.out.print("�s��F��DB");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:UGORD","UGORDWEB","hp5SdG6nnQ");
    break;
   }
  }
 //�]�w�s��������
 protected static WebDriver driver;
 protected static Robot robot;
 protected static void SetBrowser() throws Exception{
  System.out.println("�w�]�ϥ�Firefox Browser;");
  driver=new FirefoxDriver();
  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
  robot=new Robot();
}
 protected void SetBrowser(String Temp_Browser) throws Exception{
  switch(Temp_Browser){
  case "chrome":
   System.out.println("���Chrome Browser;");
   System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
   driver=new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   robot=new Robot();default:
   break;
  case "firefox":
   System.out.println("���Firefox Browser;");
   driver=new FirefoxDriver();
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   robot=new Robot();
   break;  
  }
  
 }
 //�I�s���x�޲z�t�κ��}
 protected static String WebSiteUrl(){
  return "http://vendor-"+Country+"1.beta1.ux/login?webdriver";
  }
 //�I�s�ӫ~�C����}
 protected static String List_Show(){
  return "A";
  }
 //�]�w�����H
 protected static void keyPress(Robot r , int key){//��������s
  r.keyPress(key);
  r.keyRelease(key);
  r.delay(100);
 }
 protected static void keyPressWithAlt(Robot r , int key){//Alt+������s
  r.keyPress(KeyEvent.VK_ALT);
  r.keyPress(key);
  r.keyRelease(key);
  r.keyRelease(KeyEvent.VK_ALT);
  r.delay(100);
 }
//�p��Xpath����
 //protected int CountXpath(By Temp_Xpath){
  //  List located_elements=driver.findElements(Temp_Xpath);
  //  int countxpath=0;
  //  for(WebElement located_element :located_elements){
  //   countxpath++;
  //  }
 //   return countxpath;
// }
 //�C�Ӹ}���w�]�ϥΪ���k�Ȯ��٤����D�n�����ѥ��o��
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
 //�P�_Ū�������Ǧ�loadmask�e�����ݮɶ�
 while (isElementPresent(By.className("loadmask"))) {
  Thread.sleep(100);
  //System.out.println(isElementPresent(By.className("loadmask")));
 }
 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
 }
 //String(�p��)��(�ʤ���)   StrDotToPercent(�r��,�p���I��d�X��)
 public static String StrDotToPercent(String SM_MARGIN,int dots) {
  NumberFormat DotToPercent=NumberFormat.getPercentInstance();
  DotToPercent.setMaximumFractionDigits(dots);
  String StrDotToPercent=String.valueOf(DotToPercent.format(Double.parseDouble(SM_MARGIN)));
  return StrDotToPercent;
 }
}
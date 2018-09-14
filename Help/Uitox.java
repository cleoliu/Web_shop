package Help;import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Help.SQLMan;public class Uitox {
 /*
  * �򥻬���
  */
 //�򥻸�T
 protected static String browserType;
 protected static void BasicInfo(String temp_BrowserType){
  Date date=new Date();
  SimpleDateFormat setDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  System.out.println("����G"+setDateFormat.format(date));
  System.out.println("�@�~�t�ΡG"+System.getProperty("os.name")+"("+System.getProperty("os.version")+")");
  switch(temp_BrowserType){
  case "i":
   System.out.println("�s�����GInternet Explorer");
   browserType=temp_BrowserType;
   break;
  case "c":
   System.out.println("�s�����GGoogle Chrome");
   browserType=temp_BrowserType;
   break;
  case "f":
   System.out.println("�s�����GMozilla Firefox");
   browserType=temp_BrowserType;
   break;
  }
  System.out.println("BC code�G"+Area);
  System.out.println("��a�G"+Country);
  System.out.println("");
  System.out.println("�}�l���}��;");
 }
//�]�w�s��������
 protected static WebDriver driver;
 protected static Robot robot;
 protected static SQLMan SQLMan;
 protected static void SetBrowser(String Temp_Browser) throws Exception{
  switch(Temp_Browser){
  case "c":
   System.out.println("���Google Chrome;");
   System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
   //�����driver
   driver=new ChromeDriver();
   //�]�w�T�w���ݮɶ�
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   //�����robot
   robot= new Robot();
   //�����SQL
   SQLMan=new SQLMan();
   break;
  case "f":
   System.out.println("���Mozilla Firefox;");
   //�����driver
   driver=new FirefoxDriver();
   //�]�w�T�w���ݮɶ�
   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
   //�����robot
   robot= new Robot();
   //�����SQL
   SQLMan=new SQLMan();
   break;
  }
 }
 /*
  * uitox����
  */
//�s���ϰ쪺��k�w�]"a"
 protected static String Area="a";
 protected void Area(String Temp_Area){
  Area=Temp_Area;
  }
 //�s����a����k�w�]"TW"
 protected static String Country="tw";
 protected void Country(String Temp_Country){
  Country=Temp_Country;
  }
 //�s�����x�s������k�w�]"AW000001"
 protected String Platform ="AW000001";
 protected void Platform(String Temp_Platform){
  Platform=Temp_Platform;
  }
 //�s���b������k
 protected String User;
 protected void User(String Temp_User){
  Platform=Temp_User;
  }
 //�s���K�X����k
 protected String Password;
 protected void Password(String Temp_Password){
  Platform=Temp_Password;
  }
 //�I�s���x�޲z�t�κ��}
 protected static String WebSiteUrl(){
  return "http://vendor-"+Country+"1.beta1.ux/login?webdriver";
  }
 //�P�_Ū�������Ǧ�loadmask�e�����ݮɶ�
 public static void loadmask() throws Exception {
  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  while (isElementPresent(By.className("loadmask"))) {
   Thread.sleep(100);
   //System.out.println(isElementPresent(By.className("loadmask")));
  }
  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
 }
 /*
  * Junit����
  */
//���~�T��
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
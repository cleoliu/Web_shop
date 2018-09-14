package Help;
import org.openqa.selenium.By;


public class CrossHelp extends Uitox{
 //去商品列表
 public static String uosite;
 public static void GoToCross(String x) throws Exception{
  //設定瀏覽器
  SetBrowser("firefox");
     //開啟平台管理系統
    System.out.println("開啟平台管理系統;");
    driver.get(WebSiteUrl());
    //瀏覽器最大化
    System.out.println("瀏覽器最大化;");
    driver.manage().window().maximize();
    //驗正碼輸入
    System.out.println("驗正碼輸入;");
    driver.findElement(By.id("captcha")).sendKeys("test");
    //點擊登入按鈕
    System.out.println("點擊登入按鈕;");
    driver.findElement(By.cssSelector("button.btn-submit")).click();
    //等待5秒
    Thread.sleep(5000);
    //滾動捲軸至看見[外站賣商品列表]連結
    WebDriverMan.WindowScrollBottom(driver,By.xpath("(//a[contains(text(),'外站賣商品列表')])[2]"));
    //進入外站賣商品列表
    System.out.println("進入外站賣商品列表;");
    driver.findElement(By.xpath("(//a[contains(text(),'外站賣商品列表')])[2]")).click();
    uosite=x;
    switch(x){
     case "1":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[1]")).click();
      break;
     case "2":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[2]")).click();
      break;
     case "3":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[3]")).click();
      break;
     case "4":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[4]")).click();
      break;
     case "5":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[5]")).click();
      break;
  }
   //連接DB
    //Conn_SQL("A");
    //等待5秒
    Thread.sleep(5000);
 }
}
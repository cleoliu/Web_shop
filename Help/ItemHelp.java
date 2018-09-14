package Help;
import org.testng.Assert;
import org.openqa.selenium.By;
import Help.Uitox;

public class ItemHelp extends Uitox {
 //去商品列表
 public static void GoToItem() throws Exception{
  //設定瀏覽器
  SetBrowser(browserType);
     //開啟平台管理系統
    System.out.println("開啟平台管理系統;");
    driver.get(WebSiteUrl());
    //瀏覽器最大化
    System.out.println("瀏覽器最大化;");
    driver.manage().window().maximize();
    //驗正碼輸入
    System.out.println("驗正碼輸入;");
    driver.findElement(By.id("captcha")).sendKeys("test");
    //等一下
    Thread.sleep(2000);
    //點擊登入按鈕
    System.out.println("點擊登入按鈕;");
    driver.findElement(By.cssSelector("button.btn-submit")).click();
    //等待5秒
    Thread.sleep(5000);
    //進入商品列表
    System.out.println("進入商品列表;");
    driver.findElement(By.linkText("商品列表")).click();
 }
 //查詢商品ID Itno
 protected static void SearchItno(String Temp_Itno) throws Exception{
 //輸入Itno
 driver.findElement(By.cssSelector(".search-input")).clear();
 System.out.println("輸入itno'"+Temp_Itno+"';");
 driver.findElement(By.cssSelector(".search-input")).sendKeys(Temp_Itno);
 //點擊搜尋按鈕
 System.out.println("點擊搜尋按鈕;");
 driver.findElement(By.id("search")).click();
 //Thread.sleep(10000);
 loadmask();
 String noitem =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td")).getText();
   //檢查是否抓不到商品
   if( "目前沒有相關的商品".equals(noitem)){
    Assert.fail("目前沒有相關的商品");
    }
 }
 //抓取Web上的Itno
 protected static String webItno;
 protected  static void CatchItno(){ 
 }
 
}
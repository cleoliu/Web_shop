package Help;import org.openqa.selenium.*;
import Help.WebDriverMan;public class ShowSpecialHelp extends Uitox{ //去特賣變價列表
 public static void GoToShowSpecial() throws Exception{
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
    //滾動滾軸至元素 切齊瀏覽器下緣
    WebDriverMan.WindowScrollBottom(driver,By.xpath("/html/body/div[1]/div[2]/div[2]/dl[3]/dd[1]/a"));
    //進入特賣變價列表
    System.out.println("進入特賣變價列表;");
    driver.findElement(By.linkText("特賣變價")).click();
 }
  
 }
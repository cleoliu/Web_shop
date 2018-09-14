package Help;
import static org.junit.Assert.fail;
import org.openqa.selenium.*;

public class ShowMainHelp extends Uitox {
  //去賣場列表
 public static void GoToShowMain() throws Exception{
     //瀏覽器設定   firefox or chrome
  SetBrowser(browserType);
  //開啟平台管理系統
    System.out.println("開啟平台管理系統;");
  driver.get(WebSiteUrl());
    //瀏覽器最大化
    System.out.println("瀏覽器最大化;");
    driver.manage().window().maximize();
    //驗證碼輸入
    System.out.println("驗證碼輸入;");
     driver.findElement(By.id("captcha")).clear();
     driver.findElement(By.id("captcha")).sendKeys("test");
    //點擊登入按鈕
    System.out.println("點擊登入按鈕;");
     driver.findElement(By.xpath("/html/body/form/dl/dd[6]/button")).click();
    //等待5秒
    Thread.sleep(5000);
    //進入賣場列表
    System.out.println("進入賣場列表;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/dl[1]/dd[4]/a")).click();
  }
 public static void SearchSM_SEQ(String _sm_seq) throws Exception{
  //等待頁面loading
  loadmask();
  //輸入賣場ID
  System.out.println("輸入賣場ID'"+_sm_seq+"';");
  driver.findElement(By.xpath("//*[@class='search-input']")).sendKeys(_sm_seq);
  //點擊搜尋按鈕
  System.out.println("點擊搜尋按鈕;");
  driver.findElement(By.xpath("//*[@class='btn-info']")).click();
  //等待頁面loading
  loadmask();
  String noitem =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td")).getText();
  //檢查是否抓不到商品
  if("目前沒有相關的商品".equals(noitem)){
    fail("目前沒有相關的商品");
  }
 }
}
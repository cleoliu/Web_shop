package Build;import java.awt.event.KeyEvent;
import org.openqa.selenium.*;
import org.junit.*;
import Help.AddHelp;
import Help.RobotMan;public class Add extends AddHelp{
 @Before
 public void Before() throws Exception {
  //基本資訊
   BasicInfo("f");
  //去新增頁面
  GoToAdd();
    Thread.sleep(2000);
    //點擊新增商品
    System.out.println("點擊新增商品;");
    driver.findElement(By.cssSelector(".btn-action")).click();
    Thread.sleep(1000);
    //設定商品名稱
    SetItemNameType(System.getenv("name_type"),System.getenv("item_type"));
    //點擊下一步
    System.out.println("點擊下一步;");
    driver.findElement(By.id("next_item_info")).click();
    Thread.sleep(2000);
    //設定群組分類
    SetCategory();
    //鎖定供貨廠商的欄位
    SetSup();
    //點擊上傳圖片
    SetPhoto();
    //keyin價錢
    SetPrice();
    //移動往下到最下面
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[1]/div[2]/div[3]/span")).click();
    RobotMan.keyPress(robot,KeyEvent.VK_PAGE_DOWN);
    //輸入商品說明
    SetItemContent();
    //設定保固
    //設定維修聯絡資訊
    SetWarranty();
    //下一步
    System.out.println("點擊下一步;");
    RobotMan.keyPress(robot,KeyEvent.VK_PAGE_DOWN);
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[3]/button[2]")).click();
  Thread.sleep(5000);
    //設定長寬高
  SetLWHL("1","2","3","4");
    //設定屬性不需要
  RobotMan.keyPress(robot,KeyEvent.VK_PAGE_DOWN);
  Attribute();
  //點擊確認
  RobotMan.keyPress(robot,KeyEvent.VK_PAGE_DOWN);
  driver.findElement(By.id("add_show_btn")).click();
  driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/a")).click();
  Thread.sleep(10000);
  System.out.print("新增單品商品完成;");
 } @Test
 public void testAdd() throws Exception {
  
 } @After
   public void tearDown() throws Exception {
     driver.quit();
    
   }
 }
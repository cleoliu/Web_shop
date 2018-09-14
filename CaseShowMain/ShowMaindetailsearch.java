package CaseShowMain;
import org.junit.*;
import org.junit.runners.MethodSorters;import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //照順序做testpublic class ShowMaindetailsearch extends ShowMainHelp {@BeforeClass
public static void BeforeClass() throws Exception {
/*   //設定區域
   Area();
   //設定國家
   Country();*/
   //設定瀏覽器
   GoToShowMain();
   //連接DB
   Conn_SQL("A");  
//等待5秒
 Thread.sleep(5000);//點擊進階查詢按鈕
 System.out.println("點擊進階查詢按鈕");
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/button[2]")).click();
}
++++++=
@Before //將錯誤存起來
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}@Test
public void ShowMaindetailsearch01Category() throws Exception {
//分類
   try {
    assertEquals("分類", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[1]")).getText());
    System.out.println("-單一銷售網頁維護 進階查詢 分類 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("單一銷售網頁維護 進階查詢 分類 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[1]")).getText());
  }
 //選擇第一層分類(團購)
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).click();
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).sendKeys(Keys.ARROW_DOWN);
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).sendKeys(Keys.ENTER);
 //選擇第一層分類(商品小計)
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span[2]/select")).click();
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span[2]/select")).sendKeys(Keys.ARROW_DOWN);
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span[2]/select")).sendKeys(Keys.ENTER);
 //點擊查詢按鈕
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();++++++++++++=
//等待3秒
  Thread.sleep(3000);
 
   try {
      assertEquals("商品小計", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]")).getText());
      System.out.println("-單一銷售網頁維護 分類查詢功能 正確-");
    } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("單一銷售網頁維護 分類查詢功能 錯誤-");
      System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]")).getText());
    }
}
 @Test
public void ShowMaindetailsearch02Vendor() throws Exception {
//特定廠商
   try {
  assertEquals("特定廠商", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[2]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 特定廠商 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 特定廠商 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[2]")).getText());
 }
}@Test
public void ShowMaindetailsearch03EmarketType() throws Exception {
//賣場類型++++++++===
try {
  assertEquals("賣場類型", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[3]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 賣場類型 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 賣場類型 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[3]")).getText());
} 
}@Test
public void ShowMaindetailsearch04AddTime() throws Exception {
//賣場新增日
   try {
  assertEquals("賣場新增日", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[4]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 賣場新增日 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 賣場新增日 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[4]")).getText());
}  
}@Test
public void ShowMaindetailsearch05Oversea() throws Exception {
//海外值
   try {
  assertEquals("海外值", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[6]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 海外值 文字比對正確-");
} catch (Error e) {+++++++++++++
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 海外值 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[6]")).getText());
}  
}@Test
public void ShowMaindetailsearch06EmarketStatus() throws Exception {
//賣場狀態
   try {
  assertEquals("賣場狀態", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[7]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 賣場狀態 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 賣場狀態 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[7]")).getText());
}   
}@Test
public void ShowMaindetailsearch07Qty() throws Exception {
//商品/組合 可賣量
   try {
  assertEquals("商品/組合 可賣量", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[8]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 商品/組合 可賣量 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 商品/組合 可賣量 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[8]")).getText());
}   
}++++++++===
@Test
public void ShowMaindetailsearch08ShowOthers() throws Exception {
//看其他人
   try {
  assertEquals("看其他人", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[10]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 看其他人 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 看其他人 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[10]")).getText());
}  
}@Test
public void ShowMaindetailsearch09NoEmarketImage() throws Exception {
//沒有主賣場圖的賣場
   try {
  assertEquals("沒有主賣場圖的賣場", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[11]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 沒有主賣場圖的賣場 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 沒有主賣場圖的賣場 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[11]")).getText());
} 
}@Test
public void ShowMaindetailsearch10allEMarket() throws Exception {
//看所有賣場
   try {+++++++++++=
assertEquals("看所有賣場", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[12]")).getText());
  System.out.println("-單一銷售網頁維護 進階查詢 看所有賣場 文字比對正確-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("單一銷售網頁維護 進階查詢 看所有賣場 文字比對錯誤-");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[12]")).getText());
} 
}@After
public void tearDown() {
  verificationErrorString=verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
  }
}@AfterClass
public  static void AfterClass(){
 System.out.println("腳本完成;");
  /*driver.quit();//關掉瀏覽器   */
}
}
package showspecial;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.PostMan;
import Help.ShowSpecialHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //照順序做test
public class ShowSpecial extends ShowSpecialHelp {
 
@BeforeClass
public static void BeforeClass() throws Exception {
 //瀏覽器
 BasicInfo("f");
 //進特賣變價列表
 GoToShowSpecial();
 //連接資料庫
 SQLMan.connect("A");
}@Before //將錯誤存起來
public void Befor() throws Exception{
verificationErrors= new StringBuffer();
}   ++
@Test
//平台管理系統 (zh-tw)
public void showspecial01PlatformManagementSystem() throws Exception {
  try {
     assertEquals("平台管理系統 (zh-tw)", driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/a")).getText());
     System.out.println("-平台管理系統 (zh-tw) 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("平台管理系統 (zh-tw) 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/a")).getText());
   }
}@Test
//Taiwan (繁體中文)
public void showspecial02Taiwan() throws Exception {
  try {
     assertEquals("Taiwan (繁體中文)", driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).getText());
     System.out.println("-Taiwan (繁體中文) 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("Taiwan (繁體中文) 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).getText());
   }
}++++++++++
@Test
//平台設定
public void PlatformSetup03() throws Exception {
  try {
     assertEquals("平台設定", driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/a")).getText());
     System.out.println("-平台設定 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("平台設定 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/a")).getText());
   }
}@Test
//uitox_test
public void user04() throws Exception {
  try {
     assertEquals("uitox_test", driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/a")).getText());
     System.out.println("-uitox_test 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("uitox_test 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/a")).getText());
   }
}
++++++++++++
@Test
//首頁
public void home05() throws Exception {
  try {
     assertEquals("首頁", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[1]/a")).getText());
     System.out.println("-首頁 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("首頁 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[1]/a")).getText());
   }
}@Test
//行銷活動管理
public void EventManagement06() throws Exception {
  try {
     assertEquals("行銷活動管理", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[2]/a")).getText());
     System.out.println("-行銷活動管理 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("行銷活動管理 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[2]/a")).getText());
   }
}
+++++++++++
@Test
//特賣變價
public void SpecialPromoSetting07() throws Exception {
  try {
     assertEquals("特賣變價", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[3]")).getText());
     System.out.println("-特賣變價 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("特賣變價 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[3]")).getText());
   }
}@Test
//title="賣場ID/賣場名稱"
public void EmarkeIDProductName08() throws Exception {
  try {
     assertEquals("賣場ID/賣場名稱", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/input[1]")).getAttribute("placeholder"));
     System.out.println("-賣場ID/賣場名稱 文字比對正確-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("賣場ID/賣場名稱 文字比對錯誤-");
     System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/input[1]")).getAttribute("placeholder"));
   }
}+++++++++
@After
public void tearDown() {
  verificationErrorString=verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
  }
}@AfterClass
public  static void AfterClass(){
 System.out.println("腳本完成;");
  driver.quit();//關掉瀏覽器
}
}
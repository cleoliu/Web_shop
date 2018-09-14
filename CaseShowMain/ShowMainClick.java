package CaseShowMain;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) 

 


@BeforeClass

public void BeforeClass() throws Exception{
//基本資訊
BasicInfo("f");
//去賣場列表
GoToShowMain();
//連接DB
//Conn_SQL("A");
//隨機抽取一筆賣場資訊
//RandomSQLOne();
//搜尋賣場ID
//SearchSM_SEQ(sm_seq[1][1]);
}

@Before //將錯誤存起來
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}
@Test
//點擊改售價按鈕
public void ShowMainClick01ChangePrice() throws Exception {
System.out.println("點擊改售價按鈕;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]/a[1]")).click();
//等待3秒
Thread.sleep(3000);
try {
    assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
    System.out.println("關閉改售價視窗  正確;");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("關閉改售價視窗  錯誤;");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
  }
System.out.println("點擊關閉視窗X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}
@Test
//點擊改進貨價按鈕
public void ShowMainClick02ChangeCPrice() throws Exception {
System.out.println("點擊改進貨價按鈕;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]/a[2]")).click();
//等待3秒
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("關閉改進貨價視窗  正確;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("關閉改進貨價視窗  錯誤;");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("點擊關閉視窗X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@Test
//檢查毛利率%數是否正確
public void ShowMainClick03Margin() throws Exception {
    try {
        assertEquals(StrDotToPercent(sm_info[1][7],2), driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText());
        System.out.println("毛利率  正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("毛利率 錯誤;");
        System.out.println("DB為"+StrDotToPercent(sm_info[1][7],2)+"，WB顯示"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText()+";");
      }
  }@Test
//點擊文案修按鈕
public void ShowMainClick04Description() throws Exception {
System.out.println("點擊文案修按鈕;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]/a")).click();
//等待3秒
Thread.sleep(3000);
try {
assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("關閉文案修視窗  正確;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("關閉文案修視窗  錯誤;");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("點擊關閉視窗X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@Test
//點擊贈品按鈕
public void ShowMainClick05Freebies() throws Exception {
System.out.println("點擊贈品按鈕;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]/a")).click();
//等待3秒
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("關閉贈品視窗  正確;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("關閉贈品視窗  錯誤;");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("點擊關閉視窗X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}
@Test
//檢查分類是否正確
public void ShowMainClick06Category() throws Exception {
    try {
        assertEquals(sm_info[1][36], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[5]")).getText());
        System.out.println("分類  正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("分類  錯誤;");
        System.out.println("DB為"+sm_info[1][36]+"，WB顯示"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[5]")).getText()+";");
      }
  } @Test
//點擊加購品按鈕
public void ShowMainClick07AddAccessories() throws Exception {
System.out.println("點擊加購品按鈕;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[7]/a")).click();
//等待3秒
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("關閉加購品視窗  正確;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("關閉加購品視窗  錯誤;");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("點擊關閉視窗X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}
@Test
//點擊內含商品按鈕
public void ShowMainClick08ItemsIncluded() throws Exception {
System.out.println("點擊內含商品按鈕;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[8]/a")).click();
//等待3秒
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("關閉內含商品視窗  正確;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("關閉內含商品視窗  錯誤;");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("點擊關閉視窗X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@Test
//點擊活動欄位"詳"按鈕
public void ShowMainClick09Event() throws Exception {
System.out.println("點擊活動欄位詳按鈕;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[10]/a")).click();
//等待3秒
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("關閉活動欄位詳  正確;");
} catch (Error e) {
 verificationErrors.append(e.toString());
  System.out.println("關閉活動欄位詳  錯誤;");
  System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("點擊關閉視窗X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@After
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
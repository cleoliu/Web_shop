package CaseShowMain;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //照順序做testpublic class ShowMainDataTitle extends ShowMainHelp {
 
@BeforeClass
public static void BeforeClass() throws Exception {
  
/*   //設定區域
   Area();
   //設定國家
   Country();*/
   //設定瀏覽器
   GoToShowMain();
  
//等待5秒
 Thread.sleep(5000);
}@Before //將錯誤存起來
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}+++++++++
@Test
public void ShowMainDataTitle01Display() throws Exception {
//顯示
   try {
    assertEquals("顯示", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[2]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 顯示 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 顯示 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[2]")).getText());
  }
 }@Test
public void ShowMainDataTitle02WebsiteName() throws Exception {
//販售平台名稱
   try {
    assertEquals("販售平台名稱", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[3]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 販售平台名稱 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 販售平台名稱 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[3]")).getText());
  }
}@Test
public void ShowMainDataTitle03EmarketImage() throws Exception {
//賣場圖片
   try {
    assertEquals("賣場圖片", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[4]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 賣場圖片 文字比對正確-");++++++++=
} catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 賣場圖片 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[4]")).getText());
  }
}@Test
public void ShowMainDataTitle04EmarketName() throws Exception {
//賣場名稱
   try {
    assertEquals("賣場名稱", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[5]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 賣場名稱 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 賣場名稱 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[5]")).getText());
  }   
}@Test
public void ShowMainDataTitle05Color() throws Exception {
//顏色
   try {
    assertEquals("顏色", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[6]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 顏色 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 顏色 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[6]")).getText());
  } 
}++++++++++++
@Test
public void ShowMainDataTitle06Size() throws Exception {
//尺寸
   try {
    assertEquals("尺寸", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[7]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 尺寸 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 尺寸 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[7]")).getText());
  }
}@Test
public void ShowMainDataTitle07Price() throws Exception {
//售價/進貨價\n(含稅)
   try {
    assertEquals("售價/進貨價\n(含稅)", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[1]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 售價/進貨價\n(含稅) 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 售價/進貨價\n(含稅) 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[1]")).getText());
  }
}@Test
public void ShowMainDataTitle08Margin() throws Exception {
//毛利率
   try {
    assertEquals("毛利率", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[2]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 毛利率 文字比對正確-");++++++++++
} catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 毛利率 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[2]")).getText());
  }
}@Test
public void ShowMainDataTitle09Qty() throws Exception {
//主商品\n可賣量
   try {
    assertEquals("主商品\n可賣量", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[5]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 主商品\n可賣量 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 主商品\n可賣量 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[5]")).getText());
  }   
}@Test
public void ShowMainDataTitle10Description() throws Exception {
//文案
   try {
    assertEquals("文案", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[6]")).getText());
    System.out.println("-單一銷售網頁維護 資料Title 文案 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 資料Title 文案 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[6]")).getText());
  }  
  
}++++++++++=
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
package CaseShowMain;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //照順序做testpublic class ShowMainPage extends ShowMainHelp {
 
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
}

@Before //將錯誤存起來
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}


@Test
public void ShowMainPage01next() throws Exception {
//點擊下一頁按鈕
 System.out.println("點擊下一頁按鈕");
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/a[2]")).click();//等待5秒
 Thread.sleep(5000);
 
   try {
    assertEquals("2", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
    System.out.println("-單一銷售網頁維護 頁數 2 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 頁數 2 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
  }
}@Test
public void ShowMainPage02Previous() throws Exception {//點擊下一頁按鈕
 System.out.println("點擊上一頁按鈕");
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/a[1]")).click();//等待5秒
 Thread.sleep(5000);
 
   try {
    assertEquals("1", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
    System.out.println("-單一銷售網頁維護 頁數 1 文字比對正確-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-單一銷售網頁維護 頁數 1 文字比對錯誤-");
    System.out.println("WB顯示錯誤文字 "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
  }
}
@Test/*
public void ShowMainPage03Previous() throws Exception {
 //選擇頁面
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).click();
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).sendKeys(Keys.ARROW_DOWN);
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).sendKeys(Keys.ENTER);
}*/@After																		
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
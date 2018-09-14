package CaseShowMain;import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShowMainAppoint extends ShowMainHelp {
 @BeforeClass
 public static void BeforClass() throws Exception {
  //基本資訊
  BasicInfo("f");
  //設定瀏覽器
  GoToShowMain();
  //連接DB
  SQLMan.connect(Area);
  //下指令取得指定一筆資料
  SQLMan.showMain_Appoint(System.getenv("SM_SEQ"));
  //搜尋賣場ID
  SearchSM_SEQ(SQLMan.target_info[1][1]);    
 }
 
 @Before
   public void Before() throws Exception{
    verificationErrors= new StringBuffer();
   }++++++++++++=
@Test
  public void ShowMainRandom01SM_STATUS() throws Exception {
   switch(SQLMan.target_info[1][2]) {
   case "0":
    try {
        assertEquals("margin-left: -50px;", driver.findElement(By.xpath("//tbody[@id='left_tbody']//*[@class='switch-wrapper']")).getAttribute("style"));
        System.out.println("賣場顯示狀態OFF 正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("賣場顯示狀態 錯誤;");
        System.out.println("DB為OFF，WB顯示ON;");
      }break;
   case "1":
    try {
        assertEquals("margin-left: 0px;", driver.findElement(By.xpath("//tbody[@id='left_tbody']//*[@class='switch-wrapper']")).getAttribute("style"));
        System.out.println("賣場顯示狀態ON 正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("賣場顯示狀態 錯誤;");
        System.out.println("DB為ON，WB顯示OFF;");
      }break;
   }
  }
 
  @Test
  public void ShowMainRandom02WS_NAME() throws Exception {
    try {
        assertEquals(SQLMan.target_info[1][41], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[3]/div/p")).getText());
        System.out.println("平台名稱  正確;");
      } catch (Error e) {++++++++=
 verificationErrors.append(e.toString());
        System.out.println("平台名稱 錯誤;");
        System.out.println("DB為"+SQLMan.target_info[1][41]+"，WB顯示"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[3]/div/p")).getText()+";");
      }
  }  @Test
  public void ShowMainRandom03SM_PIC() throws Exception {
   switch(SQLMan.target_info[1][3]) {
   case "null":
   try {
        assertEquals("background-image: url(\"/c/img/vendor/blank.gif\");", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a/div[1]")).getAttribute("style"));
        System.out.println("賣場圖片  正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("賣場圖片  錯誤;");
        System.out.println("DB為"+"background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][3]+"\");"+"，WB顯示"+driver.findElement(By.xpath("/html/body...;
      }break;
   default :
    try {
        assertEquals("background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][3]+"\");", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a/div[1]")).getAttribute("style"));
        System.out.println("賣場圖片  正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("賣場圖片  錯誤;");
        System.out.println("DB為"+"background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][3]+"\");"+"，WB顯示"+driver.findElement(By.xpath("/html/body...;
      }break;
  }
  }
 
  @Test
public void ShowMainRandom04SM_NAME() throws Exception {
    try {
        assertEquals(SQLMan.target_info[1][4], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[5]/div/p/a")).getText());
        System.out.println("賣場名稱  正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("賣場名稱  錯誤;");
        System.out.println("DB為"+SQLMan.target_info[1][4]+"，WB顯示"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[5]/div/p/a")).getText()+";");
      }
  }
  @Test
  public void ShowMainRandom05COLOR() throws Exception {
   if("null".equals(SQLMan.target_info[1][27])){SQLMan.target_info[1][27]= "";}
   try {
        assertEquals(SQLMan.target_info[1][27], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[6]/div/p")).getText());
        System.out.println("顏色  正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("顏色  錯誤;");
        System.out.println("DB為"+SQLMan.target_info[1][27]+"，WB顯示"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[6]/div/p")).getText()+";");
      }
  }
  @Test
  public void ShowMainRandom06IT_SIZE() throws Exception {
   if("null".equals(SQLMan.target_info[1][28])){SQLMan.target_info[1][28]= "";}
   try {
        assertEquals(SQLMan.target_info[1][28], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[7]/div/p")).getText());
        System.out.println("尺寸  正確;");
      } catch (Error e) {
        verificationErrors.append(e.toString());++++===
System.out.println("尺寸  錯誤;");
        System.out.println("DB為"+SQLMan.target_info[1][28]+"，WB顯示"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[7]/div/p")).getText()+";");
      }
  }
@After
public void After(){
  verificationErrorString=verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
   fail(verificationErrorString);
  }
}@AfterClass
public  static void AfterClass(){
 System.out.println("腳本完成;");
 driver.quit();
}
}
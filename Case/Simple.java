package Case;import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import Help.Method;
/*import Help.SimpleHelp;*/@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Simple extends Method/*extends SimpleHelp*/{
 
 @BeforeClass
 public static void BeforClass(){
  //整份腳本只跑一次拿來當作初始化
 }
 
 @Before
 public void Before(){
  verificationErrors= new StringBuffer();
  //跑每個@Test之前會跑一次
 }
 
 @Test
 public void Simple01測試名稱(){
  /*
   * 整份腳本只跑一次
   * 主要拿來放入
   * try{
   * }catch (Error e) {
   * }
   */
 }
 @Test
 public void Simple02測試圖片(){
  /*
   * 整份腳本只跑一次
   * 主要拿來放入
   * try{
   * }catch (Error e) {
   * }
   */
 }
 @Ignore@Test
 public void Simple03略過的測試(){
  /*
   * 略過的測試
   */
 }
 
 @After
  public void After(){
   verificationErrorString=verificationErrors.toString();
   if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
   }
  }
 
 @AfterClass
 public  static void AfterClass(){
  System.out.println("腳本完成;");
  driver.quit();
  //整份腳本只跑一次拿來當作結尾
 }
 }
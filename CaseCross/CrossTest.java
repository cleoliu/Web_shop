package CaseCross;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import Help.CrossHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrossTest extends CrossHelp{
  @BeforeClass
  public static void BeforClass() throws Exception{
   //自動跑至商品列表
   GoToCross(3);
   //連接資料庫
   Conn_SQL("A");
   //下指令取得隨便一筆資料
   RandomSQLOne();
   //搜尋Itno
   //SearchItno(iteminfo[1][1]);
  }
  @Before
  public void Before() throws Exception {
   verificationErrors= new StringBuffer();
  }
  @Test
  public void CrossTest01() throws Exception {
  
  }
  @After
  public void After() throws Exception {
    verificationErrorString=verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  @AfterClass
  public  static void AfterClass(){
 System.out.println("腳本完成;");
    driver.quit();
  }
}
 
package CaseCross;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import Help.CrossHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrossTest extends CrossHelp{
  @BeforeClass
  public static void BeforClass() throws Exception{
   //�۰ʶ]�ܰӫ~�C��
   GoToCross(3);
   //�s����Ʈw
   Conn_SQL("A");
   //�U���O���o�H�K�@�����
   RandomSQLOne();
   //�j�MItno
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
 System.out.println("�}������;");
    driver.quit();
  }
}
 
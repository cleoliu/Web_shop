package CaseCross;import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import Help.CrossHelp;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrossRandom extends CrossHelp{
 
 @BeforeClass
 public static void BeforClass() throws Exception{
  //�۰ʶ]�ܰӫ~�C��
  GoToCross("3");
  //�s����Ʈw
  Conn_SQL("A");
  //�U���O���o�H�K�@�����
  RandomSQLOne();
  //�j�MItno
  //SearchItno(iteminfo[1][1]);
 }
 
 @Before
 public void Before(){
  verificationErrors= new StringBuffer();
  //�]�C��@Test���e�|�]�@��
 }
 
 @Test
 public void Simple01���զW��(){
  /*
   * ����}���u�]�@��
   * �D�n���ө�J
   * try{
   * }catch (Error e) {
   * }
   */
 }
 @Test
 public void Simple02���չϤ�(){
  /*
   * ����}���u�]�@��
   * �D�n���ө�J
   * try{
   * }catch (Error e) {
   * }
   */
 }
 @Ignore@Test
 public void Simple03���L������(){
  /*
   * ���L������
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
  System.out.println("�}������;");
  driver.quit();
  //����}���u�]�@�����ӷ�@����
 }
}
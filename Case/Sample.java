package Case;import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import Help.Uitox;
/*import Help.SimpleHelp;*/@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sample extends Uitox/*extends SimpleHelp*/{
 
 @BeforeClass
 public static void BeforClass(){
  //����}���u�]�@�����ӷ�@��l��
  //�L�X�򥻸�T BasicInfo("f")���firefox
  BasicInfo("f");
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
  //�]�C��@Test����|�]�@��
  }
 
 @AfterClass
 public  static void AfterClass(){
  System.out.println("�}������;");
  driver.quit();
  //����}���u�]�@�����ӷ�@����
 }
}
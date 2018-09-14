package showspecial;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.PostMan;
import Help.ShowSpecialHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //�Ӷ��ǰ�test
public class ShowSpecial extends ShowSpecialHelp {
 
@BeforeClass
public static void BeforeClass() throws Exception {
 //�s����
 BasicInfo("f");
 //�i�S���ܻ��C��
 GoToShowSpecial();
 //�s����Ʈw
 SQLMan.connect("A");
}@Before //�N���~�s�_��
public void Befor() throws Exception{
verificationErrors= new StringBuffer();
}   ++
@Test
//���x�޲z�t�� (zh-tw)
public void showspecial01PlatformManagementSystem() throws Exception {
  try {
     assertEquals("���x�޲z�t�� (zh-tw)", driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/a")).getText());
     System.out.println("-���x�޲z�t�� (zh-tw) ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("���x�޲z�t�� (zh-tw) ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/a")).getText());
   }
}@Test
//Taiwan (�c�餤��)
public void showspecial02Taiwan() throws Exception {
  try {
     assertEquals("Taiwan (�c�餤��)", driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).getText());
     System.out.println("-Taiwan (�c�餤��) ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("Taiwan (�c�餤��) ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).getText());
   }
}++++++++++
@Test
//���x�]�w
public void PlatformSetup03() throws Exception {
  try {
     assertEquals("���x�]�w", driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/a")).getText());
     System.out.println("-���x�]�w ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("���x�]�w ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/a")).getText());
   }
}@Test
//uitox_test
public void user04() throws Exception {
  try {
     assertEquals("uitox_test", driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/a")).getText());
     System.out.println("-uitox_test ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("uitox_test ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/a")).getText());
   }
}
++++++++++++
@Test
//����
public void home05() throws Exception {
  try {
     assertEquals("����", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[1]/a")).getText());
     System.out.println("-���� ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("���� ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[1]/a")).getText());
   }
}@Test
//��P���ʺ޲z
public void EventManagement06() throws Exception {
  try {
     assertEquals("��P���ʺ޲z", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[2]/a")).getText());
     System.out.println("-��P���ʺ޲z ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("��P���ʺ޲z ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[2]/a")).getText());
   }
}
+++++++++++
@Test
//�S���ܻ�
public void SpecialPromoSetting07() throws Exception {
  try {
     assertEquals("�S���ܻ�", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[3]")).getText());
     System.out.println("-�S���ܻ� ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("�S���ܻ� ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul/li[3]")).getText());
   }
}@Test
//title="���ID/����W��"
public void EmarkeIDProductName08() throws Exception {
  try {
     assertEquals("���ID/����W��", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/input[1]")).getAttribute("placeholder"));
     System.out.println("-���ID/����W�� ��r��勵�T-");
   } catch (Error e) {
     verificationErrors.append(e.toString());
     System.out.println("���ID/����W�� ��r�����~-");
     System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/input[1]")).getAttribute("placeholder"));
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
 System.out.println("�}������;");
  driver.quit();//�����s����
}
}
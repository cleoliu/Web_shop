package CaseShowMain;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //�Ӷ��ǰ�testpublic class ShowMainDataTitle extends ShowMainHelp {
 
@BeforeClass
public static void BeforeClass() throws Exception {
  
/*   //�]�w�ϰ�
   Area();
   //�]�w��a
   Country();*/
   //�]�w�s����
   GoToShowMain();
  
//����5��
 Thread.sleep(5000);
}@Before //�N���~�s�_��
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}+++++++++
@Test
public void ShowMainDataTitle01Display() throws Exception {
//���
   try {
    assertEquals("���", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[2]")).getText());
    System.out.println("-��@�P��������@ ���Title ��� ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title ��� ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[2]")).getText());
  }
 }@Test
public void ShowMainDataTitle02WebsiteName() throws Exception {
//�c�⥭�x�W��
   try {
    assertEquals("�c�⥭�x�W��", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[3]")).getText());
    System.out.println("-��@�P��������@ ���Title �c�⥭�x�W�� ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title �c�⥭�x�W�� ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[3]")).getText());
  }
}@Test
public void ShowMainDataTitle03EmarketImage() throws Exception {
//����Ϥ�
   try {
    assertEquals("����Ϥ�", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[4]")).getText());
    System.out.println("-��@�P��������@ ���Title ����Ϥ� ��r��勵�T-");++++++++=
} catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title ����Ϥ� ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[4]")).getText());
  }
}@Test
public void ShowMainDataTitle04EmarketName() throws Exception {
//����W��
   try {
    assertEquals("����W��", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[5]")).getText());
    System.out.println("-��@�P��������@ ���Title ����W�� ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title ����W�� ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[5]")).getText());
  }   
}@Test
public void ShowMainDataTitle05Color() throws Exception {
//�C��
   try {
    assertEquals("�C��", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[6]")).getText());
    System.out.println("-��@�P��������@ ���Title �C�� ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title �C�� ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[6]")).getText());
  } 
}++++++++++++
@Test
public void ShowMainDataTitle06Size() throws Exception {
//�ؤo
   try {
    assertEquals("�ؤo", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[7]")).getText());
    System.out.println("-��@�P��������@ ���Title �ؤo ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title �ؤo ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/thead/tr/th[7]")).getText());
  }
}@Test
public void ShowMainDataTitle07Price() throws Exception {
//���/�i�f��\n(�t�|)
   try {
    assertEquals("���/�i�f��\n(�t�|)", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[1]")).getText());
    System.out.println("-��@�P��������@ ���Title ���/�i�f��\n(�t�|) ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title ���/�i�f��\n(�t�|) ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[1]")).getText());
  }
}@Test
public void ShowMainDataTitle08Margin() throws Exception {
//��Q�v
   try {
    assertEquals("��Q�v", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[2]")).getText());
    System.out.println("-��@�P��������@ ���Title ��Q�v ��r��勵�T-");++++++++++
} catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title ��Q�v ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[2]")).getText());
  }
}@Test
public void ShowMainDataTitle09Qty() throws Exception {
//�D�ӫ~\n�i��q
   try {
    assertEquals("�D�ӫ~\n�i��q", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[5]")).getText());
    System.out.println("-��@�P��������@ ���Title �D�ӫ~\n�i��q ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title �D�ӫ~\n�i��q ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[5]")).getText());
  }   
}@Test
public void ShowMainDataTitle10Description() throws Exception {
//���
   try {
    assertEquals("���", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[6]")).getText());
    System.out.println("-��@�P��������@ ���Title ��� ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���Title ��� ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[6]")).getText());
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
 System.out.println("�}������;");
  driver.quit();//�����s����
}
}
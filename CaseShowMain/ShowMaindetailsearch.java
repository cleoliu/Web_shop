package CaseShowMain;
import org.junit.*;
import org.junit.runners.MethodSorters;import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //�Ӷ��ǰ�testpublic class ShowMaindetailsearch extends ShowMainHelp {@BeforeClass
public static void BeforeClass() throws Exception {
/*   //�]�w�ϰ�
   Area();
   //�]�w��a
   Country();*/
   //�]�w�s����
   GoToShowMain();
   //�s��DB
   Conn_SQL("A");  
//����5��
 Thread.sleep(5000);//�I���i���d�߫��s
 System.out.println("�I���i���d�߫��s");
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/button[2]")).click();
}
++++++=
@Before //�N���~�s�_��
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}@Test
public void ShowMaindetailsearch01Category() throws Exception {
//����
   try {
    assertEquals("����", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[1]")).getText());
    System.out.println("-��@�P��������@ �i���d�� ���� ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("��@�P��������@ �i���d�� ���� ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[1]")).getText());
  }
 //��ܲĤ@�h����(����)
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).click();
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).sendKeys(Keys.ARROW_DOWN);
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span/select")).sendKeys(Keys.ENTER);
 //��ܲĤ@�h����(�ӫ~�p�p)
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span[2]/select")).click();
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span[2]/select")).sendKeys(Keys.ARROW_DOWN);
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]/span[2]/select")).sendKeys(Keys.ENTER);
 //�I���d�߫��s
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();++++++++++++=
//����3��
  Thread.sleep(3000);
 
   try {
      assertEquals("�ӫ~�p�p", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]")).getText());
      System.out.println("-��@�P��������@ �����d�ߥ\�� ���T-");
    } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("��@�P��������@ �����d�ߥ\�� ���~-");
      System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]")).getText());
    }
}
 @Test
public void ShowMaindetailsearch02Vendor() throws Exception {
//�S�w�t��
   try {
  assertEquals("�S�w�t��", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[2]")).getText());
  System.out.println("-��@�P��������@ �i���d�� �S�w�t�� ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� �S�w�t�� ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[2]")).getText());
 }
}@Test
public void ShowMaindetailsearch03EmarketType() throws Exception {
//�������++++++++===
try {
  assertEquals("�������", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[3]")).getText());
  System.out.println("-��@�P��������@ �i���d�� ������� ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� ������� ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[3]")).getText());
} 
}@Test
public void ShowMaindetailsearch04AddTime() throws Exception {
//����s�W��
   try {
  assertEquals("����s�W��", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[4]")).getText());
  System.out.println("-��@�P��������@ �i���d�� ����s�W�� ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� ����s�W�� ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[4]")).getText());
}  
}@Test
public void ShowMaindetailsearch05Oversea() throws Exception {
//���~��
   try {
  assertEquals("���~��", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[6]")).getText());
  System.out.println("-��@�P��������@ �i���d�� ���~�� ��r��勵�T-");
} catch (Error e) {+++++++++++++
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� ���~�� ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[6]")).getText());
}  
}@Test
public void ShowMaindetailsearch06EmarketStatus() throws Exception {
//������A
   try {
  assertEquals("������A", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[7]")).getText());
  System.out.println("-��@�P��������@ �i���d�� ������A ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� ������A ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[7]")).getText());
}   
}@Test
public void ShowMaindetailsearch07Qty() throws Exception {
//�ӫ~/�զX �i��q
   try {
  assertEquals("�ӫ~/�զX �i��q", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[8]")).getText());
  System.out.println("-��@�P��������@ �i���d�� �ӫ~/�զX �i��q ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� �ӫ~/�զX �i��q ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[8]")).getText());
}   
}++++++++===
@Test
public void ShowMaindetailsearch08ShowOthers() throws Exception {
//�ݨ�L�H
   try {
  assertEquals("�ݨ�L�H", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[10]")).getText());
  System.out.println("-��@�P��������@ �i���d�� �ݨ�L�H ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� �ݨ�L�H ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[10]")).getText());
}  
}@Test
public void ShowMaindetailsearch09NoEmarketImage() throws Exception {
//�S���D����Ϫ����
   try {
  assertEquals("�S���D����Ϫ����", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[11]")).getText());
  System.out.println("-��@�P��������@ �i���d�� �S���D����Ϫ���� ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� �S���D����Ϫ���� ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[11]")).getText());
} 
}@Test
public void ShowMaindetailsearch10allEMarket() throws Exception {
//�ݩҦ����
   try {+++++++++++=
assertEquals("�ݩҦ����", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[12]")).getText());
  System.out.println("-��@�P��������@ �i���d�� �ݩҦ���� ��r��勵�T-");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("��@�P��������@ �i���d�� �ݩҦ���� ��r�����~-");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[12]")).getText());
} 
}@After
public void tearDown() {
  verificationErrorString=verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
  }
}@AfterClass
public  static void AfterClass(){
 System.out.println("�}������;");
  /*driver.quit();//�����s����   */
}
}
package CaseShowMain;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) //�Ӷ��ǰ�testpublic class ShowMainPage extends ShowMainHelp {
 
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
}

@Before //�N���~�s�_��
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}


@Test
public void ShowMainPage01next() throws Exception {
//�I���U�@�����s
 System.out.println("�I���U�@�����s");
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/a[2]")).click();//����5��
 Thread.sleep(5000);
 
   try {
    assertEquals("2", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
    System.out.println("-��@�P��������@ ���� 2 ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���� 2 ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
  }
}@Test
public void ShowMainPage02Previous() throws Exception {//�I���U�@�����s
 System.out.println("�I���W�@�����s");
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/a[1]")).click();//����5��
 Thread.sleep(5000);
 
   try {
    assertEquals("1", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
    System.out.println("-��@�P��������@ ���� 1 ��r��勵�T-");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("-��@�P��������@ ���� 1 ��r�����~-");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[1]")).getText());
  }
}
@Test/*
public void ShowMainPage03Previous() throws Exception {
 //��ܭ���
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
 System.out.println("�}������;");
  driver.quit();//�����s����
}
}
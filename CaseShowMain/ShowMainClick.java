package CaseShowMain;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.openqa.selenium.*;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING) 

 


@BeforeClass

public void BeforeClass() throws Exception{
//�򥻸�T
BasicInfo("f");
//�h����C��
GoToShowMain();
//�s��DB
//Conn_SQL("A");
//�H������@�������T
//RandomSQLOne();
//�j�M���ID
//SearchSM_SEQ(sm_seq[1][1]);
}

@Before //�N���~�s�_��
public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
}
@Test
//�I���������s
public void ShowMainClick01ChangePrice() throws Exception {
System.out.println("�I���������s;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]/a[1]")).click();
//����3��
Thread.sleep(3000);
try {
    assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
    System.out.println("������������  ���T;");
  } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("������������  ���~;");
    System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
  }
System.out.println("�I����������X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}
@Test
//�I����i�f�����s
public void ShowMainClick02ChangeCPrice() throws Exception {
System.out.println("�I����i�f�����s;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]/a[2]")).click();
//����3��
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("������i�f������  ���T;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("������i�f������  ���~;");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("�I����������X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@Test
//�ˬd��Q�v%�ƬO�_���T
public void ShowMainClick03Margin() throws Exception {
    try {
        assertEquals(StrDotToPercent(sm_info[1][7],2), driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText());
        System.out.println("��Q�v  ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("��Q�v ���~;");
        System.out.println("DB��"+StrDotToPercent(sm_info[1][7],2)+"�AWB���"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText()+";");
      }
  }@Test
//�I����׭׫��s
public void ShowMainClick04Description() throws Exception {
System.out.println("�I����׭׫��s;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]/a")).click();
//����3��
Thread.sleep(3000);
try {
assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("������׭׵���  ���T;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("������׭׵���  ���~;");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("�I����������X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@Test
//�I���ث~���s
public void ShowMainClick05Freebies() throws Exception {
System.out.println("�I���ث~���s;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]/a")).click();
//����3��
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("�����ث~����  ���T;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("�����ث~����  ���~;");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("�I����������X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}
@Test
//�ˬd�����O�_���T
public void ShowMainClick06Category() throws Exception {
    try {
        assertEquals(sm_info[1][36], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[5]")).getText());
        System.out.println("����  ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("����  ���~;");
        System.out.println("DB��"+sm_info[1][36]+"�AWB���"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[5]")).getText()+";");
      }
  } @Test
//�I���[�ʫ~���s
public void ShowMainClick07AddAccessories() throws Exception {
System.out.println("�I���[�ʫ~���s;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[7]/a")).click();
//����3��
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("�����[�ʫ~����  ���T;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("�����[�ʫ~����  ���~;");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("�I����������X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}
@Test
//�I�����t�ӫ~���s
public void ShowMainClick08ItemsIncluded() throws Exception {
System.out.println("�I�����t�ӫ~���s;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[8]/a")).click();
//����3��
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("�������t�ӫ~����  ���T;");
} catch (Error e) {
  verificationErrors.append(e.toString());
  System.out.println("�������t�ӫ~����  ���~;");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("�I����������X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@Test
//�I���������"��"���s
public void ShowMainClick09Event() throws Exception {
System.out.println("�I���������ԫ��s;");
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[10]/a")).click();
//����3��
Thread.sleep(3000);
try {
  assertEquals("Close", driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title"));
  System.out.println("������������  ���T;");
} catch (Error e) {
 verificationErrors.append(e.toString());
  System.out.println("������������  ���~;");
  System.out.println("WB��ܿ��~��r "+driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).getAttribute("title")+";");
}
System.out.println("�I����������X;");
driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
}@After
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
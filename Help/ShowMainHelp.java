package Help;
import static org.junit.Assert.fail;
import org.openqa.selenium.*;

public class ShowMainHelp extends Uitox {
  //�h����C��
 public static void GoToShowMain() throws Exception{
     //�s�����]�w   firefox or chrome
  SetBrowser(browserType);
  //�}�ҥ��x�޲z�t��
    System.out.println("�}�ҥ��x�޲z�t��;");
  driver.get(WebSiteUrl());
    //�s�����̤j��
    System.out.println("�s�����̤j��;");
    driver.manage().window().maximize();
    //���ҽX��J
    System.out.println("���ҽX��J;");
     driver.findElement(By.id("captcha")).clear();
     driver.findElement(By.id("captcha")).sendKeys("test");
    //�I���n�J���s
    System.out.println("�I���n�J���s;");
     driver.findElement(By.xpath("/html/body/form/dl/dd[6]/button")).click();
    //����5��
    Thread.sleep(5000);
    //�i�J����C��
    System.out.println("�i�J����C��;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/dl[1]/dd[4]/a")).click();
  }
 public static void SearchSM_SEQ(String _sm_seq) throws Exception{
  //���ݭ���loading
  loadmask();
  //��J���ID
  System.out.println("��J���ID'"+_sm_seq+"';");
  driver.findElement(By.xpath("//*[@class='search-input']")).sendKeys(_sm_seq);
  //�I���j�M���s
  System.out.println("�I���j�M���s;");
  driver.findElement(By.xpath("//*[@class='btn-info']")).click();
  //���ݭ���loading
  loadmask();
  String noitem =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td")).getText();
  //�ˬd�O�_�줣��ӫ~
  if("�ثe�S���������ӫ~".equals(noitem)){
    fail("�ثe�S���������ӫ~");
  }
 }
}
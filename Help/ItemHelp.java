package Help;
import org.testng.Assert;
import org.openqa.selenium.By;
import Help.Uitox;

public class ItemHelp extends Uitox {
 //�h�ӫ~�C��
 public static void GoToItem() throws Exception{
  //�]�w�s����
  SetBrowser(browserType);
     //�}�ҥ��x�޲z�t��
    System.out.println("�}�ҥ��x�޲z�t��;");
    driver.get(WebSiteUrl());
    //�s�����̤j��
    System.out.println("�s�����̤j��;");
    driver.manage().window().maximize();
    //�祿�X��J
    System.out.println("�祿�X��J;");
    driver.findElement(By.id("captcha")).sendKeys("test");
    //���@�U
    Thread.sleep(2000);
    //�I���n�J���s
    System.out.println("�I���n�J���s;");
    driver.findElement(By.cssSelector("button.btn-submit")).click();
    //����5��
    Thread.sleep(5000);
    //�i�J�ӫ~�C��
    System.out.println("�i�J�ӫ~�C��;");
    driver.findElement(By.linkText("�ӫ~�C��")).click();
 }
 //�d�߰ӫ~ID Itno
 protected static void SearchItno(String Temp_Itno) throws Exception{
 //��JItno
 driver.findElement(By.cssSelector(".search-input")).clear();
 System.out.println("��Jitno'"+Temp_Itno+"';");
 driver.findElement(By.cssSelector(".search-input")).sendKeys(Temp_Itno);
 //�I���j�M���s
 System.out.println("�I���j�M���s;");
 driver.findElement(By.id("search")).click();
 //Thread.sleep(10000);
 loadmask();
 String noitem =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td")).getText();
   //�ˬd�O�_�줣��ӫ~
   if( "�ثe�S���������ӫ~".equals(noitem)){
    Assert.fail("�ثe�S���������ӫ~");
    }
 }
 //���Web�W��Itno
 protected static String webItno;
 protected  static void CatchItno(){ 
 }
 
}
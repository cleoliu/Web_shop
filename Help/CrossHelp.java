package Help;
import org.openqa.selenium.By;


public class CrossHelp extends Uitox{
 //�h�ӫ~�C��
 public static String uosite;
 public static void GoToCross(String x) throws Exception{
  //�]�w�s����
  SetBrowser("firefox");
     //�}�ҥ��x�޲z�t��
    System.out.println("�}�ҥ��x�޲z�t��;");
    driver.get(WebSiteUrl());
    //�s�����̤j��
    System.out.println("�s�����̤j��;");
    driver.manage().window().maximize();
    //�祿�X��J
    System.out.println("�祿�X��J;");
    driver.findElement(By.id("captcha")).sendKeys("test");
    //�I���n�J���s
    System.out.println("�I���n�J���s;");
    driver.findElement(By.cssSelector("button.btn-submit")).click();
    //����5��
    Thread.sleep(5000);
    //�u�ʱ��b�ܬݨ�[�~����ӫ~�C��]�s��
    WebDriverMan.WindowScrollBottom(driver,By.xpath("(//a[contains(text(),'�~����ӫ~�C��')])[2]"));
    //�i�J�~����ӫ~�C��
    System.out.println("�i�J�~����ӫ~�C��;");
    driver.findElement(By.xpath("(//a[contains(text(),'�~����ӫ~�C��')])[2]")).click();
    uosite=x;
    switch(x){
     case "1":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[1]")).click();
      break;
     case "2":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[2]")).click();
      break;
     case "3":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[3]")).click();
      break;
     case "4":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[4]")).click();
      break;
     case "5":
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/dl/dd[5]")).click();
      break;
  }
   //�s��DB
    //Conn_SQL("A");
    //����5��
    Thread.sleep(5000);
 }
}
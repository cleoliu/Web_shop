package Help;import org.openqa.selenium.*;
import Help.WebDriverMan;public class ShowSpecialHelp extends Uitox{ //�h�S���ܻ��C��
 public static void GoToShowSpecial() throws Exception{
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
    //�u�ʺu�b�ܤ��� �����s�����U�t
    WebDriverMan.WindowScrollBottom(driver,By.xpath("/html/body/div[1]/div[2]/div[2]/dl[3]/dd[1]/a"));
    //�i�J�S���ܻ��C��
    System.out.println("�i�J�S���ܻ��C��;");
    driver.findElement(By.linkText("�S���ܻ�")).click();
 }
  
 }
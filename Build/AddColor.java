package Build;import java.awt.event.KeyEvent;
import org.openqa.selenium.*;
import org.junit.*;
import Help.AddHelp;public class AddColor extends AddHelp{
 @Before
 public void setUp() throws Exception {
  //�h�s�W����
  GoToAdd();
    Thread.sleep(2000);
    //�I���s�W�ӫ~
    System.out.println("�I���s�W�ӫ~;");
    driver.findElement(By.cssSelector(".btn-action")).click();
    Thread.sleep(1000);
    //�]�w�ӫ~�W��
    SetItemNameType(1,1);
    //�I���U�@�B
    System.out.println("�I���U�@�B;");
    driver.findElement(By.id("next_item_info")).click();
    Thread.sleep(2000);
    //�]�w�s�դ���
    SetCategory("1");
    //2016/03/11�g��o�̤���u�n�[�J�W�Ǧh�Ϥ��NOK�F
    //��w�ѳf�t�Ӫ����
    SetSup();
    //�I���W�ǹϤ�
    SetPhoto();
    //keyin����
    SetPrice();
    //���ʩ��U��̤U��
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[1]/div[2]/div[3]/span")).click();
    keyPress(robot,KeyEvent.VK_PAGE_DOWN);
    //��J�ӫ~����
    SetItemContent();
    //�]�w�O�T
    //�]�w�����p����T
    SetWarranty();
    //�U�@�B
    System.out.println("�I���U�@�B;");
  keyPress(robot,KeyEvent.VK_PAGE_DOWN);
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[3]/button[2]")).click();
  Thread.sleep(5000);
    //�]�w���e��
  SetLWHL("1","2","3","4");
    //�]�w�ݩʤ��ݭn
  keyPress(robot,KeyEvent.VK_PAGE_DOWN);
  Attribute();
  //�I���T�{
  keyPress(robot,KeyEvent.VK_PAGE_DOWN);
  driver.findElement(By.id("add_show_btn")).click();
  driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/a")).click();
  Thread.sleep(10000);
  System.out.print("�s�W��~�ӫ~����;");
 } @Test
 public void testAdd() throws Exception {
  
 } @After
   public void tearDown() throws Exception {
     driver.quit();
    
   }
 }
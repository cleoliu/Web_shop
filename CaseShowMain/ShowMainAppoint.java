package CaseShowMain;import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import Help.ShowMainHelp;@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShowMainAppoint extends ShowMainHelp {
 @BeforeClass
 public static void BeforClass() throws Exception {
  //�򥻸�T
  BasicInfo("f");
  //�]�w�s����
  GoToShowMain();
  //�s��DB
  SQLMan.connect(Area);
  //�U���O���o���w�@�����
  SQLMan.showMain_Appoint(System.getenv("SM_SEQ"));
  //�j�M���ID
  SearchSM_SEQ(SQLMan.target_info[1][1]);    
 }
 
 @Before
   public void Before() throws Exception{
    verificationErrors= new StringBuffer();
   }++++++++++++=
@Test
  public void ShowMainRandom01SM_STATUS() throws Exception {
   switch(SQLMan.target_info[1][2]) {
   case "0":
    try {
        assertEquals("margin-left: -50px;", driver.findElement(By.xpath("//tbody[@id='left_tbody']//*[@class='switch-wrapper']")).getAttribute("style"));
        System.out.println("�����ܪ��AOFF ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("�����ܪ��A ���~;");
        System.out.println("DB��OFF�AWB���ON;");
      }break;
   case "1":
    try {
        assertEquals("margin-left: 0px;", driver.findElement(By.xpath("//tbody[@id='left_tbody']//*[@class='switch-wrapper']")).getAttribute("style"));
        System.out.println("�����ܪ��AON ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("�����ܪ��A ���~;");
        System.out.println("DB��ON�AWB���OFF;");
      }break;
   }
  }
 
  @Test
  public void ShowMainRandom02WS_NAME() throws Exception {
    try {
        assertEquals(SQLMan.target_info[1][41], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[3]/div/p")).getText());
        System.out.println("���x�W��  ���T;");
      } catch (Error e) {++++++++=
 verificationErrors.append(e.toString());
        System.out.println("���x�W�� ���~;");
        System.out.println("DB��"+SQLMan.target_info[1][41]+"�AWB���"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[3]/div/p")).getText()+";");
      }
  }  @Test
  public void ShowMainRandom03SM_PIC() throws Exception {
   switch(SQLMan.target_info[1][3]) {
   case "null":
   try {
        assertEquals("background-image: url(\"/c/img/vendor/blank.gif\");", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a/div[1]")).getAttribute("style"));
        System.out.println("����Ϥ�  ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("����Ϥ�  ���~;");
        System.out.println("DB��"+"background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][3]+"\");"+"�AWB���"+driver.findElement(By.xpath("/html/body...;
      }break;
   default :
    try {
        assertEquals("background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][3]+"\");", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a/div[1]")).getAttribute("style"));
        System.out.println("����Ϥ�  ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("����Ϥ�  ���~;");
        System.out.println("DB��"+"background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][3]+"\");"+"�AWB���"+driver.findElement(By.xpath("/html/body...;
      }break;
  }
  }
 
  @Test
public void ShowMainRandom04SM_NAME() throws Exception {
    try {
        assertEquals(SQLMan.target_info[1][4], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[5]/div/p/a")).getText());
        System.out.println("����W��  ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("����W��  ���~;");
        System.out.println("DB��"+SQLMan.target_info[1][4]+"�AWB���"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[5]/div/p/a")).getText()+";");
      }
  }
  @Test
  public void ShowMainRandom05COLOR() throws Exception {
   if("null".equals(SQLMan.target_info[1][27])){SQLMan.target_info[1][27]= "";}
   try {
        assertEquals(SQLMan.target_info[1][27], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[6]/div/p")).getText());
        System.out.println("�C��  ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("�C��  ���~;");
        System.out.println("DB��"+SQLMan.target_info[1][27]+"�AWB���"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[6]/div/p")).getText()+";");
      }
  }
  @Test
  public void ShowMainRandom06IT_SIZE() throws Exception {
   if("null".equals(SQLMan.target_info[1][28])){SQLMan.target_info[1][28]= "";}
   try {
        assertEquals(SQLMan.target_info[1][28], driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[7]/div/p")).getText());
        System.out.println("�ؤo  ���T;");
      } catch (Error e) {
        verificationErrors.append(e.toString());++++===
System.out.println("�ؤo  ���~;");
        System.out.println("DB��"+SQLMan.target_info[1][28]+"�AWB���"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[7]/div/p")).getText()+";");
      }
  }
@After
public void After(){
  verificationErrorString=verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
   fail(verificationErrorString);
  }
}@AfterClass
public  static void AfterClass(){
 System.out.println("�}������;");
 driver.quit();
}
}
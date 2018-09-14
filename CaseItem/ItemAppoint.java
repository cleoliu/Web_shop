package CaseItem;import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.*;
import Help.ItemHelp;
import Help.BasicMan;@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemAppoint extends ItemHelp{
  @BeforeClass
  public static void BeforClass() throws Exception{
   //�򥻸�T
   BasicInfo("f");
   //�۰ʶ]�ܰӫ~�C��
   GoToItem();
   //�s����Ʈw
   SQLMan.connect(Area);
  //�U���O���o���w�@�����
   SQLMan.item_Appoint(System.getenv("ITNO"));
   //�j�MItno
   SearchItno(SQLMan.target_info[1][1]);     
  }
@Before
  public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
  }
  @Test
  public void Item01Photo(){
   //�祿�Ϥ����|�O�_���T
   String webphotolink=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/a/div[1]")).getAttribute("style");
   String dbphotolink ="background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][2]+"\");";
   try {
    assertEquals(dbphotolink, webphotolink);
    System.out.println("���T-�Ϥ���T���;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�Ϥ���T���;");
    System.out.println("WB�Ϥ���T'"+webphotolink+"';");
    System.out.println("DB�Ϥ���T'"+dbphotolink+"';");
   }
  }   
  @Test
  public void Item02Name(){
 //�祿�ӫ~�W�٬O�_���T
 String webitemname=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[3]/div/p")).getText();
   String dbitemname=SQLMan.target_info[1][3];
   webitemname=webitemname.replaceAll(" ","");
   dbitemname=dbitemname.replaceAll(" ","");
   try {
    assertEquals(dbitemname,webitemname);
    System.out.println("���T-�ӫ~�W�٤��;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�ӫ~�W�٤��;");
    System.out.println("WB�ӫ~�W�ٸ�T'"+webitemname+"';");
    System.out.println("DB�ӫ~�W�ٸ�T'"+dbitemname+"';");
   }
  }
  @Test
  public void Item03Color(){
 //�祿�C��O�_���T
 String webcolor=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/div/p")).getText();
   String dbcolor=SQLMan.target_info[1][4];
   if(dbcolor == "null"){dbcolor="";}
   try {
    assertEquals(dbcolor,webcolor);
    System.out.println("���T-�C���T���;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�C���T���;");
    System.out.println("WB�C���T'"+webcolor+"';");
    System.out.println("DB�C���T'"+dbcolor+"';");
   }
  }
@Test
  public void Item04Size(){
 //�祿�ؤo�O�_���T
 String websize=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[5]/div/p")).getText();
   String dbsize=SQLMan.target_info[1][5];
   if(dbsize == "null"){dbsize="";}
   try {
    assertEquals(dbsize,websize);
    System.out.println("���T-�ؤo��T���;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�ؤo��T���;");
    System.out.println("WB�ؤo��T'"+websize+"';");
    System.out.println("DB�ؤo��T'"+dbsize+"';");
   }
  }
  @Test
  public void Item05InsuranceValue(){
 //�祿�O�I���ȬO�_���T
 String webivalue=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]")).getText();
   String dbivalue=SQLMan.target_info[1][6];
   webivalue =webivalue.substring(0,dbivalue.length());
   try {
    assertEquals(dbivalue,webivalue);
    System.out.println("���T-�O�I���Ȥ��;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�O�I���Ȥ��;");
    System.out.println("WB�O�I���ȸ�T'"+webivalue+"';");
    System.out.println("DB�O�I���ȸ�T'"+dbivalue+"';");
   }
  }
  @Test
  public void Item06Tax(){
 //�祿�i���|�v�O�_���T
   String webtax=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]")).getText();
   String dbtax=BasicMan.StrDotToPercent(SQLMan.target_info[1][7],2)+BasicMan.StrDotToPercent(SQLMan.target_info[1][8],2);
   webtax =  (webtax.replaceAll("\n","")).substring(0,dbtax.length());;
   try {
    assertEquals(dbtax,webtax);
    System.out.println("���T-�i�P���|���;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�i�P���|���;");
    System.out.println("WB�i�P���|��T'"+webtax+"';");
    System.out.println("DB�i�P���|��T'"+dbtax+"';");
   }
  }
  @Test
  public void Item07Qty(){
 //�祿�i��q�O�_���T
   String webqty=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/a[1]")).getText();
   String dbqty=SQLMan.target_info[1][9];
   webqty=webqty.substring(0,dbqty.length());
   try {
    assertEquals(dbqty,webqty);
    System.out.println("���T-�i��q���;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�i��q���;");
    System.out.println("WB�i��q��T'"+webqty+"';");
    System.out.println("DB�i��q��T'"+dbqty+"';");
   }
  }
@Test
  public void Item07Qty(){
 //�祿�i��q�O�_���T
   String webqty=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/a[1]")).getText();
   String dbqty=SQLMan.target_info[1][9];
   webqty=webqty.substring(0,dbqty.length());
   try {
    assertEquals(dbqty,webqty);
    System.out.println("���T-�i��q���;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�i��q���;");
    System.out.println("WB�i��q��T'"+webqty+"';");
    System.out.println("DB�i��q��T'"+dbqty+"';");
   }
  }
  @Test
  public void Item08Pre(){
 //�祿�w�ʬO�_���T
 int dy=0;int dM=0;int dd=0;int dH=0;int dm=0;int ny=0;int nM=0;int nd=0;int nH=0;int nm=0;
 if(SQLMan.target_info[1][21]==null){
  String t =  SQLMan.target_info[1][21];
    int s1=SQLMan.target_info[1][21].indexOf("/");
    int s2=SQLMan.target_info[1][21].lastIndexOf("/");
    int s3=SQLMan.target_info[1][21].indexOf(" ");
    int s4=SQLMan.target_info[1][21].indexOf(":");
    int s5=SQLMan.target_info[1][21].lastIndexOf(":");
    dy=Integer.valueOf(t.substring(s2+1,s3)).intValue();
    dM=Integer.valueOf(t.substring(0,s1)).intValue();
    dd=Integer.valueOf(t.substring(s1+1,s2)).intValue();
    dH=Integer.valueOf(t.substring(s3+1,s4)).intValue();
    dm=Integer.valueOf(t.substring(s4+1,s5)).intValue();
     ny=Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date())).intValue();
     nM=Integer.valueOf(new SimpleDateFormat("MM").format(new Date())).intValue();
     nd=Integer.valueOf(new SimpleDateFormat("dd").format(new Date())).intValue();
     nH=Integer.valueOf(new SimpleDateFormat("HH").format(new Date())).intValue();
     nm=Integer.valueOf(new SimpleDateFormat("mm").format(new Date())).intValue();
 }
 //���w�ʰӫ~
   if("1".equals(SQLMan.target_info[1][10]) && dy>ny && dM>nM && dd>nd && dH>nH && dm>nm){
       String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
       try {
        assertEquals("�ק�",webpre);
        System.out.println("���T-�w�ʤ��;");
       } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("���~-�w�ʤ����;");
        System.out.println("WB�w�ʸ�T'"+webpre+"';");
        System.out.println("DB�i��q��T'�ק�';");
       } 
   }
   //�����w�ʰӫ~
   else{
       String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
       try {
        assertEquals("�s�W�w��",webpre);
        System.out.println("���T-�����w�ʤ��;");
       } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("���~-�����w�ʤ��;");
        System.out.println("WB�w�ʸ�T'"+webpre+"';");
        System.out.println("DB�i��q��T'�s�W�w��';");
       }
    
   }
  }
@Test
  public void Item09LWHL(){
 //�祿���e�����q�O�_���T
 if("".equals(SQLMan.target_info[1][15])){
  SQLMan.target_info[1][15]="0";
 }
 if("0".equals(Double.parseDouble(SQLMan.target_info[1][15])% 1000)){
  SQLMan.target_info[1][15]=String.valueOf(Integer.valueOf(SQLMan.target_info[1][15])/1000);
 }else{
  SQLMan.target_info[1][15]=String.valueOf(Double.parseDouble(SQLMan.target_info[1][15])/1000);
 }
   String webLWHL=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[5]/a")).getText();
   String dbLWHL="��"+SQLMan.target_info[1][12]+" / "+SQLMan.target_info[1][13]+" / "+SQLMan.target_info[1][14]+"cm"+SQLMan.target_info[1][15]+"kg";
   if(webLWHL!="��"){
      webLWHL=webLWHL.replaceAll("\n","");
      webLWHL=webLWHL.substring(0,dbLWHL.length());
   }
  if(SQLMan.target_info[1][12]!=""){
      try {
       assertEquals(dbLWHL,webLWHL);
       System.out.println("���T-���e�����q���;");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("���~-���e�����q���;");
       System.out.println("WB���e�����q��T'"+webLWHL+"';");
       System.out.println("DB���e�����q��T'"+dbLWHL+"';");
      }
  }else{
   try {
       assertEquals("��",webLWHL);
       System.out.println("���T-���e�����q���;");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("���~-���e�����q���;");
       System.out.println("WB���e�����q��T'"+webLWHL+"';");
       System.out.println("DB���e�����q��T'��';");
      }
   
  }
  }
  @Test
  public void Item10Category(){
 //�祿�����O�_���T
   String webcategory=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[7]")).getText();
   String dbcategory=SQLMan.target_info[1][17];
   try {
    assertEquals(dbcategory,webcategory);
    System.out.println("���T-�������;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�������;");
    System.out.println("WB������T'"+webcategory+"';");
    System.out.println("DB������T'"+dbcategory+"';");
   }
  }
@Test
  public void Item11ItInType(){
 //�祿�����O�_���T
   String webit_in_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[10]")).getText();
   String dbit_in_type=null;
   if("1".equals(SQLMan.target_info[1][18])){dbit_in_type="�ɳf";}
   if("2".equals(SQLMan.target_info[1][18])){dbit_in_type="����";}
   if("3".equals(SQLMan.target_info[1][18])){dbit_in_type="���";}
   try {
    assertEquals(dbit_in_type,webit_in_type);
    System.out.println("���T-�������;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�������;");
    System.out.println("WB������T'"+webit_in_type+"';");
    System.out.println("DB������T'"+dbit_in_type+"';");
   }
  }
  @Test
  public void Item12Sup(){
 //�祿�t�ӦW�٬O�_���T
   String websup=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[12]")).getText();
   String dbsup=SQLMan.target_info[1][19];
   try {
    assertEquals(dbsup,websup);
    System.out.println("���T-�t�ӦW�٤��;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�t�ӦW�٤��;");
    System.out.println("WB�t�ӦW�ٸ�T'"+websup+"';");
    System.out.println("DB�t�ӦW�ٸ�T'"+dbsup+"';");
   }
 //���ʱ��b
   for(int i=1 ;i<=50 ;i++){
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   }
  }
  @Test
  public void Item13Itsern(){
 //�祿�t�ӦۥήƸ��O�_���T
   String webitsern=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[13]")).getText();
   String dbitsern=SQLMan.target_info[1][20];
   if(dbitsern == "null"){dbitsern="";}
   try {
    assertEquals(dbitsern,webitsern);
    System.out.println("���T-�t�ӦۥήƸ����;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("���~-�t�ӦۥήƸ����;");
    System.out.println("WB�t�ӦۥήƸ���T'"+webitsern+"';");
    System.out.println("DB�t�ӦۥήƸ���T'"+dbitsern+"';");
   }
  }
  @After
  public void After(){
   verificationErrorString=verificationErrors.toString();
   if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
   }
  }
  @AfterClass
  public  static void AfterClass(){
 System.out.println("�}������;");
    driver.quit();
  }
 
}
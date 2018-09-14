package CaseItem;import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import Help.Method;public class ItemTest extends Method{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert=true;
  private StringBuffer verificationErrors=new StringBuffer();  @Before
  public void setUp() throws Exception {
    driver=new FirefoxDriver();
    baseUrl=WebSiteUrl();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    Country("tw");
    Area("a");
  } +++++++++=
@Test
  public void Item() throws Exception {
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
 //�i�J�ӫ~�C��
//�i�J�ӫ~�C��
 System.out.println("�i�J�ӫ~�C��;");
 driver.get("���}");
 //�s��DB
 System.out.print("�s��DB");
 Conn_SQL("A");
 //���oDB���
 System.out.println("�}�l�U���O;");
    Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet rs=stmt.executeQuery("select * from ( select "
      +"i.itno,i.it_pic,i.itname,i.color,i.it_size,"
      +"i.it_cost,i.input_tax,i.output_tax,i.saleqty,i.is_pre_ord,"
      +"i.pre_ava_qty,i.length,i.width,i.height,i.weight,"
      +"i.is_cvs_pay,c.cp_name,i.it_in_type,su.sup_name,i.it_sern,"
      +"i.pre_dt_e "
      +"from uaord.item i "
      +"join uaord.show_detail sd on i.itno=sd.itno "
      +"join uaord.show_main sm on sd.sm_seq=sm.sm_seq "
      +"join uaord.category c on i.cp_seq=c.cp_seq "
      +"join uaord.supplier su on i.sup_seq=su.sup_seq "
      +"where i.islifeexpired ='0' "
      +"and sm.IS_ORGI_ITEM='1' "
      +"and sd.IS_ITNO_MAIN='1' "
      +"and sd.IT_TYPE='1' "
      +"and sm.owner_no='AL1096' "
      +"and sm.ws_seq='AW000001' "
      +"order by dbms_random.value) "
      +"where rownum��=1");
   //���o����`��
    ResultSetMetaData md =rs.getMetaData();
    int columncount=md.getColumnCount();
    rs.last();
    int total=rs.getRow();
    System.out.println("���o��Ʀ@"+total+"�����"+columncount+"�����;");  
    //����
    rs.beforeFirst();
    String [][] iteminfo=new String[total+1][columncount+1];
    for(int i=1;i ��= total ;i++){
     rs.next();
     for(int x=1;x ��= columncount;x++){
      iteminfo[i][x]=String.valueOf(rs.getString(x));
      //�L�X��T���ո}���ϥ�
      //System.out.println(i+"-"+x+")"+iteminfo[i][x]);
     }
    }
    System.out.println("��ƫإߧ���");
    //����귽
    conn.close();rs.close();stmt.close();
    System.out.println("�����Ʈw�귽;");
    //��J�ӫ~ID�j�M
    for(int i=1;i ��= total ;i++){
    String noitem =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td")).getText();
    //�ˬd�O�_�줣��ӫ~
    if( "�ثe�S���������ӫ~".equals(noitem)){
     System.out.println("�䤣��"+iteminfo[i][1]+"���ӫ~ID");
    }else{
     //��Jitno
     driver.findElement(By.cssSelector(".search-input")).clear();
     System.out.println("��Jitno'"+iteminfo[i][1]+"';");++++++++++
driver.findElement(By.cssSelector(".search-input")).sendKeys(iteminfo[i][1]);
     //�I���j�M���s
     System.out.println("�I���j�M���s;");
     driver.findElement(By.cssSelector(".btn-info")).click();
     //����5��
     Thread.sleep(5000);
     //�[����T
     driver.getPageSource();
     //�祿�Ϥ����|�O�_���T
     String webphotolink=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/a/div[1]")).getAttribute("style");
     String dbphotolink ="background-image: url(\"http://img.beta1.ux"+iteminfo[i][2]+"\");";
     try {
      assertEquals(dbphotolink, webphotolink);
      System.out.println("-�Ϥ���T��勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�Ϥ���T�����~-");
      System.out.println("WB�Ϥ���T'"+webphotolink+"';");
      System.out.println("DB�Ϥ���T'"+dbphotolink+"';");
     }
     //�祿�ӫ~�W�٬O�_���T
     String webitemname=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[3]/div/p")).getText();
     String dbitemname=iteminfo[i][3];
     webitemname=webitemname.replaceAll(" ","");
     dbitemname=dbitemname.replaceAll(" ","");
     try {++++++++++
assertEquals(dbitemname,webitemname);
      System.out.println("-�ӫ~�W�٤�勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�ӫ~�W�٤����~-");
      System.out.println("WB�ӫ~�W�ٸ�T'"+webitemname+"';");
      System.out.println("DB�ӫ~�W�ٸ�T'"+dbitemname+"';");
     }
     //�祿�C��O�_���T
     String webcolor=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/div/p")).getText();
     String dbcolor=iteminfo[i][4];
     if(dbcolor == "null"){dbcolor="";}
     try {
      assertEquals(dbcolor,webcolor);
      System.out.println("-�C���T��勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�C���T�����~-");
      System.out.println("WB�C���T'"+webcolor+"';");
      System.out.println("DB�C���T'"+dbcolor+"';");
     }
     //�祿�ؤo�O�_���T
     String websize=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[5]/div/p")).getText();
     String dbsize=iteminfo[i][5];
     if(dbsize == "null"){dbsize="";}
     try {
      assertEquals(dbsize,websize);
      System.out.println("-�ؤo��T��勵�T-");
     } catch (Error e) {+++++++++++
verificationErrors.append(e.toString());
      System.out.println("-�ؤo��T�����~-");
      System.out.println("WB�ؤo��T'"+websize+"';");
      System.out.println("DB�ؤo��T'"+dbsize+"';");
     }
     //�祿�O�I���ȬO�_���T
     String webivalue=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]")).getText();
     String dbivalue=iteminfo[i][6];
     webivalue=webivalue.substring(0,dbivalue.length());
     try {
      assertEquals(dbivalue,webivalue);
      System.out.println("-�O�I���Ȥ�勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�O�I���Ȥ����~-");
      System.out.println("WB�O�I���ȸ�T'"+webivalue+"';");
      System.out.println("DB�O�I���ȸ�T'"+dbivalue+"';");
     }
     //�祿�i���|�v�O�_���T
     String webtax=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]")).getText();
     String dbtax=String.valueOf((int)(Double.parseDouble(iteminfo[i][7])*100))+"%"+String.valueOf((int)(Double.parseDouble(iteminfo[i][8])*100))+"%";
     webtax =  (webtax.replaceAll("\n","")).substring(0,dbtax.length());;
     try {
      assertEquals(dbtax,webtax);
      System.out.println("-�i�P���|��勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�i�P���|�����~-");
      System.out.println("WB�i�P���|��T'"+webtax+"';");
      System.out.println("DB�i�P���|��T'"+dbtax+"';");+++++++++++
}
     //�祿�i��q�O�_���T
     String webqty=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/a[1]")).getText();
     String dbqty=iteminfo[i][9];
     webqty=webqty.substring(0,dbqty.length());
     try {
      assertEquals(dbqty,webqty);
      System.out.println("-�i��q��勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�i��q�����~-");
      System.out.println("WB�i��q��T'"+webqty+"';");
      System.out.println("DB�i��q��T'"+dbqty+"';");
     }
     //�祿�w�ʬO�_���T
        String t =  iteminfo[1][21];
     int s1=iteminfo[i][21].indexOf("/");
     int s2=iteminfo[i][21].lastIndexOf("/");
     int s3=iteminfo[i][21].indexOf(" ");
     int s4=iteminfo[i][21].indexOf(":");
     int s5=iteminfo[i][21].lastIndexOf(":");
     int dy=Integer.valueOf(t.substring(s2+1,s3)).intValue();
     int dM=Integer.valueOf(t.substring(0,s1)).intValue();
     int dd=Integer.valueOf(t.substring(s1+1,s2)).intValue();
     int dH=Integer.valueOf(t.substring(s3+1,s4)).intValue();
     int dm=Integer.valueOf(t.substring(s4+1,s5)).intValue();
        int ny=Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date())).intValue();
        int nM=Integer.valueOf(new SimpleDateFormat("MM").format(new Date())).intValue();
        int nd=Integer.valueOf(new SimpleDateFormat("dd").format(new Date())).intValue();
        int nH=Integer.valueOf(new SimpleDateFormat("HH").format(new Date())).intValue();
        int nm=Integer.valueOf(new SimpleDateFormat("mm").format(new Date())).intValue();+++++++++++
//���w�ʰӫ~
     if("1".equals(iteminfo[i][10]) && dy��ny && dM��nM && dd��nd && dH��nH && dm��nm){
         String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
         try {
          assertEquals("�ק�",webpre);
          System.out.println("-�w�ʤ�勵�T-");
         } catch (Error e) {
          verificationErrors.append(e.toString());
          System.out.println("-�w�ʤ������~-");
          System.out.println("WB�w�ʸ�T'"+webpre+"';");
          System.out.println("DB�i��q��T'�ק�';");
         } 
     }
     //�����w�ʰӫ~
     else{
         String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
         try {
          assertEquals("�s�W�w��",webpre);
          System.out.println("-�����w�ʤ�勵�T-");
         } catch (Error e) {
          verificationErrors.append(e.toString());
          System.out.println("-�w�ʤ����~-");
          System.out.println("WB�w�ʸ�T'"+webpre+"';");
          System.out.println("DB�i��q��T'�s�W�w��';");
         }
      
     };
     //�祿���e�����q�O�_���T
     String web1234=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[5]/a")).getText();
     String db1234="��"+iteminfo[i][12]+" / "+iteminfo[i][13]+" / "+iteminfo[i][14]+"cm"+String.valueOf(Double.parseDouble(iteminfo[i][15])/1000)+"kg";
     web1234=web1234.replaceAll("\n","");
     web1234=web1234.substring(0,db1234.length());
  if(iteminfo[i][12]!=""){++++++++++
 try {
       assertEquals(db1234,web1234);
       System.out.println("-���e�����q��勵�T-");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("-���e�����q�����~-");
       System.out.println("WB���e�����q��T'"+web1234+"';");
       System.out.println("DB���e�����q��T'"+db1234+"';");
      }
  }else{
   try {
       assertEquals("��",web1234);
       System.out.println("-���e�����q��勵�T-");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("-���e�����q�����~-");
       System.out.println("WB���e�����q��T'"+web1234+"';");
       System.out.println("DB���e�����q��T'��';");
      }
   
  };
     //�祿�����O�_���T
     String webcategory=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[7]")).getText();
     String dbcategory=iteminfo[i][17];
     try {
      assertEquals(dbcategory,webcategory);
      System.out.println("-������勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-���������~-");
      System.out.println("WB������T'"+webcategory+"';");
      System.out.println("DB������T'"+dbcategory+"';");
     }++++++++++
//�祿�����O�_���T
     String webit_in_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[10]")).getText();
     String dbit_in_type=null;
     if("1".equals(iteminfo[i][18])){dbit_in_type="�ɳf";}
     if("2".equals(iteminfo[i][18])){dbit_in_type="����";}
     if("3".equals(iteminfo[i][18])){dbit_in_type="���";}
     try {
      assertEquals(dbit_in_type,webit_in_type);
      System.out.println("-������勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-���������~-");
      System.out.println("WB������T'"+webit_in_type+"';");
      System.out.println("DB������T'"+dbit_in_type+"';");
     }
     //���ʱ��b
     //WebElement formove=driver.findElement(By.id("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[1]"));
     //for(int a=1;a��=50;a++){
     //formove.sendKeys(Keys.ARROW_RIGHT);
     //}
     //�祿�t�ӦW�٬O�_���T
     String websup=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[12]")).getText();
     String dbsup=iteminfo[i][19];
     try {
      assertEquals(dbsup,websup);
      System.out.println("-�t�ӦW�٤�勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�ӦW�٤����~-");
      System.out.println("WB�t�ӦW�ٸ�T'"+websup+"';");++++++++++=
     System.out.println("DB�t�ӦW�ٸ�T'"+dbsup+"';");
     }
     //�祿�t�ӦۥήƸ��O�_���T
     String webitsern=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[13]")).getText();
     String dbitsern=iteminfo[i][20];
     if(dbitsern == "null"){dbitsern="";}
     try {
      assertEquals(dbitsern,webitsern);
      System.out.println("-�t�ӦۥήƸ���勵�T-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-�t�ӦۥήƸ������~-");
      System.out.println("WB�t�ӦۥήƸ���T'"+webitsern+"';");
      System.out.println("DB�t�ӦۥήƸ���T'"+dbitsern+"';");
     }
     
    }
    }
  }
   @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString=verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
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
   //基本資訊
   BasicInfo("f");
   //自動跑至商品列表
   GoToItem();
   //連接資料庫
   SQLMan.connect(Area);
  //下指令取得指定一筆資料
   SQLMan.item_Appoint(System.getenv("ITNO"));
   //搜尋Itno
   SearchItno(SQLMan.target_info[1][1]);     
  }
@Before
  public void Befor() throws Exception{
   verificationErrors= new StringBuffer();
  }
  @Test
  public void Item01Photo(){
   //驗正圖片路徑是否正確
   String webphotolink=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/a/div[1]")).getAttribute("style");
   String dbphotolink ="background-image: url(\"http://img.beta1.ux"+SQLMan.target_info[1][2]+"\");";
   try {
    assertEquals(dbphotolink, webphotolink);
    System.out.println("正確-圖片資訊比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-圖片資訊比對;");
    System.out.println("WB圖片資訊'"+webphotolink+"';");
    System.out.println("DB圖片資訊'"+dbphotolink+"';");
   }
  }   
  @Test
  public void Item02Name(){
 //驗正商品名稱是否正確
 String webitemname=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[3]/div/p")).getText();
   String dbitemname=SQLMan.target_info[1][3];
   webitemname=webitemname.replaceAll(" ","");
   dbitemname=dbitemname.replaceAll(" ","");
   try {
    assertEquals(dbitemname,webitemname);
    System.out.println("正確-商品名稱比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-商品名稱比對;");
    System.out.println("WB商品名稱資訊'"+webitemname+"';");
    System.out.println("DB商品名稱資訊'"+dbitemname+"';");
   }
  }
  @Test
  public void Item03Color(){
 //驗正顏色是否正確
 String webcolor=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/div/p")).getText();
   String dbcolor=SQLMan.target_info[1][4];
   if(dbcolor == "null"){dbcolor="";}
   try {
    assertEquals(dbcolor,webcolor);
    System.out.println("正確-顏色資訊比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-顏色資訊比對;");
    System.out.println("WB顏色資訊'"+webcolor+"';");
    System.out.println("DB顏色資訊'"+dbcolor+"';");
   }
  }
@Test
  public void Item04Size(){
 //驗正尺寸是否正確
 String websize=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[5]/div/p")).getText();
   String dbsize=SQLMan.target_info[1][5];
   if(dbsize == "null"){dbsize="";}
   try {
    assertEquals(dbsize,websize);
    System.out.println("正確-尺寸資訊比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-尺寸資訊比對;");
    System.out.println("WB尺寸資訊'"+websize+"';");
    System.out.println("DB尺寸資訊'"+dbsize+"';");
   }
  }
  @Test
  public void Item05InsuranceValue(){
 //驗正保險價值是否正確
 String webivalue=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]")).getText();
   String dbivalue=SQLMan.target_info[1][6];
   webivalue =webivalue.substring(0,dbivalue.length());
   try {
    assertEquals(dbivalue,webivalue);
    System.out.println("正確-保險價值比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-保險價值比對;");
    System.out.println("WB保險價值資訊'"+webivalue+"';");
    System.out.println("DB保險價值資訊'"+dbivalue+"';");
   }
  }
  @Test
  public void Item06Tax(){
 //驗正進項稅率是否正確
   String webtax=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]")).getText();
   String dbtax=BasicMan.StrDotToPercent(SQLMan.target_info[1][7],2)+BasicMan.StrDotToPercent(SQLMan.target_info[1][8],2);
   webtax =  (webtax.replaceAll("\n","")).substring(0,dbtax.length());;
   try {
    assertEquals(dbtax,webtax);
    System.out.println("正確-進銷項稅比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-進銷項稅比對;");
    System.out.println("WB進銷項稅資訊'"+webtax+"';");
    System.out.println("DB進銷項稅資訊'"+dbtax+"';");
   }
  }
  @Test
  public void Item07Qty(){
 //驗正可賣量是否正確
   String webqty=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/a[1]")).getText();
   String dbqty=SQLMan.target_info[1][9];
   webqty=webqty.substring(0,dbqty.length());
   try {
    assertEquals(dbqty,webqty);
    System.out.println("正確-可賣量比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-可賣量比對;");
    System.out.println("WB可賣量資訊'"+webqty+"';");
    System.out.println("DB可賣量資訊'"+dbqty+"';");
   }
  }
@Test
  public void Item07Qty(){
 //驗正可賣量是否正確
   String webqty=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/a[1]")).getText();
   String dbqty=SQLMan.target_info[1][9];
   webqty=webqty.substring(0,dbqty.length());
   try {
    assertEquals(dbqty,webqty);
    System.out.println("正確-可賣量比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-可賣量比對;");
    System.out.println("WB可賣量資訊'"+webqty+"';");
    System.out.println("DB可賣量資訊'"+dbqty+"';");
   }
  }
  @Test
  public void Item08Pre(){
 //驗正預購是否正確
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
 //為預購商品
   if("1".equals(SQLMan.target_info[1][10]) && dy>ny && dM>nM && dd>nd && dH>nH && dm>nm){
       String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
       try {
        assertEquals("修改",webpre);
        System.out.println("正確-預購比對;");
       } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("錯誤-預購中比對;");
        System.out.println("WB預購資訊'"+webpre+"';");
        System.out.println("DB可賣量資訊'修改';");
       } 
   }
   //不為預購商品
   else{
       String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
       try {
        assertEquals("新增預購",webpre);
        System.out.println("正確-不為預購比對;");
       } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("錯誤-不為預購比對;");
        System.out.println("WB預購資訊'"+webpre+"';");
        System.out.println("DB可賣量資訊'新增預購';");
       }
    
   }
  }
@Test
  public void Item09LWHL(){
 //驗正長寬高重量是否正確
 if("".equals(SQLMan.target_info[1][15])){
  SQLMan.target_info[1][15]="0";
 }
 if("0".equals(Double.parseDouble(SQLMan.target_info[1][15])% 1000)){
  SQLMan.target_info[1][15]=String.valueOf(Integer.valueOf(SQLMan.target_info[1][15])/1000);
 }else{
  SQLMan.target_info[1][15]=String.valueOf(Double.parseDouble(SQLMan.target_info[1][15])/1000);
 }
   String webLWHL=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[5]/a")).getText();
   String dbLWHL="詳"+SQLMan.target_info[1][12]+" / "+SQLMan.target_info[1][13]+" / "+SQLMan.target_info[1][14]+"cm"+SQLMan.target_info[1][15]+"kg";
   if(webLWHL!="詳"){
      webLWHL=webLWHL.replaceAll("\n","");
      webLWHL=webLWHL.substring(0,dbLWHL.length());
   }
  if(SQLMan.target_info[1][12]!=""){
      try {
       assertEquals(dbLWHL,webLWHL);
       System.out.println("正確-長寬高重量比對;");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("錯誤-長寬高重量比對;");
       System.out.println("WB長寬高重量資訊'"+webLWHL+"';");
       System.out.println("DB長寬高重量資訊'"+dbLWHL+"';");
      }
  }else{
   try {
       assertEquals("詳",webLWHL);
       System.out.println("正確-長寬高重量比對;");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("錯誤-長寬高重量比對;");
       System.out.println("WB長寬高重量資訊'"+webLWHL+"';");
       System.out.println("DB長寬高重量資訊'詳';");
      }
   
  }
  }
  @Test
  public void Item10Category(){
 //驗正分類是否正確
   String webcategory=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[7]")).getText();
   String dbcategory=SQLMan.target_info[1][17];
   try {
    assertEquals(dbcategory,webcategory);
    System.out.println("正確-分類比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-分類比對;");
    System.out.println("WB分類資訊'"+webcategory+"';");
    System.out.println("DB分類資訊'"+dbcategory+"';");
   }
  }
@Test
  public void Item11ItInType(){
 //驗正借轉單是否正確
   String webit_in_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[10]")).getText();
   String dbit_in_type=null;
   if("1".equals(SQLMan.target_info[1][18])){dbit_in_type="借貨";}
   if("2".equals(SQLMan.target_info[1][18])){dbit_in_type="採購";}
   if("3".equals(SQLMan.target_info[1][18])){dbit_in_type="轉單";}
   try {
    assertEquals(dbit_in_type,webit_in_type);
    System.out.println("正確-借轉單比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-借轉單比對;");
    System.out.println("WB借轉單資訊'"+webit_in_type+"';");
    System.out.println("DB借轉單資訊'"+dbit_in_type+"';");
   }
  }
  @Test
  public void Item12Sup(){
 //驗正廠商名稱是否正確
   String websup=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[12]")).getText();
   String dbsup=SQLMan.target_info[1][19];
   try {
    assertEquals(dbsup,websup);
    System.out.println("正確-廠商名稱比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-廠商名稱比對;");
    System.out.println("WB廠商名稱資訊'"+websup+"';");
    System.out.println("DB廠商名稱資訊'"+dbsup+"';");
   }
 //移動捲軸
   for(int i=1 ;i<=50 ;i++){
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   }
  }
  @Test
  public void Item13Itsern(){
 //驗正廠商自用料號是否正確
   String webitsern=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[13]")).getText();
   String dbitsern=SQLMan.target_info[1][20];
   if(dbitsern == "null"){dbitsern="";}
   try {
    assertEquals(dbitsern,webitsern);
    System.out.println("正確-廠商自用料號比對;");
   } catch (Error e) {
    verificationErrors.append(e.toString());
    System.out.println("錯誤-廠商自用料號比對;");
    System.out.println("WB廠商自用料號資訊'"+webitsern+"';");
    System.out.println("DB廠商自用料號資訊'"+dbitsern+"';");
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
 System.out.println("腳本完成;");
    driver.quit();
  }
 
}
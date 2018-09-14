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
 //開啟平台管理系統
 System.out.println("開啟平台管理系統;");
 driver.get(WebSiteUrl());
 //瀏覽器最大化
 System.out.println("瀏覽器最大化;");
 driver.manage().window().maximize();
 //驗正碼輸入
 System.out.println("驗正碼輸入;");
 driver.findElement(By.id("captcha")).sendKeys("test");
 //點擊登入按鈕
 System.out.println("點擊登入按鈕;");
 driver.findElement(By.cssSelector("button.btn-submit")).click();
 //等待5秒
 Thread.sleep(5000);
 //進入商品列表
//進入商品列表
 System.out.println("進入商品列表;");
 driver.get("網址");
 //連結DB
 System.out.print("連結DB");
 Conn_SQL("A");
 //取得DB資料
 System.out.println("開始下指令;");
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
      +"where rownum＜=1");
   //取得資料總數
    ResultSetMetaData md =rs.getMetaData();
    int columncount=md.getColumnCount();
    rs.last();
    int total=rs.getRow();
    System.out.println("取得資料共"+total+"筆資料"+columncount+"個欄位;");  
    //塞資料
    rs.beforeFirst();
    String [][] iteminfo=new String[total+1][columncount+1];
    for(int i=1;i ＜= total ;i++){
     rs.next();
     for(int x=1;x ＜= columncount;x++){
      iteminfo[i][x]=String.valueOf(rs.getString(x));
      //印出資訊測試腳本使用
      //System.out.println(i+"-"+x+")"+iteminfo[i][x]);
     }
    }
    System.out.println("資料建立完成");
    //釋放資源
    conn.close();rs.close();stmt.close();
    System.out.println("釋放資料庫資源;");
    //輸入商品ID搜尋
    for(int i=1;i ＜= total ;i++){
    String noitem =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td")).getText();
    //檢查是否抓不到商品
    if( "目前沒有相關的商品".equals(noitem)){
     System.out.println("找不到"+iteminfo[i][1]+"的商品ID");
    }else{
     //輸入itno
     driver.findElement(By.cssSelector(".search-input")).clear();
     System.out.println("輸入itno'"+iteminfo[i][1]+"';");++++++++++
driver.findElement(By.cssSelector(".search-input")).sendKeys(iteminfo[i][1]);
     //點擊搜尋按鈕
     System.out.println("點擊搜尋按鈕;");
     driver.findElement(By.cssSelector(".btn-info")).click();
     //等待5秒
     Thread.sleep(5000);
     //加載資訊
     driver.getPageSource();
     //驗正圖片路徑是否正確
     String webphotolink=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/a/div[1]")).getAttribute("style");
     String dbphotolink ="background-image: url(\"http://img.beta1.ux"+iteminfo[i][2]+"\");";
     try {
      assertEquals(dbphotolink, webphotolink);
      System.out.println("-圖片資訊比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-圖片資訊比對錯誤-");
      System.out.println("WB圖片資訊'"+webphotolink+"';");
      System.out.println("DB圖片資訊'"+dbphotolink+"';");
     }
     //驗正商品名稱是否正確
     String webitemname=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[3]/div/p")).getText();
     String dbitemname=iteminfo[i][3];
     webitemname=webitemname.replaceAll(" ","");
     dbitemname=dbitemname.replaceAll(" ","");
     try {++++++++++
assertEquals(dbitemname,webitemname);
      System.out.println("-商品名稱比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-商品名稱比對錯誤-");
      System.out.println("WB商品名稱資訊'"+webitemname+"';");
      System.out.println("DB商品名稱資訊'"+dbitemname+"';");
     }
     //驗正顏色是否正確
     String webcolor=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/div/p")).getText();
     String dbcolor=iteminfo[i][4];
     if(dbcolor == "null"){dbcolor="";}
     try {
      assertEquals(dbcolor,webcolor);
      System.out.println("-顏色資訊比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-顏色資訊比對錯誤-");
      System.out.println("WB顏色資訊'"+webcolor+"';");
      System.out.println("DB顏色資訊'"+dbcolor+"';");
     }
     //驗正尺寸是否正確
     String websize=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[5]/div/p")).getText();
     String dbsize=iteminfo[i][5];
     if(dbsize == "null"){dbsize="";}
     try {
      assertEquals(dbsize,websize);
      System.out.println("-尺寸資訊比對正確-");
     } catch (Error e) {+++++++++++
verificationErrors.append(e.toString());
      System.out.println("-尺寸資訊比對錯誤-");
      System.out.println("WB尺寸資訊'"+websize+"';");
      System.out.println("DB尺寸資訊'"+dbsize+"';");
     }
     //驗正保險價值是否正確
     String webivalue=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]")).getText();
     String dbivalue=iteminfo[i][6];
     webivalue=webivalue.substring(0,dbivalue.length());
     try {
      assertEquals(dbivalue,webivalue);
      System.out.println("-保險價值比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-保險價值比對錯誤-");
      System.out.println("WB保險價值資訊'"+webivalue+"';");
      System.out.println("DB保險價值資訊'"+dbivalue+"';");
     }
     //驗正進項稅率是否正確
     String webtax=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]")).getText();
     String dbtax=String.valueOf((int)(Double.parseDouble(iteminfo[i][7])*100))+"%"+String.valueOf((int)(Double.parseDouble(iteminfo[i][8])*100))+"%";
     webtax =  (webtax.replaceAll("\n","")).substring(0,dbtax.length());;
     try {
      assertEquals(dbtax,webtax);
      System.out.println("-進銷項稅比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-進銷項稅比對錯誤-");
      System.out.println("WB進銷項稅資訊'"+webtax+"';");
      System.out.println("DB進銷項稅資訊'"+dbtax+"';");+++++++++++
}
     //驗正可賣量是否正確
     String webqty=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/a[1]")).getText();
     String dbqty=iteminfo[i][9];
     webqty=webqty.substring(0,dbqty.length());
     try {
      assertEquals(dbqty,webqty);
      System.out.println("-可賣量比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-可賣量比對錯誤-");
      System.out.println("WB可賣量資訊'"+webqty+"';");
      System.out.println("DB可賣量資訊'"+dbqty+"';");
     }
     //驗正預購是否正確
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
//為預購商品
     if("1".equals(iteminfo[i][10]) && dy＞ny && dM＞nM && dd＞nd && dH＞nH && dm＞nm){
         String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
         try {
          assertEquals("修改",webpre);
          System.out.println("-預購比對正確-");
         } catch (Error e) {
          verificationErrors.append(e.toString());
          System.out.println("-預購中比對錯誤-");
          System.out.println("WB預購資訊'"+webpre+"';");
          System.out.println("DB可賣量資訊'修改';");
         } 
     }
     //不為預購商品
     else{
         String webpre=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/a[1]")).getText();
         try {
          assertEquals("新增預購",webpre);
          System.out.println("-不為預購比對正確-");
         } catch (Error e) {
          verificationErrors.append(e.toString());
          System.out.println("-預購比對錯誤-");
          System.out.println("WB預購資訊'"+webpre+"';");
          System.out.println("DB可賣量資訊'新增預購';");
         }
      
     };
     //驗正長寬高重量是否正確
     String web1234=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[5]/a")).getText();
     String db1234="詳"+iteminfo[i][12]+" / "+iteminfo[i][13]+" / "+iteminfo[i][14]+"cm"+String.valueOf(Double.parseDouble(iteminfo[i][15])/1000)+"kg";
     web1234=web1234.replaceAll("\n","");
     web1234=web1234.substring(0,db1234.length());
  if(iteminfo[i][12]!=""){++++++++++
 try {
       assertEquals(db1234,web1234);
       System.out.println("-長寬高重量比對正確-");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("-長寬高重量比對錯誤-");
       System.out.println("WB長寬高重量資訊'"+web1234+"';");
       System.out.println("DB長寬高重量資訊'"+db1234+"';");
      }
  }else{
   try {
       assertEquals("詳",web1234);
       System.out.println("-長寬高重量比對正確-");
      } catch (Error e) {
       verificationErrors.append(e.toString());
       System.out.println("-長寬高重量比對錯誤-");
       System.out.println("WB長寬高重量資訊'"+web1234+"';");
       System.out.println("DB長寬高重量資訊'詳';");
      }
   
  };
     //驗正分類是否正確
     String webcategory=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[7]")).getText();
     String dbcategory=iteminfo[i][17];
     try {
      assertEquals(dbcategory,webcategory);
      System.out.println("-分類比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-分類比對錯誤-");
      System.out.println("WB分類資訊'"+webcategory+"';");
      System.out.println("DB分類資訊'"+dbcategory+"';");
     }++++++++++
//驗正借轉單是否正確
     String webit_in_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[10]")).getText();
     String dbit_in_type=null;
     if("1".equals(iteminfo[i][18])){dbit_in_type="借貨";}
     if("2".equals(iteminfo[i][18])){dbit_in_type="採購";}
     if("3".equals(iteminfo[i][18])){dbit_in_type="轉單";}
     try {
      assertEquals(dbit_in_type,webit_in_type);
      System.out.println("-借轉單比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-借轉單比對錯誤-");
      System.out.println("WB借轉單資訊'"+webit_in_type+"';");
      System.out.println("DB借轉單資訊'"+dbit_in_type+"';");
     }
     //移動捲軸
     //WebElement formove=driver.findElement(By.id("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/thead/tr/th[1]"));
     //for(int a=1;a＜=50;a++){
     //formove.sendKeys(Keys.ARROW_RIGHT);
     //}
     //驗正廠商名稱是否正確
     String websup=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[12]")).getText();
     String dbsup=iteminfo[i][19];
     try {
      assertEquals(dbsup,websup);
      System.out.println("-廠商名稱比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-商名稱比對錯誤-");
      System.out.println("WB廠商名稱資訊'"+websup+"';");++++++++++=
     System.out.println("DB廠商名稱資訊'"+dbsup+"';");
     }
     //驗正廠商自用料號是否正確
     String webitsern=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[13]")).getText();
     String dbitsern=iteminfo[i][20];
     if(dbitsern == "null"){dbitsern="";}
     try {
      assertEquals(dbitsern,webitsern);
      System.out.println("-廠商自用料號比對正確-");
     } catch (Error e) {
      verificationErrors.append(e.toString());
      System.out.println("-廠商自用料號比對錯誤-");
      System.out.println("WB廠商自用料號資訊'"+webitsern+"';");
      System.out.println("DB廠商自用料號資訊'"+dbitsern+"';");
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
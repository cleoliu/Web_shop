package Help;import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.awt.event.KeyEvent;
import Help.RobotMan;
import Help.WebDriverMan;public class AddHelp extends Uitox{
 /*
  * 去新增頁面
  */
 public void GoToAdd() throws Exception{
  //設定瀏覽器
  SetBrowser("f");
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
    System.out.println("點擊新增頁面;");
    driver.findElement(By.linkText("新增商品(單筆/大量)")).click();
 }
 /*
  * 設定商品名稱
  * name_type:1.單一商品2.多顏色商品3.多顏多尺商品
  * item_type:1.借貨3.轉單
  */
 public int photorownum;
 public void SetItemNameType(String name_type,String item_type) throws Exception{
  //設定商品名稱
    SimpleDateFormat sdFormat=new SimpleDateFormat("yyyyMMdd-hhmm");
    Date date=new Date ();
    String ItemName;
    Random ran=new Random();
    photorownum=ran.nextInt(11)+1;
    switch(name_type){
     case "1":
      switch(item_type){
       case "1":
        ItemName="WebDriverTorso-單一商品借貨-"+photorownum+"-"+sdFormat.format(date);
        break;
       case "3":
        ItemName="WebDriverTorso-單一商品轉單-"+photorownum+"-"+sdFormat.format(date);
        break;
       default:
        ItemName="WebDriverTorso-單一商品借貨-"+photorownum+"-"+sdFormat.format(date);
        break;
      }
      break;
     case "2":
      switch(item_type){
      case "1":
       ItemName="WebDriverTorso-多顏色商品借貨-"+photorownum+"-"+sdFormat.format(date);
       break;
      case "3":
       ItemName="WebDriverTorso-多顏色商品轉單-"+photorownum+"-"+sdFormat.format(date);
       break;
      default:
       ItemName="WebDriverTorso-多顏色商品借貨-"+photorownum+"-"+sdFormat.format(date);
       break;
      }
      break;
     case "3":
      switch(item_type){
      case "1":
       ItemName="WebDriverTorso-多顏多尺商品借貨-"+photorownum+"-"+sdFormat.format(date);
       break;
      case "3":
       ItemName="WebDriverTorso-多顏多尺商品轉單-"+photorownum+"-"+sdFormat.format(date);
       break;
      default:
       ItemName="WebDriverTorso-多顏多尺商品借貨-"+photorownum+"-"+sdFormat.format(date);
       break;
      }
      break;
     default:
      ItemName="WebDriverTorso-單一商品借貨-"+photorownum+"-"+sdFormat.format(date);
      break;
    }
  System.out.println("設定商品名稱：'"+ItemName+"';");
    driver.findElement(By.cssSelector(".input-product-name")).sendKeys(ItemName);
    //設定借貨轉單
    switch(item_type){
    case "1":
     System.out.println("點擊借貨;");
     driver.findElement(By.id("warehouse")).click();
     break;
    case "3":
     System.out.println("點擊轉單;");
     driver.findElement(By.id("change")).click();
     break;
    }    Thread.sleep(1000);
 }
 /*
  * 設定群組分類
  */
 public void SetCategory(){
    //設定群組分類
    //計算第一層有幾個
  Random ran=new Random();
  int count1=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select/option"))-1;
    //定義隨機的選項數字
    int ran1=ran.nextInt(count1)+1;
    System.out.print("選擇群組分類:");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).click();
    for(int i=1;i<=ran1;i++){
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ARROW_DOWN);
    }
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ENTER);
    if(ran1<=count1){ran1=ran1+1;}
    String Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getText();
    System.out.print(Name);
    //選擇第二層以下的群族分類
    int counti;
    int rani;
    String data_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getAttribute("data_type");
    for(int i=2;i<10;i++){
     if("1".equals(data_type)){
      System.out.print(">");
      //計算該層總數
        counti=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option"))-1;
        if(counti==0){break;}
        //點擊該層
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).click();
      //移動到第亂數個
      rani=ran.nextInt(counti)+1;
      for(int x=1;x<=rani;x++){
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ARROW_DOWN);
      }
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ENTER);
      if(rani<=counti){rani=rani+1;}
      //取得第亂數個名稱
      Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getText();
      //印出地亂數個名稱
      System.out.print(Name);
      //取得地亂數個是否為群組分類:1群組2分類
      data_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getAttribute("data_type");
     }
    }
    System.out.println(";");
 }
 public void SetCategory(String spec_type) throws Exception{
  String wb_spec_type="0";
  String spec_type_name;
  switch(spec_type){
 case "1":
    spec_type_name="多顏色";
    break;
   case "2":
    spec_type_name="多顏多尺";
    break;
   default:
    spec_type_name="多顏色";
    break;
  }
  do{
 //設定群組分類
     //計算第一層有幾個
   Random ran=new Random();
   int count1;
     count1=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select/option"))-1;
     //定義隨機的選項數字
     int ran1=ran.nextInt(count1)+1;
     System.out.print("選擇群組分類:");
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).click();
     for(int i=1;i<=ran1;i++){
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ARROW_DOWN);
     }
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ENTER);
     if(ran1<=count1){ran1=ran1+1;}
     String Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getText();
     System.out.print(Name);
     //選擇第二層以下的群族分類
     int counti;
     int rani;
     String data_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getAttribute("data_type");
     for(int i=2;i<10;i++){
      if("1".equals(data_type)){
       System.out.print(">");
       //計算該層總數
         counti=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option"))-1;
         if(counti==0){break;}
         //點擊該層
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).click();
       //移動到第亂數個
       rani=ran.nextInt(counti)+1;
       for(int x=1;x<=rani;x++){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ARROW_DOWN);
       }
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ENTER);
       if(rani<=counti){rani=rani+1;}
       //取得第亂數個名稱
       Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getText();
       //印出地亂數個名稱
       System.out.print(Name);
       //取得地亂數個是否為群組分類:1群組2分類
       data_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getAttribute("data_type");
       wb_spec_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getAttribute("spec_type");
      }
     }
    System.out.println(";");
     Thread.sleep(3000);
     //判斷是否可以新增多顏色或是多尺寸商品
     if(!spec_type.equals(wb_spec_type)){
      System.out.println("分類'"+Name+"'不可以新增"+spec_type_name+"商品重新選擇分類群組;");
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option[1]")).click();
      Thread.sleep(3000);
     }
  }while(!spec_type.equals(wb_spec_type));
 }
 /*
  * 設定供貨商
  */
 public void SetSup(){//隨機一家
    driver.findElement(By.id("supplier_search")).sendKeys(String.valueOf((char)((int)(Math.random()*26)+65)));
    Random ran=new Random();
    int countsup=WebDriverMan.CountXpath(driver,By.xpath("/html/body/ul/li"));
    int ransup=ran.nextInt(countsup)+1;
    for(int i=1;i<=ransup;i++){
     driver.findElement(By.id("supplier_search")).sendKeys(Keys.ARROW_DOWN);
    }
    System.out.println("選擇廠商:"+driver.findElement(By.xpath("/html/body/ul/li["+ransup+"]/a")).getText()+";");
    driver.findElement(By.id("supplier_search")).sendKeys(Keys.ENTER);
 }
 public void SetSup(String Temp_Supseq){//指定一家
    driver.findElement(By.id("supplier_search")).sendKeys(Temp_Supseq);
    System.out.println("選擇廠商:"+driver.findElement(By.xpath("/html/body/ul/li[1]/a")).getText()+";");
    driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click(); 
 }
 /*
  * 設定圖片
  */
 public void SetPhoto() throws Exception{
  Thread.sleep(5000);
  System.out.println("點擊上傳圖片;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[1]/div[1]/div[1]/a[1]/span")).click();
    Thread.sleep(2000);
    System.out.println("選擇第"+photorownum+"號圖片上傳;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[1]/div[1]/div[1]/a[1]/span/input")).sendKeys("C:\\Users\\york.lin\\Pictures\\webdriber_torse\\"+photorownum+".jpg");
    System.out.println("上傳圖片;");
    Thread.sleep(3000);
    //將上傳的檔案總館關掉
    System.out.println("關閉上傳圖片視窗;");
    RobotMan.keyPressWithAlt(robot,KeyEvent.VK_F4);
    Thread.sleep(3000);
 }
/*
  * 設定價錢
  */
 public void SetPrice() throws Exception{//預設價錢
  Random ran=new Random();
  int A=ran.nextInt(99999999)+1;
  int B=ran.nextInt(99999999)+1;
  while(B>A){
   B=ran.nextInt(99999999)+1;
  }
  String Temp_Cost=String.valueOf(A);
  String Temp_Price=String.valueOf(B);
  
  driver.findElement(By.id("it_mprice")).sendKeys(Temp_Cost);
  System.out.println("設定市價:"+Temp_Cost+";");
    driver.findElement(By.id("sm_price")).sendKeys(Temp_Price);
    System.out.println("設定售價:"+Temp_Price+";");
    
    RobotMan.keyPress(robot,KeyEvent.VK_TAB);
    //String [] sm_price=new String[Temp_Price.length()];
    //String [] sm_price_last=new String[8-Temp_Price.length()];
    for(int i=1;i<=(8-Temp_Price.length());i++){
     RobotMan.keyPress(robot,KeyEvent.VK_0);
    }
    for(int i=1;i<=Temp_Price.length();i++){
     switch(Temp_Price.substring(i-1,i)){
     case "0":
      RobotMan.keyPress(robot,KeyEvent.VK_0);
      break;
     case "1":
      RobotMan.keyPress(robot,KeyEvent.VK_1);
      break;
     case "2":
      RobotMan.keyPress(robot,KeyEvent.VK_2);
      break;
     case "3":
      RobotMan.keyPress(robot,KeyEvent.VK_3);
      break;
     case "4":
      RobotMan.keyPress(robot,KeyEvent.VK_4);
      break;
     case "5":
      RobotMan.keyPress(robot,KeyEvent.VK_5);
      break;
     case "6":
      RobotMan.keyPress(robot,KeyEvent.VK_6);
      break;
     case "7":
      RobotMan.keyPress(robot,KeyEvent.VK_7);
      break;
     case "8":
      RobotMan.keyPress(robot,KeyEvent.VK_8);
      break;
     case "9":
      RobotMan.keyPress(robot,KeyEvent.VK_9);
      break;
     }
    }
    Thread.sleep(1000);
 }
public void SetPrice(String Temp_Cost,String Temp_Price) throws Exception{//指定價錢
  driver.findElement(By.id("it_mprice")).sendKeys(Temp_Cost);
  System.out.println("設定市價:"+Temp_Cost+";");
    driver.findElement(By.id("sm_price")).sendKeys(Temp_Price);
    System.out.println("設定售價:"+Temp_Price+";");
    RobotMan.keyPress(robot,KeyEvent.VK_TAB);
    //String [] sm_price=new String[Temp_Price.length()];
    //String [] sm_price_last=new String[8-Temp_Price.length()];
    for(int i=1;i<=(8-Temp_Price.length());i++){
     RobotMan.keyPress(robot,KeyEvent.VK_0);
    }
    for(int i=1;i<=Temp_Price.length();i++){
     switch(Temp_Price.substring(i-1,i)){
     case "0":
      RobotMan.keyPress(robot,KeyEvent.VK_0);
      break;
     case "1":
      RobotMan.keyPress(robot,KeyEvent.VK_1);
      break;
     case "2":
      RobotMan.keyPress(robot,KeyEvent.VK_2);
      break;
     case "3":
      RobotMan.keyPress(robot,KeyEvent.VK_3);
      break;
     case "4":
      RobotMan.keyPress(robot,KeyEvent.VK_4);
      break;
     case "5":
      RobotMan.keyPress(robot,KeyEvent.VK_5);
      break;
     case "6":
      RobotMan.keyPress(robot,KeyEvent.VK_6);
      break;
     case "7":
      RobotMan.keyPress(robot,KeyEvent.VK_7);
      break;
     case "8":
      RobotMan.keyPress(robot,KeyEvent.VK_8);
      break;
     case "9":
      RobotMan.keyPress(robot,KeyEvent.VK_9);
      break;
     }
    }
    Thread.sleep(1000);
 }
 /*
  * 設定商品說明
  */
public void SetItemContent() throws Exception{//預設輸入"1"
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/div[1]/div/ol[1]/li/iframe")).click();
  RobotMan.keyPress(robot,KeyEvent.VK_1);
  System.out.println("輸入商品說明:1");
  Thread.sleep(1000);
 }
 public void SetItemContent(String Temp_Content) throws Exception{//指定輸入內容不能用
  for(int i=1;i<=16;i++){
   RobotMan.keyPress(robot,KeyEvent.VK_TAB);
   System.out.println(i);
  }
  driver.findElement(By.xpath("/html/body/div")).sendKeys(Temp_Content);;
  System.out.println("輸入商品說明:"+Temp_Content);
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/h3")).click();
  Thread.sleep(1000);
 }
 /*
  * 設定保固維修聯絡資訊
  */
 public void SetWarranty(){
    System.out.println("設定是否有保固:無;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/div[5]/div/div[1]/input[2]")).click();
    System.out.println("設定維修聯絡資訊:無;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/div[5]/div/div[2]/input[2]")).click();
 }
 /*
  * 設定長寬高
  */
 public void SetLWHL(){//預設長寬高
  System.out.print("預設長寬高:");
  if(isElementPresent(By.id("item_length"))){
   System.out.print("長-1");
   driver.findElement(By.id("item_length")).sendKeys("1");
   System.out.print(",寬-1");
   driver.findElement(By.id("item_width")).sendKeys("1");
   System.out.print(",高-1");
   driver.findElement(By.id("item_height")).sendKeys("1");
   System.out.print(",重量-1;");
   driver.findElement(By.id("item_weight")).sendKeys("1");
  }else{
   System.out.println("不用設定;");
  }
 }
 public void SetLWHL(String Temp_Length,String Temp_Width,String Temp_Height,String Temp_Weight){//指定長寬高
  System.out.print("設定長寬高:");
  if(isElementPresent(By.id("item_length"))){
   System.out.print("長-"+Temp_Length);
   driver.findElement(By.id("item_length")).sendKeys(Temp_Length);
   System.out.print(",寬-"+Temp_Width);
   driver.findElement(By.id("item_width")).sendKeys(Temp_Width);
   System.out.print(",高-"+Temp_Height);
   driver.findElement(By.id("item_height")).sendKeys(Temp_Height);
   System.out.print(",重量-;"+Temp_Weight);
   driver.findElement(By.id("item_weight")).sendKeys(Temp_Weight);
  }else{
   System.out.println("不用設定;");
  }
 }
/*
  *設定屬性值
  */
 public void Attribute() throws Exception{
  System.out.print("設定屬性:");
  if(isElementPresent(By.xpath("//*[contains(@class, 'attrlist attributebox')]"))){
   int countAtrr=WebDriverMan.CountXpath(driver,By.xpath("//*[contains(@class, 'attrlist attributebox')]"));
     System.out.print("有"+countAtrr+"個不需要");
     for(int countnum=1;countnum<=countAtrr;countnum++){
      System.out.print(",設定第"+countnum+"個不需要");
      driver.findElement(By.xpath("//*[@class='attrlist attributebox']["+countnum+"]/input")).click();
      Thread.sleep(1000);
     }
     System.out.println(";");
  }else{
   System.out.println("不用設定;");
  }
 }
}
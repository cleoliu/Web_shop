package Help;import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.awt.event.KeyEvent;
import Help.RobotMan;
import Help.WebDriverMan;public class AddHelp extends Uitox{
 /*
  * �h�s�W����
  */
 public void GoToAdd() throws Exception{
  //�]�w�s����
  SetBrowser("f");
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
    System.out.println("�I���s�W����;");
    driver.findElement(By.linkText("�s�W�ӫ~(�浧/�j�q)")).click();
 }
 /*
  * �]�w�ӫ~�W��
  * name_type:1.��@�ӫ~2.�h�C��ӫ~3.�h�C�h�ذӫ~
  * item_type:1.�ɳf3.���
  */
 public int photorownum;
 public void SetItemNameType(String name_type,String item_type) throws Exception{
  //�]�w�ӫ~�W��
    SimpleDateFormat sdFormat=new SimpleDateFormat("yyyyMMdd-hhmm");
    Date date=new Date ();
    String ItemName;
    Random ran=new Random();
    photorownum=ran.nextInt(11)+1;
    switch(name_type){
     case "1":
      switch(item_type){
       case "1":
        ItemName="WebDriverTorso-��@�ӫ~�ɳf-"+photorownum+"-"+sdFormat.format(date);
        break;
       case "3":
        ItemName="WebDriverTorso-��@�ӫ~���-"+photorownum+"-"+sdFormat.format(date);
        break;
       default:
        ItemName="WebDriverTorso-��@�ӫ~�ɳf-"+photorownum+"-"+sdFormat.format(date);
        break;
      }
      break;
     case "2":
      switch(item_type){
      case "1":
       ItemName="WebDriverTorso-�h�C��ӫ~�ɳf-"+photorownum+"-"+sdFormat.format(date);
       break;
      case "3":
       ItemName="WebDriverTorso-�h�C��ӫ~���-"+photorownum+"-"+sdFormat.format(date);
       break;
      default:
       ItemName="WebDriverTorso-�h�C��ӫ~�ɳf-"+photorownum+"-"+sdFormat.format(date);
       break;
      }
      break;
     case "3":
      switch(item_type){
      case "1":
       ItemName="WebDriverTorso-�h�C�h�ذӫ~�ɳf-"+photorownum+"-"+sdFormat.format(date);
       break;
      case "3":
       ItemName="WebDriverTorso-�h�C�h�ذӫ~���-"+photorownum+"-"+sdFormat.format(date);
       break;
      default:
       ItemName="WebDriverTorso-�h�C�h�ذӫ~�ɳf-"+photorownum+"-"+sdFormat.format(date);
       break;
      }
      break;
     default:
      ItemName="WebDriverTorso-��@�ӫ~�ɳf-"+photorownum+"-"+sdFormat.format(date);
      break;
    }
  System.out.println("�]�w�ӫ~�W�١G'"+ItemName+"';");
    driver.findElement(By.cssSelector(".input-product-name")).sendKeys(ItemName);
    //�]�w�ɳf���
    switch(item_type){
    case "1":
     System.out.println("�I���ɳf;");
     driver.findElement(By.id("warehouse")).click();
     break;
    case "3":
     System.out.println("�I�����;");
     driver.findElement(By.id("change")).click();
     break;
    }    Thread.sleep(1000);
 }
 /*
  * �]�w�s�դ���
  */
 public void SetCategory(){
    //�]�w�s�դ���
    //�p��Ĥ@�h���X��
  Random ran=new Random();
  int count1=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select/option"))-1;
    //�w�q�H�����ﶵ�Ʀr
    int ran1=ran.nextInt(count1)+1;
    System.out.print("��ܸs�դ���:");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).click();
    for(int i=1;i<=ran1;i++){
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ARROW_DOWN);
    }
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ENTER);
    if(ran1<=count1){ran1=ran1+1;}
    String Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getText();
    System.out.print(Name);
    //��ܲĤG�h�H�U���s�ڤ���
    int counti;
    int rani;
    String data_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getAttribute("data_type");
    for(int i=2;i<10;i++){
     if("1".equals(data_type)){
      System.out.print(">");
      //�p��Ӽh�`��
        counti=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option"))-1;
        if(counti==0){break;}
        //�I���Ӽh
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).click();
      //���ʨ�Ķüƭ�
      rani=ran.nextInt(counti)+1;
      for(int x=1;x<=rani;x++){
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ARROW_DOWN);
      }
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ENTER);
      if(rani<=counti){rani=rani+1;}
      //���o�ĶüƭӦW��
      Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getText();
      //�L�X�a�üƭӦW��
      System.out.print(Name);
      //���o�a�üƭӬO�_���s�դ���:1�s��2����
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
    spec_type_name="�h�C��";
    break;
   case "2":
    spec_type_name="�h�C�h��";
    break;
   default:
    spec_type_name="�h�C��";
    break;
  }
  do{
 //�]�w�s�դ���
     //�p��Ĥ@�h���X��
   Random ran=new Random();
   int count1;
     count1=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select/option"))-1;
     //�w�q�H�����ﶵ�Ʀr
     int ran1=ran.nextInt(count1)+1;
     System.out.print("��ܸs�դ���:");
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).click();
     for(int i=1;i<=ran1;i++){
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ARROW_DOWN);
     }
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span/select")).sendKeys(Keys.ENTER);
     if(ran1<=count1){ran1=ran1+1;}
     String Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getText();
     System.out.print(Name);
     //��ܲĤG�h�H�U���s�ڤ���
     int counti;
     int rani;
     String data_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option["+ran1+"]")).getAttribute("data_type");
     for(int i=2;i<10;i++){
      if("1".equals(data_type)){
       System.out.print(">");
       //�p��Ӽh�`��
         counti=WebDriverMan.CountXpath(driver,By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option"))-1;
         if(counti==0){break;}
         //�I���Ӽh
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).click();
       //���ʨ�Ķüƭ�
       rani=ran.nextInt(counti)+1;
       for(int x=1;x<=rani;x++){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ARROW_DOWN);
       }
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select")).sendKeys(Keys.ENTER);
       if(rani<=counti){rani=rani+1;}
       //���o�ĶüƭӦW��
       Name=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getText();
       //�L�X�a�üƭӦW��
       System.out.print(Name);
       //���o�a�üƭӬO�_���s�դ���:1�s��2����
       data_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getAttribute("data_type");
       wb_spec_type=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span["+i+"]/select/option["+rani+"]")).getAttribute("spec_type");
      }
     }
    System.out.println(";");
     Thread.sleep(3000);
     //�P�_�O�_�i�H�s�W�h�C��άO�h�ؤo�ӫ~
     if(!spec_type.equals(wb_spec_type)){
      System.out.println("����'"+Name+"'���i�H�s�W"+spec_type_name+"�ӫ~���s��ܤ����s��;");
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[1]/ul[3]/li[2]/div[2]/span/span[1]/select/option[1]")).click();
      Thread.sleep(3000);
     }
  }while(!spec_type.equals(wb_spec_type));
 }
 /*
  * �]�w�ѳf��
  */
 public void SetSup(){//�H���@�a
    driver.findElement(By.id("supplier_search")).sendKeys(String.valueOf((char)((int)(Math.random()*26)+65)));
    Random ran=new Random();
    int countsup=WebDriverMan.CountXpath(driver,By.xpath("/html/body/ul/li"));
    int ransup=ran.nextInt(countsup)+1;
    for(int i=1;i<=ransup;i++){
     driver.findElement(By.id("supplier_search")).sendKeys(Keys.ARROW_DOWN);
    }
    System.out.println("��ܼt��:"+driver.findElement(By.xpath("/html/body/ul/li["+ransup+"]/a")).getText()+";");
    driver.findElement(By.id("supplier_search")).sendKeys(Keys.ENTER);
 }
 public void SetSup(String Temp_Supseq){//���w�@�a
    driver.findElement(By.id("supplier_search")).sendKeys(Temp_Supseq);
    System.out.println("��ܼt��:"+driver.findElement(By.xpath("/html/body/ul/li[1]/a")).getText()+";");
    driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click(); 
 }
 /*
  * �]�w�Ϥ�
  */
 public void SetPhoto() throws Exception{
  Thread.sleep(5000);
  System.out.println("�I���W�ǹϤ�;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[1]/div[1]/div[1]/a[1]/span")).click();
    Thread.sleep(2000);
    System.out.println("��ܲ�"+photorownum+"���Ϥ��W��;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[1]/div[1]/div[1]/a[1]/span/input")).sendKeys("C:\\Users\\york.lin\\Pictures\\webdriber_torse\\"+photorownum+".jpg");
    System.out.println("�W�ǹϤ�;");
    Thread.sleep(3000);
    //�N�W�Ǫ��ɮ��`�]����
    System.out.println("�����W�ǹϤ�����;");
    RobotMan.keyPressWithAlt(robot,KeyEvent.VK_F4);
    Thread.sleep(3000);
 }
/*
  * �]�w����
  */
 public void SetPrice() throws Exception{//�w�]����
  Random ran=new Random();
  int A=ran.nextInt(99999999)+1;
  int B=ran.nextInt(99999999)+1;
  while(B>A){
   B=ran.nextInt(99999999)+1;
  }
  String Temp_Cost=String.valueOf(A);
  String Temp_Price=String.valueOf(B);
  
  driver.findElement(By.id("it_mprice")).sendKeys(Temp_Cost);
  System.out.println("�]�w����:"+Temp_Cost+";");
    driver.findElement(By.id("sm_price")).sendKeys(Temp_Price);
    System.out.println("�]�w���:"+Temp_Price+";");
    
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
public void SetPrice(String Temp_Cost,String Temp_Price) throws Exception{//���w����
  driver.findElement(By.id("it_mprice")).sendKeys(Temp_Cost);
  System.out.println("�]�w����:"+Temp_Cost+";");
    driver.findElement(By.id("sm_price")).sendKeys(Temp_Price);
    System.out.println("�]�w���:"+Temp_Price+";");
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
  * �]�w�ӫ~����
  */
public void SetItemContent() throws Exception{//�w�]��J"1"
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/div[1]/div/ol[1]/li/iframe")).click();
  RobotMan.keyPress(robot,KeyEvent.VK_1);
  System.out.println("��J�ӫ~����:1");
  Thread.sleep(1000);
 }
 public void SetItemContent(String Temp_Content) throws Exception{//���w��J���e�����
  for(int i=1;i<=16;i++){
   RobotMan.keyPress(robot,KeyEvent.VK_TAB);
   System.out.println(i);
  }
  driver.findElement(By.xpath("/html/body/div")).sendKeys(Temp_Content);;
  System.out.println("��J�ӫ~����:"+Temp_Content);
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/h3")).click();
  Thread.sleep(1000);
 }
 /*
  * �]�w�O�T�����p����T
  */
 public void SetWarranty(){
    System.out.println("�]�w�O�_���O�T:�L;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/div[5]/div/div[1]/input[2]")).click();
    System.out.println("�]�w�����p����T:�L;");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div/div[2]/div[2]/div[5]/div/div[2]/input[2]")).click();
 }
 /*
  * �]�w���e��
  */
 public void SetLWHL(){//�w�]���e��
  System.out.print("�w�]���e��:");
  if(isElementPresent(By.id("item_length"))){
   System.out.print("��-1");
   driver.findElement(By.id("item_length")).sendKeys("1");
   System.out.print(",�e-1");
   driver.findElement(By.id("item_width")).sendKeys("1");
   System.out.print(",��-1");
   driver.findElement(By.id("item_height")).sendKeys("1");
   System.out.print(",���q-1;");
   driver.findElement(By.id("item_weight")).sendKeys("1");
  }else{
   System.out.println("���γ]�w;");
  }
 }
 public void SetLWHL(String Temp_Length,String Temp_Width,String Temp_Height,String Temp_Weight){//���w���e��
  System.out.print("�]�w���e��:");
  if(isElementPresent(By.id("item_length"))){
   System.out.print("��-"+Temp_Length);
   driver.findElement(By.id("item_length")).sendKeys(Temp_Length);
   System.out.print(",�e-"+Temp_Width);
   driver.findElement(By.id("item_width")).sendKeys(Temp_Width);
   System.out.print(",��-"+Temp_Height);
   driver.findElement(By.id("item_height")).sendKeys(Temp_Height);
   System.out.print(",���q-;"+Temp_Weight);
   driver.findElement(By.id("item_weight")).sendKeys(Temp_Weight);
  }else{
   System.out.println("���γ]�w;");
  }
 }
/*
  *�]�w�ݩʭ�
  */
 public void Attribute() throws Exception{
  System.out.print("�]�w�ݩ�:");
  if(isElementPresent(By.xpath("//*[contains(@class, 'attrlist attributebox')]"))){
   int countAtrr=WebDriverMan.CountXpath(driver,By.xpath("//*[contains(@class, 'attrlist attributebox')]"));
     System.out.print("��"+countAtrr+"�Ӥ��ݭn");
     for(int countnum=1;countnum<=countAtrr;countnum++){
      System.out.print(",�]�w��"+countnum+"�Ӥ��ݭn");
      driver.findElement(By.xpath("//*[@class='attrlist attributebox']["+countnum+"]/input")).click();
      Thread.sleep(1000);
     }
     System.out.println(";");
  }else{
   System.out.println("���γ]�w;");
  }
 }
}
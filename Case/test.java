package Case;import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import Help.ItemHelp;public class test extends ItemHelp{
  private boolean acceptNextAlert=true;
  private StringBuffer verificationErrors=new StringBuffer();
 
  @Before
  public void setUp() throws Exception {
   //�]�w�ϰ�
   Area("a");
   //�]�w��a
   Country("tw");
   //�]�w�s����
   SetBrowser("firefox");
   //�۰ʶ]�ܰӫ~�C��
   GoToItem();
  }  @Test
  public void ItemName() throws Exception {
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")).sendKeys(Keys.ARROW_RIGHT);
  
   Thread.sleep(10000);
  }  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString=verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }}
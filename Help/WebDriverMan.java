package Help;import java.util.List;import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;public class WebDriverMan {
 //�p��Xpath�ƶq        CountXpath(driver,By.xpath("���|"));
 public static int CountXpath(WebDriver driver,By Temp_Xpath){
    List��WebElement�� located_elements=driver.findElements(Temp_Xpath);
    int countxpath=0;
    for(WebElement located_element :located_elements){
     countxpath++;
    }
    return countxpath;
 }
 //�u�ʺu�b�ܤ��� �����s�����W�t        WindowScrollTop(driver,By.xpath("���|"));
 public static void WindowScrollTop(WebDriver driver,By by)  {
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
 }
 //�u�ʺu�b�ܤ��� �����s�����U�t        WindowScrollBottom(driver,By.xpath("���|"));
 public static void WindowScrollBottom(WebDriver driver,By by)  {
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(by));
 }}
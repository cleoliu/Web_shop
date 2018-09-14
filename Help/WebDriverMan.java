package Help;import java.util.List;import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;public class WebDriverMan {
 //計算Xpath數量        CountXpath(driver,By.xpath("路徑"));
 public static int CountXpath(WebDriver driver,By Temp_Xpath){
    List＜WebElement＞ located_elements=driver.findElements(Temp_Xpath);
    int countxpath=0;
    for(WebElement located_element :located_elements){
     countxpath++;
    }
    return countxpath;
 }
 //滾動滾軸至元素 切齊瀏覽器上緣        WindowScrollTop(driver,By.xpath("路徑"));
 public static void WindowScrollTop(WebDriver driver,By by)  {
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
 }
 //滾動滾軸至元素 切齊瀏覽器下緣        WindowScrollBottom(driver,By.xpath("路徑"));
 public static void WindowScrollBottom(WebDriver driver,By by)  {
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(by));
 }}
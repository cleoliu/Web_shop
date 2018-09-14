package Help;import java.awt.Robot;
import java.awt.event.KeyEvent;public class RobotMan {
 //按什麼按鈕
 public static void keyPress(Robot r , int key){
  r.keyPress(key);
  r.keyRelease(key);
  r.delay(100);
 }
 //Alt+什麼按鈕
 public static void keyPressWithAlt(Robot r , int key){
  r.keyPress(KeyEvent.VK_ALT);
  r.keyPress(key);
  r.keyRelease(key);
  r.keyRelease(KeyEvent.VK_ALT);
  r.delay(100);
 }
 //CONTROL+什麼按鈕
 public static void keyPressWithCtrl(Robot r , int key){
  r.keyPress(KeyEvent.VK_CONTROL);
  r.keyPress(key);
  r.keyRelease(key);
  r.keyRelease(KeyEvent.VK_CONTROL);
  r.delay(100);
 }
}
package Help;import java.text.NumberFormat;public class BasicMan {
 //String(小數)轉(百分比)   StrDotToPercent(字串,小數點後留幾位)
 public static String StrDotToPercent(String SM_MARGIN,int dots) {
  NumberFormat DotToPercent=NumberFormat.getPercentInstance();
  DotToPercent.setMaximumFractionDigits(dots);
  String StrDotToPercent=String.valueOf(DotToPercent.format(Double.parseDouble(SM_MARGIN)));
  return StrDotToPercent;
 }
}
package Help;import java.text.NumberFormat;public class BasicMan {
 //String(�p��)��(�ʤ���)   StrDotToPercent(�r��,�p���I��d�X��)
 public static String StrDotToPercent(String SM_MARGIN,int dots) {
  NumberFormat DotToPercent=NumberFormat.getPercentInstance();
  DotToPercent.setMaximumFractionDigits(dots);
  String StrDotToPercent=String.valueOf(DotToPercent.format(Double.parseDouble(SM_MARGIN)));
  return StrDotToPercent;
 }
}
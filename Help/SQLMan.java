package Help;import java.sql.*;public class SQLMan {
 public String SQL_Area;
 public int total;
 public int total_seq;
 public int columncount;
 public int columncount_seq;
 public Connection conn;
 public String[][] target_seq;
 public String[][] target_info;
 
 public void connect(String _SQL_Area) throws Exception { // 連結資料庫
  SQL_Area=_SQL_Area;
  switch (SQL_Area) {
  case "A":
  case "a":
   System.out.println("連結A區DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:AORD", "UAORDWEB", "zyarhp3y");
   break;
  case "B":
  case "b":
   System.out.println("連結B區DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:BORD", "UBORDERP","j3yz6drscn");
   break;
  case "D":
  case "d":
   System.out.println("連結C區DB");+++++++++
Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:DORD", "UDORDERP","dBK7nYA8Ua");
   break;
  case "E":
  case "e":
   System.out.println("連結D區DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:EORD", "UEORDERP","PvpnXIAayq");
   break;
  case "F":
  case "f":
   System.out.println("連結E區DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:FORD", "UFORDERP","uW6jETVKSg");
   break;
  case "G":
  case "g":
   System.out.println("連結F區DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:UGORD", "UGORDWEB","hp5SdG6nnQ");
   break;
  } } public void showMainCross_Appoint(String _sm_seq) throws Exception { //外站賣列表指定
  // 讀取賣場資訊
  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
  ResultSet rs=stmt.executeQuery(
 "SELECT sm.SM_SEQ,                                                                      "//1-1   賣場ID
+"       sm.SM_STATUS,                                                                   "//1-2   顯示ON/OFF +++++++++++++
+"      sm.SM_PIC,                                                                     "//1-3  賣場圖片
+"       sm.SM_NAME,                                                                     "//1-4   賣場名稱
+"       sm.SM_PRICE,                                                                    "//1-5   售價
+"       sm.SM_COST,                                                                     "//1-6   進貨價
+"       sm.SM_MARGIN,                                                                   "//1-7   毛利率(小數)
+"       sm.SSM_TYPE,                                                                    "//1-8   特賣變價型態(1:特賣變價/2:折扣)
+"       sm.OWNER_NO,                                                                    "//1-9   所屬PM
+"       sm.IS_ORGI_ITEM,                                                                "//1-10(0:組合賣場/1:原生賣場/2:購物車加購賣場)
+"       sm.WS_SEQ,                                                                      "//1-11平台編號
+"       sm.SOURCE_MODE,                                                                 "//1-12平台類型(1:B2C / 2:Inside / 3: 代出貨)
+"       sm.IS_LIMIT_QTY,                                                                "//1-13是否限制可賣量/限購量 (0:不限制 / 1:PM設定 / 2:廠商設定 / 3:PM廠商皆設定)
+"       sm.SM_MAX_SALEQTY,                                                              "//1-14PM設定最大銷售量
+"       sm.SM_SUP_MAX_SALEQTY,                                                          "//1-15廠商設定最大銷售量
+"       sm.SM_SEARCH_SORT,                                                              "//1-16館頁自訂排序(排序由大到小)
+"       sm.ISLIFEEXPIRED,                                                               "//1-17是否不再使用日期(0:否/1:是)
+"       TO_CHAR(sm.INS_DT, 'YYYY/MM/DD HH24:MI') AS INS_DT,                             "//1-18新增時間
+"       TO_CHAR(sm.MOD_DT, 'YYYY/MM/DD HH24:MI') AS MOD_DT,                             "//1-19修改時間+++++++++++
+"      TO_CHAR(sm.SSM_EN_DT, 'YYYY/MM/DD hh24:mi:ss') AS SSM_EN_DT,                   "//1-20活動結束時間
+"       TO_CHAR(sm.DISABLE_SORT_DT, 'YYYY/MM/DD') AS DISABLE_SORT_DT,                   "//1-21館頁人工排序失效日期
+"       sm.IS_SELL_OVERSEA,                                                             "//1-22是否可賣海外(0:否/1:是)
+"       sd.SUP_SEQ,                                                                     "//1-23供應商編號
+"       (SELECT SUP_NAME                                                                "
+"          FROM UAORD.SUPPLIER                                                          "
+"         WHERE SUPPLIER.SUP_SEQ=sd.SUP_SEQ                                           "
+"           AND SUPPLIER.IS_DEFAULT=1) AS SUP_NAME,                                   "//1-24廠商名稱
+"       t_num.SPEC_COUNT,                                                               "//1-25規格數
+"       t_num.ITEM_MIN_SALEQTY,                                                         "//1-26最低可賣量
+"       i.COLOR,                                                                        "//1-27顏色
+"       i.IT_SIZE,                                                                      "//1-28尺寸
+"       i.IT_LARGE_VOLUME,                                                              "//1-29大材積旗標(0:否/1:是)
+"       i.ITNO,                                                                         "//1-30商品ID+++++++
+"      i.IT_IN_TYPE,                                                                  "//1-31購買模式(借貨:1/採購:2/轉單:3)
+"       i.IS_PRE_ORD,                                                                   "//1-32預購旗標
+"       i.SALEQTY,                                                                      "//1-33商品可賣量
+"       i.IT_COLOR_SEQ,                                                                 "//1-34商品顏色群組(同顏色)
+"       TO_CHAR(i.PRE_DT_E, 'YYYY/MM/DD hh24:mi:ss') AS PRE_DT_E,                       "//1-35預購訖
+"       (SELECT CP_NAME FROM UAORD.CATEGORY WHERE i.CP_SEQ=CATEGORY.CP_SEQ) AS CPNAME,"//1-36分類名稱
+"       (SELECT USR_NAME FROM UAORD.WUSR WHERE WUSR.USR_SEQ=sm.OWNER_NO) AS pm,       "//1-37PM使用者姓名
+"       (SELECT COUNT(ITNO)                                                             "
+"          FROM UAORD.SHOW_DETAIL                                                       "
+"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
+"           AND IS_ITNO_MAIN='0'                                                      "
+"           AND IT_TYPE IN (3, 4)                                                       "
+"           AND ISLIFEEXPIRED=0) AS GIFT_COUNT,                                       "//1-38贈品數
+"       (SELECT COUNT(ITNO)                                                             "
+"          FROM UAORD.SHOW_DETAIL                                                       "
+"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
+"           AND IS_ITNO_MAIN='0'                                                      "
+"           AND IT_TYPE=2                                                             "+++++++++
+"          AND ISLIFEEXPIRED=0) AS PLUS_PURCHASE_COUNT,                             "//1-39加購品數
+"       (SELECT GOODS_TYPE                                                              "
+"          FROM UAORD.WEBSITE_SET                                                       "
+"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS GOODS_TYPE,                          "//1-40平台商品類型(1:寄倉/2:轉單/3:寄倉+轉單)
+"       (SELECT WS_NAME                                                                 "
+"          FROM UAORD.WEBSITE_SET                                                       "
+"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS WS_NAME,                             "//1-41平台名稱
+"       CASE sm.INS_BY_WHO                                                              "
+"         WHEN '1' THEN                                                                 "
+"          (SELECT NAME                                                                 "
+"             FROM UAORD.SUPPLIER_USR                                                   "
+"            WHERE SUPPLIER_USR.SPPU_SEQ=sm.INS_USR_SEQ) || ' (廠商)'                  "
+"         WHEN '2' THEN                                                                 "
+"          (SELECT USR_NAME FROM UAORD.USR WHERE USR.USR_SEQ=sm.INS_USR_SEQ) ||       "
+"          ' (PM)'                                                                      "
+"         WHEN '4' THEN                                                                 "
+"          (SELECT USR_NAME                                                             "++++++++++
+"            FROM UAORD.WUSR                                                          "
+"            WHERE WUSR.USR_SEQ=sm.INS_USR_SEQ) || ' (PM)'                            "
+"         ELSE                                                                          "
+"          'SYSTEM'                                                                     "//新增人員的類型(0:其他/1:廠商/2:公司人員/3:系統)
+"       END AS USR,                                                                     "//1-42 新增人姓名
+"       (SELECT COUNT(*)                                                                "
+"          FROM UAORD.SHOW_FUSE_LOG                                                     "
+"         WHERE sm.SM_SEQ=SHOW_FUSE_LOG.SM_SEQ                                        "
+"           AND FUSE_STATUS=0) AS FUSE_STATUS                                         "//1-43 商品管理者是否已處理(0:否/1:是)
+"  FROM UAORD.SHOW_MAIN sm                                                              "
+" INNER JOIN UAORD.SHOW_DETAIL sd                                                       "
+"    ON sm.SM_SEQ=sd.SM_SEQ                                                           "
+" INNER JOIN UAORD.ITEM i                                                               "
+"    ON sd.ITNO=i.ITNO                                                                "
+"  LEFT JOIN (SELECT t_sm.SM_SEQ,                                                       "
+"                    COUNT(t_sm.SM_SEQ) AS SPEC_COUNT,                                  "
+"                    MIN(t_i.SALEQTY) AS ITEM_MIN_SALEQTY                               "+++++++++++
+"              FROM UAORD.SHOW_MAIN t_sm                                              "
+"              INNER JOIN UAORD.SHOW_DETAIL t_sd                                        "
+"                 ON t_sm.SM_SEQ=t_sd.SM_SEQ                                          "
+"              INNER JOIN UAORD.ITEM t_i                                                "
+"                 ON t_sd.ITNO=t_i.ITNO                                               "
+"              WHERE t_sm.SM_SEQ IN ('"+_sm_seq+"')                                "
+"                AND t_sm.ISLIFEEXPIRED=0                                             "
+"                AND t_sd.ISLIFEEXPIRED=0                                             "
+"                AND t_sd.IT_TYPE IN (1, 3, 4)                                          "
+"                AND NVL(t_sd.IS_MAIN_SPEC, 1)=1                                      "
+"              GROUP BY t_sm.SM_SEQ) t_num                                              "
+"    ON sm.SM_SEQ=t_num.SM_SEQ                                                        "
+" WHERE sm.SM_SEQ IN ('"+_sm_seq+"')                                               "
+"   AND sm.OWNER_NO='AL1096'                                                          "
+"   AND sd.IS_ITNO_MAIN=1                                                             "
+"   AND NVL(sd.IS_MAIN_SPEC, 1)=1                                                     "
+"   AND NVL(sd.SNO, 1)=1                                                              "++++++++
);
  // 取得資訊資料總數
  columncount=rs.getMetaData().getColumnCount();
  rs.last();
  total=rs.getRow();
  System.out.println("取得資訊共" + total + "筆資料" + columncount + "個欄位;");
  // 塞賣場資訊資料
  rs.beforeFirst();
  target_info=new String[total + 1][columncount + 1];
  for (int i=1;i ＜= total;i++) {
   rs.next();
   for (int x=1;x ＜= columncount;x++) {
    target_info[i][x]=String.valueOf(rs.getString(x));
    // 印出資訊測試腳本使用
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    System.out.println("target_info陣列" + i + "-" + x + ")" + target_info[i][x]);
   }
  }
  System.out.println("賣場資訊資料建立完成;");
  // 釋放資源
  rs.close();
  stmt.close();
  conn.close();
  System.out.println("釋放target_info資料庫資源;");
 } public void item_Appoint(String _itno) throws Exception { //商品列表指定
  // 讀取賣場資訊
  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
  ResultSet rs=stmt.executeQuery(
    "select i.itno,                                          ++++++++
 +"      i.it_pic,                                       "
         +"       i.itname,                                        "
         +"       i.color,                                         "
         +"       i.it_size,                                       "
         +"       i.it_cost,                                       "
         +"       i.input_tax,                                     "
         +"       i.output_tax,                                    "
         +"       i.saleqty,                                       "
         +"       i.is_pre_ord,                                    "
         +"       i.pre_ava_qty,                                   "
         +"       i.length,                                        "
         +"       i.width,                                         "
         +"       i.height,                                        "
         +"       i.weight,                                        "
         +"       i.is_cvs_pay,                                    "
         +"       c.cp_name,                                       "
         +"       i.it_in_type,                                    "
         +"       su.sup_name,                                     "
         +"       i.it_sern,                                       "
         +"       i.pre_dt_e                                       "
         +"  from uaord.item i                                     "
         +"  join uaord.category c                                 "
         +"    on i.cp_seq=c.cp_seq                              "
         +"  join uaord.supplier su                                "
         +"    on i.sup_seq=su.sup_seq                           "
         +" where i.itno in ('"+_itno+"')"++++++++
 );
  // 取得資訊資料總數
  columncount=rs.getMetaData().getColumnCount();
  rs.last();
  total=rs.getRow();
  System.out.println("取得資訊共" + total + "筆資料" + columncount + "個欄位;");
  // 塞賣場資訊資料
  rs.beforeFirst();
  target_info=new String[total + 1][columncount + 1];
  for (int i=1;i ＜= total;i++) {
   rs.next();
   for (int x=1;x ＜= columncount;x++) {
    target_info[i][x]=String.valueOf(rs.getString(x));
    // 印出資訊測試腳本使用
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    //System.out.println("item_info陣列" + i + "-" + x + ")" + target_info[i][x]);
   }
  }
  System.out.println("商品資料建立完成;");
  // 釋放資源
  rs.close();
  stmt.close();
  conn.close();
  System.out.println("釋放item_info資料庫資源;"); } public void showMain_Appoint(String _sm_seq) throws Exception { //賣場列表指定
  // 讀取賣場資訊
  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
  ResultSet rs=stmt.executeQuery(+++++++++
 "SELECT sm.SM_SEQ,                                                                     "//1-1  賣場ID
  +"       sm.SM_STATUS,                                                                   "//1-2   顯示ON/OFF
  +"       sm.SM_PIC,                                                                      "//1-3   賣場圖片
  +"       sm.SM_NAME,                                                                     "//1-4   賣場名稱
  +"       sm.SM_PRICE,                                                                    "//1-5   售價
  +"       sm.SM_COST,                                                                     "//1-6   進貨價
  +"       sm.SM_MARGIN,                                                                   "//1-7   毛利率(小數)
  +"       sm.SSM_TYPE,                                                                    "//1-8   特賣變價型態(1:特賣變價/2:折扣)
  +"       sm.OWNER_NO,                                                                    "//1-9   所屬PM
  +"       sm.IS_ORGI_ITEM,                                                                "//1-10(0:組合賣場/1:原生賣場/2:購物車加購賣場)
  +"       sm.WS_SEQ,                                                                      "//1-11平台編號
  +"       sm.SOURCE_MODE,                                                                 "//1-12平台類型(1:B2C/2:Inside/3: 代出貨)
  +"       sm.IS_LIMIT_QTY,                                                                "//1-13是否限制可賣量/限購量 (0:不限制 / 1:PM設定 / 2:廠商設定 / 3:PM廠商皆設定)
  +"       sm.SM_MAX_SALEQTY,                                                              "//1-14PM設定最大銷售量
  +"       sm.SM_SUP_MAX_SALEQTY,                                                          "//1-15廠商設定最大銷售量
  +"       sm.SM_SEARCH_SORT,                                                              "//1-16館頁自訂排序(排序由大到小)++++++++++
+"      sm.ISLIFEEXPIRED,                                                              "//1-17是否不再使用日期(0:否/1:是)
  +"       TO_CHAR(sm.INS_DT, 'YYYY/MM/DD HH24:MI') AS INS_DT,                             "//1-18新增時間
  +"       TO_CHAR(sm.MOD_DT, 'YYYY/MM/DD HH24:MI') AS MOD_DT,                             "//1-19修改時間
  +"       TO_CHAR(sm.SSM_EN_DT, 'YYYY/MM/DD hh24:mi:ss') AS SSM_EN_DT,                    "//1-20活動結束時間
  +"       TO_CHAR(sm.DISABLE_SORT_DT, 'YYYY/MM/DD') AS DISABLE_SORT_DT,                   "//1-21館頁人工排序失效日期
  +"       sm.IS_SELL_OVERSEA,                                                             "//1-22是否可賣海外(0:否/1:是)
  +"       sd.SUP_SEQ,                                                                     "//1-23供應商編號
  +"       (SELECT SUP_NAME                                                                "
  +"          FROM UAORD.SUPPLIER                                                          "
  +"         WHERE SUPPLIER.SUP_SEQ=sd.SUP_SEQ                                           "
  +"           AND SUPPLIER.IS_DEFAULT=1) AS SUP_NAME,                                   "//1-24廠商名稱
  +"       t_num.SPEC_COUNT,                                                               "//1-25規格數
  +"       t_num.ITEM_MIN_SALEQTY,                                                         "//1-26最低可賣量
  +"       i.COLOR,                                                                        "//1-27顏色+++++++++
+"      i.IT_SIZE,                                                                     "//1-28尺寸
  +"       i.IT_LARGE_VOLUME,                                                              "//1-29大材積旗標(0:否/1:是)
  +"       i.ITNO,                                                                         "//1-30商品ID
  +"       i.IT_IN_TYPE,                                                                   "//1-31購買模式(借貨:1/採購:2/轉單:3)
  +"       i.IS_PRE_ORD,                                                                   "//1-32預購旗標
  +"       i.SALEQTY,                                                                      "//1-33商品可賣量
  +"       i.IT_COLOR_SEQ,                                                                 "//1-34商品顏色群組(同顏色)
  +"       TO_CHAR(i.PRE_DT_E, 'YYYY/MM/DD hh24:mi:ss') AS PRE_DT_E,                       "//1-35預購訖
  +"       (SELECT CP_NAME FROM UAORD.CATEGORY WHERE i.CP_SEQ=CATEGORY.CP_SEQ) AS CPNAME,"//1-36分類名稱
  +"       (SELECT USR_NAME FROM UAORD.WUSR WHERE WUSR.USR_SEQ=sm.OWNER_NO) AS pm,       "//1-37PM使用者姓名
  +"       (SELECT COUNT(ITNO)                                                             "
  +"          FROM UAORD.SHOW_DETAIL                                                       "
  +"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
  +"           AND IS_ITNO_MAIN='0'                                                      "
  +"           AND IT_TYPE IN (3, 4)                                                       "
  +"           AND ISLIFEEXPIRED=0) AS GIFT_COUNT,                                       "//1-38贈品數+++++++=
+"      (SELECT COUNT(ITNO)                                                            "
  +"          FROM UAORD.SHOW_DETAIL                                                       "
  +"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
  +"           AND IS_ITNO_MAIN='0'                                                      "
  +"           AND IT_TYPE=2                                                             "
  +"           AND ISLIFEEXPIRED=0) AS PLUS_PURCHASE_COUNT,                              "//1-39加購品數
  +"       (SELECT GOODS_TYPE                                                              "
  +"          FROM UAORD.WEBSITE_SET                                                       "
  +"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS GOODS_TYPE,                          "//1-40平台商品類型(1:寄倉/2:轉單/3:寄倉+轉單)
  +"       (SELECT WS_NAME                                                                 "
  +"          FROM UAORD.WEBSITE_SET                                                       "
  +"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS WS_NAME,                             "//1-41平台名稱
  +"       CASE sm.INS_BY_WHO                                                              "
  +"         WHEN '1' THEN                                                                 "+++++++
+"         (SELECT NAME                                                                "
  +"             FROM UAORD.SUPPLIER_USR                                                   "
  +"            WHERE SUPPLIER_USR.SPPU_SEQ=sm.INS_USR_SEQ) || ' (廠商)'                  "
  +"         WHEN '2' THEN                                                                 "
  +"          (SELECT USR_NAME FROM UAORD.USR WHERE USR.USR_SEQ=sm.INS_USR_SEQ) ||       "
  +"          ' (PM)'                                                                      "
  +"         WHEN '4' THEN                                                                 "
  +"          (SELECT USR_NAME                                                             "
  +"             FROM UAORD.WUSR                                                           "
  +"            WHERE WUSR.USR_SEQ=sm.INS_USR_SEQ) || ' (PM)'                            "
  +"         ELSE                                                                          "
  +"          'SYSTEM'                                                                     "//新增人員的類型(0:其他/1:廠商/2:公司人員/3:系統)
  +"       END AS USR,                                                                     "//1-42 新增人姓名
  +"       (SELECT COUNT(*)                                                                "
  +"          FROM UAORD.SHOW_FUSE_LOG                                                     "
  +"         WHERE sm.SM_SEQ=SHOW_FUSE_LOG.SM_SEQ                                        "++++++++++
+"          AND FUSE_STATUS=0) AS FUSE_STATUS                                        "//1-43 商品管理者是否已處理(0:否/1:是)
  +"  FROM UAORD.SHOW_MAIN sm                                                              "
  +" INNER JOIN UAORD.SHOW_DETAIL sd                                                       "
  +"    ON sm.SM_SEQ=sd.SM_SEQ                                                           "
  +" INNER JOIN UAORD.ITEM i                                                               "
  +"    ON sd.ITNO=i.ITNO                                                                "
  +"  LEFT JOIN (SELECT t_sm.SM_SEQ,                                                       "
  +"                    COUNT(t_sm.SM_SEQ) AS SPEC_COUNT,                                  "
  +"                    MIN(t_i.SALEQTY) AS ITEM_MIN_SALEQTY                               "
  +"               FROM UAORD.SHOW_MAIN t_sm                                               "
  +"              INNER JOIN UAORD.SHOW_DETAIL t_sd                                        "
  +"                 ON t_sm.SM_SEQ=t_sd.SM_SEQ                                          "
  +"              INNER JOIN UAORD.ITEM t_i                                                "
  +"                 ON t_sd.ITNO=t_i.ITNO                                               "
  +"              WHERE t_sm.SM_SEQ IN ('"+_sm_seq+"')                                "
  +"                AND t_sm.ISLIFEEXPIRED=0                                             "+++++++
+"               AND t_sd.ISLIFEEXPIRED=0                                            "
  +"                AND t_sd.IT_TYPE IN (1, 3, 4)                                          "
  +"                AND NVL(t_sd.IS_MAIN_SPEC, 1)=1                                      "
  +"              GROUP BY t_sm.SM_SEQ) t_num                                              "
  +"    ON sm.SM_SEQ=t_num.SM_SEQ                                                        "
  +" WHERE sm.SM_SEQ IN ('"+_sm_seq+"')                                               "
  +"   AND sm.OWNER_NO='AL1096'                                                          "
  +"   AND sd.IS_ITNO_MAIN=1                                                             "
  +"   AND NVL(sd.IS_MAIN_SPEC, 1)=1                                                     "
  +"   AND NVL(sd.SNO, 1)=1                                                              "
        );
  // 取得資訊資料總數
  columncount=rs.getMetaData().getColumnCount();
  rs.last();
  total=rs.getRow();
  System.out.println("取得資訊共" + total + "筆資料" + columncount + "個欄位;");
  // 塞賣場資訊資料
  rs.beforeFirst();
  target_info=new String[total + 1][columncount + 1];
  for (int i=1;i ＜= total;i++) {
   rs.next();
   for (int x=1;x ＜= columncount;x++) {
    target_info[i][x]=String.valueOf(rs.getString(x));
    // 印出資訊測試腳本使用
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    //System.out.println("sm_info陣列" + i + "-" + x + ")" + target_info[i][x]);
   }
  }
  System.out.println("賣場資訊資料建立完成;");
  // 釋放資源+++++++++=
rs.close();
  stmt.close();
  conn.close();
  System.out.println("釋放sm_info資料庫資源;"); }
 
 public void showMainCross_RandomOne(String _uosite) throws Exception { // 外站賣列表隨機一筆
  // 隨機抽取一筆賣場ID
  System.out.println();
  System.out.println("隨機抽取一筆賣場ID;");
  System.out.println("開始下DB指令查詢SM_SEQ;");
  Statement stmt_seq=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet rs_seq=stmt_seq.executeQuery(
                "select * from "
            +"(select usml.sm_seq "
            +"from   uaord.uxout_show_main_list usml "
            +"join   uaord.show_main sm on usml.sm_seq=sm.sm_seq "
            +"where  usml.uo_site='"+_uosite+" '"
            +"and    usml.uo_itno != '_' "
            +"order by dbms_random.value) "
            +"where rownum＜=1"
);
  // 取得賣場ID總數
  columncount_seq=rs_seq.getMetaData().getColumnCount();
  rs_seq.last();
  total_seq=rs_seq.getRow();
  System.out.println("取得賣場ID共" + total_seq + "筆資料" + columncount_seq + "個欄位;");
  // 塞賣場ID資料
  rs_seq.beforeFirst();+++++++++
target_seq=new String[total_seq + 1][columncount_seq + 1];
  for (int i=1;i ＜= total_seq;i++) {
   rs_seq.next();
   for (int x=1;x ＜= columncount_seq;x++) {
    target_seq[i][x]=String.valueOf(rs_seq.getString(x));
    // 印出資訊測試腳本使用
    System.out.println("賣場編號陣列" + i + "-" + x + ")" + target_seq[i][x]);
   }
  }
  System.out.println("Seq資料建立完成;");
  // 釋放Seq資料庫資源
  rs_seq.close();
  stmt_seq.close();
  System.out.println("釋放target_seq資料庫資源;");
  String res_sm_seq="";
  for (int i=1;i ＜= total_seq;i++) {
   res_sm_seq=res_sm_seq + "'" + target_seq[i][1] + "',";
  }  System.out.println(res_sm_seq);
  showMainCross_Appoint(target_seq[1][1]);
 } public void item_RandomOne() throws Exception { // 商品列表隨機一筆
  // 取得DB資料
  System.out.println("開始下指令;");
  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet rs=stmt.executeQuery(
       "select *                                                 "++++++++++
 +"                  from (select sd.itno                "
       +"                           from uaord.show_detail sd    "
       +"                           join uaord.show_main sm      "
       +"                             on sd.sm_seq=sm.sm_seq   "
       +"                          where sm.islifeexpired='0'  "
       +"                            and sm.IS_ORGI_ITEM='1'   "
       +"                            and sm.owner_no='AL1096'  "
       +"                            and sm.ws_seq='AW000001'  "
       +"                            and sd.IS_ITNO_MAIN='1'   "
       +"                            and sd.IT_TYPE='1'        "
       +"                          order by dbms_random.value)   "
       +"                  where rownum ＜= 1                     "
       );
  // 取得資料總數
  ResultSetMetaData md=rs.getMetaData();
  columncount_seq=md.getColumnCount();
  rs.last();
  total_seq=rs.getRow();
  System.out.println("取得資料共" + total_seq + "筆資料" + columncount_seq + "個欄位;");
  // 塞資料
  rs.beforeFirst();
  target_seq=new String[total_seq + 1][columncount_seq + 1];
  for (int i=1;i ＜= total_seq;i++) {
   rs.next();
   for (int x=1;x ＜= columncount_seq;x++) {
    target_seq[i][x]=String.valueOf(rs.getString(x));
    // 印出資訊測試腳本使用
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    // System.out.println(target_seq[i][x]);
   }
  }++++++++
  System.out.println("資料建立完成;");
  // 釋放資源
  rs.close();
  stmt.close();
  System.out.println("釋放資料庫資源;");
  item_Appoint(target_seq[1][1]);
 } public void showMain_RandomOne() throws Exception { // 賣場列表隨機一筆
  // 隨機抽取一筆賣場ID
  System.out.println();
  System.out.println("隨機抽取一筆賣場ID;");
  System.out.println("開始下DB指令查詢SM_SEQ;");
  Statement stmt_seq=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet rs_seq=stmt_seq.executeQuery(
        "select sm_seq                             "
       +"from (select show_main.sm_seq             "
       +"from uaord.show_main                      "
       +"inner join uaord.show_detail              "
       +"on show_main.sm_seq=show_detail.sm_seq  "
       +"where show_main.owner_no='AL1096'       "
       +"and show_main.ws_seq='AW000001'         "
       +"and show_main.islifeexpired='0'         "
       +"and show_main.IS_ORGI_ITEM='1'          "
       +"and show_detail.IS_ITNO_MAIN='1'        "
       +"and show_detail.IT_TYPE='1'             "
        //+"and show_main.SM_STATUS='0'             " //搜尋OFF賣場
       +"order by dbms_random.value)               "
                + "where rownum ＜= 1                        "
       );++++++++
// 取得賣場ID總數
  columncount_seq=rs_seq.getMetaData().getColumnCount();
  rs_seq.last();
  total_seq=rs_seq.getRow();
  System.out.println("取得賣場ID共" + total_seq + "筆資料" + columncount_seq + "個欄位;");
  // 塞賣場ID資料
  rs_seq.beforeFirst();
  target_seq=new String[total_seq + 1][columncount_seq + 1];
  for (int i=1;i ＜= total_seq;i++) {
   rs_seq.next();
   for (int x=1;x ＜= columncount_seq;x++) {
    target_seq[i][x]=String.valueOf(rs_seq.getString(x));
    // 印出資訊測試腳本使用
    System.out.println("賣場編號陣列" + i + "-" + x + ")" + target_seq[i][x]);
   }
  }
  System.out.println("Seq資料建立完成;");
  // 釋放Seq資料庫資源
  rs_seq.close();
  stmt_seq.close();
  System.out.println("釋放sm_seq資料庫資源;");
  String res_sm_seq="";
  for (int i=1;i ＜= total_seq;i++) {
   res_sm_seq=res_sm_seq + "'" + target_seq[i][1] + "',";
  }  System.out.println(res_sm_seq);
  showMain_Appoint(target_seq[1][1]);
 }
}++++++=
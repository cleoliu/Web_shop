package Help;import java.sql.*;public class SQLMan {
 public String SQL_Area;
 public int total;
 public int total_seq;
 public int columncount;
 public int columncount_seq;
 public Connection conn;
 public String[][] target_seq;
 public String[][] target_info;
 
 public void connect(String _SQL_Area) throws Exception { // �s����Ʈw
  SQL_Area=_SQL_Area;
  switch (SQL_Area) {
  case "A":
  case "a":
   System.out.println("�s��A��DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:AORD", "UAORDWEB", "zyarhp3y");
   break;
  case "B":
  case "b":
   System.out.println("�s��B��DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:BORD", "UBORDERP","j3yz6drscn");
   break;
  case "D":
  case "d":
   System.out.println("�s��C��DB");+++++++++
Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:DORD", "UDORDERP","dBK7nYA8Ua");
   break;
  case "E":
  case "e":
   System.out.println("�s��D��DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:EORD", "UEORDERP","PvpnXIAayq");
   break;
  case "F":
  case "f":
   System.out.println("�s��E��DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:FORD", "UFORDERP","uW6jETVKSg");
   break;
  case "G":
  case "g":
   System.out.println("�s��F��DB");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn=DriverManager.getConnection("jdbc:oracle:thin:@dbaord01.beta1.ux:1521:UGORD", "UGORDWEB","hp5SdG6nnQ");
   break;
  } } public void showMainCross_Appoint(String _sm_seq) throws Exception { //�~����C����w
  // Ū�������T
  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
  ResultSet rs=stmt.executeQuery(
 "SELECT sm.SM_SEQ,                                                                      "//1-1   ���ID
+"       sm.SM_STATUS,                                                                   "//1-2   ���ON/OFF +++++++++++++
+"      sm.SM_PIC,                                                                     "//1-3  ����Ϥ�
+"       sm.SM_NAME,                                                                     "//1-4   ����W��
+"       sm.SM_PRICE,                                                                    "//1-5   ���
+"       sm.SM_COST,                                                                     "//1-6   �i�f��
+"       sm.SM_MARGIN,                                                                   "//1-7   ��Q�v(�p��)
+"       sm.SSM_TYPE,                                                                    "//1-8   �S���ܻ����A(1:�S���ܻ�/2:�馩)
+"       sm.OWNER_NO,                                                                    "//1-9   ����PM
+"       sm.IS_ORGI_ITEM,                                                                "//1-10(0:�զX���/1:��ͽ��/2:�ʪ����[�ʽ��)
+"       sm.WS_SEQ,                                                                      "//1-11���x�s��
+"       sm.SOURCE_MODE,                                                                 "//1-12���x����(1:B2C / 2:Inside / 3: �N�X�f)
+"       sm.IS_LIMIT_QTY,                                                                "//1-13�O�_����i��q/���ʶq (0:������ / 1:PM�]�w / 2:�t�ӳ]�w / 3:PM�t�Ӭҳ]�w)
+"       sm.SM_MAX_SALEQTY,                                                              "//1-14PM�]�w�̤j�P��q
+"       sm.SM_SUP_MAX_SALEQTY,                                                          "//1-15�t�ӳ]�w�̤j�P��q
+"       sm.SM_SEARCH_SORT,                                                              "//1-16�]���ۭq�Ƨ�(�ƧǥѤj��p)
+"       sm.ISLIFEEXPIRED,                                                               "//1-17�O�_���A�ϥΤ��(0:�_/1:�O)
+"       TO_CHAR(sm.INS_DT, 'YYYY/MM/DD HH24:MI') AS INS_DT,                             "//1-18�s�W�ɶ�
+"       TO_CHAR(sm.MOD_DT, 'YYYY/MM/DD HH24:MI') AS MOD_DT,                             "//1-19�ק�ɶ�+++++++++++
+"      TO_CHAR(sm.SSM_EN_DT, 'YYYY/MM/DD hh24:mi:ss') AS SSM_EN_DT,                   "//1-20���ʵ����ɶ�
+"       TO_CHAR(sm.DISABLE_SORT_DT, 'YYYY/MM/DD') AS DISABLE_SORT_DT,                   "//1-21�]���H�u�Ƨǥ��Ĥ��
+"       sm.IS_SELL_OVERSEA,                                                             "//1-22�O�_�i����~(0:�_/1:�O)
+"       sd.SUP_SEQ,                                                                     "//1-23�����ӽs��
+"       (SELECT SUP_NAME                                                                "
+"          FROM UAORD.SUPPLIER                                                          "
+"         WHERE SUPPLIER.SUP_SEQ=sd.SUP_SEQ                                           "
+"           AND SUPPLIER.IS_DEFAULT=1) AS SUP_NAME,                                   "//1-24�t�ӦW��
+"       t_num.SPEC_COUNT,                                                               "//1-25�W���
+"       t_num.ITEM_MIN_SALEQTY,                                                         "//1-26�̧C�i��q
+"       i.COLOR,                                                                        "//1-27�C��
+"       i.IT_SIZE,                                                                      "//1-28�ؤo
+"       i.IT_LARGE_VOLUME,                                                              "//1-29�j���n�X��(0:�_/1:�O)
+"       i.ITNO,                                                                         "//1-30�ӫ~ID+++++++
+"      i.IT_IN_TYPE,                                                                  "//1-31�ʶR�Ҧ�(�ɳf:1/����:2/���:3)
+"       i.IS_PRE_ORD,                                                                   "//1-32�w�ʺX��
+"       i.SALEQTY,                                                                      "//1-33�ӫ~�i��q
+"       i.IT_COLOR_SEQ,                                                                 "//1-34�ӫ~�C��s��(�P�C��)
+"       TO_CHAR(i.PRE_DT_E, 'YYYY/MM/DD hh24:mi:ss') AS PRE_DT_E,                       "//1-35�w�ʰW
+"       (SELECT CP_NAME FROM UAORD.CATEGORY WHERE i.CP_SEQ=CATEGORY.CP_SEQ) AS CPNAME,"//1-36�����W��
+"       (SELECT USR_NAME FROM UAORD.WUSR WHERE WUSR.USR_SEQ=sm.OWNER_NO) AS pm,       "//1-37PM�ϥΪ̩m�W
+"       (SELECT COUNT(ITNO)                                                             "
+"          FROM UAORD.SHOW_DETAIL                                                       "
+"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
+"           AND IS_ITNO_MAIN='0'                                                      "
+"           AND IT_TYPE IN (3, 4)                                                       "
+"           AND ISLIFEEXPIRED=0) AS GIFT_COUNT,                                       "//1-38�ث~��
+"       (SELECT COUNT(ITNO)                                                             "
+"          FROM UAORD.SHOW_DETAIL                                                       "
+"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
+"           AND IS_ITNO_MAIN='0'                                                      "
+"           AND IT_TYPE=2                                                             "+++++++++
+"          AND ISLIFEEXPIRED=0) AS PLUS_PURCHASE_COUNT,                             "//1-39�[�ʫ~��
+"       (SELECT GOODS_TYPE                                                              "
+"          FROM UAORD.WEBSITE_SET                                                       "
+"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS GOODS_TYPE,                          "//1-40���x�ӫ~����(1:�H��/2:���/3:�H��+���)
+"       (SELECT WS_NAME                                                                 "
+"          FROM UAORD.WEBSITE_SET                                                       "
+"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS WS_NAME,                             "//1-41���x�W��
+"       CASE sm.INS_BY_WHO                                                              "
+"         WHEN '1' THEN                                                                 "
+"          (SELECT NAME                                                                 "
+"             FROM UAORD.SUPPLIER_USR                                                   "
+"            WHERE SUPPLIER_USR.SPPU_SEQ=sm.INS_USR_SEQ) || ' (�t��)'                  "
+"         WHEN '2' THEN                                                                 "
+"          (SELECT USR_NAME FROM UAORD.USR WHERE USR.USR_SEQ=sm.INS_USR_SEQ) ||       "
+"          ' (PM)'                                                                      "
+"         WHEN '4' THEN                                                                 "
+"          (SELECT USR_NAME                                                             "++++++++++
+"            FROM UAORD.WUSR                                                          "
+"            WHERE WUSR.USR_SEQ=sm.INS_USR_SEQ) || ' (PM)'                            "
+"         ELSE                                                                          "
+"          'SYSTEM'                                                                     "//�s�W�H��������(0:��L/1:�t��/2:���q�H��/3:�t��)
+"       END AS USR,                                                                     "//1-42 �s�W�H�m�W
+"       (SELECT COUNT(*)                                                                "
+"          FROM UAORD.SHOW_FUSE_LOG                                                     "
+"         WHERE sm.SM_SEQ=SHOW_FUSE_LOG.SM_SEQ                                        "
+"           AND FUSE_STATUS=0) AS FUSE_STATUS                                         "//1-43 �ӫ~�޲z�̬O�_�w�B�z(0:�_/1:�O)
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
  // ���o��T����`��
  columncount=rs.getMetaData().getColumnCount();
  rs.last();
  total=rs.getRow();
  System.out.println("���o��T�@" + total + "�����" + columncount + "�����;");
  // ������T���
  rs.beforeFirst();
  target_info=new String[total + 1][columncount + 1];
  for (int i=1;i ��= total;i++) {
   rs.next();
   for (int x=1;x ��= columncount;x++) {
    target_info[i][x]=String.valueOf(rs.getString(x));
    // �L�X��T���ո}���ϥ�
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    System.out.println("target_info�}�C" + i + "-" + x + ")" + target_info[i][x]);
   }
  }
  System.out.println("�����T��ƫإߧ���;");
  // ����귽
  rs.close();
  stmt.close();
  conn.close();
  System.out.println("����target_info��Ʈw�귽;");
 } public void item_Appoint(String _itno) throws Exception { //�ӫ~�C����w
  // Ū�������T
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
  // ���o��T����`��
  columncount=rs.getMetaData().getColumnCount();
  rs.last();
  total=rs.getRow();
  System.out.println("���o��T�@" + total + "�����" + columncount + "�����;");
  // ������T���
  rs.beforeFirst();
  target_info=new String[total + 1][columncount + 1];
  for (int i=1;i ��= total;i++) {
   rs.next();
   for (int x=1;x ��= columncount;x++) {
    target_info[i][x]=String.valueOf(rs.getString(x));
    // �L�X��T���ո}���ϥ�
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    //System.out.println("item_info�}�C" + i + "-" + x + ")" + target_info[i][x]);
   }
  }
  System.out.println("�ӫ~��ƫإߧ���;");
  // ����귽
  rs.close();
  stmt.close();
  conn.close();
  System.out.println("����item_info��Ʈw�귽;"); } public void showMain_Appoint(String _sm_seq) throws Exception { //����C����w
  // Ū�������T
  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
  ResultSet rs=stmt.executeQuery(+++++++++
 "SELECT sm.SM_SEQ,                                                                     "//1-1  ���ID
  +"       sm.SM_STATUS,                                                                   "//1-2   ���ON/OFF
  +"       sm.SM_PIC,                                                                      "//1-3   ����Ϥ�
  +"       sm.SM_NAME,                                                                     "//1-4   ����W��
  +"       sm.SM_PRICE,                                                                    "//1-5   ���
  +"       sm.SM_COST,                                                                     "//1-6   �i�f��
  +"       sm.SM_MARGIN,                                                                   "//1-7   ��Q�v(�p��)
  +"       sm.SSM_TYPE,                                                                    "//1-8   �S���ܻ����A(1:�S���ܻ�/2:�馩)
  +"       sm.OWNER_NO,                                                                    "//1-9   ����PM
  +"       sm.IS_ORGI_ITEM,                                                                "//1-10(0:�զX���/1:��ͽ��/2:�ʪ����[�ʽ��)
  +"       sm.WS_SEQ,                                                                      "//1-11���x�s��
  +"       sm.SOURCE_MODE,                                                                 "//1-12���x����(1:B2C/2:Inside/3: �N�X�f)
  +"       sm.IS_LIMIT_QTY,                                                                "//1-13�O�_����i��q/���ʶq (0:������ / 1:PM�]�w / 2:�t�ӳ]�w / 3:PM�t�Ӭҳ]�w)
  +"       sm.SM_MAX_SALEQTY,                                                              "//1-14PM�]�w�̤j�P��q
  +"       sm.SM_SUP_MAX_SALEQTY,                                                          "//1-15�t�ӳ]�w�̤j�P��q
  +"       sm.SM_SEARCH_SORT,                                                              "//1-16�]���ۭq�Ƨ�(�ƧǥѤj��p)++++++++++
+"      sm.ISLIFEEXPIRED,                                                              "//1-17�O�_���A�ϥΤ��(0:�_/1:�O)
  +"       TO_CHAR(sm.INS_DT, 'YYYY/MM/DD HH24:MI') AS INS_DT,                             "//1-18�s�W�ɶ�
  +"       TO_CHAR(sm.MOD_DT, 'YYYY/MM/DD HH24:MI') AS MOD_DT,                             "//1-19�ק�ɶ�
  +"       TO_CHAR(sm.SSM_EN_DT, 'YYYY/MM/DD hh24:mi:ss') AS SSM_EN_DT,                    "//1-20���ʵ����ɶ�
  +"       TO_CHAR(sm.DISABLE_SORT_DT, 'YYYY/MM/DD') AS DISABLE_SORT_DT,                   "//1-21�]���H�u�Ƨǥ��Ĥ��
  +"       sm.IS_SELL_OVERSEA,                                                             "//1-22�O�_�i����~(0:�_/1:�O)
  +"       sd.SUP_SEQ,                                                                     "//1-23�����ӽs��
  +"       (SELECT SUP_NAME                                                                "
  +"          FROM UAORD.SUPPLIER                                                          "
  +"         WHERE SUPPLIER.SUP_SEQ=sd.SUP_SEQ                                           "
  +"           AND SUPPLIER.IS_DEFAULT=1) AS SUP_NAME,                                   "//1-24�t�ӦW��
  +"       t_num.SPEC_COUNT,                                                               "//1-25�W���
  +"       t_num.ITEM_MIN_SALEQTY,                                                         "//1-26�̧C�i��q
  +"       i.COLOR,                                                                        "//1-27�C��+++++++++
+"      i.IT_SIZE,                                                                     "//1-28�ؤo
  +"       i.IT_LARGE_VOLUME,                                                              "//1-29�j���n�X��(0:�_/1:�O)
  +"       i.ITNO,                                                                         "//1-30�ӫ~ID
  +"       i.IT_IN_TYPE,                                                                   "//1-31�ʶR�Ҧ�(�ɳf:1/����:2/���:3)
  +"       i.IS_PRE_ORD,                                                                   "//1-32�w�ʺX��
  +"       i.SALEQTY,                                                                      "//1-33�ӫ~�i��q
  +"       i.IT_COLOR_SEQ,                                                                 "//1-34�ӫ~�C��s��(�P�C��)
  +"       TO_CHAR(i.PRE_DT_E, 'YYYY/MM/DD hh24:mi:ss') AS PRE_DT_E,                       "//1-35�w�ʰW
  +"       (SELECT CP_NAME FROM UAORD.CATEGORY WHERE i.CP_SEQ=CATEGORY.CP_SEQ) AS CPNAME,"//1-36�����W��
  +"       (SELECT USR_NAME FROM UAORD.WUSR WHERE WUSR.USR_SEQ=sm.OWNER_NO) AS pm,       "//1-37PM�ϥΪ̩m�W
  +"       (SELECT COUNT(ITNO)                                                             "
  +"          FROM UAORD.SHOW_DETAIL                                                       "
  +"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
  +"           AND IS_ITNO_MAIN='0'                                                      "
  +"           AND IT_TYPE IN (3, 4)                                                       "
  +"           AND ISLIFEEXPIRED=0) AS GIFT_COUNT,                                       "//1-38�ث~��+++++++=
+"      (SELECT COUNT(ITNO)                                                            "
  +"          FROM UAORD.SHOW_DETAIL                                                       "
  +"         WHERE sm.SM_SEQ=SHOW_DETAIL.SM_SEQ                                          "
  +"           AND IS_ITNO_MAIN='0'                                                      "
  +"           AND IT_TYPE=2                                                             "
  +"           AND ISLIFEEXPIRED=0) AS PLUS_PURCHASE_COUNT,                              "//1-39�[�ʫ~��
  +"       (SELECT GOODS_TYPE                                                              "
  +"          FROM UAORD.WEBSITE_SET                                                       "
  +"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS GOODS_TYPE,                          "//1-40���x�ӫ~����(1:�H��/2:���/3:�H��+���)
  +"       (SELECT WS_NAME                                                                 "
  +"          FROM UAORD.WEBSITE_SET                                                       "
  +"         WHERE WEBSITE_SET.WS_SEQ=sm.WS_SEQ) AS WS_NAME,                             "//1-41���x�W��
  +"       CASE sm.INS_BY_WHO                                                              "
  +"         WHEN '1' THEN                                                                 "+++++++
+"         (SELECT NAME                                                                "
  +"             FROM UAORD.SUPPLIER_USR                                                   "
  +"            WHERE SUPPLIER_USR.SPPU_SEQ=sm.INS_USR_SEQ) || ' (�t��)'                  "
  +"         WHEN '2' THEN                                                                 "
  +"          (SELECT USR_NAME FROM UAORD.USR WHERE USR.USR_SEQ=sm.INS_USR_SEQ) ||       "
  +"          ' (PM)'                                                                      "
  +"         WHEN '4' THEN                                                                 "
  +"          (SELECT USR_NAME                                                             "
  +"             FROM UAORD.WUSR                                                           "
  +"            WHERE WUSR.USR_SEQ=sm.INS_USR_SEQ) || ' (PM)'                            "
  +"         ELSE                                                                          "
  +"          'SYSTEM'                                                                     "//�s�W�H��������(0:��L/1:�t��/2:���q�H��/3:�t��)
  +"       END AS USR,                                                                     "//1-42 �s�W�H�m�W
  +"       (SELECT COUNT(*)                                                                "
  +"          FROM UAORD.SHOW_FUSE_LOG                                                     "
  +"         WHERE sm.SM_SEQ=SHOW_FUSE_LOG.SM_SEQ                                        "++++++++++
+"          AND FUSE_STATUS=0) AS FUSE_STATUS                                        "//1-43 �ӫ~�޲z�̬O�_�w�B�z(0:�_/1:�O)
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
  // ���o��T����`��
  columncount=rs.getMetaData().getColumnCount();
  rs.last();
  total=rs.getRow();
  System.out.println("���o��T�@" + total + "�����" + columncount + "�����;");
  // ������T���
  rs.beforeFirst();
  target_info=new String[total + 1][columncount + 1];
  for (int i=1;i ��= total;i++) {
   rs.next();
   for (int x=1;x ��= columncount;x++) {
    target_info[i][x]=String.valueOf(rs.getString(x));
    // �L�X��T���ո}���ϥ�
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    //System.out.println("sm_info�}�C" + i + "-" + x + ")" + target_info[i][x]);
   }
  }
  System.out.println("�����T��ƫإߧ���;");
  // ����귽+++++++++=
rs.close();
  stmt.close();
  conn.close();
  System.out.println("����sm_info��Ʈw�귽;"); }
 
 public void showMainCross_RandomOne(String _uosite) throws Exception { // �~����C���H���@��
  // �H������@�����ID
  System.out.println();
  System.out.println("�H������@�����ID;");
  System.out.println("�}�l�UDB���O�d��SM_SEQ;");
  Statement stmt_seq=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet rs_seq=stmt_seq.executeQuery(
                "select * from "
            +"(select usml.sm_seq "
            +"from   uaord.uxout_show_main_list usml "
            +"join   uaord.show_main sm on usml.sm_seq=sm.sm_seq "
            +"where  usml.uo_site='"+_uosite+" '"
            +"and    usml.uo_itno != '_' "
            +"order by dbms_random.value) "
            +"where rownum��=1"
);
  // ���o���ID�`��
  columncount_seq=rs_seq.getMetaData().getColumnCount();
  rs_seq.last();
  total_seq=rs_seq.getRow();
  System.out.println("���o���ID�@" + total_seq + "�����" + columncount_seq + "�����;");
  // ����ID���
  rs_seq.beforeFirst();+++++++++
target_seq=new String[total_seq + 1][columncount_seq + 1];
  for (int i=1;i ��= total_seq;i++) {
   rs_seq.next();
   for (int x=1;x ��= columncount_seq;x++) {
    target_seq[i][x]=String.valueOf(rs_seq.getString(x));
    // �L�X��T���ո}���ϥ�
    System.out.println("����s���}�C" + i + "-" + x + ")" + target_seq[i][x]);
   }
  }
  System.out.println("Seq��ƫإߧ���;");
  // ����Seq��Ʈw�귽
  rs_seq.close();
  stmt_seq.close();
  System.out.println("����target_seq��Ʈw�귽;");
  String res_sm_seq="";
  for (int i=1;i ��= total_seq;i++) {
   res_sm_seq=res_sm_seq + "'" + target_seq[i][1] + "',";
  }  System.out.println(res_sm_seq);
  showMainCross_Appoint(target_seq[1][1]);
 } public void item_RandomOne() throws Exception { // �ӫ~�C���H���@��
  // ���oDB���
  System.out.println("�}�l�U���O;");
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
       +"                  where rownum ��= 1                     "
       );
  // ���o����`��
  ResultSetMetaData md=rs.getMetaData();
  columncount_seq=md.getColumnCount();
  rs.last();
  total_seq=rs.getRow();
  System.out.println("���o��Ʀ@" + total_seq + "�����" + columncount_seq + "�����;");
  // ����
  rs.beforeFirst();
  target_seq=new String[total_seq + 1][columncount_seq + 1];
  for (int i=1;i ��= total_seq;i++) {
   rs.next();
   for (int x=1;x ��= columncount_seq;x++) {
    target_seq[i][x]=String.valueOf(rs.getString(x));
    // �L�X��T���ո}���ϥ�
    // System.out.println("["+i+"]["+x+"]-"+md.getColumnName(x));
    // System.out.println(target_seq[i][x]);
   }
  }++++++++
  System.out.println("��ƫإߧ���;");
  // ����귽
  rs.close();
  stmt.close();
  System.out.println("�����Ʈw�귽;");
  item_Appoint(target_seq[1][1]);
 } public void showMain_RandomOne() throws Exception { // ����C���H���@��
  // �H������@�����ID
  System.out.println();
  System.out.println("�H������@�����ID;");
  System.out.println("�}�l�UDB���O�d��SM_SEQ;");
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
        //+"and show_main.SM_STATUS='0'             " //�j�MOFF���
       +"order by dbms_random.value)               "
                + "where rownum ��= 1                        "
       );++++++++
// ���o���ID�`��
  columncount_seq=rs_seq.getMetaData().getColumnCount();
  rs_seq.last();
  total_seq=rs_seq.getRow();
  System.out.println("���o���ID�@" + total_seq + "�����" + columncount_seq + "�����;");
  // ����ID���
  rs_seq.beforeFirst();
  target_seq=new String[total_seq + 1][columncount_seq + 1];
  for (int i=1;i ��= total_seq;i++) {
   rs_seq.next();
   for (int x=1;x ��= columncount_seq;x++) {
    target_seq[i][x]=String.valueOf(rs_seq.getString(x));
    // �L�X��T���ո}���ϥ�
    System.out.println("����s���}�C" + i + "-" + x + ")" + target_seq[i][x]);
   }
  }
  System.out.println("Seq��ƫإߧ���;");
  // ����Seq��Ʈw�귽
  rs_seq.close();
  stmt_seq.close();
  System.out.println("����sm_seq��Ʈw�귽;");
  String res_sm_seq="";
  for (int i=1;i ��= total_seq;i++) {
   res_sm_seq=res_sm_seq + "'" + target_seq[i][1] + "',";
  }  System.out.println(res_sm_seq);
  showMain_Appoint(target_seq[1][1]);
 }
}++++++=
package Help;import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;public class PostMan {
 
 /*
    public void sendGet() throws Exception { // GET������
  
  String url="A";
  HttpHost proxy=new HttpHost("proxy",8080);
  
  System.out.println("create");
  //CloseableHttpClient  client=HttpClients.createDefault();
  CloseableHttpClient  client=HttpClientBuilder.create().setProxy(proxy).build();
  System.out.println("new get");
  HttpGet get=new HttpGet(url);
  System.out.println("response");
  HttpResponse response=client.execute(get);
  System.out.println("try get");
    
  System.out.println("P4");
  System.out.println("\nSending 'GET' request to URL : "+url);
  System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
  
  BufferedReader rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  
  StringBuffer result=new StringBuffer();
  String line="";
  System.out.println("P5");
  while ((line=rd.readLine()) != null) {
   result.append(line);
  }
        System.out.println(result.toString());
 }*/ 
//sendPost(url,uo_site,sm_seq_arr)
 public static JSONObject sendPost_get_price_infos(String _uo_site,String _sm_seq_arr) throws Exception {
  //���}
  String url="A";
  
  //Proxy
  HttpHost proxy=new HttpHost("proxy",8080);
  CloseableHttpClient  client=HttpClientBuilder.create().setProxy(proxy).build();
  HttpPost post=new HttpPost(url);
  
  //POST �ѼƳ]�w �ӧO���եΥi���[(ex:String uo_site="3")
  String uo_site=_uo_site;
  String sm_seq_arr=_sm_seq_arr;
  String debug="on";
  
  //�N�U���}�C�s��urlParameters
  List urlParameters=new ArrayList();
  //�}�C����
  urlParameters.add(new BasicNameValuePair("uo_site", uo_site));//�᭱��uo_site�i�令�Ʀr
  urlParameters.add(new BasicNameValuePair("sm_seq_arr", "[\""+sm_seq_arr+"\"]"));
  urlParameters.add(new BasicNameValuePair("debug", debug));
  //��J���N��
  post.setEntity(new UrlEncodedFormEntity(urlParameters));
  //����POST
  HttpResponse response=client.execute(post);
  
  /*
  System.out.println("\nSending 'POST' request to URL : "+url);
  System.out.println("Post parameters : "+post.getEntity());
  System.out.println("Response parameters : "+response.getEntity());
  System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
  */
  
  
  //�Npost���@�s�굲�G�s�_�ӥsrd
  BufferedReader rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//���ؤ@�Ӧr��W�٬�line="",�@��JSON=null,�p�Grd�����G������,�N�s��jsonresult
  StringBuffer result=new StringBuffer();
  String line="";
  JSONObject jsonresult=null;
  while ((line=rd.readLine()) != null) {
   result.append(line);
   jsonresult=new JSONObject(result.toString());
  }
  
  //�^�ǵ��G
  return jsonresult;
 }
}
 /*�btest�̪��Ϊk
 System.out.println(jsonresult.getJSONObject(sm_seq_arr).getJSONObject("forward_price_result").getDouble("export_sm_price"));
             ��s      �Ĥ@�h�W��        �ĤG�h�W��
 
 public void SEE() throws Exception {
 JSONObject x=PostMan.sendPost_get_price_infos("3","201511AM200000014");
 System.out.println(x.getJSONObject("201511AM200000014").getJSONObject("forward_price_result").getDouble("UXOUT_PRICE"));
 }
 */
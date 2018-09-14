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
    public void sendGet() throws Exception { // GET未完成
  
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
  //網址
  String url="A";
  
  //Proxy
  HttpHost proxy=new HttpHost("proxy",8080);
  CloseableHttpClient  client=HttpClientBuilder.create().setProxy(proxy).build();
  HttpPost post=new HttpPost(url);
  
  //POST 參數設定 個別測試用可不加(ex:String uo_site="3")
  String uo_site=_uo_site;
  String sm_seq_arr=_sm_seq_arr;
  String debug="on";
  
  //將下面陣列存成urlParameters
  List urlParameters=new ArrayList();
  //陣列部分
  urlParameters.add(new BasicNameValuePair("uo_site", uo_site));//後面的uo_site可改成數字
  urlParameters.add(new BasicNameValuePair("sm_seq_arr", "[\""+sm_seq_arr+"\"]"));
  urlParameters.add(new BasicNameValuePair("debug", debug));
  //輸入的意思
  post.setEntity(new UrlEncodedFormEntity(urlParameters));
  //執行POST
  HttpResponse response=client.execute(post);
  
  /*
  System.out.println("\nSending 'POST' request to URL : "+url);
  System.out.println("Post parameters : "+post.getEntity());
  System.out.println("Response parameters : "+response.getEntity());
  System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
  */
  
  
  //將post的一連串結果存起來叫rd
  BufferedReader rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//指建一個字串名稱為line="",一個JSON=null,如果rd的結果為有值,就存成jsonresult
  StringBuffer result=new StringBuffer();
  String line="";
  JSONObject jsonresult=null;
  while ((line=rd.readLine()) != null) {
   result.append(line);
   jsonresult=new JSONObject(result.toString());
  }
  
  //回傳結果
  return jsonresult;
 }
}
 /*在test裡的用法
 System.out.println(jsonresult.getJSONObject(sm_seq_arr).getJSONObject("forward_price_result").getDouble("export_sm_price"));
             賣編      第一層名稱        第二層名稱
 
 public void SEE() throws Exception {
 JSONObject x=PostMan.sendPost_get_price_infos("3","201511AM200000014");
 System.out.println(x.getJSONObject("201511AM200000014").getJSONObject("forward_price_result").getDouble("UXOUT_PRICE"));
 }
 */
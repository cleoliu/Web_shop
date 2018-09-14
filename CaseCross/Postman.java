package CaseCross;import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;public class Postman { public static void main(String[] args) throws Exception{
  
  Postman http=new Postman();
  
  //System.out.println("Send GET");
  //http.sendGet();
  
  System.out.println("Send POST");
  http.sendPost();
  
 }
 
private void sendGet() throws Exception {
  
  String url="A";
  HttpHost proxy=new HttpHost("proxy",8080);
  
  System.out.println("create");
  //CloseableHttpClient  client=HttpClients.createDefault();
  CloseableHttpClient  client=HttpClientBuilder.create().setProxy(proxy).build();
  System.out.println("new get");
  HttpGet get=new HttpGet(url);
  System.out.println("response");
  CloseableHttpResponse response=client.execute(get);
  System.out.println("try get");
  try {
   System.out.println(response.getStatusLine());
   HttpEntity entity=response.getEntity();
   EntityUtils.consume(entity);
  }finally{
  response.close();
  }
  
/*System.out.println("P4");
  System.out.println("\nSending 'GET' request to URL : "+url);
  System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
  
  BufferedReader rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  
  StringBuffer result=new StringBuffer();
  String line="";
  System.out.println("P5");
  while ((line=rd.readLine()) != null) {
   result.append(line);
  }
        System.out.println(result.toString());*/
 } 
 private void sendPost() throws Exception {
  //網址
  String url="A";
  //Proxy
  HttpHost proxy=new HttpHost("proxy",8080);
  CloseableHttpClient  client=HttpClientBuilder.create().setProxy(proxy).build();
  HttpPost post=new HttpPost(url);
  //POST 參數設定
  String uo_site="3";
  String sm_seq_arr="201512AM030000014";
  String debug="on";
  
  List urlParameters=new ArrayList();
  urlParameters.add(new BasicNameValuePair("uo_site", uo_site));
  urlParameters.add(new BasicNameValuePair("sm_seq_arr", "[\""+sm_seq_arr+"\"]"));
  urlParameters.add(new BasicNameValuePair("debug", debug));
  post.setEntity(new UrlEncodedFormEntity(urlParameters));
  //執行POST
  HttpResponse response=client.execute(post);
  /*
  System.out.println("\nSending 'POST' request to URL : "+url);
  System.out.println("Post parameters : "+post.getEntity());
  System.out.println("Response parameters : "+response.getEntity());
  System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
  */
  BufferedReader rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  
  StringBuffer result=new StringBuffer();
  String line="";
  JSONObject jsonresult=null;
  while ((line=rd.readLine()) != null) {
   result.append(line);
   jsonresult=new JSONObject(result.toString());
  }
  //System.out.println(jsonresult);
  //System.out.println(jsonresult.getJSONObject(sm_seq_arr).getJSONObject("forward_price_result").getDouble("export_sm_price"));
  Double D8 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("sm_infos").getDouble("SM_PRICE");
  Double G8 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("site_cfg").getDouble("UO_COUNTRY_OPERATE_COST");
  Double G10 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("erp_infos").getDouble("OUT_VAT");
  Double M6 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("sm_infos").getDouble("MAX_WEIGHT_NEW")*jsonresult.getJSONObject(sm_seq_arr).getJSONObject("fee_infos").getDouble
("LOGISTICS_FEE");
  Double G14 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("site_cfg").getDouble("TRANSFER_COUNTRY_FEE");
  Double G16 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("site_cfg").getDouble("TRANSFER_COUNTRY_PROFIT");
  Double D10 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("erp_infos").getDouble("CURRENT_HSCODE_TAX");
  Double G12 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("erp_infos").getDouble("IN_VAT");
  Double G6 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("site_cfg").getDouble("UO_COUNTRY_SHIPPING_FEE");
  Double D15 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("site_cfg").getDouble("UO_PROFIT");
  Double J12 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("erp_infos").getDouble("CENTER_CURRENCY_TO_USD");
  Double J6 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("erp_infos").getDouble("OUT_CURRENCY_TO_USD");
  Double J16 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("erp_infos").getDouble("IN_CURRENCY_FROM_USD");
  Double D6 =jsonresult.getJSONObject(sm_seq_arr).getJSONObject("sm_infos").getDouble("IT_COST");
  Double crossPrice=((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15))*J6*J16;
  System.out.println(crossPrice);
  Double crossEarnPrice=(((D8+D8*G8)*(1-G10)+M6+(((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15))*D10)+(((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15))*D10*G12)+(((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15))*G12)+((((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15)))*G6)+G14)-M6-((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15))*D10-((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15))*D10*G12-D6-((D8+D8*G8)*(1-G10)+M6+G14)*(1+G16)/(1-(D10*(1+G16)+D10*G12*(1+G16)+G12*(1+G16)+G6*(1+G16)+D15))*G12-D8*G8)*J6*J16;
  System.out.println(crossEarnPrice);
     
 }
  
}

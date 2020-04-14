package com.adima.seo.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.impl.client.HttpClientBuilder;
/**
*CreatedwithIntelliJIDEA.
*User:weiwt
*Date:2016/4/14
*Time:15:01
*Version:1.0
*
*windowsvpn設定要求:
*1、主機IP:45.79.83.149
*2、vpn名字:自動vpn(可自行修改)
*3、使用者名稱固定:i.vpno.net
* 
* Article source first
* https://mkyong.com/java/the-type-defaulthttpclient-is-deprecated/
* second
* https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/320474/
*/
public class ConnectVPN{
public static void main(String[]args) throws IOException{
connect("自動vpn","i.vpno.net",getMmTxt());
}
private static String execCmd(String cmd) throws IOException{
Process process=Runtime.getRuntime().exec("cmd/c"+cmd);
StringBuilder sbCmd=new StringBuilder();
BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
String line="";
while((line=br.readLine())!=null){
sbCmd.append(line);
}
return sbCmd.toString();
}
private static boolean connect(String vpnName,String username,String passwd)throws IOException{
String cmd="rasdial"+vpnName+""+username+""+passwd;
String result=execCmd(cmd);
if(result.contains("已連線"))
return true;
return false;
}
private static boolean disconnect(String vpnName,String username,String passwd) throws IOException{
String cmd="rasdial"+vpnName+"/disconnect";
String result=execCmd(cmd);
if(result.contains("沒有連線"))
return true;
return false;
}
private static String getMmTxt(){
String passwd="";
//HttpClient httpClient=new DefaultHttpClient();
HttpClient httpClient = HttpClientBuilder.create().build();

HttpGet httpGet=new HttpGet("http://45.79.83.149/mm.txt");
//HttpGet httpGet=new HttpGet("http://www.google.com.tw/search?q=adima");
try{
HttpResponse response=httpClient.execute(httpGet);
HttpEntity entity=response.getEntity();
if(entity!=null){
passwd=EntityUtils.toString(entity);
passwd.replace("/n","");
System.out.println(passwd);
}
}catch(Exception e){
e.printStackTrace();
}
return passwd;
}
}
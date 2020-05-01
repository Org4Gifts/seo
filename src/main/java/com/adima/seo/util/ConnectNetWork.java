/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adima.seo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class ConnectNetWork {
/**
* @param args
* @throws Exception 
*/
public static void main(String[] args) throws Exception {
// TODO Auto-generated method stub
connAdsl("VPN_Test","test", "test"); 
Thread.sleep(1000); 
cutAdsl("VPN_Test"); 
Thread.sleep(1000); 
}
/** 
    * 執行CMD命令,並返回String字串 
*/ 
public static String executeCmd(String strCmd) throws Exception {
System.out.println("cmd /c " + strCmd);
Process p = Runtime.getRuntime().exec("cmd /c " + strCmd); 
StringBuilder sbCmd = new StringBuilder();
//這裡很重要，設定GB2312解決亂碼！！！
//如果程式預設編碼就是GB2312，可以不寫
//我NetBeans預設用UTF8
//BufferedReader br = new BufferedReader(new InputStreamReader(p 
//.getInputStream(), "GB2312")); 
BufferedReader br = new BufferedReader(new InputStreamReader(p 
.getInputStream()));

String line; 
while ((line = br.readLine()) != null) { 
sbCmd.append(line  + "\n"); 
}
return sbCmd.toString(); 
/*
//如果整個過程換成這樣，就更清楚了。getInputStream是獲取最原始的位元組流，
//cmd返回的是以GB2312雙位元組編碼的位元組流
InputStream in = p.getInputStream();
byte[] b = new byte[2000];
in.read(b);
String msg = new String(b, "GB2312");
//用GB2312解釋這堆位元組，就可以組裝成一個正常的String了
//如果上邊不寫GB2312，等於這裡用UTF8組裝，結果一樣
return msg;
*/
} 
/** 
* 連線ADSL 
* 語法： rasdial 連線名稱 username password 
* 例項： rasdial 我的寬頻 hzhz1234567890 dfdfdfdfdf 
*/ 
public static boolean connAdsl(String adslTitle, String adslName, String adslPass) throws Exception { 
System.out.println("正在建立連線."); 
System.out.println("Creating connect."); 
String adslCmd = "rasdial " +  adslTitle  + " " +  adslName +  " " +  adslPass; 
String tempCmd = executeCmd(adslCmd); 
//String tempCmd = executeCmd("ping www.youku.com"); 
// 判斷是否連線成功 
System.out.println("tempCmd: " + tempCmd); 
if (tempCmd.indexOf("已連線") > 0) { 
System.out.println("已成功建立連線."); 
System.out.println("create success."); 
return true; 
} else { 
System.err.println(tempCmd); 
System.err.println("建立連線失敗"); 
System.out.println("Create failed."); 
return false; 
} 
} 
/** 
* 斷開ADSL 
*/ 
public static boolean cutAdsl(String adslTitle) throws Exception { 
String cutAdsl = "rasdial "  + adslTitle +  " /disconnect"; 
String result = executeCmd(cutAdsl); 
if (result.indexOf("沒有連線")!=-1){ 
System.err.println(adslTitle  + "連線不存在!"); 
return false; 
} else { 
System.out.println("連線已斷開"); 
return true; 
} 
} 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://blog.csdn.net/XmlRequest/article/details/11646309
 */
package com.adima.seo.util;

import java.io.IOException;
import org.apache.commons.httpclient.Cookie;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
//import org.apache.commons.lang.xwork.StringUtils;

/**
 *
 * @author yctse
 */
public class HttpClientUtil {

    public static HttpClient getClient() {
        HttpClient client = new HttpClient();
        return client;
    }

    public static String getHtml(String url) throws HttpException, IOException {
        return getHtml(url, 80, null, null, 0, null);
    }

    public static String getHtml(String url, String cookie) throws HttpException, IOException {
        return getHtml(url, 80, null, null, 0, cookie);
    }

    public static String getHtml(String url, int port, String cookie) throws HttpException, IOException {
        return getHtml(url, port, null, null, 0, cookie);
    }

    public static String getHtml(String url, int port, String encoding, String proxyHost, int proxyPort, String cookie)
            throws HttpException, IOException {
        HttpClient httpClient = getClient();
        String rest = null;
        if (proxyHost != null && proxyPort != 0) {
            httpClient.getHostConfiguration().setProxy(proxyHost, proxyPort);
        }
        HttpMethod method = new GetMethod(url);
        HttpGet get = new HttpGet(url);
        if (!StringUtils.isBlank(cookie)) {
            method.addRequestHeader("Cookie", cookie);
        }
        method.addRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727");
        //Mozilla/5.0 (Windows NT 6.1; rv:7.0.1) Gecko/20100101 Firefox/7.0.1  
        httpClient.executeMethod(method);

        //檢查cookie 確認 cookie 不會重複
//    Cookie[] cookies = httpClient.getState().getCookies();
//    for(int i=0; i<cookies.length; i++){
//        System.out.println("cookies["+i+"]: "+cookies[i]);
//    }
        //根据http头解析正确的字符集  
        String header = method.getResponseHeader("Content-Type").getValue();
        if (header.contains("charset=")) {
            encoding = header.substring(header.indexOf("charset=") + "charset=".length(), header.length());
        }
        if (encoding == null) {
            encoding = "GBK";
        }
//        ForFile.writeFileContent("", method.getResponseBodyAsString());
        rest = new String(method.getResponseBody(), encoding);
        method.releaseConnection();
        return rest;
    }

    public static void main(String[] args) throws HttpException, IOException {
//    String url = "http://blog.csdn.net/xmlrequest/article/details/11519503";  
        String engine = "https://www.google.com.tw/search?q=";
        String keyWord = "adima";
        String keyUrl = "www.shopadimas.com";
//    String url = "http://www.google.com.tw/search?q=adima"; 
//    System.out.println(getHtml(url)); 
//        System.out.println(getHtml(engine + keyWord));
//        String newUrl = new AnalyUrl().analyUrl(getHtml(engine + keyWord), keyUrl, keyWord);
//        System.out.println(getHtml(newUrl));

        String htmlResult = getHtml(engine + keyWord);
//        ForFile.writeFileContent("", htmlResult);
//
//        String newUrl = new AnalyUrl().analyUrl(htmlResult, keyUrl, keyWord);
//        
//        ForFile.writeFileContent("", newUrl);
//        
//        ForFile.writeFileContent("", getHtml(newUrl));
        //寫入搜尋結果
//          ForFile.writeFileContent("", getHtml(engine + keyWord));
    }
}

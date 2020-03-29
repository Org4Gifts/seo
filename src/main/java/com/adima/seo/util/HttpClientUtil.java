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

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.apache.commons.lang.xwork.StringUtils;

import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlLink;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

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
//        method.addRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727");
        method.addRequestHeader("User-Agent", "Mozilla/5.0 AppleWebKit/537.36 (KHTML like Gecko) Gecko/20100101 Firefox/72.0");
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

//https://www.itread01.com/content/1558576864.html
    public static String getNewHtml(String url) throws IOException {
        //1.生成httpclient，相當於該開啟一個瀏覽器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.建立get請求，相當於在瀏覽器位址列輸入 網址
        HttpGet request = new HttpGet(url);
        String html = "error";
        try {
            //3.執行get請求，相當於在輸入位址列後敲回車鍵
            response = httpClient.execute(request);

            //4.判斷響應狀態為200，進行處理
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.獲取響應內容
                HttpEntity httpEntity = response.getEntity();
                html = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(html);
            } else {
                //如果返回狀態不是200，比如404（頁面不存在）等，根據情況做處理，這裡略
                System.out.println("返回狀態不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
                html = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } finally {
            //6.關閉
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return html;
    }

    public static void newMethod(String url, String keyWd, String keyUrl) throws IOException {
        // 创建webclient
        WebClient webClient = new WebClient();
        // 取消 JS 支持
        webClient.getOptions().setJavaScriptEnabled(false);
        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);
        // 获取指定网页实体
        HtmlPage page = (HtmlPage) webClient.getPage(url);
        // 获取搜索输入框
//        HtmlInput input = (HtmlInput) page.getHtmlElementById("input");
        HtmlInput input = page.getElementByName("q");
//        System.out.println("input = " + input.getTagName()); //取得tagName

        // 往输入框 “填值”
        input.setValueAttribute(keyWd);
//        System.out.println("input = " + input.asText());
        // 获取搜索按钮
//        HtmlInput btn = (HtmlInput) page.getHtmlElementById("search-button");
        HtmlInput btn = page.getElementByName("btnK");
//        System.out.println("input = " + btn.asText());
        // “点击” 搜索
        HtmlPage page2 = btn.click();
        System.out.println("page2 = " + page2.getTitleText());
//        System.out.println("link = " + page2.getElementById("pnnext").asText());
//        HtmlLink link = (HtmlLink)page2.getElementById("pnnext");
//                System.out.println("link = " + link.asText());
        // 选择元素
//        List<HtmlElement> spanList = page2.getByXPath("//h3[@class='res-title']/a");
        List<HtmlElement> spanList = page2.getTabbableElements();
        for (int i = 0; i < spanList.size(); i++) {
            // 输出新页面的文本
            HtmlElement element = spanList.get(i);
            String linkName = element.asText();
            String linkUrl = element.getAttribute("href");
            System.out.println(i + 1 + "、" + linkName + " 、" +linkUrl );
            if(linkName.contains("阿蒂瑪") && linkUrl.contains(keyUrl)){
                HtmlAnchor link = (HtmlAnchor) element;
                HtmlPage page3 = link.click();
                System.out.println("link = " + page3.getTitleText());
                break;
            }else if(linkName.equals("下一頁 >")){
                HtmlAnchor link = (HtmlAnchor) element;
                HtmlPage page3 = link.click();
                System.out.println("next = " + page3.getTitleText());
                break;
            }
        }
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

//        String htmlResult = getHtml(engine + keyWord);
//        ForFile.writeFileContent("", htmlResult);
//        String htmlResult = getNewHtml(engine + keyWord);
//        ForFile.writeFileContent("", htmlResult);
//        
//        String newUrl = new AnalyUrl().analyUrl(htmlResult, keyUrl, keyWord);
//        ForFile.writeFileContent("", newUrl);
//
//        htmlResult = getNewHtml(newUrl);
//        ForFile.writeFileContent("", htmlResult);
        newMethod("https://www.google.com.tw/", keyWord, keyUrl);

//        ForFile.writeFileContent("", getHtml(newUrl));
        //寫入搜尋結果
//          ForFile.writeFileContent("", getHtml(engine + keyWord));
    }
}

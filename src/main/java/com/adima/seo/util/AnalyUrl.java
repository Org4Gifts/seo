/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adima.seo.util;

import java.util.StringTokenizer;

/**
 *
 * @author odise
 * https://jjnnykimo.pixnet.net/blog/post/21585194
 */
public class AnalyUrl {

    public String analyUrl(String totalstring) {
        StringTokenizer token = new StringTokenizer(totalstring, "<> ");

String firstword;

        CompareStr compstr = new CompareStr();

        String dsturl = null;

        while (token.hasMoreTokens()) {

            firstword = token.nextToken();
//            System.out.println("firstword:  "+firstword);

            if (!compstr.comparestring("google.com", firstword) && !compstr.comparestring("cache", firstword)) {
                if (firstword.length() > 14 && firstword.contains("https")) {
                    dsturl = firstword.substring(13, firstword.length() - 1);
                    System.out.println(dsturl); //成功取到URL，記錄到文件中
                    if(dsturl.contains("www.shopadima.com"))
                        return dsturl;
                }
            }
        }
        return "error";
    }
}

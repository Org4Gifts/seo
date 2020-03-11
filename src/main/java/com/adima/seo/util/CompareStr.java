/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adima.seo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author odise
 * https://jjnnykimo.pixnet.net/blog/post/21585194
 */
public class CompareStr {

    public boolean comparestring(String oristring, String tostring) {

        Pattern p = null; //正則運算式

        Matcher m = null; //操作的字符串

        boolean b;

        p = Pattern.compile(oristring, Pattern.CASE_INSENSITIVE);
        
//        System.out.println("ppppp:  "+ p);

        m = p.matcher(tostring);
        
//        System.out.println("mmmmm:  "+m);

        b = m.find();
        
//        System.out.println("bbbbbb:  "+b);

        return b;
    }
}

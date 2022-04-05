package com.tcl.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wang on 2017-06-13.
 */
public class CookieUtils {
    public final static String getCookieValue(HttpServletRequest request,String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (int i = 0; i < cookies.length; ++i) {
            if (cookies[i].getName().equals(name))
                return cookies[i].getValue();
        }
        return null;
    }
}

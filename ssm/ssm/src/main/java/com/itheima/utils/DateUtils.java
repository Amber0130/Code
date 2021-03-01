package com.itheima.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String Date_to_String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.format(date);
    }

    public static Date String_to_Date(String str, String patt) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.parse(str);
    }
}

package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (StringUtils.isEmpty(s)){
            throw new RuntimeException("输入日期");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("格式错误");
        }
    }
}

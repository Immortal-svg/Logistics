package com.logistics.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author q
 * @create 2019- 05- 07 8:08
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        System.out.println("-----------日期转换器调用--------------");
        try {
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date =s.parse(source);
            return date;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}

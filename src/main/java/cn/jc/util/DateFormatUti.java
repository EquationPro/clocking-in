package cn.jc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUti {
    public static SimpleDateFormat all(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format;
    }
    public static String justHour(Date parse){
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String justHour = format.format(parse);
        return justHour;
    }
    public static String justMinute(Date parse){
        SimpleDateFormat format = new SimpleDateFormat("mm");
        String justMinute = format.format(parse);
        return justMinute;
    }
    public static String getCheckDay(Date parse){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String checkDayNum = format.format(parse);
        return checkDayNum;
    }
}

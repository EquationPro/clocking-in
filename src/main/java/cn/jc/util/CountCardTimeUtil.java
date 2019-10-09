package cn.jc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 传入第一次打卡时间和最后一次打卡时间进行计算
 */
public class CountCardTimeUtil {
    public static SimpleDateFormat all(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format;
    }
    //最后一次打卡时间-第一次打卡时间
    public static Integer countCardTimeUtil(String cardFirst,String punTime) throws ParseException {
        CountCardTimeUtil countCardTimeUtil = new CountCardTimeUtil();
        SimpleDateFormat all = countCardTimeUtil.all();
        int gap = new Long((all.parse(punTime).getTime() - all.parse(cardFirst).getTime()) / (1000 * 60 * 60)).intValue();
        return gap;
    }
}

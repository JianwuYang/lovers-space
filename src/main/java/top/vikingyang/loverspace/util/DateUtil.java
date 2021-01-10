package top.vikingyang.loverspace.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 日期操作 加天数
     * @param date 日期
     * @param count 增加天数（正数） 减少天数（负数）
     * @return 操作后的结果
     */
    public static Date addDay(Date date, int count){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, count);
        return calendar.getTime();
    }
}

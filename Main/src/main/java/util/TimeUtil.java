package util;

import java.util.Calendar;

/**
 * Created by raychen on 16/5/22.
 */
public class TimeUtil {

    public static Calendar getTimeFromInt(int time){
        Calendar cal = Calendar.getInstance();
        int i = time % 100;
        cal.set(Calendar.DATE, i);
        time /= 100;
        i = time % 100;
        cal.set(Calendar.MONTH, i-1);
        time /= 100;
        cal.set(Calendar.YEAR, time);
        return cal;
    }
}

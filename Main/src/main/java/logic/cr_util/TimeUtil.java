package logic.cr_util;

import java.util.Calendar;

/**
 * Created by raychen on 16/5/26.
 */
public class TimeUtil {
    public static int getInterval(Calendar c1, Calendar c2){
        return (int) ((c2.getTimeInMillis() - c1.getTimeInMillis()) / 1000 / 60 / 60 / 24);
    }
}

package logic.cr_main;

import logic.cr_util.DataUtil;
import logic.cr_util.Sample;
import logic.cr_util.TimeUtil;

import java.util.*;

/**
 * Created by raychen on 16/5/27.
 */
public class Main {

    private static final int parameters = 2;
    private Logic logic;

    public Main() {
        logic = new Logic();
    }

    public Map<Calendar, Double> getPlayTimes(String song_id){
        Map<Calendar, Double> map = new HashMap<>();
        List<Sample> samples = DataUtil.getSamples(song_id);
        double[] t = logic.getThetas(samples, parameters);
        System.out.println(t[0]+" "+t[1]);
        double[] x = new double[parameters];
        x[0] = 1;
        long start_time = DataUtil.startTime.getTimeInMillis();
        long end_time = DataUtil.endTime.getTimeInMillis();
        long day = 1000*60*60*24;

        for (long i = start_time; i <= end_time; i+=day) {
            Calendar cal = Calendar.getInstance();

            cal.setTimeInMillis(i - day);
            x[1] = TimeUtil.getInterval(DataUtil.initTime, cal);
            double t1 = logic.h(x, t, parameters);

            cal.setTimeInMillis(i);
            x[1] = TimeUtil.getInterval(DataUtil.initTime, cal);
            double t2 = logic.h(x, t, parameters);

            map.put(cal, t2-t1);
        }
        return map;
    }

}

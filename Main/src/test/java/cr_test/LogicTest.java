package cr_test;

import logic.cr_main.Logic;
import logic.cr_main.Main;
import logic.cr_util.DataUtil;
import logic.cr_util.Sample;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by raychen on 16/5/27.
 */
public class LogicTest {

    private Logic logic;

    @Before
    public void before(){
        logic = new Logic();
    }

    @Test
    public void getThetas() throws Exception {
        List<Sample> samples = DataUtil.getSamples("0081e9a35207457455b6703178a79303");
//        samples.forEach(sample -> {
//            System.out.println(sample.x[1]+" "+sample.y);
//        });
        double[] t = logic.getThetas(samples, 2);
        System.out.println(t[0] + " AND " +t[1]);
        samples.forEach(sample -> {
            System.out.println(sample.y+" "+logic.h(sample.x, t, 2));
        });
    }

    @Test
    public void main() throws Exception {
        Main main = new Main();
        Map<Calendar, Double> times = main.getPlayTimes("0081e9a35207457455b6703178a79303");
        System.out.println(times.size());
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(DataUtil.initTime.getTimeInMillis()-2*1000*24*60*60);
//        System.out.println(cal.getTime().toString());
    }
}

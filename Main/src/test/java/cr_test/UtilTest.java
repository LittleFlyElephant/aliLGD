package cr_test;

import logic.cr_util.DataUtil;
import logic.cr_util.Sample;
import logic.cr_util.TimeUtil;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

/**
 * Created by raychen on 16/5/26.
 */
public class UtilTest {
    @Test
    public void time() throws Exception {
        Calendar c1 = Calendar.getInstance();
        c1.set(2015, 3, 12);
        Calendar c2 = Calendar.getInstance();
        c2.set(2015, 4, 15);
        System.out.println(TimeUtil.getInterval(c1, c2));
    }

    @Test
    public void samples() throws Exception {
        List<Sample> samples = DataUtil.getSamples("0008de587f84d8c9491502c5a5c8b466");
        samples.forEach(sample -> {
            System.out.println(sample.x[0] + " " + sample.y);
        });
    }
}

package logic.cr_util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by raychen on 16/5/26.
 */
public class Sample {
    public double[] x;
    public double y; // accumulate play times

    public Sample(int y, int size) {
        this.y = y;
        this.x = new double[size + 1];
        this.x[0] = 1;
    }
}

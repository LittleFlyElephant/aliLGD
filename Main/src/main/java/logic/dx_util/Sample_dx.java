package logic.dx_util;


import logic.dx_main.Logic_dx;

/**
 * Created by darxan on 2016/5/27.
 */
public class Sample_dx {
    public double[] x;
    public double y; // accumulate play times

    public Sample_dx(int y) {
        this.y = y;
        this.x = new double[Logic_dx.PARAMETER_SIZE];
        this.x[0] = 1;
    }
}

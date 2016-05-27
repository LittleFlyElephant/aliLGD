package logic.cr_main;

import logic.cr_util.Sample;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by raychen on 16/5/26.
 */
public class Logic {

    private static final double minE = 0.00000001;
    private static final int maxCount = 100000;

    //判断是否收敛
    private boolean converge(double e1, double e2){
        return Math.abs(e1 - e2) < minE;
    }

    /**
     * 计算估计值
     * @param x-参数列表
     * @param t-系数列表
     * @param size-列表大小
     * @return 估计值
     */
    public double h(double[] x, double[] t, int size){
        double ans = 0;
        for (int i = 0; i < size; i++) {
            ans += x[i]*t[i];
        }
        return ans;
    }

    //计算误差
    private double getError(List<Sample> samples, double[] t, int size){
        double error = 0;
        for (Sample s: samples) {
            double hh = h(s.x, t, size);
            error += (s.y - hh)* (s.y - hh);
        }
        error /= samples.size();
        return error/2;
    }

    /**
     * 计算回归系数
     * @param samples-学习样本
     * @param size-参数个数
     * @return 系数列表
     */
    public double[] getThetas(List<Sample> samples, int size){
        double[] thetas = new double[size];
        double[] lastthetas = new double[size];
        for (int i = 0; i < size; i++) thetas[i] = 0; // init
        double error = getError(samples, thetas, size); // 误差
        int count = 0; //计数
        double alpha = 1; //学习速率
        while (true){
            for (int i = 0; i < size; i++) lastthetas[i] = thetas[i];
            double err;

            //保证收敛,计算alpha
            while (true){
                for (int i = 0; i < size; i++) {
                    double sum = 0;
                    for (Sample s: samples) {
                        double hh = h(s.x, lastthetas, size);
                        sum += (hh - s.y)*s.x[i];
                    }
                    thetas[i] = lastthetas[i] - alpha*sum/samples.size();
                }
                err = getError(samples, thetas, size);
                if (err < error) break;
                alpha /= 2;
            }
//            System.out.print(count+"+"+thetas[0]+" "+thetas[1]+" -- "+error+" -- "+ alpha + " -- ");

            if (converge(err, error) || count > maxCount) break;
            error = err;
            count ++;
        }

        return thetas;
    }
}

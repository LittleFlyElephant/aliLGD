package logic.dx_main;


import logic.dx_util.Sample_dx;

import java.util.List;

/**
 * Created by darxan on 2016/5/27.
 */
public class Logic_dx {


    private static final double minE = 0.00000001;
    private static final int maxCount = 100000;

    private double alpha = 1;//学习效率
    /**
     * the highest order of parameters
     *              参数的阶数，不同于普通的线性回归：y = kx + b
     *              可能会有这样的情况： y = a*x^2 + b*x + c
     *              这里order是2.
     */
    public static final  int ORDER = 2;
    /**
     * how many parameter there is ,which have influence on our predict.
     */
    public static final  int PARAMETER_SIZE = 5;

    //判断是否收敛
    private boolean _converge(double e1, double e2){
        return Math.abs(e1 - e2) < minE;
    }

    /**
     * @param x-参数矩阵
     * @param t-系数列表
     * @return 计算以参数矩阵x和系数列表t为依据的估计值
     */
    public double calculate(double[] x,double[][] t){
        double answer = 1;
        for (int parameterSizeIterator = 0; parameterSizeIterator<ORDER; parameterSizeIterator++) {
            double temp = 0;
            double xToPowerOfOrderIterator = 1;
            for(int orderIterator = 0; orderIterator<PARAMETER_SIZE;
                orderIterator++){
                temp += t[parameterSizeIterator][orderIterator] * xToPowerOfOrderIterator;
                xToPowerOfOrderIterator*=x[parameterSizeIterator];
            }
            if(temp==0){
            }
            answer *= temp;
        }
        return  answer;
    }





    //计算误差
    private double _getError(List<Sample_dx> samples, double[][] t){
        double error = 0;
        for (Sample_dx s: samples) {
            double hh = calculate(s.x, t);
            error += (s.y - hh)* (s.y - hh);
        }
        error /= samples.size();
        return error/2;
    }


    public double[][] getThetas(List<Sample_dx> samples){
        double[][] thetas = new double[PARAMETER_SIZE][ORDER];
        double[][] lastThetas = new double[PARAMETER_SIZE][ORDER];
        for(int parameter = 0; parameter<PARAMETER_SIZE; parameter++){
            for (int  order=0; order<ORDER; order++){
                thetas[parameter][order] = 1;
            }
        }
        double error = _getError(samples, thetas); // 误差
        int count = 0; //计数

        while (true){
            for (int i = 0; i < PARAMETER_SIZE; i++){
                lastThetas[i] = thetas[i];
            }
            double newError;
            //保证收敛,计算alpha
            while (true){
                //update thetas
                for (int parameter = 0; parameter < PARAMETER_SIZE; parameter++) {
                    for(int order = 0; order<ORDER; order++){
                        double sum = 0;
                        for (Sample_dx sample:samples) {
                            double h_theta_x = calculate(sample.x,thetas);
                            double derivatives = 0.0;
                            double temp = 1;
                            for (int i=0; i<order; i++){
                                derivatives+=thetas[parameter][i]*temp;
                                temp *= sample.x[parameter];
                            }
                            sum+= (sample.y-h_theta_x)*h_theta_x*thetas[parameter][order]/derivatives;
                        }
                        thetas[parameter][order] = lastThetas[parameter][order] + sum/samples.size();
                    }
                }
                newError = _getError(samples, thetas);
                if (newError < error) break;
                alpha /= 1.1;
            }
            if (_converge(newError, error) || count > maxCount) break;
            error = newError;
            count ++;
        }
        return thetas;

    }



}

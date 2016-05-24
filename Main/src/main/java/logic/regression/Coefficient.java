package logic.regression;

import java.math.BigDecimal;
/**
 * Created by darxan on 2016/5/24.
 * 对于某一个参数{ParameterTyp}的多项式转换系数组
 */
public class Coefficient {

    public Coefficient(int index) {
        if(index<1){
            index = 1;
        }
        this.index = index;
        this.parameters = new BigDecimal[index];
        parameters[0] = new BigDecimal(1);
        for (int i = 1; i<index; i++) {
            parameters[i] = (new BigDecimal(1));
        }
    }

    /**
     *
     * 计算某一个参数的转换值
     * @param bigDecimal
     * @return  can be null
     */
    public BigDecimal calculate( BigDecimal bigDecimal){

        //err
        if(bigDecimal==null){
            System.err.println("err in calculator, bigDecimal can not be none");
            return null;
        }
        //temp
        //result = 0;
        //reuslt += bigDecimal^n;
        BigDecimal temp = new BigDecimal(1);
        BigDecimal result = new BigDecimal(0);
        for(int i=0; i<index; i++){
            result =  result.add( temp.multiply(parameters[i]) );
            temp = temp.multiply(bigDecimal);
        }
        return result;
    }

    private final int index;
    private BigDecimal[] parameters;

    public void set(int i,BigDecimal bigDecimal){
        parameters[i] = bigDecimal;
    }
    public BigDecimal get(int i){
        return parameters[i];
    }
}

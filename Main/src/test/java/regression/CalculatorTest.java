package regression;

import logic.highorder.Coefficient;

import java.math.BigDecimal;

/**
 * Created by darxan on 2016/5/24.
 */
public class CalculatorTest {

    @org.junit.Test
    public void test(){
        Coefficient vector = new Coefficient(5);
        assert (vector.calculate(new BigDecimal(10)).longValue()==11111);
    }
}

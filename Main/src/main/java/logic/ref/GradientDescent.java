package logic.ref;
import java.text.DecimalFormat;

public class GradientDescent {
    /**
     * gradient descent algorithm
     * this program can only for one criterion variable
     * but many predictor variable
     * @pred_size predictor variable's size
     * @train_size size of the training data
     * @pred_var predictor variable
     * @crit_var criterion variable
     * @para parameter
     * @rate learning rate
     */
    static DecimalFormat df   =new DecimalFormat("#.000000000");

    static int pred_size=1,train_size=6;
    /*
     * predictor variable(can be more than one)
     * h=ax+b,one predictor variable,have two parameter:a,b.the pred_var value for the b is
     * {1,1,1,1,...}.because h=ax+b'y','y'==1
     */
    static double[][] pred_var;

    static double[] crit_var;
    /*
     * for example,h=ax1+bx2+c,para[0]=a,para[1]=b,para[2]=c
     */
    static double[] para=new double[pred_size+1];
    //learning rate
    static double rate=0.0002;

    //cost function
    static double cost_fun=0;

    public static void main(String args[]){
        pred_var=new double[][]{{9,15,25,14,10,18},{1,1,1,1,1,1}};
        crit_var=new double[]{39,56,93,61,50,75};

		/*test:score=4*a+1
		  pred_var=new double[][]{{9,15,25,14,10,18},{1,1,1,1,1,1}};
		  crit_var=new double[]{37,61,101,57,41,73};*/

        //initialize the parameter
        for (double d : para) {
            d=0;
        }

        GradientDescent.obtainParaByGD();

        for (int i=0;i<pred_size+1;i++) {
            System.out.print("para["+i+"]="+df.format(para[i])+" ");
        }
        System.out.println();
        System.out.println("cost:"+df.format(cost_fun));

    }
    /**
     *
     * @hy_value h(a)=a0+a1x1+a2x2+...
     * @flag iterations
     * @temp_para  accumulated value in Gradient_D
     * @min_fun The minimum loss function
     */
    public static void obtainParaByGD(){

        double hy_value;
        for(int i=0;i<train_size;i++)
        {
            hy_value=0;
            for(int j=0;j<=pred_size;j++)
            {
                hy_value+=para[j]*pred_var[j][i];
            }

            cost_fun+=(hy_value-crit_var[i])*(hy_value-crit_var[i]);
        }
        cost_fun=cost_fun/2;

        double min_fun=cost_fun;

        int flag=0;

        while(true)
        {
            double[] temp_para=new double[pred_size+1];
            for (double d : temp_para) {
                d=0;
            }
            for(int j=0;j<=pred_size;j++)
            {

                for(int i=0;i<train_size;i++)
                {
                    hy_value=0;
                    for(int h=0;h<=pred_size;h++){
                        hy_value+=para[h]*pred_var[h][i];
                    }

                    temp_para[j]+=((hy_value-crit_var[i])*pred_var[j][i]);

                }

            }
            for(int i=0;i<=pred_size;i++){
                para[i]=para[i]-rate*temp_para[i];
                //System.out.println(para[i]+" ");
            }

            for(int i=0;i<train_size;i++)
            {
                hy_value=0;
                for(int j=0;j<=pred_size;j++)
                {
                    hy_value+=para[j]*pred_var[j][i];
                }
                cost_fun+=(hy_value-crit_var[i])*(hy_value-crit_var[i]);
            }
            cost_fun=cost_fun/2;

            if(cost_fun<min_fun)
            {
                min_fun=cost_fun;
                flag=0;
            }else {
                flag++;
            }
            if(flag==1000)
                break;
        }
    }
}

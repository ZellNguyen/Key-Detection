import Jama.Matrix;
import org.jblas.*;

/**
 * Created by Zell on 12/11/15.
 */
public class test {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        DoubleMatrix R = DoubleMatrix.rand(1024,1024);
        DoubleMatrix X = DoubleMatrix.rand(1024,1);
        DoubleMatrix Y = R.mmul(X);
        double[] rs = Y.toArray();
        for(int i = 0; i < rs.length; i++) rs[i] = rs[i]*rs[i];
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

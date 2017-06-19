import org.jblas.*;
/**
 * Created by Zell on 11/13/15.
 */
public class FourierTransform {

    public double[] magnitudeFT (double[] input, int samples){

        //Create two parts real and imagine
        double[][] real = new double[samples][samples];
        double[][] imagine = new double[samples][samples];

        //k is the number of samples
        //n = k = (2*pi)/(samples*omega)
        int k = 0;
        int n = 0;

        //Create two matrix of real and imagine
        for(n = 0; n < samples; n++){
            for(k = 0; k < samples; k++){
                double angle = (2*Math.PI*n*k)/samples;
                real[n][k] = Math.cos(angle);
                imagine[n][k] = Math.sin(angle);
            }
        }

        DoubleMatrix R = new DoubleMatrix(real);
        DoubleMatrix I = new DoubleMatrix(imagine);

        //Create Matrix X which is the input signal
        DoubleMatrix X = new DoubleMatrix(input);

        //Compute Matrix Y which is the Fourier Transform
        DoubleMatrix subY1 = R.mmul(X);
        subY1 = subY1.mul(subY1);

        DoubleMatrix subY2 = I.mmul(X);
        subY2 = subY2.mul(subY2);

        DoubleMatrix Y = subY1.add(subY2);
        double[] output = Y.toArray();
        for(int i = 0; i < output.length; i++){
            output[i] = Math.sqrt(output[i]);
        }
        return output;
    }

    public double[] logFourier(double[] array){
        double[] logF = array;
        for(int i = 0; i < array.length; i++){
            logF[i] = Math.log(array[i]);
        }
        return logF;
    }

    public double[] inverseFourier(double[] array, int samples){
        double[][] real = new double[samples][samples];
        double[][] imagine = new double[samples][samples];

        int k = 0;
        int n = 0;
        for(k = 0; k < samples; k++){
            for(n = 0; n < samples; n++){
                double angle = (2*Math.PI*n*k)/samples;
                real[k][n] = Math.cos(angle)/samples;
                imagine[k][k] = Math.sin(angle)/samples;
            }
        }

        DoubleMatrix R = new DoubleMatrix(real);
        DoubleMatrix I = new DoubleMatrix(imagine);

        DoubleMatrix X = new DoubleMatrix(array);
        //(X.transpose()).print(1,3);

        DoubleMatrix subY1 = R.mmul(X);
        subY1 = subY1.mul(subY1);

        DoubleMatrix subY2 = I.mmul(X);
        subY2 = subY2.mul(subY2);

        DoubleMatrix Y = subY1.add(subY2);
        double[] output = Y.toArray();
        for(int i = 0; i < output.length; i++){
            output[i] = Math.sqrt(output[i]);
        }
        return output;
    }

}

import org.ojalgo.matrix.*;
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

        Matrix R = new Matrix(real);
        Matrix I = new Matrix(imagine);

        //Create Matrix X which is the input signal
        Matrix X = new Matrix(input,1);
        //(X.transpose()).print(1,3);

        //Compute Matrix Y which is the Fourier Transform
        Matrix subY1 = R.times(X.transpose());
        subY1 = subY1.arrayTimes(subY1);

        Matrix subY2 = I.times(X.transpose());
        subY2 = subY2.arrayTimes(subY2);

        Matrix Y = subY1.plus(subY2);
        double[] output = Y.getColumnPackedCopy();
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

        Matrix R = new Matrix(real);
        Matrix I = new Matrix(imagine);

        Matrix X = new Matrix(array,1);
        //(X.transpose()).print(1,3);

        Matrix subY1 = R.times(X.transpose());
        subY1 = subY1.arrayTimes(subY1);

        Matrix subY2 = I.times(X.transpose());
        subY2 = subY2.arrayTimes(subY2);

        Matrix Y = subY1.plus(subY2);
        double[] output = Y.getColumnPackedCopy();
        for(int i = 0; i < output.length; i++){
            output[i] = Math.sqrt(output[i]);
        }
        return output;
    }

}

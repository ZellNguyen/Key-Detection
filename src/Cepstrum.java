import java.io.File;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zell on 12/3/15.
 */
public class Cepstrum extends FourierTransform{
    public double getFrequency(double[] array, int frameRate){

        //initialize the peak as of frequency 50Hz - upper bound of fundamental frequency
        double max = array[frameRate/260];
        double frequency = 0;
        int i = 0;

        //Find the peak in range 50Hz - 320Hz
        for(i = (frameRate/260); i < (frameRate/80); i++){
            if(array[i] > max) {
                max = array[i];
                frequency = frameRate/i;
            }
        }

        //frequency = frame rate / position of peak
        return frequency;
    }

    public double[] hamming(double[] array){

        for(int n = 0; n < array.length; n++){
            double angle = (2*Math.PI*n)/((double)array.length-1);
            double hamming = 0.54 - 0.46*Math.cos(angle);
            array[n] = array[n]*hamming;
        }

        return array;
    }
}

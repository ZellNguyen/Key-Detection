import Jama.Matrix;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zell on 12/4/15.
 */
public class CepstrumPitchDetect extends Cepstrum{
    /*** Get the note of the input frequency ***/
    public Note isEqual(double frequency){
        double min_error = (frequency - Note.F2.frequency) * (frequency - Note.F2.frequency);
        Note comparedNote = Note.F2;
        for(Note note: Note.NOTES) {
            if (min_error > (frequency - note.frequency) * (frequency - note.frequency)) {
                min_error = (frequency - note.frequency) * (frequency - note.frequency);
                comparedNote = note;
            }
        }
        return comparedNote;
    }

    public List<Note> pitchDetect(WavFile wavFile, int frames){

        /*** Initialize wavFile properties ***/
        int numChannels = wavFile.getNumChannels();

        double[][] temp_buffer = new double[(int)Math.ceil(wavFile.getNumFrames() / (float)frames)][frames * numChannels];

        int framesRead;
        int i = 0;

        List<Note> noteList = new ArrayList<Note>();

        /***Start pitch detection***/

        try {
            /** Read frames into buffer **/
            do {
                framesRead = wavFile.readFrames(temp_buffer[i], frames);
                i++;
            } while (framesRead == frames);


            //Analyse frames*4 at the same time
            for (int k = 0; k + 3 < temp_buffer.length; k++) {
                //merge 4 temp_buffer into 1 buffer
                double[] buffer = MergeArrays.merge(temp_buffer[k], temp_buffer[k + 1], temp_buffer[k + 2], temp_buffer[k + 3]);
                CepstrumPitchDetect obj = new CepstrumPitchDetect();
                //buffer = obj.hamming(buffer);

                /***Cepstrum process***/

                double[] frequency = obj.magnitudeFT(buffer, frames * 4);
                frequency = obj.hamming(frequency);
                double[] logFrequency = obj.logFourier(frequency);
                double[] quefrency = obj.inverseFourier(logFrequency, frames * 4);
                Matrix C = new Matrix(quefrency, 1);
                double f = obj.getFrequency(quefrency, (int) wavFile.getSampleRate());

                /***End Cepstrum process***/

                /*** Get the equal note ***/
                Note note = obj.isEqual(f);
                noteList.add(note);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return noteList;
    }

    public static void main (String args[]){
        try{
            WavFile wavFile = WavFile.openWavFile(new File("sample4.wav"));

            // Create a buffer of 256 frames
            int frames = 256;

            //Start pitch detection process
            CepstrumPitchDetect obj = new CepstrumPitchDetect();
            obj.pitchDetect(wavFile, frames);

            System.out.println(wavFile.getNumFrames());

            // Close the wavFile
            wavFile.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

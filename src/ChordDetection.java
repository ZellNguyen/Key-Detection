import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zell on 12/4/15.
 */
public class ChordDetection extends CepstrumPitchDetect{
    public Note[] percentageNote(List<Note> noteList){
        Note[] notes = Note.NOTES;
        for(int i = 0; i < notes.length; i++ ) {
            int count = 0;
            for (Iterator<Note> k = noteList.iterator(); k.hasNext(); ) {
                Note item = k.next();
                if(notes[i].equals(item)) count ++;
            }
            notes[i].setPercentage((double)count/noteList.size() * 100);
        }
        return notes;
    }

    public Note[] selectTop(Note[] notes){
        Note[] topNotes = new Note[3];
        for(int i = 1; i <= 3; i++ ){
            Selection select = new Selection();
            Note note = select.quickselect(notes, i);
            topNotes[i-1] = note;
        }

        return topNotes;
    }

    public Note[] chordDetect(WavFile wavFile, int frames){
        ChordDetection obj = new ChordDetection();
        List<Note> noteList = obj.pitchDetect(wavFile, frames);
        Note[] notes = obj.percentageNote(noteList);
        //notes = obj.selectTop(notes);

        return notes;
    }

    public static void main (String args[]){
        try{
            WavFile wavFile = WavFile.openWavFile(new File("sample5.wav"));

            // Create a buffer of 256 frames
            int frames = 256;

            //Start chord detection process

            ChordDetection obj = new ChordDetection();
            Note[] notes = obj.chordDetect(wavFile, frames);

            for(Note note: notes){
                System.out.println(note.percentage);
            }

            System.out.println(wavFile.getNumFrames());

            // Close the wavFile
            wavFile.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

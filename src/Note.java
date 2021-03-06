/**
 * Created by Zell on 12/3/15.
 */
public class Note {

    double frequency;
    String name;
    double percentage;

    public static final Note F2 = new Note(87.31, "F2");
    public static final Note Fsharp2 = new Note(92.50, "F#2");
    public static final Note G2 = new Note(98.00, "G2");
    public static final Note Gsharp2 = new Note(103.83, "G#2");
    public static final Note A2 = new Note(110.00, "A2");
    public static final Note Asharp2 = new Note(116.54, "A#2");
    public static final Note B2 = new Note(123.47, "B2");
    public static final Note C3 = new Note(130.81, "C3");
    public static final Note Csharp3 = new Note(138.59, "C#3");
    public static final Note D3 = new Note(146.83, "D3");
    public static final Note Dsharp3 = new Note(155.56, "D#3");
    public static final Note E3 = new Note(164.81, "E3");
    public static final Note F3 = new Note(174.61, "F3");
    public static final Note Fsharp3 = new Note(185.00, "F#3");
    public static final Note G3 = new Note(196.00, "G3");
    public static final Note Gsharp3 = new Note(207.65, "G#3");
    public static final Note A3 = new Note(220, "A3");
    public static final Note Asharp3 = new Note(233.08, "A#3");
    public static final Note B3 = new Note(246.94, "B3");

    public static final Note[] NOTES = new Note[]{F2, Fsharp2, G2, Gsharp2, A2, Asharp2, B2, C3, Csharp3, D3, Dsharp3,
    E3, F3, Fsharp3, G3, Gsharp3, A3, Asharp3, B3};

    public Note(double frequency, String name) {
        this.frequency = frequency;
        this.name = name;
        this.percentage = 0;
    }

    public boolean equals(Note note){
        if(this.frequency == note.frequency) return true;
        return false;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}

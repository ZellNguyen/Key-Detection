import java.util.Arrays;
import java.util.List;

/**
 * Created by Zell on 12/4/15.
 */
public class Chord {
    List<Note> noteList;
    String name;

    public Chord(List<Note> noteList, String name) {
        this.noteList = noteList;
        this.name = name;
    }

    /*** LIST OF MAJOR CHORDS ***/
    public static final Chord CMajor = new Chord(Arrays.asList(Note.G2, Note.C3, Note.E3, Note.G3), "C");
    public static final Chord CsharpMajor = new Chord(Arrays.asList(Note.F2, Note.Gsharp2, Note.Csharp3, Note.F3, Note.Gsharp3), "C#");
    public static final Chord DMajor = new Chord(Arrays.asList(Note.Fsharp2, Note.A2, Note.D3, Note.Fsharp3, Note.A3), "D");
    public static final Chord DsharpMajor = new Chord(Arrays.asList(Note.G2, Note.Asharp2, Note.Dsharp3, Note.G3, Note.Asharp3), "D#");
    public static final Chord EMajor = new Chord(Arrays.asList(Note.Gsharp2, Note.B2, Note.E3, Note.Gsharp3, Note.B3), "D#");
    public static final Chord FMajor = new Chord(Arrays.asList(Note.F2, Note.A2, Note.C3, Note.F3, Note.A3), "F");
    public static final Chord FsharpMajor = new Chord(Arrays.asList(Note.Fsharp2, Note.Asharp2, Note.Csharp3, Note.Fsharp3, Note.Asharp3), "F#");
    public static final Chord GMajor = new Chord(Arrays.asList(Note.G2, Note.B2, Note.D3, Note.G3, Note.B3), "G");
    public static final Chord GsharpMajor = new Chord(Arrays.asList(Note.Gsharp2, Note.C3, Note.Dsharp3, Note.Gsharp3), "G#");
    public static final Chord AMajor = new Chord(Arrays.asList(Note.A2, Note.Csharp3, Note.E3, Note.A3), "A");
    public static final Chord AsharpMajor = new Chord(Arrays.asList(Note.F2, Note.Asharp2, Note.D3, Note.F3), "A#");
    public static final Chord BMajor = new Chord(Arrays.asList(Note.Fsharp2, Note.B2, Note.Dsharp3, Note.Fsharp3), "B");

    /*** LIST OF MINOR CHORDS ***/
    public static final Chord CMinor = new Chord(Arrays.asList(Note.G2, Note.C3, Note.Dsharp3, Note.G3), "Cm");
    public static final Chord CsharpMinor = new Chord(Arrays.asList(Note.Gsharp2, Note.Csharp3, Note.E3, Note.Gsharp3), "C#m");
    public static final Chord DMinor = new Chord(Arrays.asList(Note.F2, Note.A2, Note.D3, Note.F3, Note.A3), "Dm");
    public static final Chord DsharpMinor = new Chord(Arrays.asList(Note.Fsharp2, Note.Asharp2, Note.Dsharp3, Note.Fsharp3, Note.Asharp3), "D#m");
    public static final Chord EMinor = new Chord(Arrays.asList(Note.G2, Note.B2, Note.E3, Note.G3, Note.B3), "Em");
    public static final Chord FMinor = new Chord(Arrays.asList(Note.F2, Note.Gsharp2, Note.C3, Note.F3, Note.Gsharp3), "Fm");
    public static final Chord FsharpMinor = new Chord(Arrays.asList(Note.Fsharp2, Note.A2, Note.Csharp3, Note.Fsharp3, Note.A3), "F#m");
    public static final Chord GMinor = new Chord(Arrays.asList(Note.G2, Note.Asharp2, Note.D3, Note.G3, Note.Asharp3), "Gm");
    public static final Chord GsharpMinor = new Chord(Arrays.asList(Note.Gsharp2, Note.B2, Note.Dsharp3, Note.Gsharp3, Note.B3), "G#m");
    public static final Chord AMinor = new Chord(Arrays.asList(Note.A2, Note.C3, Note.E3, Note.A3), "Am");
    public static final Chord AsharpMinor = new Chord(Arrays.asList(Note.F2, Note.Asharp2, Note.Csharp3, Note.F3, Note.Asharp3), "A#m");
    public static final Chord BMinor = new Chord(Arrays.asList(Note.Fsharp2, Note.B2, Note.D3, Note.Fsharp3, Note.B3), "Bm");

    /*** ARRAYS OF ALL CHORDS ***/
    public static final Chord[] chords = new Chord[]{CMajor, CMinor, CsharpMajor. CsharpMinor, DMajor, DMinor, DsharpMajor, DsharpMinor,
    EMajor, EMinor, FMajor, FMinor, FsharpMajor, FsharpMinor, GMajor, GMinor, GsharpMajor, GsharpMinor, AMajor, AMinor, AsharpMajor,
    AsharpMinor, BMajor, BMinor};

}

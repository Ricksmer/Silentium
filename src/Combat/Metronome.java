package Combat;

public class Metronome {
    private int beat;

    public Metronome() {
        beat = 1;
    }

    public int getBeat() {
        return beat;
    }

    public void reset() {
        beat = 1;
    }

    public void updateBeat(int totalNoteDamage) {
        if (totalNoteDamage % beat == 0) {
            beat++;
            if (beat > 4) beat = 4;
            System.out.println("Beat Sync! Metronome increased to " + beat + "!");
        } else {
            beat--;
            if (beat < 1) beat = 1;
            System.out.println("Off-beat! Metronome decreased to " + beat + ".");
        }
    }
}
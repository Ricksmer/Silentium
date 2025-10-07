package Combat;

public class Metronome {
    private int beat;

    public Metronome() {
        beat = 1; // starts at 1 at the beginning of the battle
    }

    public int getBeat() {
        return beat;
    }

    public void reset() {
        beat = 1;
    }

    // Update metronome based on the total note damage (sum of notes)
    public void updateBeat(int totalNoteDamage) {
        if (totalNoteDamage % beat == 0) {
            // Divisible → increase beat
            beat++;
            if (beat > 4) beat = 4;
            System.out.println("Beat Sync! Metronome increased to " + beat + "!");
        } else {
            // Not divisible → decrease beat
            beat--;
            if (beat < 1) beat = 1;
            System.out.println("Off-beat! Metronome decreased to " + beat + ".");
        }
    }
}
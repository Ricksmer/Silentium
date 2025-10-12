package Combat;

import Player.Character;

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

    public int updateBeat(Character player, int totalNoteDamage) {
        if (totalNoteDamage % beat == 0) {
            totalNoteDamage *= beat;
            beat++;
            if (beat > 4) beat = 4;
            System.out.println("\tBeat Sync! Metronome increased to " + beat + "!");

            // LYRON PASSIVE
            if (player.name.equals("Lyron")) {
                totalNoteDamage = player.ps.skillEffect(player, totalNoteDamage);
            }
        } else {
            beat--;
            if (beat < 1) beat = 1;
            System.out.println("\tOff-beat! Metronome decreased to " + beat + ".");
        }

        return totalNoteDamage;
    }
}
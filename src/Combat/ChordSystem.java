package Combat;

import Player.Character;

public class ChordSystem {
    //chord detection
    public String checkChord(char n1, char n2, char n3) {
        String notes = "" + n1 + n2 + n3;

        if (contains(notes, 'C') && contains(notes, 'E') && contains(notes, 'G')) return "CMAJOR";
        if (contains(notes, 'D') && contains(notes, 'F') && contains(notes, 'A')) return "DMINOR";
        if (contains(notes, 'E') && contains(notes, 'G') && contains(notes, 'B')) return "EMINOR";
        if (contains(notes, 'F') && contains(notes, 'A') && contains(notes, 'C')) return "FMAJOR";
        if (contains(notes, 'G') && contains(notes, 'B') && contains(notes, 'D')) return "GMAJOR";
        if (contains(notes, 'A') && contains(notes, 'C') && contains(notes, 'E')) return "AMINOR";
        if (contains(notes, 'B') && contains(notes, 'D') && contains(notes, 'F')) return "BDIM";

        return null;
    }

    private boolean contains(String notes, char c) {
        return notes.indexOf(c) != -1;
    }

    //main buff system
    public void applyChord(String chord, Character player) {
        if (chord == null) return;

        switch (chord) {
            case "CMAJOR":
                player.heal((int)(player.getMaxHp() * 0.2));
                System.out.println("Chord Activated: C Major! Healed 20% HP.");
                break;
            case "DMINOR":
                player.setDamageBuff(1.2);
                System.out.println("Chord Activated: D Minor! +20% Damage Buff.");
                break;
            case "EMINOR":
                player.heal((int)(player.getMaxHp() * 0.1));
                player.setDamageBuff(1.1);
                System.out.println("Chord Activated: E Minor! Heal 10% HP & +10% Damage Buff.");
                break;
            case "FMAJOR":
                player.addShield(25);
                System.out.println("Chord Activated: F Major! +25 Shield Points.");
                break;
            case "GMAJOR":
                player.heal((int)(player.getMaxHp() * 0.15));
                player.addShield(15);
                System.out.println("Chord Activated: G Major! Heal 15% HP & +15 Shield Points.");
                break;
            case "AMINOR":
                player.addShield(35);
                System.out.println("Chord Activated: A Minor! +35 Shield Points.");
                break;
            case "BDIM":
                player.setDamageBuff(1.3);
                player.setHp(player.getHp() - (int)(player.getMaxHp() * 0.1));
                System.out.println("Chord Activated: B Dim! +30% Damage but lose 10% HP.");
                break;
        }
    }
}

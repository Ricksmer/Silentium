package Combat;

import Player.Character;

public class ChordSystem {
    private boolean cMajor = false;
    private boolean dMinor = false;
    private boolean eMinor = false;
    private boolean fMajor = false;
    private boolean gMajor = false;
    private boolean aMinor = false;
    private boolean bDim = false;

    public void ChordSystem() {
        resetChords();
    }

    //reset all chords
    public void resetChords() {
        cMajor = false;
        dMinor = false;
        eMinor = false;
        fMajor = false;
        gMajor = false;
        aMinor = false;
        bDim = false;
    }

    //chord detection
    public String checkChord(char n1, char n2, char n3) {
        String notes = "" + n1 + n2 + n3;

        if (!cMajor && (contains(notes, 'C') && contains(notes, 'E') && contains(notes, 'G'))) {
            cMajor = true;
            return "CMAJOR";
        }
        if (!dMinor && (contains(notes, 'D') && contains(notes, 'F') && contains(notes, 'A'))) {
            dMinor = true;
            return "DMINOR";
        }
        if (!eMinor && (contains(notes, 'E') && contains(notes, 'G') && contains(notes, 'B'))) {
            eMinor = true;
            return "EMINOR";
        }
        if (!fMajor && (contains(notes, 'F') && contains(notes, 'A') && contains(notes, 'C'))) {
            fMajor = true;
            return "FMAJOR";
        }
        if (!gMajor && (contains(notes, 'G') && contains(notes, 'B') && contains(notes, 'D'))) {
            gMajor = true;
            return "GMAJOR";
        }
        if (!aMinor && (contains(notes, 'A') && contains(notes, 'C') && contains(notes, 'E'))) {
            aMinor = true;
            return "AMINOR";
        }
        if (!bDim && (contains(notes, 'B') && contains(notes, 'D') && contains(notes, 'F'))) {
            bDim = true;
            return "BDIM";
        }

        return null;
    }

    private boolean contains(String notes, char c) {
        return notes.indexOf(c) != -1;
    }

    //main buff system
    public int applyChord(String chord, Character player, int damage) {
        if (chord == null) return damage;

        double bonusDamage = 1;

        //AURELIUS PASSIVE

        if(player.name.equals("Aurelius")) player.ps.skillEffect(player);
        System.out.println();
        System.out.println("===================================================");
        System.out.println();

        switch (chord) {
            case "CMAJOR":
                player.heal((int)(player.getMaxHp() * 0.2));
                System.out.println("\tChord Activated: C Major! Healed 20% HP.");
                break;
            case "DMINOR":
                player.setDamageBuff(1.2);
                System.out.println("\tChord Activated: D Minor! +20% Damage Buff.");
                break;
            case "EMINOR":
                player.heal((int)(player.getMaxHp() * 0.1));
                player.setDamageBuff(1.1);
                System.out.println("\tChord Activated: E Minor! Heal 10% HP & +10% Damage Buff.");
                break;
            case "FMAJOR":
                player.addShield(25);
                System.out.println("\tChord Activated: F Major! +25 Shield Points.");
                break;
            case "GMAJOR":
                player.heal((int)(player.getMaxHp() * 0.15));
                player.addShield(15);
                System.out.println("\tChord Activated: G Major! Heal 15% HP & +15 Shield Points.");
                break;
            case "AMINOR":
                player.addShield(35);
                System.out.println("\tChord Activated: A Minor! +35 Shield Points.");
                break;
            case "BDIM":
                bonusDamage = 1.3;
                player.setHp(player.getHp() - (int)(player.getMaxHp() * 0.1));
                System.out.println("\tChord Activated: B Dim! +30% Damage but lose 10% HP.");
                break;
        }

        System.out.println();
        System.out.println("===================================================");
        System.out.println();
        return (int) (damage * bonusDamage);
    }

    public void chordChart(){
        System.out.println("===================================================");
        System.out.println();
        System.out.println("\t\t --- CHORD CHART --- ");
        System.out.println();
        System.out.println("\t [ C Major ] ---> \t" + (cMajor ? "USED" : "AVAILABLE"));
        System.out.println("\t [ D Minor ] ---> \t" + (dMinor ? "USED" : "AVAILABLE"));
        System.out.println("\t [ E Minor ] ---> \t" + (eMinor ? "USED" : "AVAILABLE"));
        System.out.println("\t [ F Major ] ---> \t" + (fMajor ? "USED" : "AVAILABLE"));
        System.out.println("\t [ G Major ] ---> \t" + (gMajor ? "USED" : "AVAILABLE"));
        System.out.println("\t [ A Minor ] ---> \t" + (aMinor ? "USED" : "AVAILABLE"));
        System.out.println("\t [ B Dim   ] ---> \t" + (bDim ? "USED" : "AVAILABLE"));
        System.out.println();
        System.out.println("===================================================");
    }
}

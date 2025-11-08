package Display;

import java.util.Scanner;

public class HowToPlay {
    private final TextDisplay text = new TextDisplay();
    private final Scanner sc = new Scanner(System.in);

    public void displayHowToPlay() {
        text.lineBreak();
        text.printSystemMessage("--- HOW TO PLAY SILENTIUM ---");
        text.lineBreak();

        introduction();      text.pause();
        combatSystem();      text.pause();
        noteSystem();        text.pause();
        metronomeSystem();   text.pause();
        chordSystem();       text.pause();
        defenseSystem();     text.pause();
        itemSystem();        text.pause();
        text.lineBreak();
        text.printSystemMessage("--- END OF HOW TO PLAY ---");
        text.lineBreak();
    }

    private void introduction() {
        text.printNarration("Welcome to Silentium — a tactical rhythm RPG where music becomes your weapon against silence itself.");
        text.printNarration("Each battle tests your timing, strategy, and mastery of notes, chords, and rhythm. Victory depends on harmony — not haste.");
    }

    private void combatSystem() {
        text.shortbreak();
        text.printSystemMessage("COMBAT SYSTEM");
        text.printNarration("During combat, you will enter musical notes (A–G) to attack your enemies.");
        text.printNarration("Each note has its own damage range, and damage changes per turn depending on the note’s rhythm alignment.");
        System.out.println("""
                
                \t\tA -> 1–10 Damage
                \t\tB -> 5–13 Damage
                \t\tC -> 9–16 Damage
                \t\tD -> 12–18 Damage
                \t\tE -> 16–21 Damage
                \t\tF -> 19–23 Damage
                \t\tG -> 21–24 Damage
                """);
        text.printNarration("Combine these notes strategically to deal maximum damage or synchronize with the Metronome.");
    }

    private void noteSystem() {
        text.shortbreak();
        text.printSystemMessage("NOTE INPUT SYSTEM");
        text.printNarration("Before each attack phase, you will be asked to enter notes. Each note represents a musical strike.");
        text.printNarration("You can mix notes like A, C, and G for custom combinations — experiment to find your strongest sequences.");
    }

    private void metronomeSystem() {
        text.shortbreak();
        text.printSystemMessage("METRONOME SYSTEM");
        text.printNarration("At the start of every battle, the metronome begins at tempo 1.");
        text.printNarration("If the total sum of your selected notes is divisible by the current tempo, your attack is amplified!");
        text.printNarration("The metronome then increases its tempo by one (up to 4). If not divisible, it decreases by one.");
        text.printNarration("Timing your notes and damage totals can multiply your attacks dramatically.");
    }

    private void chordSystem() {
        text.shortbreak();
        text.printSystemMessage("CHORD SYSTEM");
        text.printNarration("Chords can be played to heal, gain shields, or enhance your damage.");
        text.printNarration("Each chord can only be used once, so use them wisely.");
        System.out.println("""
                
                \t\tC Major  ->  C-E-G   -> Heal 20% HP
                \t\tD Minor  ->  D-F-A   -> +20% Damage
                \t\tE Minor  ->  E-G-B   -> Heal 10% HP + 10% Damage
                \t\tF Major  ->  F-A-C   -> Gain 25 Shield
                \t\tG Major  ->  G-B-D   -> Heal 15% HP + 15 Shield
                \t\tA Minor  ->  A-C-E   -> Gain 35 Shield
                \t\tB Dim    ->  B-D-F   -> +30% Damage, Lose 10% HP
                """);
        text.printNarration("Mastering chord usage can turn the tide of even the most difficult battles.");
    }

    private void defenseSystem() {
        text.shortbreak();
        text.printSystemMessage("DEFENSE & EVADE SYSTEM");
        text.printNarration("Defense reduces enemy damage using your current shield points.");
        text.printNarration("Aurelius has a unique Evade skill that lets him dodge attacks — each success lowers his next evade chance by 75%.");
        text.printNarration("Always monitor your shield, as running out leaves your health exposed.");
    }

    private void itemSystem() {
        text.shortbreak();
        text.printSystemMessage("DROP ITEMS");
        text.printNarration("Enemies can drop powerful relics after combat:");
        System.out.println("""
                
                \t\tCrimson Chorus   -> Enemies take +5–10% more damage for 2–3 turns.
                \t\tSilent Barrier   -> Grants 1 turn of full immunity.
                \t\tResolved Dissonance -> Play B Diminished without losing HP.
                \t\tMinor’s Grace    -> Start with +1 Minor Chord.
                \t\tMajor’s Blessing -> Start with +1 Major Chord.
                """);
        text.printNarration("Collecting these can offer temporary advantages or save you from defeat.");
    }

    /*
    private void pause() {
        text.printSystemInput("Press [ENTER] to continue...");
        sc.nextLine();
    } */
}

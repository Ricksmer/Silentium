package Display;

import java.util.Random;
import Player.Character;
import Enemy.Monster;

public class Dialogue implements CharacterDialogue {
    private final Random random = new Random();
    private TextDisplay text = new TextDisplay();

    private String[] quotes = new String[5];
    public void setQuotes(String[] quotes) { this.quotes = quotes; }
    public String[] getQuotes() { return quotes; }


    // --- Storyteller Implementation (Specific Story Sequences) ---

    public void firstLevelUp(Character character) {
        if (character.name.equals("Sonara")) {
            text.printSystemMessage("SONARA LEVEL UP: Vicious, clean force.");
            text.printNarration("Sonara has leveled up. Vicious, clean force. Her Banjo found its edge.");
            text.printDialogue(character, "The strings are cleaner now. I won't lose this clarity again; this feeling of striking back.\nI won't stop until there's nowhere left for the shadows to hide.");
        }

        else if (character.name.equals("Aurelius")) {
            text.printSystemMessage("AURELIUS LEVEL UP: Resilient barrier.");
            text.printNarration("Aurelius has leveled up. Resilient barrier. His breath stabilized the shield.");
            text.printDialogue(character, "I can see the fear, and my breath pushes it away. This instrument is a boundary.\nI will keep playing for those who can't.");
        }

        else if (character.name.equals("Lyron")) {
            text.printSystemMessage("LYRON LEVEL UP: Complex, sweeping patterns.");
            text.printNarration("Lyron has leveled up. Complex, sweeping patterns. He found structure for engagement.");
            text.printDialogue(character, "I watched it vanish. The guilt is heavy, but the sound feels like my mother.\nI can't be a coward if I have this. I have to be strong enough to see the next shadow fall.");
        }
    }

    public void secondLevelUp(Character character) {
        if (character.name.equals("Sonara")) {
            text.printSystemMessage("SONARA LEVEL 2: Deeply disruptive sound.");
            text.printNarration("Sonara has leveled up. Deeply disruptive sound. The rhythm broke their cohesion.");
            text.printDialogue(character, "The rhythm is focused. I know where to hit them.\nVengeance is a clean, sharp note, and I have the pattern now.");
        }

        else if (character.name.equals("Aurelius")) {
            text.printSystemMessage("AURELIUS LEVEL 2: Layered harmonies.");
            text.printNarration("Aurelius has leveled up. Layered harmonies. The protective shield expanded.");
            text.printDialogue(character, "The music is lighter now, less burdened by my past. This is more than debt; it's hope.\nThe cruelty of my family ends with every breath I give.");
        }

        else if (character.name.equals("Lyron")) {
            text.printSystemMessage("LYRON LEVEL 2: Intricate arpeggios.");
            text.printNarration("Lyron has leveled up. Intricate arpeggios. Sound-webs trapped the enemy.");
            text.printDialogue(character, "The guilt is a weapon, a promise. The Harp spins webs that trap the shadows.\nI'll use every trick to avoid fighting face-to-face.");
        }
    }

    public void thirdLevelUp(Character character) {
        if (character.name.equals("Sonara")) {
            text.printSystemMessage("SONARA LEVEL 3: Calculated sonic bursts.");
            text.printNarration("Sonara has leveled up. Calculated sonic bursts. The hunt became surgical.");
            text.printDialogue(character, "No wasted motion, no wasted sound.\nMy rage isn't a fire anymore—it’s the scalpel. Every note cuts exactly where it must.\nThis is not feeling; this is precision.");
        }

        else if (character.name.equals("Aurelius")) {
            text.printSystemMessage("AURELIUS LEVEL 3: Purifying trills.");
            text.printNarration("Aurelius has leveled up. Purifying trills. The sound banished mental corruption.");
            text.printDialogue(character, "They try to break my focus, but the notes keep weaving, faster.\nI am not brittle; I am layered resilience. My music finds everyone waiting beneath the surface.");
        }

        else if (character.name.equals("Lyron")) {
            text.printSystemMessage("LYRON LEVEL 3: Tragic clarity.");
            text.printNarration("Lyron has leveled up. Tragic clarity. The Harp struck with the weight of his loss.");
            text.printDialogue(character, "I couldn't run. The fear is there, but I played through it.\nThis Harp is my witness. I will make the thing that ruined my life suffer.");
        }
    }


    public void fourthLevelUp(Character character) {
        if (character.name.equals("Sonara")) {
            text.printSystemMessage("SONARA LEVEL 4: Final signature.");
            text.printNarration("Sonara has leveled up. Final signature. The sound became retribution's voice.");
            text.printDialogue(character, "There is no turning back.\nThe sound is a permanent promise etched onto my soul. I will play the final, deafening chord.");
        }

        else if (character.name.equals("Aurelius")) {
            text.printSystemMessage("AURELIUS LEVEL 4: Voice of justice.");
            text.printNarration("Aurelius has leveled up. Voice of justice. His sound carried the promise of the future.");
            text.printDialogue(character, "The path is clear. This is the rebuilding.\nThe trust I feel is a foundation. I play for a world that knows the quiet truth of justice.");
        }

        else if (character.name.equals("Lyron")) {
            text.printSystemMessage("LYRON LEVEL 4: Quiet dignity.");
            text.printNarration("Lyron has leveled up. Quiet dignity. The instrument was seamlessly integrated.");
            text.printDialogue(character, "I can't undo what happened, but I can finish this.\nI'm afraid, yes, but the need to see this through is louder than my fear.\nThis final music is for them.");
        }
    }
    // --- Randomized Post-Combat Dialogue Implementation ---


    public void victoryDialogue(Character character) {
        if (character.name.equals("Sonara")) {
            text.printNarration("Sonara won. A rush of cold, satisfying certainty replaced the heat of the fight. The air felt clear.");
            String quote = character.narrative.getQuotes()[random.nextInt(character.narrative.getQuotes().length)];
            text.printDialogue(character, quote);
        }

        else if (character.name.equals("Aurelius")) {
            text.printNarration("Aurelius won. A profound sense of relief that the vulnerable were safe. His duty was performed.");
            String quote = character.narrative.getQuotes()[random.nextInt(character.narrative.getQuotes().length)];
            text.printDialogue(character, quote);
        }

        else if (character.name.equals("Lyron")) {
            text.printNarration("Aurelius won. A profound sense of relief that the vulnerable were safe. His duty was performed.");
            String quote = character.narrative.getQuotes()[random.nextInt(character.narrative.getQuotes().length)];
            text.printDialogue(character, quote);
        }
    }
    // --- Final Boss Maestro Syozan Dialogue (Formatted for readability) ---

    public void bossPreBattleDialogue(Monster boss) {
        text.printNarration("MAESTRO SYOZAN appears, radiating a crushing, absolute silence.");
        text.printDialogue(boss, "Ah, another one. A child of the silence, yet obsessed with the deafening clang of sound. Did you truly believe your little noise could lead you here? How pathetic.\n" +
                "You found my work—the eternal silence—and instead of realizing its perfection, you declared it a disease.\n" +
                "You confuse chaos for life, and order for cruelty.");
    }

    public void bossPostBattleDialogue(Monster boss) {
        text.printDialogue(boss, "No... you fool! You have ruined the perfection! You confuse this chaos for life, and order for cruelty!\n" +
                "I imposed this silence out of pity, stopping the world from screaming itself into oblivion, gifting humanity absolute peace from the sheer, agonizing volume of its own sorrow.\n" +
                "You think this noise is freedom? It is the sound of inevitable pain and hatred, magnified a thousand times! You will live to regret this freedom, child; you will beg for the quiet I gifted you.");
        text.printNarration("Maestro Syozan dissipates into silence as the world rushes with sound.");
    }


    // --- Final Boss Victory Moments (EXACTLY from document) ---

    public void finalVictory(Character character) {
        if (character.name.equals("Sonara")) {
            text.printSystemMessage("VICTORY! THE SILENCE IS SHATTERED!");
            text.printNarration("Sonara won. The shattering sound of her Banjo ended Syozan's stillness. The deafening rage in her heart was finally replaced by clean, profound peace, and the world was free.");
            text.printDialogue(character, "It’s over. The deafening silence is gone, and so is the rage. I gave them back the world, not just my anger; I am finally free.");
        }

        else if (character.name.equals("Aurelius")) {
            text.printSystemMessage("VICTORY! CONVICTION RESTORED!");
            text.printNarration("Aurelius won. Syozan dissolved beneath his soaring conviction. The crushing shame of his past lifted, leaving him resolute and ready to lead the world into its noisy, just future.");
            text.printDialogue(character, "The silence is shattered, and the world breathes. The battle is over, and my shame is finally lifted. I will listen to the sounds of freedom, and I will lead the rebuilding.");

        }

        else if (character.name.equals("Lyron")) {
            text.printSystemMessage("VICTORY! UNBURDENED GRIEF!");
            text.printNarration("Lyron won. The Maestro's defeat immediately banished his fear. The cold resolve of vengeance gave way to unburdened grief, marking him as a survivor finally at peace with his bravery.");
            text.printDialogue(character, "It’s finished. They are avenged. The fear that drove me is gone; I will live for them, never forgetting the bravery I found.");
        }
    }

    // --- Item Drops (EXACTLY from document) ---


    public void itemDrop(Character character /*, Item item*/) {
        text.printSystemMessage("ITEM ACQUIRED: " /* + item.name*/);
        text.printNarration("You found " + /*item.name*/ " after defeating the enemy. " /* + item.description*/);
    }

    /*
    @Override
    public void dropCrimsonChorus() {
        printSystemMessage("ITEM ACQUIRED: CRIMSON CHORUS");
        printNarration("The enemy dropped an item, CRIMSON CHORUS. For 2–3 random turns, the enemy takes 5 - 10% more damage.");
    }

    @Override
    public void dropSilentBarrier() {
        printSystemMessage("ITEM ACQUIRED: SILENT BARRIER");
        printNarration("The enemy dropped an item, SILENT BARRIER. Grants 1 turn of full immunity to damage and debuffs.");
    }

    @Override
    public void dropResolvedDissonance() {
        printSystemMessage("ITEM ACQUIRED: RESOLVED DISSONANCE");
        printNarration("The enemy dropped an item, RESOLVED DISSONANCE. The next time you play B Diminished, you don’t lose HP.");
    }

    @Override
    public void dropMinorGrace() {
        printSystemMessage("ITEM ACQUIRED: MINOR’S GRACE");
        printNarration("The enemy dropped an item, MINOR’S GRACE. Start battle with +1 free use of any Minor chord.");
    }

    @Override
    public void dropMajorBlessing() {
        printSystemMessage("ITEM ACQUIRED: MAJOR’S BLESSING");
        printNarration("The enemy dropped an item, MAJOR’S BLESSING. Start battle with +1 free use of any Major chord.");
    }
    */
}


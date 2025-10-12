import java.util.Random;
interface GameNarrator {
    void printNarration(String narration);
    void printDialogue(String characterName, String dialogue);
    void printSystemMessage(String message);
    void printSeparator();
}
interface Storyteller {
    // --- World/Location Introductions ---
    void introRuinedTownOfEchoes();
    void introSilentCaverns();
    void introAbyssOfDissonance();

    // --- Character Level-Up Moments (Post-Combat) ---
    void sonaraFirstLevelUp();
    void sonaraSecondLevelUp();
    void sonaraThirdLevelUp();
    void sonaraFourthLevelUp();

    void aureliusFirstLevelUp();
    void aureliusSecondLevelUp();
    void aureliusThirdLevelUp();
    void aureliusFourthLevelUp();

    void lyronFirstLevelUp();
    void lyronSecondLevelUp();
    void lyronThirdLevelUp();
    void lyronFourthLevelUp();

    // --- Randomized Post-Combat Dialogue (New) ---
    void sonaraVictoryDialogue();
    void aureliusVictoryDialogue();
    void lyronVictoryDialogue();

    // --- Final Boss Moments ---
    void maestroSyozanPreBattleDialogue();
    void maestroSyozanPostBattleDialogue();

    void victorySonara();
    void victoryAurelius();
    void victoryLyron();

    // --- Item Drops ---
    void dropCrimsonChorus();
    void dropSilentBarrier();
    void dropResolvedDissonance();
    void dropMinorGrace();
    void dropMajorBlessing();
}

class GameNarrative implements GameNarrator, Storyteller {

    // Utility for randomization
    private final Random random = new Random();

    // ANSI color codes for basic console styling
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";    // Dialogue
    private static final String YELLOW = "\u001B[33m";   // Narration
    private static final String GREEN = "\u001B[32m";    // System Messages (Success/Info)
    private static final String RED = "\u001B[31m";      // Maestro Dialogue

    // --- Randomized Dialogue Banks (Consolidated from Shadow 1-4) ---

    // Sonara's Victory Quotes (4 unique quotes)
    private final String[] sonaraQuotes = {
            "Gone. Deserved it.", // Shadow 1
            "Too slow. The truth is faster than any lie.", // Shadow 2
            "A waste of my time. Next.", // Shadow 3
            "That's for my parents. Now, who's next on the list?" // Shadow 4
    };

    // Aurelius's Victory Quotes (4 unique quotes)
    private final String[] aureliusQuotes = {
            "The fear is gone. Be safe.", // Shadow 1
            "You will not touch the vulnerable.", // Shadow 2
            "My breath will not fail. Justice prevails.", // Shadow 3
            "Go back to the apathy you came from. We are awake now." // Shadow 4
    };

    // Lyron's Victory Quotes (4 unique quotes)
    private final String[] lyronQuotes = {
            "Not again. Go.", // Shadow 1
            "I won't let you follow me anymore!", // Shadow 2
            "It's gone. I... I did it.", // Shadow 3
            "You will pay for every single sound I lost!" // Shadow 4
    };


    // --- GameNarrator Implementation (Standard Output Methods) ---

    @Override
    public void printNarration(String narration) {
        System.out.println(YELLOW + ">>> " + narration + RESET);
    }

    @Override
    public void printDialogue(String characterName, String dialogue) {
        // Maestro Syozan gets a distinct color
        if (characterName.equals("MAESTRO SYOZAN")) {
            System.out.println(RED + "[" + characterName + "]: " + RESET + dialogue);
        } else {
            System.out.println(BLUE + "[" + characterName + "]: " + RESET + dialogue);
        }
    }

    @Override
    public void printSystemMessage(String message) {
        System.out.println(GREEN + "---! " + message.toUpperCase() + " !---" + RESET);
    }

    @Override
    public void printSeparator() {
        System.out.println("\n" + "=".repeat(70) + "\n");
    }

    // --- Storyteller Implementation (Specific Story Sequences) ---

    // --- World/Location Introductions (Formatted for readability) ---

    @Override
    public void introRuinedTownOfEchoes() {
        printSeparator();
        printSystemMessage("ENTERING: RUINED TOWN OF ECHOES");
        printNarration("The Ruined Town stands as a skeleton of what once was, its walls cracked and leaning, roofs caved in, and windows nothing more than gaping holes.\n" +
                "Dust settles thick on streets where no footsteps fall, and weeds grow wild between the stones, claiming what the people left behind.\n" +
                "The air feels heavy, as if the place itself remembers the weight of life that once filled it.\n" +
                "Every corner, every broken doorway, suggests a story cut short—homes abandoned, lives forgotten, yet the stillness keeps it all locked away.\n" +
                "It is a place where time lingers, unmoving, waiting for something to stir it again..");
        printSeparator();
    }

    @Override
    public void introSilentCaverns() {
        printSeparator();
        printSystemMessage("ENTERING: SILENT CAVERNS");
        printNarration("Beneath the shattered town lies a cave swallowed in darkness, where silence is absolute and every sound is hunted.\n" +
                "The monsters here are born from broken echoes, feeding on any stray note that dares to exist.\n" +
                "In this suffocating void, the hero presses forward, wielding their instruments not as fragile relics but as powerful weapons that defy the silence itself.\n" +
                "Every melody played is a strike against the creeping stillness, a prelude to the final confrontation with the one who seeks to erase all sound.");
        printSeparator();
    }

    @Override
    public void introAbyssOfDissonance() {
        printSeparator();
        printSystemMessage("ENTERING: ABYSS OF DISSONANCE");
        printNarration("At the edge of the world lies the Abyss, a realm where silence is no longer absence but a living hunger.\n" +
                "Here dwells the sovereign who loathes sound, a being that devoured every whisper, every song, and twisted them into a void of unending quiet.\n" +
                "The air is heavy, crushing, as if even breath is forbidden. Within this abyss, the hero makes their final stand.");
        printSeparator();
    }

    // --- Sonara Level-Up Moments (Updated Level 3 Dialogue) ---

    @Override
    public void sonaraFirstLevelUp() {
        printSystemMessage("SONARA LEVEL UP: Vicious, clean force.");
        printNarration("Sonara has leveled up. Vicious, clean force. Her Banjo found its edge.");
        printDialogue("Sonara", "The strings are cleaner now. I won't lose this clarity again; this feeling of striking back.\nI won't stop until there's nowhere left for the shadows to hide.");
    }

    @Override
    public void sonaraSecondLevelUp() {
        printSystemMessage("SONARA LEVEL 2: Deeply disruptive sound.");
        printNarration("Sonara has leveled up. Deeply disruptive sound. The rhythm broke their cohesion.");
        printDialogue("Sonara", "The rhythm is focused. I know where to hit them.\nVengeance is a clean, sharp note, and I have the pattern now.");
    }

    @Override
    public void sonaraThirdLevelUp() {
        printSystemMessage("SONARA LEVEL 3: Calculated sonic bursts.");
        printNarration("Sonara has leveled up. Calculated sonic bursts. The hunt became surgical.");
        printDialogue("Sonara", "No wasted motion, no wasted sound.\nMy rage isn't a fire anymore—it’s the scalpel. Every note cuts exactly where it must.\nThis is not feeling; this is precision.");
    }

    @Override
    public void sonaraFourthLevelUp() {
        printSystemMessage("SONARA LEVEL 4: Final signature.");
        printNarration("Sonara has leveled up. Final signature. The sound became retribution's voice.");
        printDialogue("Sonara", "There is no turning back.\nThe sound is a permanent promise etched onto my soul. I will play the final, deafening chord.");
    }

    // --- Aurelius Level-Up Moments (EXACTLY from document) ---

    @Override
    public void aureliusFirstLevelUp() {
        printSystemMessage("AURELIUS LEVEL UP: Resilient barrier.");
        printNarration("Aurelius has leveled up. Resilient barrier. His breath stabilized the shield.");
        printDialogue("Aurelius", "I can see the fear, and my breath pushes it away. This instrument is a boundary.\nI will keep playing for those who can't.");
    }

    @Override
    public void aureliusSecondLevelUp() {
        printSystemMessage("AURELIUS LEVEL 2: Layered harmonies.");
        printNarration("Aurelius has leveled up. Layered harmonies. The protective shield expanded.");
        printDialogue("Aurelius", "The music is lighter now, less burdened by my past. This is more than debt; it's hope.\nThe cruelty of my family ends with every breath I give.");
    }

    @Override
    public void aureliusThirdLevelUp() {
        printSystemMessage("AURELIUS LEVEL 3: Purifying trills.");
        printNarration("Aurelius has leveled up. Purifying trills. The sound banished mental corruption.");
        printDialogue("Aurelius", "They try to break my focus, but the notes keep weaving, faster.\nI am not brittle; I am layered resilience. My music finds everyone waiting beneath the surface.");
    }

    @Override
    public void aureliusFourthLevelUp() {
        printSystemMessage("AURELIUS LEVEL 4: Voice of justice.");
        printNarration("Aurelius has leveled up. Voice of justice. His sound carried the promise of the future.");
        printDialogue("Aurelius", "The path is clear. This is the rebuilding.\nThe trust I feel is a foundation. I play for a world that knows the quiet truth of justice.");
    }

    // --- Lyron Level-Up Moments (EXACTLY from document) ---

    @Override
    public void lyronFirstLevelUp() {
        printSystemMessage("LYRON LEVEL UP: Complex, sweeping patterns.");
        printNarration("Lyron has leveled up. Complex, sweeping patterns. He found structure for engagement.");
        printDialogue("Lyron", "I watched it vanish. The guilt is heavy, but the sound feels like my mother.\nI can't be a coward if I have this. I have to be strong enough to see the next shadow fall.");
    }

    @Override
    public void lyronSecondLevelUp() {
        printSystemMessage("LYRON LEVEL 2: Intricate arpeggios.");
        printNarration("Lyron has leveled up. Intricate arpeggios. Sound-webs trapped the enemy.");
        printDialogue("Lyron", "The guilt is a weapon, a promise. The Harp spins webs that trap the shadows.\nI'll use every trick to avoid fighting face-to-face.");
    }

    @Override
    public void lyronThirdLevelUp() {
        printSystemMessage("LYRON LEVEL 3: Tragic clarity.");
        printNarration("Lyron has leveled up. Tragic clarity. The Harp struck with the weight of his loss.");
        printDialogue("Lyron", "I couldn't run. The fear is there, but I played through it.\nThis Harp is my witness. I will make the thing that ruined my life suffer.");
    }

    @Override
    public void lyronFourthLevelUp() {
        printSystemMessage("LYRON LEVEL 4: Quiet dignity.");
        printNarration("Lyron has leveled up. Quiet dignity. The instrument was seamlessly integrated.");
        printDialogue("Lyron", "I can't undo what happened, but I can finish this.\nI'm afraid, yes, but the need to see this through is louder than my fear.\nThis final music is for them.");
    }

    // --- Randomized Post-Combat Dialogue Implementation ---

    @Override
    public void sonaraVictoryDialogue() {
        // Narration for winning a simple fight is used for all victories before the dialogue.
        String narration = "Sonara won. A rush of cold, satisfying certainty replaced the heat of the fight. The air felt clear.";
        printNarration(narration);
        String quote = sonaraQuotes[random.nextInt(sonaraQuotes.length)];
        printDialogue("Sonara", quote);
    }

    @Override
    public void aureliusVictoryDialogue() {
        // Narration for winning a simple fight is used for all victories before the dialogue.
        String narration = "Aurelius won. A profound sense of relief that the vulnerable were safe. His duty was performed.";
        printNarration(narration);
        String quote = aureliusQuotes[random.nextInt(aureliusQuotes.length)];
        printDialogue("Aurelius", quote);
    }

    @Override
    public void lyronVictoryDialogue() {
        // Narration for winning a simple fight is used for all victories before the dialogue.
        String narration = "Lyron won. A brief, exhilarating flash of shocked survival. The paralyzing fear was momentarily gone.";
        printNarration(narration);
        String quote = lyronQuotes[random.nextInt(lyronQuotes.length)];
        printDialogue("Lyron", quote);
    }

    // --- Final Boss Maestro Syozan Dialogue (Formatted for readability) ---

    @Override
    public void maestroSyozanPreBattleDialogue() {
        printNarration("MAESTRO SYOZAN appears, radiating a crushing, absolute silence.");
        printDialogue("MAESTRO SYOZAN", "Ah, another one. A child of the silence, yet obsessed with the deafening clang of sound. Did you truly believe your little noise could lead you here? How pathetic.\n" +
                "You found my work—the eternal silence—and instead of realizing its perfection, you declared it a disease.\n" +
                "You confuse chaos for life, and order for cruelty.");
    }

    @Override
    public void maestroSyozanPostBattleDialogue() {
        printDialogue("MAESTRO SYOZAN", "No... you fool! You have ruined the perfection! You confuse this chaos for life, and order for cruelty!\n" +
                "I imposed this silence out of pity, stopping the world from screaming itself into oblivion, gifting humanity absolute peace from the sheer, agonizing volume of its own sorrow.\n" +
                "You think this noise is freedom? It is the sound of inevitable pain and hatred, magnified a thousand times! You will live to regret this freedom, child; you will beg for the quiet I gifted you.");
        printNarration("Maestro Syozan dissipates into silence as the world rushes with sound.");
    }


    // --- Final Boss Victory Moments (EXACTLY from document) ---

    @Override
    public void victorySonara() {
        printSystemMessage("VICTORY! THE SILENCE IS SHATTERED!");
        printNarration("Sonara won. The shattering sound of her Banjo ended Syozan's stillness. The deafening rage in her heart was finally replaced by clean, profound peace, and the world was free.");
        printDialogue("Sonara", "It’s over. The deafening silence is gone, and so is the rage. I gave them back the world, not just my anger; I am finally free.");
    }

    @Override
    public void victoryAurelius() {
        printSystemMessage("VICTORY! CONVICTION RESTORED!");
        printNarration("Aurelius won. Syozan dissolved beneath his soaring conviction. The crushing shame of his past lifted, leaving him resolute and ready to lead the world into its noisy, just future.");
        printDialogue("Aurelius", "The silence is shattered, and the world breathes. The battle is over, and my shame is finally lifted. I will listen to the sounds of freedom, and I will lead the rebuilding.");
    }

    @Override
    public void victoryLyron() {
        printSystemMessage("VICTORY! UNBURDENED GRIEF!");
        printNarration("Lyron won. The Maestro's defeat immediately banished his fear. The cold resolve of vengeance gave way to unburdened grief, marking him as a survivor finally at peace with his bravery.");
        printDialogue("Lyron", "It’s finished. They are avenged. The fear that drove me is gone; I will live for them, never forgetting the bravery I found.");
    }

    // --- Item Drops (EXACTLY from document) ---

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
}

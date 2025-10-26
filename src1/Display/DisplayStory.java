package Display;


public class DisplayStory {

    // Assuming TextDisplay is available in the Display package
    // and provides methods like printSystemMessage, printNarration, etc.
    private final TextDisplay text = new TextDisplay();

    /**
     * Prints the entire game lore by calling the section methods.
     */
    public void displayFullLore() {
        text.lineBreak();
        text.printSystemMessage("--- SILENTIUM: COMPLETE GAME LORE DOCUMENTATION ---");
        text.lineBreak();

        displayWorldSettings();
        displayPlotSummary();
        displayCharacterBiographies();

        text.printSystemMessage("--- DOCUMENTATION END ---");
        text.lineBreak();
    }

    /**
     * Prints the setting and environment details.
     */
    public void displayWorldSettings() {
        text.printSystemMessage("I. WORLD SETTINGS");
        text.lineBreak();

        text.yellowText("RUINED TOWN OF ECHOES");
        text.printNarration("The Ruined Town stands as a skeleton of what once was, its walls cracked and leaning, roofs caved in, and windows nothing more than gaping holes.\n" +
                "Every corner, every broken doorway, suggests a story cut short—homes abandoned, lives forgotten, yet the stillness keeps it all locked away.\n" +
                "It is a place where time lingers, unmoving, waiting for something to stir it again.");

        text.lineBreak();
        text.yellowText("SILENT CAVERNS");
        text.printNarration("Beneath the shattered town lies a cave swallowed in darkness, where silence is absolute and every sound is hunted.\n" +
                "The monsters here are born from broken echoes, feeding on any stray note that dares to exist.\n" +
                "Every melody played is a strike against the creeping stillness, a prelude to the final confrontation with the one who seeks to erase all sound.");

        text.lineBreak();
        text.yellowText("ABYSS OF DISSONANCE");
        text.printNarration("At the edge of the world lies the Abyss, a realm where silence is no longer absence but a living hunger.\n" +
                "Here dwells the sovereign who loathes sound, a being that devoured every whisper, every song.\n" +
                "The air is heavy, crushing, as if even breath is forbidden. Within this abyss, the hero must unleash the full force of their instruments.");
        text.lineBreak();
    }

    /**
     * Prints the plot history, main event, progression, and climax.
     */
    public void displayPlotSummary() {
        text.printSystemMessage("II. PLOT SUMMARY");
        text.lineBreak();

        text.yellowText("HISTORY & THE ETERNAL SILENCE");
        text.printNarration("Once, the towns echoed with song, pleasing a great entity. Upon the entity's request for rest, the people silenced their music.\n" +
                "Unbeknownst to them, their music, not the entity, preserved the peace. Without it, **Shadow Beasts** emerged, creatures that fed on stillness.\n" +
                "The Beasts attacked, leading to the **Eternal Silence**—centuries of quiet that drained the soul from the living.");

        text.lineBreak();
        text.yellowText("MAIN EVENT & PROGRESSION");
        text.printNarration("The silence was shattered by a single **bell toll**, shaking the world and awakening the Shadows in frenzy.\n" +
                "Children, born in silence, use hidden instruments to fight through the **Ruined Town of Echoes** and the suffocating **Silent Caverns**.\n" +
                "Their journey leads to the **Abyss of Dissonance** and the **Maestro Syozan**, the source of the silence.");

        text.lineBreak();
        text.yellowText("CLIMAX");
        text.printNarration("In the heart of the Abyss, the hero plays not just to fight, but to answer an intense yearning to feel what it means to listen.\n" +
                "Each note is defiance, grief, hope, and love entwined—a final symphony against the entity that devoured all sound.");
        text.lineBreak();
    }

    /**
     * Prints the biographies and endings for all three main characters.
     */
    public void displayCharacterBiographies() {
        text.printSystemMessage("III. CHARACTER BIOGRAPHIES & ENDINGS");
        text.lineBreak();

        // --- SONARA ---
        text.yellowText("SONARA (The Fury) - Banjo “The Scourge of Echoes”");
        text.printNarration("Background: Lived in a comforting delusion that her family was still alive, unaware the surrounding silence was hiding the truth of their violent loss.\n" +
                "Personality: Defined by a newfound, unyielding intensity and deep, barely contained grief. Her music is the raw, twangy sound of rebellion, demanding retribution.\n" +
                "Introduction: The bell shattered her delusion, forcing her to grab the hidden Banjo. Her final vow: \"I will use the sound to destroy the silence... until my family is finally, truly avenged.\"\n" +
                "Ending: Finds true peace, replacing vengeance with a lifelong dedication to **advocating harmony and justice** through music.");
        text.lineBreak();

        // --- AURELIUS ---
        text.yellowText("AURELIUS (The Shield) - Flute “The Whispering Bulwark”");
        text.printNarration("Background: Grew up in a cruel, privileged family, secretly harboring guilt and using a hidden Flute to process the empathy he felt for the suffering world.\n" +
                "Personality: Fundamentally empathetic and driven by a strong moral duty. Prefers to observe and protect. His music is light, airy, and protective.\n" +
                "Introduction: The bell galvanized his shame into purpose, prompting him to flee and use his Flute's sound to create a protective barrier. His resolve: \"My silence was shame. My sound will be shelter.\"\n" +
                "Ending: Becomes the **Moral Compass** of the new era, ensuring the noise-filled future is built on justice and shared community.");
        text.lineBreak();

        // --- LYRON ---
        text.yellowText("LYRON (The Resolve) - Harp “The Shattered Harmony”");
        text.printNarration("Background: Deemed the weakest in his family, he felt crippling shame, but held onto a sliver of hope represented by his mother's untouched Harp.\n" +
                "Personality: Riddled with guilt and paralyzed by fear, he pushes forward as a reluctant avenger. His commitment provides the fragile resolve he needs.\n" +
                "Introduction: After witnessing his family's murder, he violently struck the Harp in desperate fear, banishing the monster and gaining a tool for vengeance.\n" +
                "Ending: Ends his quest for vengeance, transforms into a **Custodian of Memory**, using his Harp to heal others' guilt and fear.");
        text.lineBreak();
    }
}

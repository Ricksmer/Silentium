package Display;

import Enemy.Monster;
import Player.Character;

public class TextDisplay{
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";    // Dialogue
    private static final String YELLOW = "\u001B[33m";   // Narration
    private static final String GREEN = "\u001B[32m";    // System Messages (Success/Info)
    private static final String RED = "\u001B[31m";      // Maestro Dialogue

    // --- Text Display Tools (Standard Output Methods) ---
    public void printNarration(String narration) {
        System.out.println(YELLOW + ">>> " + narration + RESET);
    }

    public void printDialogue(Character player, String dialogue) {
        System.out.println(BLUE + "[" + player.name + "]: " + RESET + dialogue);
    }

    public void printDialogue(Monster enemy,String dialogue) {
        System.out.println(RED + "[" + enemy.name+ "]: " + RESET + dialogue);
    }

    public void printSystemMessage(String message) {
        System.out.println(GREEN + "\t\t " + message.toUpperCase() + RESET);
    }

    public void printMap(String message) {
        System.out.print(GREEN + "\t\t " + message.toUpperCase() + RESET);
    }

    public void printSystemInput(String message) {
        System.out.print(GREEN + "\t\t" + message.toUpperCase() + RESET);
    }


    public void greenText(String string) { System.out.println(GREEN + string + RESET); }
    public void blueText(String string) { System.out.println(BLUE + string + RESET); }
    public void redText(String string) { System.out.println(RED + string + RESET); }
    public void yellowText(String string) { System.out.println(YELLOW + string + RESET); }
    public void lineBreak() {
        System.out.println("\n\t--------------------------------------------------\n");
    }
}


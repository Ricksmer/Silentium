package Display;

import Enemy.Monster;
import Player.Character;

public class TextDisplay{
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";    // Dialogue
    private static final String YELLOW = "\u001B[33m";   // Narration
    private static final String GREEN = "\u001B[32m";    // System Messages (Success/Info)
    private static final String RED = "\u001B[31m";      // Maestro Dialogue
    private static final String WHITE = "\u001B[37m";      // Maestro Dialogue

    // --- Text Display Tools (Standard Output Methods) ---
    public void printNarration(String narration) {
        System.out.println(YELLOW + "\t>>> " + narration + RESET);
    }

    public void printDialogue(Character player, String dialogue) {
        System.out.println(BLUE + "\t[" + player.name + "]: " + RESET + "\t" + dialogue);
    }

    public void printDialogue(Monster enemy,String dialogue) {
        System.out.println(RED + "\t[" + enemy.name+ "]: " + RESET + "\t" + dialogue);
    }

    public void printSystemMessage(String message) {
        System.out.println(GREEN + "\t\t" + message.toUpperCase() + RESET);
    }

    public void printStats(String attribute, String value, String space) {
        System.out.println(GREEN + "\t\t" + attribute + ": " + space + YELLOW + value + RESET);
    }

    public void printStats(String attribute, String value, String maxValue, String space) {
        System.out.println(GREEN + "\t\t" + attribute + ": " + space + YELLOW + value + GREEN + " / " + YELLOW + maxValue + RESET);
    }

    public void printSystemError(String message) {
        System.out.println(RED + "\t\t" + message.toUpperCase() + RESET);
    }

    public void printMap(String message) {
        System.out.print(GREEN + "\t\t" + message.toUpperCase() + RESET);
    }

    public void printExitMap(String message) {
        System.out.print(YELLOW + "\t\t" + message.toUpperCase() + RESET);
    }

    public void printEnemyMap(String message) {
        System.out.print(RED + "\t\t" + message.toUpperCase() + RESET);
    }

    public void printPlayerOnMap(String message) {
        System.out.print(BLUE + "\t\t" + message.toUpperCase() + RESET);
    }

    public void printSystemAnnouncement(String message) {
        System.out.println(YELLOW + "\t\t" + message.toUpperCase() + RESET);
    }

    public void printGameAnnouncement(String message) {
        System.out.println(YELLOW + "\t" + message.toUpperCase() + RESET);
    }


    public void printSystemInput(String message) {
        System.out.print(GREEN + "\t\t" + message.toUpperCase() + WHITE);
    }


    public void greenText(String string) { System.out.println(GREEN + string + RESET); }
    public void blueText(String string) { System.out.println(BLUE + string + RESET); }
    public void redText(String string) { System.out.println(RED + string + RESET); }
    public void yellowText(String string) { System.out.println(YELLOW + string + RESET); }

    public void playerText(String string) { System.out.println(BLUE + "\t" + string + RESET); }
    public void enemyText(String string) { System.out.println(RED + "\t" + string + RESET); }
    public void lineBreak() {
        System.out.println(GREEN + "\n\t------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }
    public void shortbreak(){
        yellowText("\n\t================================================================\n");
    }

    public void clear(){
        String art = """
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        """;
        System.out.println(art);
    }
}


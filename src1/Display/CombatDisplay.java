package Display;

import Enemy.*;
import Player.Character;
import Player.Sonara;
import Player.Aurelius;
import Player.Lyron;
import Combat.ChordSystem;

public class CombatDisplay implements CombatPrint, InputPrint{
    TextDisplay text = new TextDisplay();


    @Override
    public void battleStart(){
        text.printSystemMessage("=============== Battle Start! ===============");
        System.out.println();
    }

    @Override
    public void battleEnd(Boolean isWin){
        if(isWin) { text.printSystemMessage("==========   Y O U     W I N !   ==========\n"); }
        else { text.printSystemMessage("==========   Y O U     L O S E !   ==========\n"); }
    }

    public void noteInput(){
        text.printSystemMessage(" --- Enter Notes ---");
        System.out.println();
    }

    public void CharacterSelect(){
        Character sonara = new Sonara();
        Character aurelius = new Aurelius();
        Character lyron = new Lyron();

        text.printSystemMessage("--- Select Character ---");
        System.out.println();
        text.printSystemMessage("[ 1 ] --->  " + sonara.name + " : " + sonara.instrument + " ");
        text.printSystemMessage("[ 2 ] --->  " + aurelius.name + " : " + aurelius.instrument + " ");
        text.printSystemMessage("[ 3 ] --->  " + lyron.name + " : " + lyron.instrument + " ");
        System.out.println();
        text.printSystemInput("Select :   ");
    }

    public void turnAction(){
        text.printSystemMessage("--- Choose an action ---\n");
        text.printSystemMessage("[ 1 ] ---> \t Attack");
        text.printSystemMessage("[ 2 ] ---> \t Skill");
        text.printSystemMessage("[ 3 ] ---> \t Inventory");
        text.printSystemMessage("[ 4 ] ---> \t Chord Chart");
        text.printSystemMessage("[ 5 ] ---> \t Display Stats");
        text.printSystemMessage("[ 6 ] ---> \t Attack Guide");
        System.out.println();
        text.printSystemInput("Select: ");
    }

    public void characterDisplay(Character player){
        playerStatsSummary(player);
        text.printSystemMessage(" Passive Skill: " + player.ps.skillName+ "\n" + player.ps.skillDescription);
        text.printSystemMessage(" Active Skill: " + player.as.skillName+ "\n" + player.as.skillDescription);
        System.out.println();
        text.printSystemMessage("------------------------- ");
    }

    public void playerStatsSummary(Character player){
        text.printSystemMessage("---     " + player.name + "     ---");
        text.printSystemMessage("---    ( Player )     ---");
        System.out.println();
        text.printSystemMessage("Level: " + player.getLevel());
        text.printSystemMessage("Instrument: " + player.instrument);
        text.printSystemMessage("HP: " + player.getHp() + " / " +  player.getMaxHp());
        text.printSystemMessage("Shield: " + player.getShield() + " / " +  player.getMaxShield());
        System.out.println();
    }

    public void enemyStatsSummary(Monster enemy){
        text.printSystemMessage("---     " + enemy.name + "     ---");
        text.printSystemMessage("---    ( Monster )     ---");
        System.out.println();
        text.printSystemMessage("HP: " + enemy.getHp() + " / " +  enemy.getMaxHp());
        System.out.println();
        text.printSystemMessage("------------------------- ");

    }

    public void displayValidNotes(Character player){
        text.printSystemMessage("--- Valid Notes ---");
        text.printSystemMessage("NOTE \tDAMAGE RANGE");
        System.out.println();
        text.printSystemMessage("[ A ] --->  \t { 1 - 10 } ");
        text.printSystemMessage("[ B ] --->  \t { 5 - 13 } ");
        text.printSystemMessage("[ C ] --->  \t { 9 - 16 } ");
        if(player.getLevel() >= 2){
            text.printSystemMessage("[ D ] --->  \t{ 12 - 18 }");
            text.printSystemMessage("[ E ] --->  \t{ 16 - 21 }");
        }

        if(player.getHp() <= 4){
            text.printSystemMessage("[ F ] --->  \t{ 19 - 23 }");
            text.printSystemMessage("[ G ] --->  \t{ 21 - 24 }");
        }
        System.out.println();
    }


    public void chordChart(ChordSystem chord){
        text.printSystemMessage("===================================================");
        System.out.println();
        text.printSystemMessage("--- CHORD CHART --- ");
        System.out.println();
        text.printSystemMessage("[ C Major ] ---> \t" + (chord.isChordUsed('c') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ D Minor ] ---> \t" + (chord.isChordUsed('d') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ E Minor ] ---> \t" + (chord.isChordUsed('e') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ F Major ] ---> \t" + (chord.isChordUsed('f') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ G Major ] ---> \t" + (chord.isChordUsed('g') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ A Minor ] ---> \t" + (chord.isChordUsed('a') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ B Dim   ] ---> \t" + (chord.isChordUsed('b') ? "USED" : "AVAILABLE"));
        System.out.println();
        text.printSystemMessage("===================================================");
    }
}

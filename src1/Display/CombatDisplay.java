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
        text.printSystemMessage("\t=============== Battle Start! ===============");
        System.out.println();
    }

    @Override
    public void battleEnd(Boolean isWin){
        if(isWin) { text.printSystemMessage("\t\t ==========   Y O U     W I N !   =========="); }
        else { text.printSystemMessage("\t\t ==========   Y O U     L O S E !   =========="); }
    }

    public void noteInput(){
        text.printSystemMessage("\t --- Enter Notes ---");
        System.out.println();
    }

    public void CharacterSelect(){
        Character sonara = new Sonara();
        Character aurelius = new Aurelius();
        Character lyron = new Lyron();

        text.printSystemMessage("\t --- Select Character ---");
        System.out.println();
        text.printSystemMessage("\t [ 1 ] --->  " + sonara.name + " : " + sonara.instrument + " ");
        text.printSystemMessage("\t [ 2 ] --->  " + aurelius.name + " : " + aurelius.instrument + " ");
        text.printSystemMessage("\t [ 3 ] --->  " + lyron.name + " : " + lyron.instrument + " ");
        System.out.println();
        text.printSystemInput("\t Select :   ");
    }

    public void turnAction(){
        text.printSystemMessage("\t --- Choose an action ---\n");
        text.printSystemMessage("\t [ 1 ] ---> \t Attack");
        text.printSystemMessage("\t [ 2 ] ---> \t Skill");
        text.printSystemMessage("\t [ 3 ] ---> \t Inventory");
        text.printSystemMessage("\t [ 4 ] ---> \t Chord Chart");
        text.printSystemMessage("\t [ 5 ] ---> \t Display Stats");
        text.printSystemMessage("\t [ 6 ] ---> \t Attack Guide");
        System.out.println();
        text.printSystemInput("\t Select: ");
    }

    public void characterDisplay(Character player){
        playerStatsSummary(player);
        //System.out.println(" Passive Skill: " + player.ps.skillDescription);
        //System.out.println(" Active Skill: " + player.as.skillDescription);
        System.out.println();
        text.printSystemMessage("\t ------------------------- ");
    }

    public void playerStatsSummary(Character player){
        text.printSystemMessage("\t ---     " + player.name + "     ---");
        text.printSystemMessage("\t ---    ( Player )     ---");
        System.out.println();
        text.printSystemMessage("\t Level: " + player.getLevel());
        text.printSystemMessage("\t Instrument: " + player.instrument);
        text.printSystemMessage("\t HP: " + player.getHp() + " / " +  player.getMaxHp());
        text.printSystemMessage("\t Shield: " + player.getShield() + " / " +  player.getMaxShield());
        System.out.println();
    }

    public void enemyStatsSummary(Monster enemy){
        text.printSystemMessage("\t ---     " + enemy.name + "     ---");
        text.printSystemMessage("\t ---    ( Monster )     ---");
        System.out.println();
        text.printSystemMessage("\t HP: " + enemy.getHp() + " / " +  enemy.getMaxHp());
        System.out.println();
        text.printSystemMessage("\t ------------------------- ");

    }

    public void displayValidNotes(Character player){
        text.printSystemMessage("\t\t--- Valid Notes ---");
        text.printSystemMessage("\tNOTE \tDAMAGE RANGE");
        System.out.println();
        text.printSystemMessage("\t [ A ] --->  \t { 1 - 10 } ");
        text.printSystemMessage("\t [ B ] --->  \t { 5 - 13 } ");
        text.printSystemMessage("\t [ C ] --->  \t { 9 - 16 } ");
        if(player.getLevel() >= 2){
            text.printSystemMessage("\t [ D ] --->  \t{ 12 - 18 }");
            text.printSystemMessage("\t [ E ] --->  \t{ 16 - 21 }");
        }

        if(player.getHp() <= 4){
            text.printSystemMessage("\t [ F ] --->  \t{ 19 - 23 }");
            text.printSystemMessage("\t [ G ] --->  \t{ 21 - 24 }");
        }
        System.out.println();
    }


    public void chordChart(ChordSystem chord){
        text.printSystemMessage("===================================================");
        System.out.println();
        text.printSystemMessage("\t\t --- CHORD CHART --- ");
        System.out.println();
        text.printSystemMessage("\t [ C Major ] ---> \t" + (chord.isChordUsed('c') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("\t [ D Minor ] ---> \t" + (chord.isChordUsed('d') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("\t [ E Minor ] ---> \t" + (chord.isChordUsed('e') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("\t [ F Major ] ---> \t" + (chord.isChordUsed('f') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("\t [ G Major ] ---> \t" + (chord.isChordUsed('g') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("\t [ A Minor ] ---> \t" + (chord.isChordUsed('a') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("\t [ B Dim   ] ---> \t" + (chord.isChordUsed('b') ? "USED" : "AVAILABLE"));
        System.out.println();
        text.printSystemMessage("===================================================");
    }
}

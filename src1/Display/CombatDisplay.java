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
        text.printSystemAnnouncement("========== \t\t B A T T L E     S T A R T! \t\t==========");
        System.out.println();
    }

    @Override
    public void battleEnd(Boolean isWin){
        if(isWin) { text.printSystemAnnouncement("========== \t\t  Y O U     W I N !   \t\t==========\n"); }
        else { text.printSystemMessage("========== \t\t  Y O U     L O S E!   \t\t==========\n"); }
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

    public void turnAction(Character player){
        if(player.getLevel() < 3){
            text.printSystemMessage("--- Choose an action ---\n");
            text.printSystemMessage("[ 1 ] ---> \t Attack");
            text.printSystemMessage("[ 2 ] ---> \t Skill");
            text.printSystemMessage("[ 3 ] ---> \t Display Stats");
            text.printSystemMessage("[ 4 ] ---> \t Attack Guide");
            System.out.println();
            text.printSystemInput("Select: ");
        }else{
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

    }

    public void characterDisplay(Character player){
        playerStatsSummary(player);
        text.printSystemMessage("Passive Skill: \t\t" + player.ps.skillName+ "\n\t\t\t\t\t\t\t" + player.ps.skillDescription);
        text.printSystemMessage("Active Skill: \t\t" + player.as.skillName+ "\n\t\t\t\t\t\t\t" + player.as.skillDescription);
        System.out.println();
    }

    public void playerStatsSummary(Character player){
        text.printSystemMessage("=====    \t\t" + player.name + "\t(Player) \t\t     =====");
        System.out.println();
        text.printSystemMessage("Level: \t\t\t\t" + player.getLevel());
        text.printSystemMessage("Instrument: \t\t" + player.instrument);
        text.printSystemMessage("HP: \t\t\t\t" + player.getHp() + " / " +  player.getMaxHp());
        text.printSystemMessage("Shield: \t\t\t" + player.getShield() + " / " +  player.getMaxShield());
        System.out.println();
    }

    public void enemyStatsSummary(Monster enemy){
        text.printSystemMessage("=====    \t\t" + enemy.name + "\t(Monster) \t\t     =====");

        System.out.println();
        if(enemy.getHp() <= 0)
            enemy.setHp(0);

        text.printSystemMessage("HP: \t\t\t\t" + enemy.getHp() + " / " +  enemy.getMaxHp());
        text.printSystemMessage("Description: \t\t" + enemy.monsterDescription);
        System.out.println();

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

        if(player.getLevel() >= 3){
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

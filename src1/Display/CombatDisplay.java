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
        text.printGameAnnouncement("========== \t\t B A T T L E     S T A R T! \t\t==========");
        System.out.println();
    }

    @Override
    public void battleEnd(Boolean isWin){
        if(isWin) { text.printGameAnnouncement("========== \t\t  Y O U     W I N !   \t\t==========\n"); }
        else { text.printGameAnnouncement("========== \t\t  Y O U     L O S E !   \t\t==========\n"); }
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
        text.printSystemMessage("[ 0 ] --->  VIEW CHARACTERS");
        text.printSystemMessage("[ 1 ] --->  " + sonara.name + " : " + sonara.instrument);
        text.printSystemMessage("[ 2 ] --->  " + aurelius.name + " : " + aurelius.instrument);
        text.printSystemMessage("[ 3 ] --->  " + lyron.name + " : " + lyron.instrument);
        System.out.println();
        text.printSystemInput("Select :   ");
    }

    public void turnAction(Character player){
        text.shortbreak();
        if(player.getLevel() < 3){
            text.printSystemMessage("--- Choose an action ---\n");
            text.printSystemMessage("[ 1 ] ---> \t Attack");
            text.printSystemMessage("[ 2 ] ---> \t Skill");
            text.printSystemMessage("[ 3 ] ---> \t Display Stats");
            text.printSystemMessage("[ 4 ] ---> \t Attack Guide");
            System.out.println();
        }else{
            text.printSystemMessage("--- Choose an action ---\n");
            text.printSystemMessage("[ 1 ] ---> \t Attack");
            text.printSystemMessage("[ 2 ] ---> \t Skill");
            text.printSystemMessage("[ 3 ] ---> \t Inventory");
            text.printSystemMessage("[ 4 ] ---> \t Chord Chart");
            text.printSystemMessage("[ 5 ] ---> \t Display Stats");
            text.printSystemMessage("[ 6 ] ---> \t Attack Guide");
            System.out.println();
        }
    }

    public void characterDisplay(Character player){
        playerStatsSummary(player);
        text.printStats("Passive Skill", player.ps.skillName, "\t\t");
        text.yellowText("\t\t\t\t\t\t\t > " + player.ps.skillDescription);
        text.printStats("Active Skill", player.as.skillName, "\t\t");
        text.yellowText("\t\t\t\t\t\t\t > " + player.as.skillDescription);
        System.out.println();
    }

    public void displayStats(Character player, Monster enemy){
        text.shortbreak();
        playerStatsSummary(player);
        text.shortbreak();
        enemyStatsSummary(enemy);
        text.shortbreak();
    }


    public void playerStatsSummary(Character player){
        text.playerText("=====    \t\t" + player.name + "\t(Player) \t\t     =====");
        System.out.println();
        text.printStats("Level", String.valueOf(player.getLevel()), "\t\t\t\t");
        text.printStats("Instrument", player.instrument, "\t\t");
        text.printStats("HP",  String.valueOf(player.getHp()), String.valueOf(player.getMaxHp()), "\t\t\t\t");
        text.printStats("Shield", String.valueOf(player.getShield()), String.valueOf(player.getMaxShield()),  "\t\t\t");
        System.out.println();
        if(player.name.equals("Aurelius")){
            text.playerText("=======================================================");
        }else{
            text.playerText("==================================================");
        }
        System.out.println();
    }

    public void enemyStatsSummary(Monster enemy){
        text.enemyText("=====    \t\t" + enemy.name + "\t(Monster) \t\t     =====");

        System.out.println();
        if(enemy.getHp() <= 0)
            enemy.setHp(0);

        text.printStats("HP",  String.valueOf(enemy.getHp()), String.valueOf(enemy.getMaxHp()), "\t\t\t\t");
        text.printStats("Description", enemy.monsterDescription, "\t\t");
        System.out.println();
        if(enemy.name.equals("Aryzachnid") || enemy.name.equals("Chimericks")){ text.enemyText("======================================================"); }
        else if(enemy.name.equals("Abarquez the Abyss Guardian")){ text.enemyText("=============================================================="); }
        else{ text.enemyText("=========================================================="); }
        System.out.println();

    }

    public void displayValidNotes(int level){
        text.printSystemMessage("--- Valid Notes ---");
        System.out.println();
        text.printSystemMessage("NOTE \t\t\tDAMAGE RANGE");
        System.out.println();
        text.printSystemMessage("[ A ] --->  \t { 1 - 10 } ");
        text.printSystemMessage("[ B ] --->  \t { 5 - 13 } ");
        text.printSystemMessage("[ C ] --->  \t { 9 - 16 } ");
        if(level >= 2){
            text.printSystemMessage("[ D ] --->  \t{ 12 - 18 }");
            text.printSystemMessage("[ E ] --->  \t{ 16 - 21 }");
        }

        if(level >= 3){
            text.printSystemMessage("[ F ] --->  \t{ 19 - 23 }");
            text.printSystemMessage("[ G ] --->  \t{ 21 - 24 }");
        }
        text.shortbreak();
    }


    public void chordChart(ChordSystem chord){
        text.shortbreak();
        text.printSystemMessage("--- CHORD CHART --- ");
        System.out.println();
        text.printSystemMessage("[ C Major ] ---> \t" + (chord.isChordUsed('c') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ D Minor ] ---> \t" + (chord.isChordUsed('d') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ E Minor ] ---> \t" + (chord.isChordUsed('e') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ F Major ] ---> \t" + (chord.isChordUsed('f') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ G Major ] ---> \t" + (chord.isChordUsed('g') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ A Minor ] ---> \t" + (chord.isChordUsed('a') ? "USED" : "AVAILABLE"));
        text.printSystemMessage("[ B Dim   ] ---> \t" + (chord.isChordUsed('b') ? "USED" : "AVAILABLE"));
        text.shortbreak();
    }

    public void displayChord(){
        text.shortbreak();
        text.printSystemMessage("--- CHORD CHART --- ");
        System.out.println();
        text.yellowText("\t[ C Major ] ---> \t Notes: C, E, G \t Effect: Heals 20% HP");
        text.yellowText("\t[ D Minor ] ---> \t Notes: D, F, A \t Effect: +20% Damage Buff");
        text.yellowText("\t[ E Minor ] ---> \t Notes: E, G, B \t Effect: Heals 10% HP & +10% Damage Buff");
        text.yellowText("\t[ F Major ] ---> \t Notes: F, A, C \t Effect: +25 Shield Points");
        text.yellowText("\t[ G Major ] ---> \t Notes: G, B, D \t Effect: Heals 15% HP & +15 Shield Points");
        text.yellowText("\t[ A Minor ] ---> \t Notes: A, C, E \t Effect: +35 Shield Points");
        text.yellowText("\t[ B Dim   ] ---> \t Notes: B, D, F \t Effect: +30% Damage but lose 10% HP");
        text.shortbreak();
    }

    public void attackGuide(Character player){
        text.printSystemMessage("--- Attack Guide ---");
        System.out.println();
        text.printSystemMessage(" > Note System < ");
        text.yellowText("\tEach note corresponds to a specific damage range.");
        System.out.println();
        displayValidNotes(5);
        text.printSystemMessage(" > Metronome System <");
        if(player.getLevel() < 2){
            text.redText("\tLocked! Reach Level 2 to unlock the Metronome System.");
        }
        else if(player.getLevel() >= 2){
            text.yellowText("\tThe metronome acts as the damage multiplier based on the beat of the metronome.");
            text.yellowText("\tWhen your initial damage is divisible by the beat of the metronome, your attack synchronizes to the beat, resulting in a damage boost.");
            text.yellowText("\tEach time your attack syncs with the metronome, the metronome beat increases by 1, up to a maximum of 4.");
        }

        text.shortbreak();
        text.printSystemMessage(" > Chord System <");
        if(player.getLevel() < 3){
            text.redText("\tLocked! Reach Level 3 to unlock the Chord System.");
            text.shortbreak();
        }
        if(player.getLevel() >= 3){
            text.yellowText("\tBy combining specific notes, you can form chords that trigger unique effects.");
            text.yellowText("\tEach chord can only be used once per battle, so choose wisely!");
            displayChord();
        }

        text.printSystemMessage(" > Passive Skill < ");
        if(player.name.equals("Sonara")){
            text.playerText("--- Sonara's Passive Skill ---");
        }else if(player.name.equals("Aurelius")){
            text.playerText("--- Aurelius' Passive Skill ---");
        }else if(player.name.equals("Lyron")){
            text.playerText("--- Lyron's Passive Skill ---");
        }

        text.playerText(player.ps.skillName);
        text.playerText(player.ps.skillDescription);
        text.shortbreak();

        text.printSystemMessage(" > Active Skill < ");
        if(player.name.equals("Sonara")){
            text.playerText("--- Sonara's Active Skill ---");
        }else if(player.name.equals("Aurelius")){
            text.playerText("--- Aurelius' Active Skill ---");
        }else if(player.name.equals("Lyron")){
            text.playerText("--- Lyron's Active Skill ---");
        }

        text.playerText(player.as.skillName);
        text.playerText(player.as.skillDescription);
        text.shortbreak();
    }
}

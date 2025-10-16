package Combat;

import java.util.Scanner;
import java.util.Random;

import Display.TextDisplay;
import Player.Character;
import Enemy.Monster;
import Display.CombatDisplay;

public class Combat {
    TextDisplay text = new TextDisplay();
    CombatDisplay combDisplay = new CombatDisplay();
    Metronome mt = new Metronome();
    Note nt = new Note();
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    ChordSystem chordSystem = new ChordSystem();

    private boolean isGameOver = false;

    public void battle(Character player, Monster enemy) {
        combDisplay.battleStart();
        int beat;

        while (!isGameOver) {
            beat = mt.getBeat();

            turnAction(player, enemy, beat);

            //Game Check
            isGameOver = isEnemyDefeated(enemy);
            if (isGameOver) break;

            //Enemy Attack
            // SONARA PASSIVE
            if (player.name.equals("Sonara")) {
                player.ps.skillEffect(enemy);
            } else player.takeDamage(enemyAttack(enemy));

            combDisplay.playerStatsSummary(player);

            //Game Check
            isGameOver = isPlayerDefeated(player);
            if (isGameOver) break;

        }
    }

    //Player Attack
    public void playerAttack(Character player, Monster enemy, int beat) {
        boolean isValidAttack = false;
        char note1 = ' ';
        char note2 = ' ';
        char note3 = ' ';

        while (!isValidAttack) {
            combDisplay.noteInput();

            text.printSystemInput("#1:   ");
            note1 = sc.next().charAt(0);
            text.printSystemInput("#2:   ");
            note2 = sc.next().charAt(0);
            text.printSystemInput("#3:   ");
            note3 = sc.next().charAt(0);
            System.out.println();

            isValidAttack = checkNotes(player, note1, note2, note3);
            if(!isValidAttack){
                text.printSystemMessage("Please re-enter your notes.");
            }
        }
        //Note Input

        //Total Damage
        int damage = computeNoteDamage(player, note1, note2, note3, beat);

        if(player.getLevel() >= 3){
            String chord = chordSystem.checkChord(note1, note2, note3);
            if (chord != null) {
                damage = chordSystem.applyChord(chord, player, damage);
            }
        }
        //Chord Check

        text.printSystemMessage("\tTotal Damage Dealt: " + damage);
        System.out.println();

        //Enemy Status Update
        enemy.takeDamage(damage);
    }

    public boolean checkNotes(Character player,char n1, char n2, char n3) {
        if (nt.isValidNote(n1, player) && nt.isValidNote(n2, player) && nt.isValidNote(n3, player)) {
            if (n1 == n2 || n1 == n3 || n2 == n3) {
                text.printSystemMessage(" --- Duplicate notes detected! Please enter different notes. ---\n");
                combDisplay.displayValidNotes();
            }else{
                return true;
            }
        } else {
            combDisplay.displayValidNotes();
        }
        return false;
    }
    //Monster Attack
    public int enemyAttack(Monster enemy) {
        int attack = rd.nextInt(1, 3 + 1);
        int damage = 0;

        if(attack == 1){
            damage = enemy.sk1Damage;
        }else if(attack == 2){
            damage = enemy.sk2Damage;
        }else if(attack == 3){
            damage = enemy.sk3Damage;
        }
        text.printSystemMessage("\tMonster attacks Player and deals " + damage + " damage!");
        System.out.println();
        return damage;
    }

    public int computeNoteDamage(Character player, char note1, char note2, char note3, int beat){
        int initialDamage = 0;
        initialDamage += nt.noteDamage(note1);
        initialDamage += nt.noteDamage(note2);
        initialDamage += nt.noteDamage(note3);
        text.printSystemMessage("Initial Damage: " + initialDamage);

        //SONARA'S ACTIVE SKILL
        if(player.name.equals("Sonara")) { initialDamage = player.as.skillEffect(player, initialDamage); }

        //Metronome
        text.printSystemMessage("Metronome: " + beat);
        int finalDamage= mt.updateBeat(player, initialDamage);

        //Final Damage
        text.printSystemMessage("Final Damage: " + finalDamage);


        return finalDamage;
    }

    /*
    public void printStats(Character player, Character enemy){
    }
    */

    public boolean isPlayerDefeated(Character player){
        if(player.getHp()<=0) {
            player.setHp(0);
            isGameOver = true;

            combDisplay.battleEnd(false);
            return true;
        }
        return false;
    }

    public boolean isEnemyDefeated(Monster enemy){
        if(enemy.getHp()<=0){
            enemy.setHp(0);
            isGameOver = true;

            combDisplay.battleEnd(true);
            return true;
        }
        return false;
    }

    public void turnAction(Character player, Monster enemy, int beat) {
        boolean isTurnOver;
        int action = 0;
        boolean isEnabled;
        text.printSystemMessage("Metronome: " + beat);
        nt.generateNotes();

        do {
            //LYRON'S ACTIVE SKILL
            if(player.name.equals("Lyron")) { if(player.as.skillEffect(player)) nt.generateNotes(); }

            nt.damagePerNote(player);
            isTurnOver = false;
            combDisplay.turnAction();
            isEnabled = true;
            while(isEnabled){
                try{
                    action = sc.nextInt();
                    System.out.println();
                    if(action <= 0 || action >6){
                        System.out.println();
                        text.printSystemMessage("--- Invalid Input ---");
                        System.out.println();
                        text.printSystemInput("Select: ");
                    }
                    else{
                        isEnabled = false;
                    }
                }
                catch(Exception e){
                    System.out.println();
                    text.printSystemMessage("--- Invalid Input ---");
                    System.out.println();
                    text.printSystemInput("Select: ");
                    sc.next();
                }
            }


            switch (action) {
                case 1:
                    playerAttack(player, enemy, beat);
                    combDisplay.enemyStatsSummary(enemy);
                    isTurnOver = true;
                    break;
                case 2:
                    player.as.useSkill(player);
                    break;
                case 3:
                    text.printSystemMessage("Inventory is currently empty.");
                    break;
                case 4:
                    combDisplay.chordChart(chordSystem);
                    break;
                case 5:
                    combDisplay.playerStatsSummary(player);
                    combDisplay.enemyStatsSummary(enemy);
                    break;
                case 6:
                    text.printSystemMessage("No content available...");
                    break;
                default:
                    break;
            }
        } while (!isTurnOver);
    }
}

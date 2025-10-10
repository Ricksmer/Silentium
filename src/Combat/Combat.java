package Combat;

import java.util.Scanner;
import java.util.Random;
import Player.Character;
import Enemy.Monster;
import Main.InterfaceFormats;

public class Combat {
    InterfaceFormats inf = new InterfaceFormats();
    Metronome mt = new Metronome();
    Note nt = new Note();
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    ChordSystem chordSystem = new ChordSystem();

    private boolean isGameOver = false;

    public void battle(Character player, Monster enemy) {
        inf.battleStart();
        int beat;
        boolean isTurnOver;
        while (!isGameOver) {
            beat = mt.getBeat();

            turnAction(player, enemy, beat);

            //Game Check
            isGameOver = isEnemyDefeated(enemy);
            if (isGameOver) break;

            //Enemy Attack
            // SONARA PASSIVE
            if (player.name.equals("Sonara")) {
                player.ps.skillEffect(player, enemy);
            } else enemyAttack(player, enemy);

            inf.playerStatsSummary(player);

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
            System.out.println("Metronome: " + beat);
            inf.noteInput();
            nt.damagePerNote();

            System.out.print("");
            System.out.print(" #1:   ");
            note1 = sc.next().charAt(0);
            System.out.print(" #2:   ");
            note2 = sc.next().charAt(0);
            System.out.print(" #3:   ");
            note3 = sc.next().charAt(0);
            System.out.println();

            isValidAttack = checkNotes(note1, note2, note3);
            if(!isValidAttack){
                System.out.println("Please re-enter your notes.\n");
            }
        }
        //Note Input



        //Total Damage
        int damage = computeNoteDamage(note1, note2, note3, beat);

        //Chord Check
        String chord = chordSystem.checkChord(note1, note2, note3);
        if (chord != null) {
            damage = chordSystem.applyChord(chord, player, damage);

            // LYRON PASSIVE
            if (player.name.equals("Lyron")) {
                damage = player.ps.skillEffect(player, damage);
            }
        }

        System.out.println("\tTotal Damage Dealt: " + damage);
        System.out.println();

        //Enemy Status Update
        enemy.takeDamage(damage);
    }

    public boolean checkNotes(char n1, char n2, char n3) {
        if (nt.isValidNote(n1) && nt.isValidNote(n2) && nt.isValidNote(n3)) {
            if (n1 == n2 || n1 == n3 || n2 == n3) {
                System.out.println(" --- Duplicate notes detected! Please enter different notes. ---\n");
                inf.displayValidNotes();
            }else{
                return true;
            }
        } else {
            inf.displayValidNotes();
        }
        return false;
    }
    //Monster Attack
    public void enemyAttack(Character player, Monster enemy) {
        int attack = rd.nextInt(1, 3 + 1);
        int damage = 0;

        if(attack == 1){
            damage = enemy.sk1Damage;
        }else if(attack == 2){
            damage = enemy.sk2Damage;
        }else if(attack == 3){
            damage = enemy.sk3Damage;
        }
        System.out.println("\tMonster attacks Player and deals " + damage + " damage!");
        System.out.println();
        player.takeDamage(damage);
    }

    public int computeNoteDamage(char note1, char note2, char note3, int beat){
        int initialDamage = 0;
        int finalDamage = initialDamage;
        initialDamage += nt.noteDamage(note1);
        initialDamage += nt.noteDamage(note2);
        initialDamage += nt.noteDamage(note3);
        System.out.println("\tInitial Damage: " + initialDamage);

        //Metronome
        System.out.println("\tMetronome: " + beat);
        if(initialDamage % beat == 0){
            finalDamage = initialDamage * beat;
        }

        //Final Damage
        System.out.println("\tFinal Damage: " + finalDamage);


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

            System.out.println("You lost!");
            return true;
        }
        return false;
    }

    public boolean isEnemyDefeated(Monster enemy){
        if(enemy.getHp()<=0){
            enemy.setHp(0);
            isGameOver = true;

            System.out.println("You win!");
            return true;
        }
        return false;
    }

    public void turnAction(Character player, Monster enemy, int beat) {
        boolean isTurnOver;
        int action;

        do {
            isTurnOver = false;
            inf.turnAction();
            action = sc.nextInt();
            System.out.println();

            switch (action) {
                case 1:
                    playerAttack(player, enemy, beat);
                    inf.enemyStatsSummary(enemy);
                    isTurnOver = true;
                    break;
                case 2:
                    System.out.println("No content available.");
                    break;
                case 3:
                    System.out.println("Inventory is currently empty.");
                    break;
                case 4:
                    chordSystem.chordChart();
                    break;
                case 5:
                    inf.playerStatsSummary(player);
                    inf.enemyStatsSummary(enemy);
                    break;
                case 6:
                    System.out.println("No content available.");
                    break;
                default:
                    System.out.println("Invalid action. Please choose again.");
            }
        } while (!isTurnOver);
    }
}

import java.util.Scanner;
import java.util.Random;

public class Combat {
    Character player = new Character();
    InterfaceFormats inf = new InterfaceFormats();
    Metronome mt = new Metronome();
    Note nt = new Note();
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    ChordSystem chordSystem = new ChordSystem();

    private boolean isGameOver = false;

    public void battle(Character player, Monster enemy){
        inf.battleStart();

        while(!isGameOver){
            int beat = mt.beatRoll();

            //Player Attack
            playerAttack(player, enemy, beat);

            //Game Check
            isGameOver = isEnemyDefeated(enemy);
            if(isGameOver == true) break;

            //Enemy Attack
            enemyAttack(player, enemy);

            //Game Check
            isGameOver = isPlayerDefeated(player);
            if(isGameOver == true) break;

        }
    }

//Player Attack
    public void playerAttack(Character player, Monster enemy, int beat){
        //Note Input
        inf.noteInput();
        nt.damagePerNote();

        System.out.print("");
        System.out.print(" #1:   ");
        char note1 = sc.next().charAt(0);
        System.out.print(" #2:   ");
        char note2 = sc.next().charAt(0);
        System.out.print(" #3:   ");
        char note3 = sc.next().charAt(0);

        //Initial Damage
        int damage =  computeNoteDamage(note1, note2, note3, beat);

    //Chord Check
        String chord = chordSystem.checkChord(note1, note2, note3);
        if(chord != null){
            chordSystem.applyChord(chord, player);
        }

    //Enemy Status Update
        enemy.takeDamage(damage);
    }

//Monster Attack
    public void enemyAttack(Character player, Monster enemy) {
        int damage = rd.nextInt(15) + 5;
        System.out.println("Monster attacks Player and deals " + damage + " damage!");
        System.out.println();
        player.takeDamage(damage);
    }

    public int computeNoteDamage(char note1, char note2, char note3, int beat){
        int initialDamage = 0;
        int finalDamage = initialDamage;
        initialDamage += nt.noteDamage(note1);
        initialDamage += nt.noteDamage(note2);
        initialDamage += nt.noteDamage(note3);
        System.out.println("Initial Damage: " + initialDamage);

        //Metronome
        System.out.println("Metronome: " + beat);
        if(initialDamage % beat == 0){
            finalDamage = initialDamage * beat;
        }

        //Final Damage
        System.out.println("Final Damage: " + finalDamage);
        return finalDamage;
    }

    public void printStats(Character player, Character enemy){

    }

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
}

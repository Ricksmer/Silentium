import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static Character player = new Character();
    static Monster enemy = new Monster();
    static InterfaceFormats inf =  new InterfaceFormats();
    static Combat combat = new Combat();

    public static void main(String []args){
        player = inf.CharacterSelect();
        inf.characterDisplay(player);

        enemy.testMonster();

        combat.battle(player, enemy);
    }
}



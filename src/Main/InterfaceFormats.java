package Main;

import java.util.Scanner;
import Player.Character;
import Player.Sonara;
import Player.Aurelius;
import Player.Lyron;
import Enemy.Monster;

public class InterfaceFormats implements DisplayFormat{
    Scanner sc = new Scanner(System.in);
    @Override
    public void battleStart(){
        System.out.println("===== Battle Start! =====");
        System.out.println();
    }

    @Override
    public void battleEnd(Boolean isWin){
        if(isWin) { System.out.println("=====   Y O U     W I N !   ====="); }
        else { System.out.println("=====   Y O U     L O S E !   ====="); }
    }

    public void noteInput(){
        System.out.println(" --- Enter Notes ---");
        System.out.println();
    }

    public Character CharacterSelect(){
        int charSelect;
        Character sonara = new Sonara();
        Character aurelius = new Aurelius();
        Character lyron = new Lyron();
        Character player = null;

        System.out.println();
        do{
            System.out.println(" --- Select Character ---");
            System.out.println();

            System.out.println(" [ 1 ] --->  " + sonara.name + " : " + sonara.instrument + " ");

            System.out.println(" [ 2 ] --->  " + aurelius.name + " : " + aurelius.instrument + " ");

            System.out.println(" [ 3 ] --->  " + lyron.name + " : " + lyron.instrument + " ");

            System.out.println();
            System.out.print(" Select :   ");
            charSelect = sc.nextInt();

            switch (charSelect){
                case 1:
                    player = new Sonara();
                case 2:
                    player = new Aurelius();
                case 3:
                    player = new Lyron();
                default:
                    System.out.println();
                    System.out.println(" --- Invalid Input ---");
                    System.out.println();
                    continue;
            }

        }while(charSelect <= 0 || charSelect > 3);

        return player;
    }

    public void MonsterSpawn(){

    }

    public void characterDisplay(Character player){
        System.out.println(" ---     " + player.name + "     ---");
        System.out.println(" ---    ( Player )     ---");
        System.out.println();
        System.out.println(" Level: " + player.getLevel());
        System.out.println(" Instrument: " + player.instrument);
        System.out.println(" HP: " + player.getHp() + " / " +  player.getMaxHp());
        System.out.println(" Shield: " + player.getShield() + " / " +  player.getMaxShield());
        //System.out.println(" Passive Skill: " + player.ps.skillDescription);
        //System.out.println(" Active Skill: " + player.as.skillDescription);
        System.out.println();
        System.out.println(" ------------------------- ");
    }

    public void playerStatsSummary(Character player){
        System.out.println(" ---     " + player.name + "     ---");
        System.out.println(" ---    ( Player )     ---");
        System.out.println();
        System.out.println(" Level: " + player.getLevel());
        System.out.println(" Instrument: " + player.instrument);
        System.out.println(" HP: " + player.getHp() + " / " +  player.getMaxHp());
        System.out.println(" Shield: " + player.getShield() + " / " +  player.getMaxShield());
        System.out.println();
    }

    public void enemyStatsSummary(Monster enemy){
        System.out.println(" ------------------------- ");
        //System.out.println(" ---     " + enemy.name + "     ---");
        System.out.println(" ---    ( Monster )     ---");
        System.out.println();
        //System.out.println(" HP: " + enemy.getHp() + " / " +  enemy.getMaxHp());
        System.out.println();
        System.out.println(" ------------------------- ");

    }
}

package Main;

import java.util.Random;
import java.util.Scanner;

import Enemy.*;
import Player.Character;
import Player.Sonara;
import Player.Aurelius;
import Player.Lyron;

public class InterfaceFormats implements DisplayFormat{
    @Override
    public void battleStart(){
        System.out.println("\t=============== Battle Start! ===============");
        System.out.println();
    }

    @Override
    public void battleEnd(Boolean isWin){
        if(isWin) { System.out.println("\t\t ==========   Y O U     W I N !   =========="); }
        else { System.out.println("\t\t ==========   Y O U     L O S E !   =========="); }
    }

    public void noteInput(){
        System.out.println("\t --- Enter Notes ---");
        System.out.println();
    }

    public void CharacterSelect(){
        Character sonara = new Sonara();
        Character aurelius = new Aurelius();
        Character lyron = new Lyron();

        System.out.println("\t --- Select Character ---");
        System.out.println();

        System.out.println("\t [ 1 ] --->  " + sonara.name + " : " + sonara.instrument + " ");

        System.out.println("\t [ 2 ] --->  " + aurelius.name + " : " + aurelius.instrument + " ");

        System.out.println("\t [ 3 ] --->  " + lyron.name + " : " + lyron.instrument + " ");

        System.out.println();
        System.out.print("\t Select :   ");
    }

    public Monster MonsterSpawn(int map){
        Random rd = new Random();
        int op = 1;

        if(map == 1){
            op = rd.nextInt(1, 2 + 1);

            if(op == 1) return new FleshFeeders();
            if(op == 2) return new Andrewellers();
        }else if(map == 2){
            op = rd.nextInt(1, 2 + 1);

            if(op == 1) return new Aryzachnid();
            if(op == 2) return new Chimericks();
        }
        return new Abarquez();
    }

    public void characterDisplay(Character player){
        System.out.println("\t ---     " + player.name + "     ---");
        System.out.println("\t ---    ( Player )     ---");
        System.out.println();
        System.out.println("\t Level: " + player.getLevel());
        System.out.println("\t Instrument: " + player.instrument);
        System.out.println("\t HP: " + player.getHp() + " / " +  player.getMaxHp());
        System.out.println("\t Shield: " + player.getShield() + " / " +  player.getMaxShield());
        //System.out.println(" Passive Skill: " + player.ps.skillDescription);
        //System.out.println(" Active Skill: " + player.as.skillDescription);
        System.out.println();
        System.out.println("\t ------------------------- ");
    }

    public void playerStatsSummary(Character player){
        System.out.println("\t ---     " + player.name + "     ---");
        System.out.println("\t ---    ( Player )     ---");
        System.out.println();
        System.out.println("\t Level: " + player.getLevel());
        System.out.println("\t Instrument: " + player.instrument);
        System.out.println("\t HP: " + player.getHp() + " / " +  player.getMaxHp());
        System.out.println("\t Shield: " + player.getShield() + " / " +  player.getMaxShield());
        System.out.println();
    }

    public void enemyStatsSummary(Monster enemy){
        System.out.println("\t ---     " + enemy.name + "     ---");
        System.out.println("\t ---    ( Monster )     ---");
        System.out.println();
        System.out.println("\t HP: " + enemy.getHp() + " / " +  enemy.getMaxHp());
        System.out.println();
        System.out.println("\t ------------------------- ");

    }

    public void displayValidNotes(){
        System.out.println("\t\t--- Valid Notes ---");
        System.out.println("\tNOTE \tDAMAGE RANGE");
        System.out.println();
        System.out.println("\t [ A ] --->  \t { 1 - 10 } ");
        System.out.println("\t [ B ] --->  \t { 5 - 13 } ");
        System.out.println("\t [ C ] --->  \t { 9 - 16 } ");
        System.out.println("\t [ D ] --->  \t{ 12 - 18 }");
        System.out.println("\t [ E ] --->  \t{ 16 - 21 }");
        System.out.println("\t [ F ] --->  \t{ 19 - 23 }");
        System.out.println("\t [ G ] --->  \t{ 21 - 24 }");
        System.out.println();
    }

    public void turnAction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t --- Choose an action ---\n");
        System.out.println("\t [ 1 ] ---> \t Attack");
        System.out.println("\t [ 2 ] ---> \t Skill");
        System.out.println("\t [ 3 ] ---> \t Inventory");
        System.out.println("\t [ 4 ] ---> \t Chord Chart");
        System.out.println("\t [ 5 ] ---> \t Display Stats");
        System.out.println("\t [ 6 ] ---> \t Attack Guide");
        System.out.println();
        System.out.print("\t Select: ");
    }
}

package Display;

import Map.Arc;
import Player.Character;
import Player.*;
import Map.*;
import Display.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
    TextDisplay text = new  TextDisplay();
    Character player;
    CombatDisplay combDisplay = new CombatDisplay();
    MapCharacter mapChar = new MapCharacter();

    Arc arcManager = null;

    public void start(){
        boolean isRunning = true;
        displayMenu();

        Scanner sc = new Scanner(System.in);
        boolean isEnabled;
        int option = 0;

        while(isRunning) {
            isEnabled = true;
            while(isEnabled){
                try{
                    option  = sc.nextInt();
                    if(option <= 0 || option > 5){
                        System.out.println();
                        text.printSystemError(" --- Invalid Input ---");
                        System.out.println();

                        text.printSystemInput("Select: ");
                    }
                    else{
                        isEnabled = false;
                        text.shortbreak();
                    }
                }catch(InputMismatchException e){
                    System.out.println();
                    text.printSystemError(" --- Invalid Input ---");
                    System.out.println();

                    text.printSystemInput("Select: ");
                    sc.next();
                }
            }

            switch (option) {
                case 1: // PLAY
                    player = CharacterSelect();
                    combDisplay.characterDisplay(player);

                    arcManager = new Arc(mapChar,player); // Arc Instantiation - Sangasina

                    //ARC SEQUENCE
                    arcManager.startArc1();
                    arcManager.startArc2();
                    arcManager.startArc3();
                    break;
                case 2: //StoryLine
                    System.out.println("Require: ... Please implement\n-Sangasina");
                    break;
                case 3: //Credits
                    System.out.println(credits());
                    break;
                case 4: //How to Play
                    System.out.println("Require: How to Play... Please implement\n-Sangasina");
                    break;
                case 5: // Exit
                    System.out.println("Require: Exit Function... Please implement\n-Sangasina");
                    isRunning = false;
                    break;
            }
        }
    }


    public void displayMenu(){
        text.shortbreak();
        text.printSystemMessage("--- Main Menu ---");
        System.out.println();
        text.printSystemMessage("[ 1 ] --->  Start Game");
        text.printSystemMessage("[ 2 ] --->  Story");
        text.printSystemMessage("[ 3 ] --->  Credits");
        text.printSystemMessage("[ 4 ] --->  How To Play");
        text.printSystemMessage("[ 5 ] --->  Exit");
        System.out.println();
        text.printSystemInput("Select :   ");
    }

    public String credits(){
        return "\n\n=========================================CREDITS=========================================\n"
                + "Silentium is a project developed by the \"Team Balanghoy\" Group that is composed\n"
                + "of 2nd year BSIT students from CIT-U (Cebu Institute of Technology University).\n"
                + "Silentium serves as a final submission for the final project assigned by \n"
                + "Kenn Migan Vincent Gumonan under the subject code CSIT227 titled \n\"Object Oriented Programming 1\"...\n\n" + "Members:\n"
                + "Ricksmer Cabatingan - Project Manager\n" + "Andrew Sangasina - Project Manager\n"+ "Yohan Abarquez - Member\n"
                + "Ryza Janell Mutya - Memeber\n"+ "Precious Ann Tolentino - Member"
                + "\n=========================================================================================\n\n";
    }

    public Character CharacterSelect(){
        int charSelect = 1;
        boolean isEnabled;
        Character sonara = new Sonara();
        Character aurelius = new Aurelius();
        Character lyron = new Lyron();
        Character op = new Op();
        Scanner sc = new Scanner(System.in);
        CombatDisplay combDisplay = new CombatDisplay();

        do{
            combDisplay.CharacterSelect();

            isEnabled = true;
            while(isEnabled){
                try{
                    charSelect = sc.nextInt();
                    if(charSelect < 0 || charSelect > 3){
                        System.out.println();
                        text.printSystemError(" --- Invalid Input ---");
                        System.out.println();

                        text.printSystemInput("Select: ");
                    }
                    else {
                        isEnabled = false;
                        text.shortbreak();
                    }
                }
                catch(Exception e){
                    System.out.println();
                    text.printSystemMessage(" --- Invalid Input ---");
                    System.out.println();

                    text.printSystemInput("Select: ");
                    sc.next();
                }
            }


            switch (charSelect){
                case 1:
                    return sonara;
                case 2:
                    return aurelius;
                case 3:
                    return lyron;
                case 0:

                    return op;
                default:
                    break;
            }


        }while(charSelect <= 0 || charSelect > 3);

        return null;
    }
}

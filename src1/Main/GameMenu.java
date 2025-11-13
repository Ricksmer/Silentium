package Main;

import Main.Task;
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
    DisplayStory displayStory = new DisplayStory();
    HowToPlay howToPlay = new HowToPlay();
    Task task = new Task();

    Arc arcManager = null;

    public void start(){
        task.load(2);
        boolean isRunning = true;

        Scanner sc = new Scanner(System.in);
        boolean isEnabled;
        int option = 0;

        while(isRunning) {
            displayMenu();
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
                        task.load(1);
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
                    if(player == null) break;
                    combDisplay.characterDisplay(player);

                    arcManager = new Arc(mapChar,player); // Arc Instantiation - Sangasina

                    //ARC SEQUENCE
                    arcManager.startArc1();
                    arcManager.startArc2();
                    arcManager.startArc3();

                    break;
                case 2: //StoryLine
                    displayStory.displayFullLore();
                    break;
                case 3: //Credits
                    credits();
                    break;
                case 4: //How to Play
                    howToPlay.displayHowToPlay();
                    break;
                case 5: // Exit
                    text.redTextV2("\t\t\t\t\tExiting Silentium");
                    task.load(3);
                    isRunning = false;
                    text.shortbreak();
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

    public void credits(){
        String credits = """
                                           =====   CREDITS   ===== 
                                                   
                       Silentium is a project developed by the "Team Balanghoy" Group that
                    is composed of 2nd year BSIT students from CIT-U (Cebu Institute of
                    Technology University). Silentium serves as a final submission for the 
                    final project assigned by Kenn Migan Vincent Gumonan under the subject
                     code CSIT227 titled "Object Oriented Programming 1"...
                                    
                                             > Project Managers <
                                             Cabatingan, Ricksmer
                                              Sangasina, Andrew
                                               
                                              > Co-Developers <
                                               Abarquez, Yohan
                                              Mutya, Ryza Janell
                                            Tolentino, Precious Ann   
                                                                           
                """;

        text.yellowTextV2(credits);

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
                        task.load(1);
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
                    combDisplay.displayStats(sonara);
                    combDisplay.displayStats(aurelius);
                    combDisplay.displayStats(lyron);
                    return null;
                default:
                    break;
            }


        }while(charSelect <= 0 || charSelect > 3);

        return null;
    }
}

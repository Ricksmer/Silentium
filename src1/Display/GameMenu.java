package Display;

import Player.Character;
import Player.*;
import java.util.Scanner;

public class GameMenu {
    TextDisplay text = new  TextDisplay();

    public Character CharacterSelect(){
        int charSelect = 1;
        boolean isEnabled;
        Character sonara = new Sonara();
        Character aurelius = new Aurelius();
        Character lyron = new Lyron();
        Character op = new Op();
        Scanner sc = new Scanner(System.in);
        CombatDisplay combDisplay = new CombatDisplay();

        System.out.println();
        do{
            combDisplay.CharacterSelect();

            isEnabled = true;
            while(isEnabled){
                try{
                    charSelect = sc.nextInt();
                    System.out.println();
                    if(charSelect < 0 || charSelect > 3){
                        System.out.println();
                        text.printSystemError("\t --- Invalid Input ---");
                        System.out.println();

                        text.printSystemInput("\t Select: ");
                    }
                    else {
                        isEnabled = false;
                    }
                }
                catch(Exception e){
                    System.out.println();
                    text.printSystemMessage("\t --- Invalid Input ---");
                    System.out.println();

                    text.printSystemInput("\t Select: ");
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

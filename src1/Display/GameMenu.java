package Display;

import Player.Aurelius;
import Player.Character;
import Player.Lyron;
import Player.Sonara;
import java.util.Scanner;

public class GameMenu {
    TextDisplay text = new  TextDisplay();

    public Player.Character CharacterSelect(){
        int charSelect = 1;
        boolean isEnabled;
        Player.Character sonara = new Sonara();
        Player.Character aurelius = new Aurelius();
        Character lyron = new Lyron();
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
                    if(charSelect <= 0 || charSelect > 3){
                        System.out.println();
                        text.printSystemMessage("\t --- Invalid Input ---");
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
                default:
                    break;
            }


        }while(charSelect <= 0 || charSelect > 3);

        return null;
    }
}

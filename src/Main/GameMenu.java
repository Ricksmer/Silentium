package Main;

import Player.Aurelius;
import Player.Character;
import Player.Lyron;
import Player.Sonara;
import java.util.Scanner;

public class GameMenu {
    public Player.Character CharacterSelect(){
        int charSelect = 1;
        boolean isEnabled;
        Player.Character sonara = new Sonara();
        Player.Character aurelius = new Aurelius();
        Character lyron = new Lyron();
        Scanner sc = new Scanner(System.in);
        InterfaceFormats inf = new InterfaceFormats();

        System.out.println();
        do{
            inf.CharacterSelect();

            isEnabled = true;
            while(isEnabled){
                try{
                    charSelect = sc.nextInt();
                    System.out.println();
                    if(charSelect <= 0 || charSelect > 3){
                        System.out.println("\t Invalid Input!!! Try again... ");
                        System.out.print("\t Select: ");
                    }
                    else {
                        isEnabled = false;
                    }
                }
                catch(Exception e){
                    System.out.println("\t Invalid Input!!! Try again... ");
                    System.out.print("\t Select: ");
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

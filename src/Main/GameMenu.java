package Main;

import Player.Aurelius;
import Player.Character;
import Player.Lyron;
import Player.Sonara;
import java.util.Scanner;

public class GameMenu {
    public Player.Character CharacterSelect(){
        int charSelect;
        Player.Character sonara = new Sonara();
        Player.Character aurelius = new Aurelius();
        Character lyron = new Lyron();
        Scanner sc = new Scanner(System.in);
        InterfaceFormats inf = new InterfaceFormats();

        System.out.println();
        do{
            inf.CharacterSelect();
            charSelect = sc.nextInt();
            System.out.println();

            switch (charSelect){
                case 1:
                    return sonara;
                case 2:
                    return aurelius;
                case 3:
                    return lyron;
                default:
                    System.out.println();
                    System.out.println("\t --- Invalid Input ---");
                    System.out.println();
                    continue;
            }


        }while(charSelect <= 0 || charSelect > 3);

        return null;
    }
}

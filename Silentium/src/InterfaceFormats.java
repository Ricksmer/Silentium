import java.util.Scanner;

public class InterfaceFormats {
    Scanner sc = new Scanner(System.in);
    public void battleStart(){
        System.out.println("===== Battle Start! =====");
        System.out.println();
    }

    public void noteInput(){
        System.out.println(" --- Enter Notes ---");
        System.out.println();
    }

    public Character CharacterSelect(){
        int charSelect;
        Character player = new Character();

        System.out.println();
        do{
            System.out.println(" --- Select Character ---");
            System.out.println();

            player.Sonara();
            System.out.println(" [ 1 ] --->  " + player.name + " : " + player.instrument + " ");

            player.Aurelius();
            System.out.println(" [ 2 ] --->  " + player.name + " : " + player.instrument + " ");

            player.Lyron();
            System.out.println(" [ 3 ] --->  " + player.name + " : " + player.instrument + " ");

            System.out.println();
            System.out.print(" Select :   ");
            charSelect = sc.nextInt();

            switch (charSelect){
                case 1:
                    player.Sonara();
                    break;
                case 2:
                    player.Aurelius();
                    break;
                case 3:
                    player.Lyron();
                    break;
                default:
                    System.out.println();
                    System.out.println(" --- Invalid Input ---");
                    System.out.println();
                    continue;
            }

        }while(charSelect <= 0 || charSelect > 3);

        return player;
    }

    public void characterDisplay(Character player){
        System.out.println(" ---     " + player.name + "     ---");
        System.out.println(" ---    ( Player )     ---");
        System.out.println();
        System.out.println(" Level: " + player.getLevel());
        System.out.println(" Instrument: " + player.instrument);
        System.out.println(" HP: " + player.getHp() + " / " +  player.getMaxHp());
        System.out.println(" Shield: " + player.getShield() + " / " +  player.getMaxShield());
        System.out.println(" Passive Skill: " + player.ps.skillDescription);
        System.out.println(" Active Skill: " + player.as.skillDescription);
        System.out.println();
        System.out.println(" ------------------------- ");
    }

}

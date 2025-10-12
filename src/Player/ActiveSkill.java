package Player;

import java.util.Scanner;

public class ActiveSkill {
    Scanner sc = new Scanner(System.in);
    public String skillName;
    public String skillDescription;

    //SONARA
    boolean sonaraActiveUsed = false;
    public int skillEffect(Character player, int damage) {
        if(!sonaraActiveUsed){
            System.out.println("Unique Skill: Add +1 to final damage");
            System.out.println("Convert " + damage + " to " + (damage+1) + "? [0/1]: ");
            int choice = sc.nextInt();
            // need to try catch this!!!!!!!
            if(choice == 1){
                sonaraActiveUsed = true;
                return 1;
            }
        } else System.out.println("Active Skill already used!");
        return 0;
    }

    //AURELIUS
//    public void skillEffect(Character player) {
//
//    }

    //LYRON
    boolean lyronActiveUsed = false;
    public int skillEffect(Character player) {
        if(!lyronActiveUsed){
            System.out.print("Unique Skill: Reroll notes values? [0/1]: ");
            int choice = sc.nextInt();
            // need to try catch this!!!!!!!
            if(choice == 1){
                lyronActiveUsed = true;
                return 1;
            }
        } else System.out.println("Active Skill already used!");
        return 0;
    }

}

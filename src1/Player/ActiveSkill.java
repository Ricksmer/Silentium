package Player;

import java.util.InputMismatchException;
import java.util.Scanner;
import Display.TextDisplay;


public class ActiveSkill {
    TextDisplay text = new TextDisplay();
    Scanner sc = new Scanner(System.in);
    public String skillName;
    public String skillDescription;
    public boolean skillActive = false;

    public void useSkill(Character player){
        System.out.println();
        text.lineBreak();
        text.printSystemMessage("--- " + player.name +" ---");
        text.printSystemMessage("--- " + player.as.skillName + " ---");
        text.printSystemMessage(player.as.skillDescription);
        System.out.println();

        do{
            text.printSystemInput("Activate Skill? [ Y / N ]: ");

            try{
                char ans = sc.next().toUpperCase().charAt(0);
                if(ans == 'Y'){
                    player.as.skillActive = true;
                }else  if(ans == 'N'){
                    player.as.skillActive = false;
                }else{
                    System.out.println();
                    text.printSystemMessage("--- Invalid Input --- ");
                    System.out.println();
                    continue;
                }

                text.lineBreak();
                break;
            }catch(InputMismatchException e){
                System.out.println();
                text.printSystemMessage("--- Invalid Input --- ");
                System.out.println();
            }

        }while(true);


    }

    //SONARA'S ACTIVE SKILL
    public int skillEffect(Character player, int damage) {
        if(!player.as.skillActive) return damage;

        text.lineBreak();
        text.printSystemMessage("Skill Activated: " + player.as.skillName);
        text.printSystemMessage("Current Damage: " + damage);
        text.printSystemMessage("Unique Skill: Add +1 to Final Damage.");
        damage += 1;
        text.printSystemMessage("New Damage: " + damage);
        text.lineBreak();
        player.as.skillActive = false;
        return damage;
    }

    //LYRON'S ACTIVE SKILL
    public boolean skillEffect(Character player) {
        if(!player.as.skillActive) return false;

        text.lineBreak();
        text.printSystemMessage("Skill Activated: " + player.as.skillName);
        text.printSystemMessage("Unique Skill: Reroll Note Damage.");
        text.lineBreak();
        player.as.skillActive = false;
        return true;
    }
}

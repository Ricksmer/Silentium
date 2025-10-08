package Player;

import Main.Dialogue;

public class Sonara extends Character implements Dialogue{
    public Sonara(){
        name = "Sonara";
        instrument = "The Scrouge of Echoes";
        ps.skillName = "Body of Thorns";
        ps.skillDescription = "Upon receiving damage, The enemy receives 25% of shared true damage from the enemy’s inflicted damage.";
        setMaxHp(150);
        setHp(getMaxHp());
        setMaxShield(35);
        //this.ps.Sonara();
        //this.as.Sonara();
        setLevel(1);
    }

    public void introDialogue(){
        System.out.println("HELLO! ");
    }
}

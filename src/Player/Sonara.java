package Player;

import Main.Dialogue;

public class Sonara extends Character implements Dialogue{
    public Sonara(){
        name = "Sonara";
        instrument = "The Scrouge of Echoes";
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

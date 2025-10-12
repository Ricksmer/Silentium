package Player;

public class Lyron extends Character{
    public Lyron(){
        name = "Lyron";
        instrument = "The Shattered Harmony";
        ps.skillName = "The winner takes it all";
        ps.skillDescription = "In a successful metronome synchronization Reduces the final damage output by 25%. \n" +
                "Lyron gains 25% of the final damage points as shielding points\n";
        setMaxHp(250);
        setHp(getMaxHp());
        setMaxShield(50);
        //this.ps.Lyron();
        //this.as.Lyron();
        setLevel(1);
    }

}

package Player;

public class Lyron extends Character{
    public Lyron(){
        name = "Lyron";
        instrument = "The Shattered Harmony";
        ps.skillName = "The winner takes it all";
        ps.skillDescription = "In a successful metronome synchronization Reduces the final damage output by 25%. \n" +
                "Lyron gains 25% of the final damage points as shielding points\n";
        as.skillName = "Musical Roulette";
        as.skillDescription = "Can reroll all the damage value of all notes. Only once every turn.\n";
        setMaxHp(250);
        setHp(getMaxHp());
        setMaxShield(50);
        //this.ps.Lyron();
        //this.as.Lyron();
        setLevel(1);
    }
}

package Player;

public class Aurelius extends Character{
    public Aurelius(){
        name = "Aurelius";
        instrument = "The Whispering Bulwark";
        ps.skillName = "Melodic Remedy";
        ps.skillDescription = "Chords heals 5% of Aurelius’ health\n" +
                "After a chord, grants aurelius an extra turn but is limited to use one note.\n";
        as.skillName = "Conservation";
        as.skillDescription = "Aurelius can choose to preserve the selected notes' current damage for next turn.\n";
        setMaxHp(150);
        setHp(getMaxHp());
        setMaxShield(40);
        //this.ps.Lyron();
        //this.as.Lyron();
        setLevel(1);
    }
}

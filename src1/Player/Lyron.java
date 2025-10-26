package Player;

public class Lyron extends Character{
    private final String[] quotes = {
            "Not again. Go.", // Shadow 1
            "I won't let you follow me anymore!", // Shadow 2
            "It's gone. I... I did it.", // Shadow 3
            "You will pay for every single sound I lost!" // Shadow 4
    };

    public Lyron(){
        name = "Lyron";
        instrument = "The Shattered Harmony";
        ps.skillName = "The winner takes it all";
        ps.skillDescription = "In a successful metronome synchronization Reduces the final damage output by 25%. \n" +
                "Lyron gains 25% of the final damage points as shielding points";
        as.skillName = "Musical Roulette";
        as.skillDescription = " Lyron can reroll the notes to reset their damage output.";
        setMaxHp(250);
        setHp(getMaxHp());
        setMaxShield(50);
        setMap(1);
        setLevel(1, 1);

        narrative.setQuotes(quotes);
    }
}

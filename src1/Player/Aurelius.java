package Player;

public class Aurelius extends Character{
    private final String[] quotes = {
            "The fear is gone. Be safe.", // Shadow 1
            "You will not touch the vulnerable.", // Shadow 2
            "My breath will not fail. Justice prevails.", // Shadow 3
            "Go back to the apathy you came from. We are awake now." // Shadow 4
    };

    public Aurelius(){
        name = "Aurelius";
        instrument = "The Whispering Bulwark";
        ps.skillName = "Melodic Remedy";
        ps.skillDescription = "Chords heals 5% of Aurelius’ health\n" +
                "After a chord, grants aurelius an extra turn but is limited to use one note.";
        as.skillName = "Conservatio";
        as.skillDescription = " Aurelius can choose to preserve the selected notes' current damage for next turn.";
        setMaxHp(150);
        setHp(getMaxHp());
        setMaxShield(40);
        setMap(1);
        setLevel(1);

        narrative.setQuotes(quotes);
    }
}

package Player;

public class Sonara extends Character{

    private final String[] quotes = {
            "Gone. Deserved it.", // Shadow 1
            "Too slow. The truth is faster than any lie.", // Shadow 2
            "A waste of my time. Next.", // Shadow 3
            "That's for my parents. Now, who's next on the list?" // Shadow 4
    };

    public Sonara(){
        name = "Sonara";
        instrument = "The Scrouge of Echoes";
        ps.skillName = "Body of Thorns";
        ps.skillDescription = "Upon receiving damage, The enemy receives 25% of shared true damage from the enemy’s inflicted damage.";
        as.skillName = "Melodic Impromptu";
        as.skillDescription = " Sonara can add one (1) point to the initial damage.";
        setMaxHp(150);
        setHp(getMaxHp());
        setMaxShield(35);
        setMap(1);
        setLevel(1);

        narrative.setQuotes(quotes);
    }

}

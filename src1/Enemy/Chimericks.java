package Enemy;

public class Chimericks extends Monster {
    public Chimericks(){
        name = "Chimericks";
        setMaxHp(700);
        setHp(getMaxHp());

        sk1Name = "Binding Webs";
        sk1Damage = rd.nextInt(15, 35 + 1);
        sk2Name = "Paralyzing Fangs";
        sk2Damage = rd.nextInt(20, 40 + 1);
        sk3Name = "Wrap-up";
        sk3Damage = rd.nextInt(40, 60 + 1);

        monsterDescription = "A fearsome, corrupted chimeric beast that represents pain and leeching corruption, making it highly self-sustaining. ";
    }
}

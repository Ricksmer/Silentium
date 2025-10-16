package Enemy;

public class Aryzachnid extends Monster{
    public Aryzachnid(){
        name = "Aryzachnid";
        setMaxHp(400);
        setHp(getMaxHp());

        sk1Name = "Binding Webs";
        sk1Damage = rd.nextInt(10, 30 + 1);
        sk2Name = "Paralyzing Fangs";
        sk2Damage = rd.nextInt(15, 45 + 1);
        sk3Name = "Wrap-up";
        sk3Damage = rd.nextInt(30, 50 + 1);
    }
}

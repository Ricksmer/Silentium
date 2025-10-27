package Enemy;

public class Abarquez extends Monster {
    public Abarquez(){
        name = "Abarquez the Abyss Guardian";
        setMaxHp(1000);
        setHp(getMaxHp());

        sk1Name = "Defensive Stance";
        sk1Damage = rd.nextInt(10, 20 + 1);
        sk2Name = "Hammer Swipe";
        sk2Damage = rd.nextInt(25, 55 + 1);
        sk3Name = "Hammer Strike";
        sk3Damage = rd.nextInt(30, 65 + 1);

        monsterDescription = "Abarquez the Abyss Guardian";
    }
}

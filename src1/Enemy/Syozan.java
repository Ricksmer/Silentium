package Enemy;

public class Syozan extends Monster {
    public Syozan(){
        name = "Maestro Syozan";
        setMaxHp(2000);
        setHp(getMaxHp());

        sk1Name = "Abyssal Echo Dirge";
        sk1Damage = rd.nextInt(20, 75 + 1);
        sk2Name = "Dirge of the Shattered Moon";
        sk2Damage = rd.nextInt(30, 100 + 1);
        sk3Name = "Ebon Symphony of Consuming Night";
        sk3Damage = rd.nextInt(40, 150 + 1);

        monsterDescription = "Maestro Syozan";
    }
}

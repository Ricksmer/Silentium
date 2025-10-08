package Enemy;

public class FleshFeeders extends Monster{
    public FleshFeeders(){
        name = "Flesh Feeders";
        setMaxHp(200);
        setHp(getMaxHp());;

        sk1Name = "Claw Through";
        sk1Damage = rd.nextInt(5, 15 + 1);
        sk2Name = "Bite";
        sk2Damage = rd.nextInt(5, 20 + 1);
        sk3Name = "Leap";
        sk3Damage = rd.nextInt(20, 35 + 1);
    }
}

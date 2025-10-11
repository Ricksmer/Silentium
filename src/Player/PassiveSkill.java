package Player;

import Enemy.Monster;
import Main.InterfaceFormats;
import java.util.Random;

public class PassiveSkill {
    public Random rd = new Random();
    public InterfaceFormats inf = new InterfaceFormats();
    public String skillName;
    public String skillDescription;

    //SONARA SKILL EFFECT
    public void skillEffect(Character player, Monster enemy){
        int attack = rd.nextInt(1, 3 + 1);
        int damage = 0;

        if(attack == 1){
            damage = enemy.sk1Damage;
        }else if(attack == 2){
            damage = enemy.sk2Damage;
        }else if(attack == 3){
            damage = enemy.sk3Damage;
        }
        System.out.println("Monster attacks Player and deals " + damage + " damage!");
        System.out.println();
        player.takeDamage(damage);

        int thorn = (int) (damage *  0.50);

        enemy.takeDamage(thorn);
        inf.enemyStatsSummary(enemy);
    }

    //AURELIUS SKILL EFFECT
    public void skillEffect(Character player){
        player.heal((int)(player.getMaxHp() * 0.08));
    }


    //LYRON SKILL EFFECT
    public int skillEffect(Character player, int damage){
        System.out.println("Lyron's Passive Skill activates! He gains Shield equal to 25% of the damage dealt!");
        player.addShield((int)(damage * 0.25));
        return (int) (damage * 0.25);

    }
}

package Player;

import Combat.Combat;
import Enemy.Monster;
import Display.CombatDisplay;

public class PassiveSkill {
    public CombatDisplay combDisplay = new CombatDisplay();
    public Combat combat = new Combat();
    public String skillName;
    public String skillDescription;

    //SONARA SKILL EFFECT
    public int skillEffect(Monster enemy){
        int damage = (combat.enemyAttack(enemy));;
        int thorn = (int) (damage * 0.50);

        enemy.takeDamage(thorn);
        combDisplay.enemyStatsSummary(enemy);
        return damage;
    }

    //AURELIUS SKILL EFFECT
    public void skillEffect(Character player){
        player.heal((int)(player.getMaxHp() * 0.08));
    }


    //LYRON SKILL EFFECT
    public int skillEffect(Character player, int damage){
        System.out.println("Lyron's Passive Skill activates! He gains Shield equal to 25% of the damage dealt!");
        System.out.println("\n\n === " + damage + " SHIELD:  " + (damage * 0.25) + " === \n\n");

        player.addShield((int)(damage * 0.25));
        return (int) (damage * 0.25);

    }
}

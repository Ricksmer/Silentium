package Enemy;

import java.util.Random;


public class Monster extends MonsterSkill{
    public String name;
    private int hp;
    private int maxHp;


    // MONSTER INITIALIZATION
    Random rd = new Random();

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
    public  int getMaxHp() {
        return maxHp;
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
    }

    public void testMonster(){
        hp = 250;
    }

    public void printStats() {
        System.out.println("Enemy Monster");
        System.out.println("=========================");
        System.out.println("HP: " + getHp());
        System.out.println();
    }
}
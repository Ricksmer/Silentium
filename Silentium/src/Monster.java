import java.util.Random;

public class Monster {
    private int hp;
    Random rd = new Random();

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        setHp(getHp() - damage);
    }

    public void testMonster(){
        setHp(250);
    }

    public void printStats() {
        System.out.println("Enemy Monster");
        System.out.println("=========================");
        System.out.println("HP: " + getHp());
        System.out.println();
    }
}
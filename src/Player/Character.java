package Player;

public class Character {
    public String name;
    public String instrument;
    public PassiveSkill ps = new PassiveSkill();
    //ActiveSkill as = new ActiveSkill();
    private int hp;
    private int maxHp;
    private int maxShield;
    private int shield;
    private int level;
    private double damageBuff;
    private int monstersDefeated = 0;

    public int getMaxShield() { return maxShield; }
    public void setMaxShield(int maxShield) { this.maxShield = maxShield; }
    public void setMaxShield(int maxShield, int level) { this.maxShield = maxShield; }

    public int getShield() { return shield; }
    public void setShield(int shield) { this.shield = shield; }

    public int getLevel() { return level; }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHp() { return maxHp; }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() { return hp; }

    public void displayName() {
        System.out.println("Name: " + name);
        System.out.println("Instrument: " + instrument);
        System.out.println("HP: " + hp);
    }


    public void addShield(int amount) {
        shield += amount;
        if (maxShield > 35) shield = 35;
    }

    public void takeDamage(int dmg) {
        if (shield > 0) {
            int reduced = dmg - shield;
            if (reduced < 0) reduced = 0;
            shield -= dmg;
            if (shield < 0) shield = 0;
            setHp(getHp() - reduced);
        } else {
            setHp(getHp() - dmg);
        }

    }

    public void heal(int amount) {
        setHp(getHp() + amount);
    }

    public void setDamageBuff(double buff) {
        this.damageBuff = buff;
    }
    public double getDamageBuff() {
        return damageBuff;
    }

}

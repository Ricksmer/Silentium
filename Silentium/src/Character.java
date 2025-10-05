public class Character {
    public String name;
    public String instrument;
    PassiveSkill ps = new PassiveSkill();
    ActiveSkill as = new ActiveSkill();
    private int hp;
    private int maxHp;
    private int maxShield;
    private int shield;
    private int level;
    private double damageBuff;

    // CHARACTER INITIALIZATION
    public void Sonara(){
        name = "Sonara";
        instrument = "The Scrouge of Echoes";
        this.ps.Sonara();
        this.as.Sonara();
        maxHp = 150;
        hp = maxHp;
        maxShield = 35;
        level = 1;
    }

    public void Aurelius(){
        name = "Aurelius";
        instrument = "The Whispering Bulwark";
        ps.Aurelius();
        as.Aurelius();
        maxHp = 150;
        hp = maxHp;
        maxShield = 40;
        level = 1;
    }

    public void Lyron(){
        name = "Lyron";
        instrument = "The Shattered Harmony";
        ps.Lyron();
        as.Lyron();
        maxHp = 250;
        hp = maxHp;
        maxShield = 50;
        level = 1;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getHp(){
        return hp;
    }

    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public void setMaxShield(int maxShield){
        this.maxShield = maxShield;
    }
    public int getMaxShield(){
        return maxShield;
    }

    public void setShield(int shield){
        this.shield = shield;
    }

    public int getShield(){
        return shield;
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

    public void displayName(){};

    public void heal(int amount) {
        setHp(Math.min(hp, getHp() + amount));
    }

    //added damageBuff system
    public void setDamageBuff(double buff) {
        this.damageBuff = buff;
    }

    public double getDamageBuff() {
        return damageBuff;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

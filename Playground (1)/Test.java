/*
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

class Ability{
    String skillName;
    double baseDamage;
    double manaCost;
    double addDamage;
    
    Ability(
        String skillName, double baseDamage, double manaCost, double addDamage)
        {
        this.skillName = skillName;
        this.baseDamage = baseDamage;
        this.manaCost = manaCost;
        this.addDamage = addDamage;
    }
}

class Character{
    String name;
    String role;
    double hp;
    double mana;
    double baseDamage;
    Ability sk1;
    Ability sk2;
    Ability sk3;
    
    Character(
        String name, String role, double hp, double mana, double baseDamage, 
        Ability sk1, Ability sk2, Ability sk3)
        {
        this.name = name;
        this.role = role;
        this.hp = hp;
        this.mana = mana;
        this.baseDamage = baseDamage;
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.sk3 = sk3;
    }
    
        Character(Character other) {
        this.name = other.name;
        this.role = other.role;
        this.hp = other.hp;
        this.mana = other.mana;
        this.baseDamage = other.baseDamage;
        this.sk1 = other.sk1;
        this.sk2 = other.sk2;
        this.sk3 = other.sk3;
    }
}

class Draft {
    static Random rd = new Random();
    static DecimalFormat df = new DecimalFormat("0");

    public static int randomizer(int max) {
        return rd.nextInt(max) + 1;
    }

    public static void attackSimulator(double baseDamage, double critRate, double critDamage) {
        double rateCalc = rd.nextInt(100) + 1;
        if (rateCalc <= critRate * 100) {
            System.out.println("CRITICAL HIT! Dealt " + df.format(critDamage) + " HP Damage!\n");
        } else {
            System.out.println("HIT! Dealt " + df.format(baseDamage) + " HP Damage!\n");
        }
    }
}

class BattleUtils{
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    DecimalFormat df = new DecimalFormat("0");
    DecimalFormat dfFull = new DecimalFormat("0.00");
    inGameOptions go = new inGameOptions();
    
    public void displayStats(Character hero){
        System.out.println("==============================");
        System.out.println();
        System.out.println("          " + hero.name);
        System.out.println();
        System.out.println("   Role     : " + hero.role);
        System.out.println("   HP       : " + dfFull.format(hero.hp));
        System.out.println("   Mana     : " + dfFull.format(hero.mana));
        System.out.println("   Damage   : " + dfFull.format(hero.baseDamage));
        System.out.println();
        System.out.println("   Skill 1                  : " + hero.sk1.skillName);
        System.out.println("        Damage              : " + dfFull.format(hero.sk1.baseDamage));
        System.out.println("        Mana Cost           : " + dfFull.format(hero.sk1.manaCost));
        System.out.println("        Additional Damage   : " + dfFull.format(hero.sk1.addDamage));
        System.out.println();
        System.out.println("   Skill 2                  : " + hero.sk2.skillName);
        System.out.println("        Damage              : " + dfFull.format(hero.sk2.baseDamage));
        System.out.println("        Mana Cost           : " + dfFull.format(hero.sk2.manaCost));
        System.out.println("        Additional Damage   : " + dfFull.format(hero.sk2.addDamage));
        System.out.println();
        System.out.println("   Skill 3                  : " + hero.sk3.skillName);
        System.out.println("        Damage              : " + dfFull.format(hero.sk3.baseDamage));
        System.out.println("        Mana Cost           : " + dfFull.format(hero.sk3.manaCost));
        System.out.println("        Additional Damage   : " + dfFull.format(hero.sk3.addDamage));
        System.out.println();
        System.out.println();
    }
    
    public void attackUpdateStats(Character attacker, Character defender, double manaCost, double damageRecieved){
        System.out.println("============================================================");
        System.out.println();
        System.out.println("Attack Successful! Damage Dealt: " + damageRecieved);
        defender.hp -= damageRecieved;
        attacker.mana -= manaCost;
        System.out.println();
        go.displayStats(defender);
    }
    
    public void attack(Character attacker, Character defender){
        int choice;
        System.out.println("==============================");
        System.out.println();
        System.out.println("   Please choose an attack: ");
        System.out.println("       [ 1 ]  ---> " + attacker.sk1.skillName);
        System.out.println("       [ 2 ]  ---> " + attacker.sk2.skillName);
        System.out.println("       [ 3 ]  ---> " + attacker.sk3.skillName);
        System.out.println();
        System.out.print("   Select : "); choice = sc.nextInt();
        System.out.println();
        
        switch(choice){
            case 1:
                attackUpdateStats(attacker, defender, attacker.sk1.manaCost, ((attacker.sk1.baseDamage) + (attacker.baseDamage * attacker.sk1.addDamage)));
            break;
                
            case 2:
                attackUpdateStats(attacker, defender, attacker.sk2.manaCost, ((attacker.sk2.baseDamage) + (attacker.baseDamage * attacker.sk2.addDamage)));
            break;
                
            case 3:
                attackUpdateStats(attacker, defender, attacker.sk3.manaCost, ((attacker.sk3.baseDamage) + (attacker.baseDamage * attacker.sk3.addDamage)));
            break;
        }
        
        System.out.println();

    }
    
    public int attackSimulator() {
        double rateCalc = rd.nextInt(100) + 1;
        if (rateCalc <= 60) {
            return 1;
        } else if(rateCalc <= 90){
            return 2;
        }else{
            return 2;
        }
    }
    
    public void enemyAttack(Character attacker, Character defender){
        
        int choice = attackSimulator();
        
        System.out.println("============================================================");
        System.out.println();

        switch(choice){
            case 1:
                attackUpdateStats(attacker, defender, attacker.sk1.manaCost, ((attacker.sk1.baseDamage) + (attacker.baseDamage * attacker.sk1.addDamage)));
            break;
                
            case 2:
                attackUpdateStats(attacker, defender, attacker.sk2.manaCost, ((attacker.sk2.baseDamage) + (attacker.baseDamage * attacker.sk2.addDamage)));
            break;
                
            case 3:
                attackUpdateStats(attacker, defender, attacker.sk3.manaCost, ((attacker.sk3.baseDamage) + (attacker.baseDamage * attacker.sk3.addDamage)));
            break;
        }
        
        System.out.println();
        System.out.println("============================================================");
        System.out.println();
        
    }
    
}

class inGameOptions{
    DecimalFormat df = new DecimalFormat("0");
    DecimalFormat dfFull = new DecimalFormat("0.00");
    
    public void displayStats(Character hero){
        if(hero.hp <= 0) hero.hp = 0;
        System.out.println("==============================");
        System.out.println();
        System.out.println("          " + hero.name);
        System.out.println();
        System.out.println("   Role     : " + hero.role);
        System.out.println("   HP       : " + dfFull.format(hero.hp));
        System.out.println("   Mana     : " + dfFull.format(hero.mana));
        System.out.println("   Damage   : " + dfFull.format(hero.baseDamage));
        System.out.println("   Skill 1  : " + hero.sk1.skillName);
        System.out.println("   Skill 2  : " + hero.sk2.skillName);
        System.out.println("   Skill 3  : " + hero.sk3.skillName);
        System.out.println();
        
    }
}

public class Main{
        static Scanner sc = new Scanner(System.in);
        static Random rd = new Random();
        static DecimalFormat df = new DecimalFormat("0");
        
        public static Character warrior;
        public static Character mage;
        public static Character archer;
        public static Character tank;
        public static Character dummy;
        
        static {
                warrior = new Character(    
                "Warrior", "Frontline", 720, 100, 160,
                    new Ability("Slash", 100, 10, 0.60),
                    new Ability("Charge", 150, 15, 0.45),
                    new Ability("Whirlwind", 200, 25, 0.50)
                );
        
                mage = new Character(
                    "Mage", "Backline", 480, 350, 90,
                    new Ability("Fireball", 150, 30, 0.75),
                    new Ability("Ice Spike", 200, 60, 0.60),
                    new Ability("Arcane Blast", 350, 150, 0.50)
                );
                
                archer = new Character(
                    "Archer", "Backline", 560, 200, 120,
                    new Ability("Pierce", 80, 20, 0.50),
                    new Ability("Scatter Shot", 100, 75, 0.90),
                    new Ability("Burst Snipe", 240, 150, 0.75)
                );
                
                tank = new Character(
                    "Tank", "Frontline", 1250, 150, 75,
                    new Ability("Hammer Strike", 50, 10, 0.50),
                    new Ability("Shield Bash", 75, 25, 0.70),
                    new Ability("Imperial Smash", 120, 45, 0.90)
                );
                
                dummy = new Character(
                "Dummy", "Bot", 999999, 999999, 999999,
                    new Ability("Nod", 0, 0, 0),
                    new Ability("Clap", 0, 0, 0),
                    new Ability("Smile", 0, 0, 0)
                );
            }
            
    public static Boolean roundCheck(Character player, Character enemy){
        if(enemy.hp <= 0){
                System.out.println("============================================================");
                System.out.println();
                System.out.println("                      Y O U    W I N !   ");
                System.out.println();
                System.out.println("============================================================");
                return true;
            }
            
            if(player.hp <= 0){
                System.out.println("============================================================");
                System.out.println();
                System.out.println("                     Y O U    L O S E !   ");
                System.out.println();
                System.out.println("============================================================");
                return true;
            }
        return false;
    }
    
    public static void main(String []args){
        System.out.print("Enter maximum number: ");
        int maxNum = sc.nextInt();
        System.out.print("Enter base damage: ");
        double baseDamage = sc.nextDouble();
        System.out.print("Enter crit rate (in percent): ");
        double critRate = sc.nextDouble()/100;
        System.out.print("Enter crit damage (in percent): ");
        double critDamage = ((sc.nextDouble() /100) * baseDamage) + baseDamage;
        
        for(int i = 0; i < 20; i++){
            Draft.attackSimulator(baseDamage, critRate, critDamage);
        }
        
        int heroSelect;
        int action;
        Boolean choice;
        Character player = null;
        Character enemy = null;
        BattleUtils btu = new BattleUtils();
        inGameOptions op = new inGameOptions();
        
        System.out.println("==============================");
        System.out.println();
        System.out.println("     Choose a Hero: ");
        System.out.println();
        System.out.println("     Heroes: ");
        System.out.println("       [ 1 ]  ---> Warrior: Damage-Dealer, Frontline");
        System.out.println("       [ 2 ]  ---> Mage: Damage-Dealer, Backline");
        System.out.println("       [ 3 ]  ---> Archer: Damage-Dealer, Backline");
        System.out.println("       [ 4 ]  ---> Tank: Defence Guardian, Frontline");
        System.out.println();
        
        System.out.print("Select: "); heroSelect = sc.nextInt();
        System.out.println();
        
        
        switch(heroSelect){
            case 1:
                player = new Character(warrior);
                player.name = warrior.name + "   (Player)";
            break;
            case 2:
                player = new Character(mage);
                player.name = mage.name + "   (Player)";
            break;
            case 3:
                player = new Character(archer);
                player.name = archer.name + "   (Player)";
            break;
            case 4:
                player = new Character(tank);
                player.name = tank.name + "   (Player)";
            break;
        }
        
        op.displayStats(player);
        
        System.out.println("==============================");
        
        System.out.println("==============================");
        System.out.println();
        System.out.println("     Choose an Enemy: ");
        System.out.println();
        System.out.println("     Heroes: ");
        System.out.println("       [ 0 ]  ---> Dummy: Training Partner");
        System.out.println("       [ 1 ]  ---> Warrior: Damage-Dealer, Frontline");
        System.out.println("       [ 2 ]  ---> Mage: Damage-Dealer, Backline");
        System.out.println("       [ 3 ]  ---> Archer: Damage-Dealer, Backline");
        System.out.println("       [ 4 ]  ---> Tank: Defence Guardian, Frontline");
        System.out.println();
        
        System.out.print("Select: "); heroSelect = sc.nextInt();
        System.out.println();
        
        
        switch(heroSelect){
            case 0:
                enemy = new Character(dummy);
                enemy.name = dummy.name + "   (Enemy)";
            break;
            case 1:
                enemy = new Character(warrior);
                enemy.name = warrior.name + "   (Enemy)";
            break;
            case 2:
                enemy = new Character(mage);
                enemy.name = mage.name + "   (Enemy)";
            break;
            case 3:
                enemy = new Character(archer);
                enemy.name = archer.name + "   (Enemy)";
            break;
            case 4:
                enemy = new Character(tank);
                enemy.name = tank.name + "   (Enemy)";
            break;
        }
        
        op.displayStats(enemy);
        
        System.out.println("==============================");
        System.out.println();
        System.out.println("     Prepare to Battle!");
        System.out.println();
        
        do{
            
            System.out.println("==============================");
            System.out.println();
            System.out.println("     Choose an Move: ");
            System.out.println();
            System.out.println("     Heroes: ");
            System.out.println("       [ 0 ]  ---> Leave Battle");
            System.out.println("       [ 1 ]  ---> Check Stats");
            System.out.println("       [ 2 ]  ---> Attack");
            System.out.println();
            
            System.out.print("Select: "); action = sc.nextInt();
            System.out.println();
        
        
            switch(action){
                case 0:
                    System.out.println("==============================");
                    System.out.println();
                    System.out.print("    THANK YOU FOR PLAYING!");
                break;
                
                case 1:
                    System.out.println("==============================");
                    System.out.println();
                    System.out.println("     Choose which Stats to Check: ");
                    System.out.println();
                    System.out.println("     Heroes: ");
                    System.out.println("       [ 0 ]  ---> Cancel");
                    System.out.println("       [ 1 ]  ---> Player Stats");
                    System.out.println("       [ 2 ]  ---> Enemy Stats");
                    System.out.println();
                    
                    System.out.print("Select: "); action = sc.nextInt();
                    System.out.println();
                    
                    switch(action){
                        case 0:
                        break;
                        case 1:
                            btu.displayStats(player);
                        break;
                        case 2:
                            btu.displayStats(enemy);
                        break;
                    }
                break;
                
                case 2:
                    btu.attack(player, enemy);
                    if(roundCheck(player, enemy))return;
                    btu.enemyAttack(enemy, player);
                    if(roundCheck(player, enemy))return;
                    System.out.println();
                break;
            }
        }while(action != 0);
        
        
        
    }
}

*/
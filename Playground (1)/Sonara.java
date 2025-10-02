import java.util.Random;

public class Sonara extends Character{
    
    public Sonara(){
        setHp(250);
    }
    
    public void printStats(){
        System.out.println("My name is Sonara!");
        System.out.println("=========================");
        System.out.println("HP: " + getHp());
        System.out.println();
        
    }
    
    
    /*
    @Override
    public void displayName(){
        System.out.println("LAYLA");
        System.out.println("-------------------------");
    }
    
    @Override
    public int skill1(){
        Random rnd = new Random();
        int damageSkill1 = rnd.nextInt(11);
        System.out.println("Layla used skill 1 (Tung tung tung tung tung tung tung sahur!) dealt " + damageSkill1 + " damage.");
        return damageSkill1;
    }
    
    @Override
    public int skill2(){
        Random rnd = new Random();
        int min = 30;
        int max = 50;
        int damageSkill2 = rnd.nextInt(max - min) + min;
        System.out.println("Layla used skill 2 (BRRR BRRR PATAPIM!) dealt " + damageSkill2 + " damage.");
        return damageSkill2;
    }
    */
    
}

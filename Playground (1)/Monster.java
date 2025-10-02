public class Monster extends Character{
    public Monster(){
        setHp(200);
    }
    
    public void printStats(){
        System.out.println("Enemy");
        System.out.println("=========================");
        System.out.println("HP: " + getHp());
        System.out.println();
        
    }
}
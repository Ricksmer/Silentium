import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Sonara sonara = new Sonara();
        Metronome met = new Metronome();
        Monster mons = new Monster();
        Note nt = new Note();
        
        int i, beat = met.beatRoll();
        char note1 ='X', note2 = 'X', note3 ='X';
        boolean isA = false;
        boolean isB = false;
        boolean isC = false;
        boolean isD = false;
        boolean isE = false;
        boolean isF = false;
        boolean isG = false;
        boolean isGameOver = false;
        
        do{
           
            sonara.printStats();
            mons.printStats();
            
            System.out.println("Metronome Beat: " + beat);
            nt.damagePerNote();
            System.out.println();
            
            System.out.print("Enter Notes: ");
                note1 = sc.next().charAt(0);
                note2 = sc.next().charAt(0);
                note3 = sc.next().charAt(0);
            
            int damage = 0;
            damage += nt.noteDamage(note1);
            damage += nt.noteDamage(note2);
            damage += nt.noteDamage(note3);
            
            
            
            System.out.println("Initial Damage: " + damage);
            
            if(damage % beat == 0)
                damage *= beat;    
            
            System.out.println("Metronome Beat: " + beat);
            System.out.println("Damage Dealt: " + damage);
            mons.setHp(mons.getHp() - damage);
            System.out.println();
            
            if(sonara.getHp() <= 0){
                sonara.setHp(0);
                isGameOver = true;
                mons.printStats(); 
                System.out.println("==================================================");
                System.out.println("                Y O U     L O S E !               ");
                System.out.println("==================================================");
                System.out.println();
            } else if(mons.getHp() <= 0){
                sonara.setHp(0);
                isGameOver = true;
                sonara.printStats(); 
                System.out.println("==================================================");
                System.out.println("                 Y O U     W I N !                ");
                System.out.println("==================================================");
                System.out.println();
            } else {
                mons.printStats(); 
            }
            
        }while(!isGameOver);
        
        
    }
}



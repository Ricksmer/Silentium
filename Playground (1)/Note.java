import java.util.Random;

public class Note{
    Random rd = new Random();
    /*
    A : ( 1 - 10 );
    B : ( 5 - 13 );
    C : ( 9 - 16 );
    D : ( 12 - 18 );
    E : ( 16 - 21 );
    F : ( 19 - 23 );
    G : ( 21 - 24 );
    */
    
    int A;
    int B;
    int C;
    int D;
    int E;
    int F;
    int G;
    
    public int A(){
        A = rd.nextInt(10) + 1;
        return A;
    }
    
    public int B(){
        B = rd.nextInt(9) + 5;
        return B;
    }
    
    public int C(){
        C = rd.nextInt(8) + 9;
        return C;
    }
    
    public int D(){
        D = rd.nextInt(7) + 12;
        return D;
    }
    
    public int E(){
        E = rd.nextInt(6) + 16;
        return E;
    }
    
    public int F(){
        F = rd.nextInt(5) + 19;
        return F;
    }
    
    public int G(){
        G = rd.nextInt(4) + 21;
        return G;
    }

    public void displayDamage(){
        System.out.println("");
    }
    
    public void damagePerNote(){
        System.out.println("A --> " + A());
        System.out.println("B --> " + B());
        System.out.println("C --> " + C());
        System.out.println("D --> " + D());
        System.out.println("E --> " + E());
        System.out.println("F --> " + F());
        System.out.println("G --> " + G());
    }
    
    public int noteDamage(char note){
        switch(note){
            case 'A':
                return A;
            
            case 'B':
                return B;
            
            case 'C':
                return C;
            
            case 'D':
                return D;
            
            case 'E':
                return E;
            
            case 'F':
                return F;
            
            case 'G':
                return G;
            
            default:
                System.out.println("Invalid note.");
        }
        
        return 0;
    }
}
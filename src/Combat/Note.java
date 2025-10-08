package Combat;

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

    int minA = 1;
    int maxA = 10;
    int minB = 5;
    int maxB = 13;
    int minC = 9;
    int maxC = 16;
    int minD = 12;
    int maxD = 18;
    int minE = 16;
    int maxE = 21;
    int minF = 19;
    int maxF = 23;
    int minG = 21;
    int maxG = 24;

    int A;
    int B;
    int C;
    int D;
    int E;
    int F;
    int G;

    int rangeA = maxA- minA + 1;
    int rangeB = maxB- minB + 1;
    int rangeC = maxC- minC + 1;
    int rangeD = maxD- minD + 1;
    int rangeE = maxE- minE + 1;
    int rangeF = maxF- minF + 1;
    int rangeG = maxG- minG + 1;

    public void generateNotes(){
        A = rd.nextInt(rangeA) + minA;
        B = rd.nextInt(rangeB) + minB;
        C = rd.nextInt(rangeC) + minC;
        D = rd.nextInt(rangeD) + minD;
        E = rd.nextInt(rangeE) + minE;
        F = rd.nextInt(rangeF) + minF;
        G = rd.nextInt(rangeG) + minG;
    }

    public void damagePerNote(){
        generateNotes();
        System.out.println("A --> " + A);
        System.out.println("B --> " + B);
        System.out.println("C --> " + C);
        System.out.println("D --> " + D);
        System.out.println("E --> " + E);
        System.out.println("F --> " + F);
        System.out.println("G --> " + G);
    }

    public int noteDamage(char note){
        switch(note){
            case 'A': return A;
            case 'B': return B;
            case 'C': return C;
            case 'D': return D;
            case 'E': return E;
            case 'F': return F;
            case 'G': return G;
            default:
                System.out.println("Invalid note.");
                return 0;
        }
    }
}
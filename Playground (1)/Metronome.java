import java.util.Random;

public class Metronome{
    Random rd = new Random();
    public int beat;
    
    public int beatRoll(){
        return rd.nextInt(4) + 1;
    }
}
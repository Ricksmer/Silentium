package Combat;

public class Task {
    public void wait(int seconds){
        int milliseconds = seconds * 1000;

        try{
            Thread.sleep(milliseconds);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}


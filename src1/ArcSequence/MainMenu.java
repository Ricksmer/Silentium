package ArcSequence;
import Display.MainMenuFunctionalities;

public class MainMenu {
    public void start(){
        MainMenuFunctionalities mainFunct = new MainMenuFunctionalities();
        boolean isRunning = true;
        mainFunct.displayMenu();

        while(isRunning) {
            switch (mainFunct.selectOption()) {
                case 1:
                    isRunning = false;
                    break;
                case 2: System.out.println("Require: Storyline... Please implement\n-Sangasina"); break;
                case 3:
                    System.out.println(mainFunct.credits());
                    break;
                case 4: System.out.println("Require: Tutorial... Please implement\n-Sangasina"); break;
                case 5:
                    System.out.println("Require: Exit Function... Please implement\n-Sangasina");break;
                default:
                    System.out.println("Test Phase...");
                    break;
            }
        }
    }
}

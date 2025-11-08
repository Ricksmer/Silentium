package Main;

import Display.*;
import Map.*;

public class Main {
    static GameMenu game = new GameMenu();
    static AsciiArt art = new AsciiArt();
    static void main() {

        art.displayTitle();
        game.start(); //Main menu - Sangasina
    }
}

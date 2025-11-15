package Main;

import Display.*;

public class Main {

    static GameMenu game = new GameMenu();
    static AsciiArt art = new AsciiArt();
    public static void main(String[] args) {
        art.displayTitle();
        //art.sonaraAscii();
        //art.lyronAscii();
        //art.aureliusAscii();

        game.start(); //Main menu - Sangasina

    }
}

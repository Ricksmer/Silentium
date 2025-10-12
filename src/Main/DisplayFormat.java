package Main;
import Enemy.*;
import Player.Aurelius;
import Player.Character;
import Player.Lyron;
import Player.Sonara;

import java.util.Random;
import java.util.Scanner;

public interface DisplayFormat {
    public void battleStart();
    public void battleEnd(Boolean isWin);


    public void CharacterSelect();
    public Monster MonsterSpawn(int map);

    public void characterDisplay(Character player);
    public void playerStatsSummary(Character player);
    public void enemyStatsSummary(Monster enemy);


    public void displayValidNotes();
    public void turnAction();
    public void noteInput();

}

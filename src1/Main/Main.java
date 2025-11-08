package Main;

import Map.Arc;
import Combat.Combat;
import Display.*;
import Player.Character;
import Enemy.Monster;
import Map.*;

public class Main {
    static Character player;
    static Monster enemy;
    static CombatDisplay combDisplay = new CombatDisplay();
    static GameMenu game = new GameMenu();
    static Combat combat = new Combat();
    static Map map;
    static MapCharacter mapChar = new MapCharacter();
    static AsciiArt art = new AsciiArt();
    static Arc arcManager = null;
    static TextDisplay text = new TextDisplay();
    public static void main(String[] args) {

        art.displayTitle();
        game.start(); //Main menu - Sangasina
        /*
        map = new TownOfEchoes();
        map.setMap();
        mapChar.explore(map,player);

        map = new SilentCaverns();
        map.setMap();
        mapChar.explore(map,player);

        map = new AbyssOfDissonance();
        map.setMap();
        mapChar.explore(map,player);


        enemy = map.MonsterSpawn(1);
        combDisplay.enemyStatsSummary(enemy);

        combat.battle(player, enemy);
        */
    }
}

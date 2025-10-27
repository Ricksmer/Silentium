package Main;

import Combat.Combat;
import Display.*;
import Player.Character;
import Enemy.Monster;
import Map.*;

import java.util.Scanner;

public class Main {
    static Character player;
    static Monster enemy;
    static CombatDisplay combDisplay = new CombatDisplay();
    static GameMenu game = new GameMenu();
    static Combat combat = new Combat();
    static Map map;
    static MapCharacter mapChar = new MapCharacter();
    static AsciiArt art = new AsciiArt();
    public static void main(String[] args) {

//        art.displayTitle();
        player = game.CharacterSelect();
        combDisplay.characterDisplay(player);


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

    }
}

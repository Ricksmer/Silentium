package Main;

import Combat.Combat;
import Display.GameMenu;
import Display.CombatDisplay;
import Player.Character;
import Enemy.Monster;
import Map.Map;
import Map.TownOfEchoes;

public class Main {
    static Character player;
    static Monster enemy;
    static CombatDisplay combDisplay = new CombatDisplay();
    static GameMenu game = new GameMenu();
    static Combat combat = new Combat();
    static Map map = new TownOfEchoes();

    public static void main(String[] args) {
        int p = 1;

        player = game.CharacterSelect();
        combDisplay.characterDisplay(player);

        enemy = map.MonsterSpawn(p);
        combDisplay.enemyStatsSummary(enemy);

        combat.battle(player, enemy);

    }
}

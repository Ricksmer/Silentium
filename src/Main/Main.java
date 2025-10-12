package Main;

import Combat.Combat;
import Player.Character;
import Enemy.Monster;

public class Main {
    static Character player;
    static Monster enemy;
    static InterfaceFormats inf = new InterfaceFormats();
    static GameMenu game = new GameMenu();
    static Combat combat = new Combat();

    public static void main(String[] args) {
        int map = 1;

        player = game.CharacterSelect();
        inf.characterDisplay(player);

        enemy = inf.MonsterSpawn(map);
        inf.enemyStatsSummary(enemy);

        combat.battle(player, enemy);
        //All hail
    }
}

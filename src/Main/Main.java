package Main;

import Combat.Combat;
import Player.Character;
import Enemy.Monster;

public class Main {
    static Character player = null;
    static Monster enemy = null;
    static InterfaceFormats inf = new InterfaceFormats();
    static Combat combat = new Combat();

    public static void main(String[] args) {
        int map = 1;

        player = inf.CharacterSelect();
        inf.characterDisplay(player);

        enemy = inf.MonsterSpawn(map);
        inf.enemyStatsSummary(enemy);

        combat.battle(player, enemy);

    }
}

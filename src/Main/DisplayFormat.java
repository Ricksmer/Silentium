package Main;
import Player.Character;
import Enemy.Monster;

public interface DisplayFormat {

    public void battleStart();
    public void battleEnd(Boolean isWin);

    public void noteInput();

    public Character CharacterSelect();
    public Monster MonsterSpawn(int map);

    public void characterDisplay(Character player);

    public void playerStatsSummary(Character player);
    public void enemyStatsSummary(Monster enemy);

}

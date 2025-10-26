package Map;

import Combat.Combat;
import Display.*;
import Enemy.Monster;
import Player.Character;

import java.util.Scanner;

public class MapCharacter {
    MapDisplay mapNar =  new MapDisplay();
    Combat combat = new Combat();
    CombatDisplay combDisplay = new CombatDisplay();
    TextDisplay text = new TextDisplay();

    private int row;
    private int col;

    //Setters and Getters
    public void setRow(int row){
        this.row = row;
    }
    public int getRow(){
        return row;
    }

    public void setCol(int col){
        this.col = col;
    }
    public int getCol(){
        return col;
    }

    //Character Movements
    public void up(){
        row -= 1;
    }
    public void down(){
        row += 1;
    }
    public void left(){
        col -= 1;
    }
    public void right(){
        col += 1;
    }

    public void showPosition(){
        System.out.println("Character is at index [" + row + "] [" + col + "]");
    }

    public void displayDirections(){
        text.printSystemMessage("Which way are you moving?");
        text.printSystemMessage("1: North");
        text.printSystemMessage("2: South");
        text.printSystemMessage("3: West");
        text.printSystemMessage("4: East");
        text.lineBreak();
        System.out.println();
    }
    public void explore(Map map, Character player){

        Monster enemy;
        Scanner scanner = new Scanner(System.in);
        int movement = 0;
        boolean isExploring = true;
        boolean isEnabled;

        //Disposeable
        text.printSystemMessage("Test Map:");
        map.viewMap();
        System.out.println();
        System.out.println();
        //END

        text.printSystemMessage("Exploring: " + player.name);

        setRow(map.getStartingRow());
        setCol(map.getStartingCol());
        while(isExploring){
            isEnabled = true;
            while(isEnabled){
                try{
                    displayDirections();
                    System.out.print("\t Select: ");
                    movement = scanner.nextInt();
                    if(movement <= 0 || movement > 4){
                        mapNar.displayMapConfused(player);
                    }
                    else{
                        isEnabled = false;
                    }
                }catch(Exception e){
                    mapNar.displayMapConfused(player);
                    scanner.next();
                }
            }

            System.out.println();
            System.out.println("========================");
            System.out.println(player.name + ":");

            switch(movement){
                case 1:
                    if(getRow() == 0){
                        mapNar.displayMapBlocked(player);
                    }
                    else{
                        up();
                    }
                    break;
                case 2:
                    if(getRow() >= map.getMapRow() - 1){
                        mapNar.displayMapBlocked(player);
                    }
                    else{
                        down();
                    }
                    break;
                case 3:
                    if(getCol() == 0){
                        mapNar.displayMapBlocked(player);
                    }
                    else{
                        left();
                    }
                    break;
                case 4:
                    if(getCol() >= map.getMapCol() - 1){
                        mapNar.displayMapBlocked(player);
                    }
                    else{
                        right();
                    }
                    break;
                default:
                    break;
            }


            switch(map.getIndex(getRow(),getCol())){
                case 0:
                    mapNar.displayEmptySpot(player);
                    break;
                case 1:
                    mapNar.displayEnemyEncounter(player);
                    enemy = map.MonsterSpawn(player.getMap());
                    combDisplay.enemyStatsSummary(enemy);

                    combat.battle(player, enemy);
                    break;
                case 2:
                    mapNar.displayEntrance(player);
                    text.printDialogue(player, "This is where I started");
                    break;
                case 3:
                    mapNar.displayExit(player);
                    text.printSystemMessage("--Assuming they met the conditions--");
                    isExploring = false;
                    player.setMap(player.getMap() + 1);
                    break;
                default: break;
            }

            System.out.println("========================");
            System.out.println();
        }
    }
}

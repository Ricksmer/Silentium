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
        Map mapDisp = null;
        if(player.getMap() == 1){ mapDisp = new TownOfEchoes(); }
        else if(player.getMap() == 2){ mapDisp = new SilentCaverns(); }
        else{ mapDisp = new AbyssOfDissonance(); };

        mapDisp.initDisplayMap(map);


        Monster enemy;
        Scanner sc = new Scanner(System.in);
        int movement = 0;
        boolean isExploring = true;
        boolean isEnabled;

        //Disposeable
        text.printSystemMessage("Test Map:");

        //END

        text.printSystemMessage("Exploring: " + player.name);

        setRow(map.getStartingRow());
        setCol(map.getStartingCol());
        while(isExploring){
            isEnabled = true;
            map.viewMap();
            System.out.println();
            System.out.println();
            mapDisp.setMapPos(row, col, 2);
            mapDisp.viewDisplayMap();
            System.out.println();
            System.out.println();
            while(isEnabled){
                try{
                    displayDirections();
                    System.out.print("\t Select: ");
                    movement = sc.nextInt();
                    if(movement <= 0 || movement > 4){
                        mapNar.displayMapConfused(player);
                    }
                    else{
                        isEnabled = false;
                    }
                }catch(Exception e){
                    mapNar.displayMapConfused(player);
                    sc.next();
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
                        mapDisp.setTravelled(map, row,col);
                        up();
                        mapDisp.updateMapTravel(map, row,col);
                    }
                    break;
                case 2:
                    if(getRow() >= map.getMapRow() - 1){
                        mapNar.displayMapBlocked(player);
                    }
                    else{
                        mapDisp.setTravelled(map, row,col);
                        down();
                        mapDisp.updateMapTravel(map, row,col);
                    }
                    break;
                case 3:
                    if(getCol() == 0){
                        mapNar.displayMapBlocked(player);
                    }
                    else{
                        mapDisp.setTravelled(map, row,col);
                        left();
                        mapDisp.updateMapTravel(map, row,col);
                    }
                    break;
                case 4:
                    if(getCol() >= map.getMapCol() - 1){
                        mapNar.displayMapBlocked(player);
                    }
                    else{
                        mapDisp.setTravelled(map, row,col);
                        right();
                        mapDisp.updateMapTravel(map, row,col);
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
                    map.setMapPos(row,col, 4);
                    break;
                case 2:
                    mapNar.displayEntrance(player);
                    text.printDialogue(player, "This is where I started");
                    break;
                case 3:
                    mapNar.displayExit(player);
                    text.printSystemInput("Enter? [ Y / N ]: ");
                    char tempOp = sc.next().charAt(0);
                    java.lang.Character.toUpperCase(tempOp);
                    if(tempOp == 'Y'){
                        if(player.getMap() == 1){
                            text.printSystemMessage("Player level: " + player.getLevel());

                            if(player.getLevel() < 3){
                                text.printSystemMessage("You are not strong enough! You need to level up!");
                            }
                            else{
                                text.printSystemMessage("Travelling towards the next map!");
                                player.setMap(player.getMap() + 1);
                                return;
                            }
                        }
                        else if (player.getMap() == 2){
                            if(player.getLevel() < 5){
                                text.printSystemMessage("You are not strong enough! You need to level up!");
                            }
                            else {
                                text.printSystemMessage("Travelling towards the next map!");
                                player.setMap(player.getMap() + 1);
                                return;
                            }
                        }
                        else{
                            text.printSystemMessage("Travelling towards the next map!");
                            isExploring = false;
                            player.setMap(player.getMap() + 1);
                            return;
                        }
                    }else if(tempOp == 'N'){
                        text.printSystemMessage("Travelling continues...");
                    }
                    break;
                default: break;
            }

            System.out.println("========================");
            System.out.println();
        }
    }
}

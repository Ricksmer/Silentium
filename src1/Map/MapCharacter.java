package Map;

import Combat.Combat;
import Display.*;
import Enemy.Monster;
import Enemy.Syozan;
import Player.Character;

import java.util.Scanner;

public class MapCharacter {
    MapDisplay mapNar =  new MapDisplay();
    Combat combat = new Combat();
    CombatDisplay combDisplay = new CombatDisplay();
    TextDisplay text = new TextDisplay();
    Syozan syozan = new Syozan();
    private int mapIdNum;
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
        System.out.println();
        text.printSystemMessage("[ 1 ] \t---> \tNorth");
        text.printSystemMessage("[ 2 ] \t---> \tSouth");
        text.printSystemMessage("[ 3 ] \t---> \tWest");
        text.printSystemMessage("[ 4 ] \t---> \tEast");
        System.out.println();
    }

    public void explore(Map map, Character player){
        Map mapDisp = null;
        if(player.getMap() == 1){
            mapDisp = new TownOfEchoes();
            mapNar.mapIntroduction(1);
        }
        else if(player.getMap() == 2){
            mapDisp = new SilentCaverns();
            mapNar.mapIntroduction(2);
        }
        else{
            mapDisp = new AbyssOfDissonance();
            mapNar.mapIntroduction(3);
        };

        mapDisp.initDisplayMap(map);


        Monster enemy;
        Scanner sc = new Scanner(System.in);
        int movement = 0;
        boolean isExploring = true;
        boolean isEnabled;

        setRow(map.getStartingRow());
        setCol(map.getStartingCol());
        while(isExploring){
            isEnabled = true;
            mapDisp.setMapPos(row, col, 2);
            mapDisp.viewDisplayMap(map.name);
            System.out.println();
            System.out.println();
            while(isEnabled){
                try{
                    displayDirections();
                    text.printSystemInput("Select: ");
                    movement = sc.nextInt();
                    text.shortbreak();;
                    if(movement <= 0 || movement > 4){
                        mapNar.displayMapConfused(player);
                        text.shortbreak();
                    }
                    else{
                        isEnabled = false;
                    }
                }catch(Exception e){
                    text.shortbreak();
                    mapNar.displayMapConfused(player);
                    text.shortbreak();
                    sc.next();
                }
            }


            switch(movement){
                case 1:
                    if(getRow() == 0){
                        mapNar.displayMapBlocked(player);
                        System.out.println();
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
                    text.shortbreak();
                    break;
                case 1:
                    mapNar.displayEnemyEncounter(player);
                    text.shortbreak();
                    enemy = map.MonsterSpawn(player.getMap());
                    combDisplay.enemyStatsSummary(enemy);

                    combat.battle(player, enemy);
                    map.setMapPos(row,col, 4);
                    break;
                case 2:
                    mapNar.displayEntrance(player);
                    text.shortbreak();
                    break;
                case 3:
                    mapNar.displayExit(player);
                    System.out.println();

                    char tempOp = 'N';
                    boolean valid = false;

                    while (true) {
                        text.printSystemInput("Explore? [ Y / N ] :   ");
                        String input = sc.next().trim().toUpperCase();
                        tempOp = input.charAt(0);

                        if (tempOp == 'Y') {
                            if (player.getMap() == 1) {
                                text.printSystemMessage("Player level: " + player.getLevel());
                                if (player.getLevel() < 3) {
                                    text.printSystemMessage("You are not strong enough! You need to level up!");
                                    break;
                                }
                                else {
                                    text.printGameAnnouncement("\tTravelling towards the next map!");
                                    player.setMap(player.getMap() + 1);
                                    isExploring = false;
                                    return;
                                }
                            } else if (player.getMap() == 2) {
                                if (player.getLevel() < 5) {
                                    text.printSystemMessage("You are not strong enough! You need to level up!");
                                    break;
                                }
                                else {
                                    text.printGameAnnouncement("\tTravelling towards the next map!");
                                    player.setMap(player.getMap() + 1);
                                    isExploring = false;
                                    return;
                                }
                            } else if(player.getMap() == 3){
                                text.printDialogue(syozan,"Hello");
                                combat.battle(player,syozan);
                                //eNDINGS ETC..
                            }
                        } else if (tempOp == 'N') {
                            text.printSystemMessage("Travelling continues...");
                            break;
                        } else {
                            System.out.println();
                            text.printSystemError("--- Invalid Input --- ");
                            System.out.println();
                        }
                    }

                    /*
                    while (!valid) {
                        text.printSystemInput("Enter? [ Y / N ]: ");
                        String input = sc.nextLine().trim();

                        if (input.isEmpty() || input.length() != 1 || !java.lang.Character.isLetter(input.charAt(0))) {
                            text.printSystemMessage("Invalid input! Please enter Y or N only.");
                            System.out.println();
                            continue;
                        }

                        tempOp = java.lang.Character.toUpperCase(input.charAt(0));

                        if (tempOp != 'Y' && tempOp != 'N') {
                            text.printSystemMessage("Invalid input! Please enter Y or N only.");
                            System.out.println();
                            continue;
                        }

                        valid = true;
                    }*/



                    text.shortbreak();
                    break;
            }
        }
    }
}

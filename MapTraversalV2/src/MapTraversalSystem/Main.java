package MapTraversalSystem;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean exploring;

        //Object Instantiate
        TownOfEchoes townOfEchoes = new TownOfEchoes();
        SilentCaverns silentCaverns = new SilentCaverns();
        AbyssOfDissonance abyssOfDissonance = new AbyssOfDissonance();
        MapCharacter mapCharacter = new MapCharacter();

        //Setting The Maps
        townOfEchoes.setMap();
        silentCaverns.setMap();
        abyssOfDissonance.setMap();

        System.out.println("Town of Echoes");
        townOfEchoes.viewMap();
        mapCharacter.setRow(townOfEchoes.getStartingRow());
        mapCharacter.setCol(townOfEchoes.getStartingCol());
        System.out.println();
        exploring = true;
        while(exploring){
            System.out.println("Which way are you moving?");
            System.out.println("1: North");
            System.out.println("2: South");
            System.out.println("3: West");
            System.out.println("4: East");
            System.out.println("--------------------------");
            System.out.print("Enter: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    if(mapCharacter.getRow() == 0){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.up();
                        mapCharacter.showPosition();
                    }
                    break;
                case 2:
                    if(mapCharacter.getRow() == townOfEchoes.getMapCol() - 1){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.down();
                        mapCharacter.showPosition();
                    }
                    break;
                case 3:
                    if(mapCharacter.getCol() == 0){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.left();
                        mapCharacter.showPosition();
                    }
                    break;
                case 4:
                    if(mapCharacter.getCol() == townOfEchoes.getMapRow() - 1){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.right();
                        mapCharacter.showPosition();
                    }
                    break;
                default:
                    System.out.println("You remain still....");
                    mapCharacter.showPosition();
            }

            switch(townOfEchoes.getIndex(mapCharacter.getRow(), mapCharacter.getCol())){
                case 0:
                    System.out.println("There are no enemies here");
                    break;
                case 1:
                    System.out.println("Enemy encounter");
                    break;
                case 2:
                    System.out.println("This is where I started");
                    break;
                case 3:
                    System.out.println("This is the exit...");
                    System.out.println("--check condition--");
                    System.out.println("Assuming the character met condition");
                    System.out.println("Traversing to the caverns");
                    exploring = false;
                    break;
                default: break;
            }
        }


        System.out.println("Silent Caverns");
        silentCaverns.viewMap();
        mapCharacter.setRow(silentCaverns.getStartingRow());
        mapCharacter.setCol(silentCaverns.getStartingCol());
        mapCharacter.showPosition();
        System.out.println();
        exploring = true;
        while(exploring){
            System.out.println("Which way are you moving?");
            System.out.println("1: North");
            System.out.println("2: South");
            System.out.println("3: West");
            System.out.println("4: East");
            System.out.println("--------------------------");
            System.out.print("Enter: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    if(mapCharacter.getRow() == 0){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.up();
                        mapCharacter.showPosition();
                    }
                    break;
                case 2:
                    if(mapCharacter.getRow() == silentCaverns.getMapCol() - 1){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.down();
                        mapCharacter.showPosition();
                    }
                    break;
                case 3:
                    if(mapCharacter.getCol() == 0){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.left();
                        mapCharacter.showPosition();
                    }
                    break;
                case 4:
                    if(mapCharacter.getCol() == silentCaverns.getMapRow() - 1){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.right();
                        mapCharacter.showPosition();
                    }
                    break;
                default:
                    System.out.println("You remain still....");
                    mapCharacter.showPosition();
            }

            switch(silentCaverns.getIndex(mapCharacter.getRow(), mapCharacter.getCol())){
                case 0:
                    System.out.println("There are no enemies here");
                    break;
                case 1:
                    System.out.println("Enemy encounter");
                    break;
                case 2:
                    System.out.println("This is where I started");
                    break;
                case 3:
                    System.out.println("This is the exit...");
                    System.out.println("--check condition--");
                    System.out.println("Assuming the character met condition");
                    System.out.println("Entering the abyss");
                    exploring = false;
                    break;
                default: break;
            }
        }

        System.out.println("Abyss of Dissonance");
        abyssOfDissonance.viewMap();
        mapCharacter.setRow(abyssOfDissonance.getStartingRow());
        mapCharacter.setCol(abyssOfDissonance.getStartingCol());
        mapCharacter.showPosition();
        System.out.println();
        exploring = true;
        while(exploring){
            System.out.println("Which way are you moving?");
            System.out.println("1: North");
            System.out.println("2: South");
            System.out.println("3: West");
            System.out.println("4: East");
            System.out.println("--------------------------");
            System.out.print("Enter: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    if(mapCharacter.getRow() == 0){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.up();
                        mapCharacter.showPosition();
                    }
                    break;
                case 2:
                    if(mapCharacter.getRow() == abyssOfDissonance.getMapCol() - 1){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.down();
                        mapCharacter.showPosition();
                    }
                    break;
                case 3:
                    if(mapCharacter.getCol() == 0){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.left();
                        mapCharacter.showPosition();
                    }
                    break;
                case 4:
                    if(mapCharacter.getCol() == abyssOfDissonance.getMapRow() - 1){
                        System.out.println("Something is in the way.....");
                    }
                    else{
                        mapCharacter.right();
                        mapCharacter.showPosition();
                    }
                    break;
                default:
                    System.out.println("You remain still....");
                    mapCharacter.showPosition();
            }

            switch(abyssOfDissonance.getIndex(mapCharacter.getRow(), mapCharacter.getCol())){
                case 0:
                    System.out.println("There are no enemies here");
                    break;
                case 1:
                    System.out.println("Enemy encounter");
                    break;
                case 2:
                    System.out.println("This is where I started");
                    break;
                case 3:
                    System.out.println("--Boss Encounter--");
                    System.out.println("--Assuming the character deafeats boss--");
                    System.out.println("ENDING...");
                    exploring = false;
                    break;
                default: break;
            }
        }
    }
}

package Map;


import Display.TextDisplay;
import Player.Character;

public class Arc {
    Map map = null;
    Character player = null;
    MapCharacter mapChar = null;
    boolean playerDied;
    TextDisplay text = new TextDisplay();

    public Arc(MapCharacter mapChar, Character player){
        this.player = player;
        this.mapChar = mapChar;
    }

    public boolean startArc1(){
        map = new TownOfEchoes();
        map.setMap();

        Map checkPointMap = map;
        Character checkPointPlayer = player;
        playerDied = true;
        while(player.getLives() > 0 && playerDied){
            playerDied = mapChar.explore(checkPointMap,checkPointPlayer);

            if(playerDied){
                text.printSystemError("You have died!");
                player.playerDied();
                if(player.getLives() > 0) text.printSystemAnnouncement("Resetting Last Arc...\n\t\tLives left: " + player.getLives());
                else break;
            }

        }
        return !playerDied;
    }

    public boolean startArc2(){
        map = new SilentCaverns();
        map.setMap();

        Map checkPointMap = map;
        Character checkPointPlayer = player;
        playerDied = true;
        while(player.getLives() > 0 && playerDied){
            playerDied = mapChar.explore(checkPointMap, checkPointPlayer);

            if(playerDied){
                text.printSystemError("You have died!");
                player.playerDied();
                if(player.getLives() > 0) text.printSystemAnnouncement("Resetting Second Arc...\n\t\tLives left: " + player.getLives());
                else break;
            }
        }
        return !playerDied;
    }

    public boolean startArc3(){
        map = new AbyssOfDissonance();

        Map checkPointMap = map;
        Character checkPointPlayer = player;
        playerDied = true;
        while(player.getLives() > 0 && playerDied){
            playerDied = mapChar.explore(checkPointMap, checkPointPlayer);

            if(playerDied){
                text.printSystemError("You have died!");
                player.playerDied();
                if(player.getLives() > 0) text.printSystemAnnouncement("Resetting Last Arc...\n\t\tLives left: " + player.getLives());
                else break;
            }
        }
        return !playerDied;
    }
}

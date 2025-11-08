package Map;

import Player.Character;

public class Arc {
    Map map = null;
    Character player = null;
    MapCharacter mapChar = null;

    public Arc(MapCharacter mapChar, Character player){
        this.player = player;
        this.mapChar = mapChar;
    }

    public void startArc1(){
        map = new TownOfEchoes();
        map.setMap();
        mapChar.explore(map,player);
    }

    public void startArc2(){
        map = new SilentCaverns();
        map.setMap();
        mapChar.explore(map,player);
    }

    public void startArc3(){
        map = new AbyssOfDissonance();
        map.setMap();
        mapChar.explore(map,player);
    }
}

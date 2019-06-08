package game.Enity.wall;

import game.GameObject;

public class Wall extends GameObject {
    public Wall() {
        key = "Wall";
        GameObject.addToHashMap(key,this);
        GameObject.addToHashMap(WallName,this);
    }
}

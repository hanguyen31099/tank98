package game.Enity;

import game.GameObject;
import game.renderer.Renderer;

public class Tree extends GameObject {
    public Tree(){
        key = "Tree";
        renderer = new Renderer("assets/images/tree/tree2.png");
        GameObject.addToHashMap(key,this);
    }
}

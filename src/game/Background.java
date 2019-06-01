package game;

import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;


public class Background extends GameObject{
    public Background() {
        key = "Background";
        renderer = new Renderer("assets/images/background/box.jpg");
        position.set(0,Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT);
        anchor.set(0,0);
        GameObject.addToHashMap(key,this);
    }
}

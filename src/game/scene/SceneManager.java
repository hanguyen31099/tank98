package game.scene;

import game.GameObject;

public class SceneManager {
    public static Scene currentScene;
    public static void signNewScene(Scene newScene){
        if(currentScene!=null){
            currentScene.clear();
        }
        newScene.init();
        currentScene = newScene;
    }
}

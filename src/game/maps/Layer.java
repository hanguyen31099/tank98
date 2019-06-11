package game.maps;

import game.Enity.Platform;
import game.Enity.Tree;
import game.GameObject;
import game.Settings;
import game.player.PlayerSummer;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int height;
    private int width;

    public void generate() {
        for (int titleY= 0;titleY <height;titleY++){
            for (int titleX=0;titleX<width;titleX++){
                int mapData = data.get(titleY * width + titleX);
                if(mapData!=0){
                    GameObject object = Platform.addPlatform(mapData);
                    if(object!=null){
                        if(mapData==3||mapData==4){
                            object.position.set(titleX*24+24 ,titleY*24);
//                            GameObject.objects.add(object);
                        }
                        else{
                            // 12 do map lech
                            object.position.set(titleX*24 + 12,titleY*24 + 12);
//                            GameObject.objects.add(object);
                        }
                    }

                }
            }
        }
    }

    @Override
    public String toString() {
        return "Layer={" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width + '}';
    }
}

package game;

import game.Enity.wall.Wall;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameObject {
    // quan li doi tuong(static)
    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static HashMap<String,ArrayList<GameObject> > hashMaparr = new HashMap<String, ArrayList<GameObject>>();
    public static void addToHashMap(String mapKey,GameObject other){
        ArrayList<GameObject> list = hashMaparr.get(mapKey);
        if (list == null) {
            list = new ArrayList<GameObject>();
            list.add(other);
            hashMaparr.put(mapKey,list);
        }
        else{
            if(!list.contains(mapKey)) list.add(other);
        }
    }

    public static <E extends GameObject>E recycle(String str,Class<E> cls){
        // 1. tim phan tu bi deactive >> reset phan tu thi >> tra ve
        E object = findInactive(str);
        if(object!=null){
            object.reset();
            return object;
        }
        // 2. k tim thay thi tao moi
        try{
            object = cls.getConstructor().newInstance();
            return object;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static <E extends GameObject>E recycleSpectical(String str,Class<E> cls){
        // 1. tim phan tu bi deactive >> reset phan tu thi >> tra ve
        E object = findInactive(str);
        if(object!=null){
            return object;
        }
        // 2. k tim thay thi tao moi
        try{
            object = cls.getConstructor().newInstance();
            return object;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static <E extends GameObject>E findInactive(String str){
        // cls ~ Player.class || BackGround.class
        // E ~ player || background
        if(hashMaparr.get(str)!=null){
            for (int i=0;i<hashMaparr.get(str).size();i++){
                if(hashMaparr.get(str).get(i)!=null){
                    GameObject object = objects.get(hashMaparr.get(str).get(i).Index);
                    // object ~ cls
                    if(!object.active){
                        return (E)object;
                    }
                }
            }
        }
        return null;
    }


    public static <E extends GameObject>E findInterSectsWall(String str,BoxCollider hitBox,String find,
                                                             GameObject master, Class<E> cls, ArrayList<GameObject> wallArr){
        int dem = 0;
        for (int i=0;i<hashMaparr.get(str).size();i++){
            GameObject object = hashMaparr.get(str).get(i);
            if(object.active
                    && object.Index != master.Index
                    && object.hitBox!=null
                    && object.hitBox.interset(hitBox.SpcecticalHitBox(find))
                    && cls.isAssignableFrom(object.getClass()))
            {
                dem++;
                wallArr.add(object);
            }
            if (dem>=2){
                break;
            }
        }
        return null;
    }
    public static <E extends GameObject>E findInterSects(String str,BoxCollider hitBox,Class<E> cls,GameObject master){
        if(hashMaparr.get(str)!=null){
            for (int i=0;i<hashMaparr.get(str).size();i++){
                if(hashMaparr.get(str).get(i)!=null) {
                    GameObject object = objects.get(hashMaparr.get(str).get(i).Index);
                    if (object.active
                            && object.Index != master.Index
                            && object.hitBox != null
                            && object.hitBox.interset(hitBox)
                            && cls.isAssignableFrom(object.getClass())) {
                        return (E) object;
                    }
                }

            }
        }
        return null;
    }
    public static void ClearAll(){
        objects.clear();
        for (var key : GameObject.hashMaparr.keySet()) {
            GameObject.hashMaparr.get(key).clear();
        }

    }
    // dinh nghia doi tuong
    public boolean active;
    public Renderer renderer;
    // Renderer renderer
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox;
    public Vector2D anchor;
    public String key;
    public Vector2D Go;
    public int Index;
    public Vector2D bulletGoing;
    public String WallName;
    public String Find;
    public boolean immune;
    public GameObject(){
        position = new Vector2D(0,0);
        velocity = new Vector2D(0,0);
        anchor = new Vector2D(0.5,0.5);
        bulletGoing = new Vector2D(0,0);
        this.Index = Settings.Index;
        Settings.Index++;
        objects.add(this);
        active = true;
        immune = true;
    }
    public void render(Graphics g){
        if(renderer!=null){
            renderer.render(g,this);
        }
    }
    public void run(){
        this.deactiveIfNeeded();
        position.add(velocity.x,velocity.y);
    }
    private void deactiveIfNeeded() {
        if (position.y>Settings.GAME_HEIGHT||
                position.x>Settings.GAME_WIDTH||
                position.y<-50||position.x<-50) this.deactive();

    }
    public void deactive(){
        active = false;
    }
    public void reset(){
        active = true;
    }
}

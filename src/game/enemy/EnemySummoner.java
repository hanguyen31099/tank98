package game.enemy;

import game.GameObject;
import game.Settings;
import tklibs.Mathx;

public class EnemySummoner extends GameObject {
    public EnemySummoner() {
        key = "EnemySummoner";
        GameObject.addToHashMap(key,this);
    }
    long count = 0;
    @Override
    public void run() {
        count++;
        if (count>=200) {
            count = 0;
//            int EnemyType = Mathx.random(1,2);
//            switch (EnemyType){
//                case 1: {
//                    Zombie zombie = GameObject.recycle(Zombie.class);
//                    zombie.position.set(Mathx.random(500,700),20);
//                }
//                case 2: {
//                    Boss boss = GameObject.recycle(Boss.class);
//                    boss.position.set(Mathx.random(500,700),20);
//                }
//            }
        }
    }
}

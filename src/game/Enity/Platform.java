package game.Enity;
import game.Enity.bird.Bird2;
import game.Enity.wall.wall_brown.wallBig.WallBig;
import game.Enity.wall.wall_brown.wallMini.Wall_Brown;
import game.Enity.wall.wall_while.Wall_while;
import game.GameObject;

public class Platform extends GameObject {
    public static GameObject addPlatform(int x){
        switch (x){
            case 1:{
                return new Wall_Brown();
            }
            case 2:{
                return new game.Enity.Tree();
            }
            case 5:{
                return new Wall_while();
            }
            case 3:{
                return new game.Enity.Bird1();
            }
            case 4:{
                return new Bird2();
            }
            case 6:{
                return new WallBig();
            }
        }
        return null;
    }
}

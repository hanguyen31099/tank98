package game;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Human {
    // thuoc tinh
    String name; // = null
    int age; // = 0
    String gender; // = null

    // ham tao
    public Human() { // ham tao rong
        name = "New Person";
        age = 20;
        gender = "male";
    }

    // ham tao day du
    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // phuong thuc
    public void eat() {
        System.out.println(name + " eating..");
    }

    public void sleep() {
        System.out.println(name + " sleeping..");
    }
    public ArrayList< ArrayList<Vector2D> > arr = new ArrayList<>();
    public ArrayList<Vector2D> arr1 = new ArrayList<>();
    public static void main(String[] args) {

    }
}

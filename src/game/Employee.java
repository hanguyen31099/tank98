package game;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Human {
    public static void main(String[] args){
        try{
            errorMaker(1);
            errorMaker(0);
            errorMaker(-1);
        } catch (Exception ex){
//            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            System.out.println("final~");
        }
        System.out.println("continune");
    }
    public static int doSomething() throws Exception{
        return 1/0;
    }
    public static void errorMaker(int input) throws Exception{
        if(input > 0){
            System.out.println("oke");
        }
        else if(input==0) {
            throw new Exception("NOT oke");
        }
        else
            System.out.println("oke");
    }
}

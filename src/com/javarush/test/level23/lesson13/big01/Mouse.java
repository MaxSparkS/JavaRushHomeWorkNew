package com.javarush.test.level23.lesson13.big01;

/**
 * Created by m.shkurko on 10/4/2016.
 */
public class Mouse{
    int x, y;

    public Mouse(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setX(int x){
        this.x=x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getY(){
        return y;
    }
}

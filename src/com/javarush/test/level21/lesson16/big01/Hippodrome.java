package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by m.shkurko on 10/3/2016.
 */
public class Hippodrome {

    private static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();

        game.getHorses().add(new Horse("Tek",3, 0));
        game.getHorses().add(new Horse("Lon",3, 0));
        game.getHorses().add(new Horse("Hip",3, 0));

        game.run();
        game.printWinner();

    }
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses(){
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i<100; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }
    public void move(){
        for (Horse horse : horses){
            horse.move();
        }

    }
    public void print(){
        for (Horse horse : horses){
            horse.print();
            System.out.println();
            System.out.println();
        }

    }

    public Horse getWinner(){
        double result=0;
        Horse winner = null;
        for (Horse horse : horses){
            if (horse.getDistance()>result){
                result = horse.getDistance();
                winner=horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+"!");
    }

}

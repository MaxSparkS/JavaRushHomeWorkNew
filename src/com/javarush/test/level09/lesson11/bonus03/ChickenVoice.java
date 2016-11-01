package com.javarush.test.level09.lesson11.bonus03;

/**
 * Created by m.shkurko on 10/18/2016.
 */
public class ChickenVoice
    {
    static EggVoice eggVoice;

    public static void main(String[] args) {
        eggVoice = new EggVoice();
        System.out.println("Спор начат");
        eggVoice.start();

        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
            }System.out.println("курица");
        }

        if (eggVoice.isAlive()){
            try{
                eggVoice.join();
            }catch (Exception e){

            }System.out.println("Первым было яйцо");
        }else System.out.println("Первым была курица");

        System.out.println("Спор закончен");
    }
    }

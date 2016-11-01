package com.javarush.test.level09.lesson11.bonus03;

/**
 * Created by m.shkurko on 10/18/2016.
 */
public class EggVoice extends Thread
    {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try{
                sleep(500);
            }catch (InterruptedException e){
            }
            System.out.println("яйцо");
        }
    }
    }

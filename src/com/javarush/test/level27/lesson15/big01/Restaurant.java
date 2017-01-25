package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by m.shkurko on 11/23/2016.
 */
public class Restaurant
    {
    public static void main(String[] args) {
        Cook cook = new Cook("Amigo");
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);

        cook.addObserver(new Waitor());
        tablet.createOrder();


    }
    }

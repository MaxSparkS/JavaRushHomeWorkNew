package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by m.shkurko on 10/27/2016.
 */
interface Command
    {
        void execute()throws InterruptOperationException;
    }

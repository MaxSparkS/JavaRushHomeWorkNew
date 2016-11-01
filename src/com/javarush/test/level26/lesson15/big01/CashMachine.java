package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by m.shkurko on 10/21/2016.
 */
public class CashMachine
    {
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args) throws InterruptOperationException {

        Locale.setDefault(Locale.ENGLISH);
        try {
            ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH+"common_en");
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do {
                ConsoleHelper.writeMessage(res.getString("choose.operation")+"\n 1:"+
                        res.getString("operation.INFO")+"\n 2:"+res.getString("operation.DEPOSIT")+"\n 3:"+res.getString("operation.WITHDRAW")+"\n 4:"+res.getString("operation.EXIT"));
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);

            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e) {

        }
    }
    }

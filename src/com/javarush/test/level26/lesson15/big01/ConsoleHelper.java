package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by m.shkurko on 10/21/2016.
 */
public class ConsoleHelper
    {

       static private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String message = "";
        try {
            message = reader.readLine();
            if (message.equalsIgnoreCase(res.getString("operation.EXIT"))) {
                ConsoleHelper.writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }

        }
        catch (IOException ignored) {
        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode;
        while (true) {
            currencyCode = readString();
            if (currencyCode.length() != 3) writeMessage(res.getString("invalid.data"));
            else {
                break;
            }
        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] mass;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (true) {
            String s = readString();
            mass = s.split(" ");
            int par, quantity;
            try {
                par = Integer.parseInt(mass[0]);
                quantity = Integer.parseInt(mass[1]);
            }
            catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (Integer.parseInt(mass[0]) < 0 || Integer.parseInt(mass[1]) < 0 || mass.length > 2) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }


        return mass;
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            String s = readString();
            if (mather(s)) {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
            } else
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }

    }

    public static boolean mather(String name) {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
    }


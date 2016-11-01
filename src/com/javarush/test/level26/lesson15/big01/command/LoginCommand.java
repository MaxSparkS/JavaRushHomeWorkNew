package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by m.shkurko on 10/31/2016.
 */
class LoginCommand implements Command
    {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String card, pin;
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        while (true){
            card = ConsoleHelper.readString();
            if (validCreditCards.containsKey(card)){
                ConsoleHelper.writeMessage(String.format(res.getString("success.format.card"), card));
                ConsoleHelper.writeMessage("Please, enter pin code");
                while (true){
                    pin  = ConsoleHelper.readString();
                    if (validCreditCards.getString(card).equals(pin)){
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format.pin"), card));
                    }
                    else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format.pin"),card));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit.pin"));
                        continue;
                    }
                    break;
                }
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format.card"),card));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit.card"));
                continue;
            }
            break;

        }



//        String card, pin;
//        ConsoleHelper.writeMessage("Enter Card Number");
//        boolean index=false;
//        while (index==false) {
//            card = ConsoleHelper.readString();
//            for (Map.Entry<String, String> entry : cards.entrySet()) {
//                if (entry.getKey().equals(card)) {
//                    ConsoleHelper.writeMessage("Card number adopted");
//                    while (index==false){
//                        ConsoleHelper.writeMessage("Enter Pin Code");
//                        pin=ConsoleHelper.readString();
//                        if (entry.getValue().equals(pin)){
//                            ConsoleHelper.writeMessage("Pin Code adopted");
//                            index=true;
//                        }else{
//                            ConsoleHelper.writeMessage("Invalid Pin Code! Please, try again enter Pin Code");
//                        }
//                    }
//
//                } else {
//                    ConsoleHelper.writeMessage("Invalid Card Number! Try again enter number");
//                }
//            }
//
//
//        }

    }
    }

package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by m.shkurko on 10/27/2016.
 */
class DepositCommand implements Command
    {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        String[] digits = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        try{
            currencyManipulator.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(digits[0])*Integer.parseInt(digits[1]),code));
        } catch (NumberFormatException e){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
    }

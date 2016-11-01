package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem{

        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

    @Override
    public String getCountryCode() {
        String res = "";
        String country = customer.getCountryName();
        for (Map.Entry<String,String> x : countries.entrySet())
        {
            if (x.getValue().equals(country)) res = x.getKey();
        }
        return res;
    }

    @Override
    public String getCompany() {
        return customer.getCompanyName();
    }

    @Override
    public String getContactFirstName() {
        String[] strings = contact.getName().split(", ");
        return strings[1];
    }

    @Override
    public String getContactLastName() {
        String[] strings = contact.getName().split(", ");
        return strings[0];
    }

    @Override
    public String getDialString() {
        return "callto://"+contact.getPhoneNumber().replace("(","").replace(")","").replace("-","");
    }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
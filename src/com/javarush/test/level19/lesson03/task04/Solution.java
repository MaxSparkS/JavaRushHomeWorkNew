package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scanner;

    public PersonScannerAdapter(Scanner scanner){
            this.scanner=scanner;
        }

    @Override
    public Person read() throws IOException {
        Person person = null;
        if (scanner.hasNext()){
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            int year, month, day;
            year = Integer.parseInt(strings[5]);
            month = Integer.parseInt(strings[4])-1;
            day = Integer.parseInt(strings[3]);
            Date date = (new GregorianCalendar(year,month,day)).getTime();
            person = new Person(strings[1],strings[2], strings[0],date);
        }
        return person;
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
    }
}

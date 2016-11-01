package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> list = new ArrayList<>();
        String input;
        while((input=in.readLine())!=null){
            list.add(input);
        }
        in.close();

        for (String aList : list){
            String[] arr = aList.split(" ");
            String name="";
            int year, month, day;
            for (int i = 0; i < arr.length-3; i++) {
                name +=arr[i]+" ";
            }
            year = Integer.parseInt(arr[arr.length-1]);
            month=Integer.parseInt(arr[arr.length-2])-1;
            day = Integer.parseInt(arr[arr.length-3]);
            Date date = new GregorianCalendar(year,month,day).getTime();
            PEOPLE.add(new Person(name,date));
        }

    }

}

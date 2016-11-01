package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{

        String fileName = args[0];
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        TreeMap<String, Double> list = new TreeMap<>();
        while (in.ready()){
           String[] stringRes = in.readLine().split(" ");

            if (list.containsKey(stringRes[0])){
                double d = list.get(stringRes[0]);
                list.put(stringRes[0], Double.parseDouble(stringRes[1])+d);
            }else list.put(stringRes[0], Double.parseDouble(stringRes[1]));
        }

        for (Map.Entry entry : list.entrySet()){
            System.out.println(entry);
        }
        in.close();
    }
}

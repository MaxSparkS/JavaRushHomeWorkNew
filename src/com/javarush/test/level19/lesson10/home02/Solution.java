package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        String[] array;
        String line;
        Double value;

        while ((line=in.readLine())!=null){
            array = line.split(" ");
            if (map.containsKey(array[0])){
                value = map.get(array[0]);
                map.put(array[0], Double.parseDouble(array[1])+value);
            }else
                map.put(array[0], Double.parseDouble(array[1]));
        }
        in.close();
        Double max = Double.MIN_VALUE;
        Double val;
        for (String s : map.keySet()){
            val=map.get(s);
            if (val>max)
                max=val;
        }

        for (String s1 : map.keySet()){
            val = map.get(s1);
            if (val==max){
                System.out.println(s1);
            }
        }
    }
}

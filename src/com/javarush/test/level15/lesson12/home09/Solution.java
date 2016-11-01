package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String param = reader.readLine();
        String result="";
        int i = param.indexOf("?");
        String newParam = param.substring(i+1,param.length());
            double d=0;
            for (String s: newParam.split("&")){
                if (s.contains("=")){
                    int index = s.indexOf("=");
                    result=result+s.substring(0,index)+" ";
                }
                else result=result+s+" ";
                if (s.contains("obj")){
                    int index = s.indexOf("=");
                    d = Double.parseDouble(s.substring(index+1, s.length()));
                }
            }
        alert(result);
        if (d!=0) alert(d);

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println(value);
    }
}

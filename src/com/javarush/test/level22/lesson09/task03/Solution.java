package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file=new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> list = new ArrayList<>();
        String[] arr;
        while (file.ready()){
            String line = file.readLine();
            arr = line.split(" ");
            Collections.addAll(list, arr);
        }
        StringBuilder result = getLine(list);
        System.out.println(result.toString());
    }
    public static StringBuilder getLine(ArrayList<String> list) {
        StringBuilder builder = new StringBuilder();
        Collections.sort(list);
        builder.append(list.get(0));
        int l = builder.length();
        String s2 = builder.substring(l-1);
        System.out.println(s2);

        for (String s:list){
                String s1 = s.substring(0,1);
                System.out.println(s1);
                if (s2.equalsIgnoreCase(s1)){
                    builder.append(s);
                    list.remove(s);
                }
        }
        return builder;
    }
}

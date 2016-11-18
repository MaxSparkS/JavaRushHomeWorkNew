package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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
public class Solution
    {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String[] arr = new String[file.read()];
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = file.readLine()) != null) {
            arr = line.split(" ");
        }
        file.close();
        Arrays.sort(arr);
        for (String s : arr) {
            list.add(s);
        }
        StringBuilder result = getLine(list);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(ArrayList<String> words) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words.get(0));
        words.remove(0);
        while (!words.isEmpty()) {
            for (String s : words) {
                if (stringBuilder.substring(stringBuilder.length() - 1).equals(s.substring(0, 1).toLowerCase())) {
                    stringBuilder.append(" " + s);
                    words.remove(s);
                    break;
                }
            }
        }
        return stringBuilder;
    }
    }

package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));

        while (in.ready()){
            words.addAll(Arrays.asList(in.readLine().split(" ")));
        }
        in.close();

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size();) {
                if (words.get(i).equals(new StringBuilder(words.get(j)).reverse().toString())&&j!=i){
                    Pair pair = new Pair();
                    pair.first=words.get(j);
                    pair.second=words.get(i);
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    j=0;
                }else j++;
            }
        }

        for (Pair pair : result){
            System.out.println(pair.toString());
        }



    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

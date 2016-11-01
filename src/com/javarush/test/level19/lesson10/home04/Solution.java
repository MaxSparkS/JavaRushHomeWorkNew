package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("string");
        words.add("green");
        words.add("V");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        List<String> list = new ArrayList<>();
        String input;
        while((input=in.readLine())!=null){
            list.add(input);
        }
        in.close();
        for(String line : list){
            String[] arr=line.split(" ");
            int i=0;
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < words.size(); k++) {
                    if (arr[j].equals(words.get(k)))
                        i++;
                }
            }
            if (i==2)
                System.out.println(line);
        }
    }
}

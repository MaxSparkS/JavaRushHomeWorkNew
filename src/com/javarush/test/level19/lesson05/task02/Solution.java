package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader in = new FileReader(reader.readLine());
        reader.close();

        String s="";
        int i=0;

        while(in.ready()){
            char c = (char) in.read();
            s+=String.valueOf(c).toLowerCase();
        }
        s=s.replaceAll("\\p{Punct}", " ");
        s=s.replaceAll("\n", " ");
        String[] splitString = s.split(" ");
        for (String str : splitString){
            if (str.equals("world")) i++;
        }
        System.out.println(i);
        in.close();
    }
}

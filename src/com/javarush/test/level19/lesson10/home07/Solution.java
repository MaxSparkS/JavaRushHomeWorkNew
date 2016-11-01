package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        FileWriter out = new FileWriter(args[1]);
        String line="";
        String[]array;
        while (in.ready()){
            line=in.readLine();
            array=line.split(" ");
            String s="";
            for (int i = 0; i < array.length; i++) {
                if (array[i].length()>6)
                    s=s+array[i]+",";
            }
            s=s.substring(0,s.length()-1);
            out.write(s);
        }
        in.close();
        out.close();

    }
}

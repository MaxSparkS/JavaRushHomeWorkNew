package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        FileWriter out = new FileWriter(reader.readLine());
        reader.close();

        while(in.ready()){
            char b = (char) in.read();
            if (b=='.'){
                b='!';
            }
            out.write(b);
        }
        in.close();
        out.close();
    }
}

package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        FileWriter out = new FileWriter(reader.readLine());
        reader.close();
        String s = "";
        while(in.ready()){
            s = in.readLine()+" ";
        }

        String[] arr = s.split(" ");
        for (String word : arr){
            try{
                int a = Integer.parseInt(word);
                out.write(a+" ");
            }catch (NumberFormatException e){

            }
        }
        in.close();
        out.close();

    }
}

package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        reader.close();
        ArrayList<Integer> list = new ArrayList<>();
        while (fileReader.ready()){
            int data = fileReader.read();
            list.add(data);
        }
        fileReader.close();
        for (int i = 0; i<list.size(); i++){
            if (i%2!=0){
                fileWriter.write(list.get(i));
            }
        }
        fileWriter.close();
    }
}

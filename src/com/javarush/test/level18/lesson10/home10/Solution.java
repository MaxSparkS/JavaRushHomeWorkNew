package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Set<File> set = new TreeSet<>();
        while (!(name=reader.readLine()).equals("end")){
            set.add(new File(name));
        }
        Iterator<File> iterator = set.iterator();
        String folder = iterator.next().getAbsolutePath();
        folder = folder.substring(0, folder.length()-6);
        FileOutputStream out = new FileOutputStream(folder);

        for (File file : set){
            FileInputStream in = new FileInputStream(file);
            byte[] data = new byte[in.available()];
            while (in.available()>0){
                in.read(data);
            }
            out.write(data);
            in.close();
        }
        out.close();
        reader.close();

    }
}

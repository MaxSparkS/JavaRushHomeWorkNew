package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOut = new FileOutputStream(reader.readLine());
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());

        byte[] a = new byte[file2.available()];
        byte[] b = new byte[file3.available()];

        while (file2.available()>0){
            file2.read(a);

        }

        while (file3.available()>0){
            file3.read(b);
        }

        fileOut.write(a);
        fileOut.write(b);

        reader.close();
        file2.close();
        file3.close();
        fileOut.close();

    }
}

package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(new File(reader.readLine()));
        FileOutputStream file3 = new FileOutputStream(new File(reader.readLine()));
        byte[] list = new byte[file.available()];
        int k=0;
        if (file.available()<0){
            byte c =(byte) file.read();
            list[k]=c;
            k++;
        }
        if (file.available()%2==0){
            for (int i = 0; i < list.length/2 ; i++){
                file2.write(list[i]);
            }
            for (int j = list.length/2; j < list.length; j++){
                file3.write(list[j]);
            }
        }else{
            for (int i = 0; i <list.length/2+1 ; i++) {
                file2.write(list[i]);
            }
            for (int j = list.length/2+1; j < list.length; j++){
                file3.write(list[j]);
            }
        }

        reader.close();
        file.close();
        file2.close();
        file3.close();

    }
}

package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        String key = args[0];
        String in  = args[1];
        String out = args[2];

        FileInputStream fileIn = new FileInputStream(in);
        FileOutputStream fileOut = new FileOutputStream(out);
        byte[] data = new byte[fileIn.available()];
        fileIn.read(data);

        fileIn.close();
        if (key.equals("-e")){
            for (int i = 0; i < data.length ; i++) {
                data[i] = (byte)(data[i]+1);
            }
        }else if (key.equals("-d")){
            for (int i = 0; i < data.length; i++) {
                data[i]=(byte)(data[i]-1);
            }
        }
        fileOut.write(data);
        fileOut.close();
    }

}

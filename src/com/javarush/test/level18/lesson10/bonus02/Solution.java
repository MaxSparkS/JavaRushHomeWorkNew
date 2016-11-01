package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        args = new String[]{"-c", "shelldawdwqdqwdqw", "56","3" };
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        reader.close();
        String id;
        String productName = ref(args[1],60);
        String price = ref(args[2], 8);
        String quantity = ref(args[3], 4);
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int maxID = 0;
        int curID;
        String line;
        if ((line=bufferedReader.readLine())!=null){
            curID = Integer.parseInt(line.substring(0,8).trim());
            if (curID>maxID) maxID=curID;
        }
        id=ref(String.valueOf(maxID+1), 8);


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(id+productName+price+quantity);
        bufferedWriter.newLine();
        fileReader.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
    private static String ref(String in, int i){
        String name;
        if (in.length()>i){
            name=in.substring(0,i);
        }else{
            String s ="";
            for (int j = 0; j <i-in.length() ; j++) {
                s=s+" ";
            } name = in+s;

        }
    return name;
    }

}

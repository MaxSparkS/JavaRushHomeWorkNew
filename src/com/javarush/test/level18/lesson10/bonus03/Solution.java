package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line=file.readLine())!=null){
            list.add(line);
        }
//        for (String s : list){
//            int id;
//            String productName;
//            double price;
//            int quantity;
//        }
        if (args.length==5 && args[0].equals("-u")){
//            try{
                int id = Integer.parseInt(args[1]);
                String productName = args[2];
                double price = Double.parseDouble(args[3]);
                int quantity = Integer.parseInt(args[4]);
                for (String s : list){
                    int id1 = Integer.parseInt(s.substring(0,8).replace(" ", ""));
                    System.out.println(s.substring(0,8).replace(" ",""));
                    String name = s.substring(8,38);
                    System.out.println(name);
//                    double price1 = Double.parseDouble(s.substring(38,46).replaceAll(" ", ""));
                    System.out.println(s.substring(38,46).replaceAll(" ", ""));
//                    int quantity1 = Integer.parseInt(s.substring(46));

//                    System.out.println(id1+name+price1+quantity1);
                }
//            }catch (Exception e){
//                System.out.println("Exception");
//            }
        }
        else if (args.length==2 && args[0].equals("-d")){
            try{
                int id = Integer.parseInt(args[1]);
            }catch (Exception e){}
        }
    }
}

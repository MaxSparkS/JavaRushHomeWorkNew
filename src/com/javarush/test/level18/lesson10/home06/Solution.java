package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
public static void main(String[] args) throws IOException {


    List<Integer> symbols = new ArrayList<Integer>();
    if (args.length > 0) {
        FileInputStream in = new FileInputStream(args[0]);
        while(in.available()>0){
            symbols.add(in.read());
        }
        in.close();
        for (int i = 0; i < 256; i++) {
            int count=0;
            for (int j = 0; j < symbols.size(); j++) {
                if(symbols.get(j).equals(i)){
                    count++;
                }
            }
            if(count>0){
                System.out.println((char)i+" "+count);
            }
        }
    }
}
}

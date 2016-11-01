package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //инициализация
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        String rs = "";
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>();
        // запихиваем все байты в массив
        while (file.available()>0){
            list.add(file.read());
        }
        //считаем кол-во байтов
        int[] x = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            x[i]=0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i)==list.get(j)) x[i]++;
            }
        }
        //определяем минимальное количество повторов
        int max = Integer.MIN_VALUE;
        for (int i :x){
            if (i>max) max=i;
        }
        //собираем байты с максимальным количеством повторов
        for (int i = 0; i < list.size(); i++) {
            if (!resList.contains(list.get(i))&&x[i]==max) resList.add(list.get(i));
        }
        //выводим байты с максимальным количеством повторов на экран
        for (int i :resList){
            rs += i+" ";
        }
        System.out.println(rs);
        //закрываем потоки
        reader.close();
        file.close();


    }
}

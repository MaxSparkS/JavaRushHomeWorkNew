package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //инициализация
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>();
        //запихиваем байты в массив
        while (file.available()>0){
            list.add(file.read());
        }
        // считаем количество байтов
        int[] data = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            data[i]=0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i)==list.get(j)) data[i]++;
            }
        }
        //определяем минимальное количество повторов
        int min = Integer.MAX_VALUE;
        for (int i : data){
            if (i<min) min=i;
        }
        //находим байты с минимальным количеством повторов
        for (int i = 0; i < list.size(); i++) {
            if (!resList.contains(list.get(i))&&data[i]==min) resList.add(list.get(i));
        }
        //выводим байты с минимальным количеством повторов на экран
        for (int i:resList){
            s += i+" ";
        }
        System.out.println(s);
        //закрываем потоки
        reader.close();
        file.close();


    }
}

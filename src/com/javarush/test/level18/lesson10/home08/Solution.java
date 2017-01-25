package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        do {
            filename=reader.readLine();
            ReadThread thread = new ReadThread(filename);
            thread.start();
        }while (!filename.equalsIgnoreCase("exit"));
        reader.close();
        System.out.println(resultMap);
    }
    public static class ReadThread extends Thread {
        private String filename;
        public ReadThread(String fileName) {
            this.filename=fileName;//implement constructor body
        }
    @Override
    public void run() {
        try{
            FileInputStream inputStream = new FileInputStream(filename);
            ArrayList<Integer> list = new ArrayList<>();
            while(inputStream.available()>0){
                int data = inputStream.read();
                list.add(data);
            }
            inputStream.close();
            int max = 0;
            int id = 0;
            int count;

            for (int i = 0; i<list.size(); i++){
                count = Collections.frequency(list,list.get(i));
                if (max<count){
                    max = count;
                    id = list.get(i);
                }
            }
            resultMap.put(filename, id);
        }catch (Exception e){}
    }
    // implement file reading here - реализуйте чтение из файла тут
    }
}

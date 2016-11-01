package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName=reader.readLine();
            OutputStream outputStream = new FileOutputStream(fileName);
            InputStream inputStream = new FileInputStream(fileName);

            Document document = new Document();
            Propertie propertie1 = new Propertie();
            propertie1.setKey("Address");
            propertie1.setValue("Minsk");

            Propertie propertie2 = new Propertie();
            propertie2.setKey("PhoneNumber");
            propertie2.setValue("+375295611771");

            document.properties.add(propertie1);
            document.properties.add(propertie2);

            document.save(outputStream);

            Document loadDocument = new Document();
            loadDocument.load(inputStream);

            reader.close();
            inputStream.close();
            outputStream.close();
        }catch (IOException e){
            System.out.println("Oops, something wrong with my file");
        }catch (Exception e){
            System.out.println("Oops, something wrong with save/load method");
        }
        //implement this method - реализуйте этот метод
    }

    public static class Document{
        public List<Propertie> properties = new ArrayList<>();

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Propertie propertie : properties){
            String key  = propertie.getKey();
            String value = propertie.getValue();
            writer.println(key+" = "+value);

        }
        writer.close();
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line=reader.readLine())!=null){
            String[] arr = line.split(" = ");
            Propertie propertie = new Propertie();
            propertie.setKey(arr[0]);
            propertie.setValue(arr[1]);
            properties.add(propertie);
        }
        reader.close();
        //implement this method - реализуйте этот метод
    }
    }
}

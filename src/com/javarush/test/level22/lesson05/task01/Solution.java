package com.javarush.test.level22.lesson05.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string==null)
            throw new TooShortStringException();
        int firstIndex = string.indexOf(" ");
        if (firstIndex==-1)
            throw new TooShortStringException();
        int lastIndex = string.indexOf(" ", firstIndex+1);
        if (lastIndex==-1)
            throw new TooShortStringException();
        lastIndex = string.indexOf(" ", lastIndex+1);
        if (lastIndex==-1)
            throw new TooShortStringException();
        lastIndex = string.indexOf(" ", lastIndex+1);
        if (lastIndex==-1)
            throw new TooShortStringException();
        lastIndex = string.indexOf(" ", lastIndex+1);
        if (lastIndex==-1)
            throw new TooShortStringException();


        string = string.substring(firstIndex+1, lastIndex);
        return string;
    }

    public static class TooShortStringException extends Exception{
    }

public static void main(String[] args) throws TooShortStringException{
    System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
}
}

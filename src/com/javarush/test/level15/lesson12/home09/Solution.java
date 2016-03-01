package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String url = reader.readLine();
            String allParameters = url.substring(url.indexOf("?") + 1);
            String[] listOfParams = allParameters.split("&");
            String fullString = "";
            ArrayList<String> list2 = new ArrayList<>();

            for (String s : listOfParams)
            {
                if (s.contains("="))
                {
                    fullString += (s.substring(0, s.indexOf("=")) + " ");
                    if ("obj".equals(s.substring(0, s.indexOf("="))))
                    {
                        list2.add(s.substring(s.indexOf("=") + 1));
                    }
                } else
                    fullString += (s + " ");
            }
            System.out.println(fullString.substring(0, fullString.length() - 1));
            if (list2.size() > 0)
            {
                for (String obj : list2)
                {
                    if (obj.contains(".") || isNumber(obj))
                        alert(Double.parseDouble(obj));
                    else
                        alert(obj);
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static boolean isNumber(String s)
    {
        try
        {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}

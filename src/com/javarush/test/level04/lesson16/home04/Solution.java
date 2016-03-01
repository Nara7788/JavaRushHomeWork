package com.javarush.test.level04.lesson16.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String sYear = reader.readLine();
        String sMonth = reader.readLine();
        String sDay = reader.readLine();

        int nYear = Integer.parseInt(sYear);
        int nMonth = Integer.parseInt(sMonth);
        int nDay = Integer.parseInt(sDay);

        System.out.println("Меня зовут "+name);
        System.out.println("Я родился "+nDay+"."+nMonth+"."+nYear);
    }
}

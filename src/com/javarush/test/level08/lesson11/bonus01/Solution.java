package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        HashMap<String, Integer> calendar = new HashMap<>();

        calendar.put("JAN", 1);
        calendar.put("JANUARY", 1);
        calendar.put("FEB", 2);
        calendar.put("FEBRUARY", 2);
        calendar.put("MAR", 3);
        calendar.put("MARCH", 3);
        calendar.put("APR", 4);
        calendar.put("APRIL", 4);
        calendar.put("MAY", 5);
        calendar.put("JUN", 6);
        calendar.put("JUNE", 6);
        calendar.put("JUL", 7);
        calendar.put("JULY", 7);
        calendar.put("AUG", 8);
        calendar.put("AUGUST", 8);
        calendar.put("SEP", 9);
        calendar.put("SEPT", 9);
        calendar.put("SEPTEMBER", 9);
        calendar.put("OCT", 10);
        calendar.put("OCTOBER", 10);
        calendar.put("NOV", 11);
        calendar.put("NOVEMBER", 11);
        calendar.put("DEC", 12);
        calendar.put("DECEMBER", 12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s = s.toUpperCase();
        String word = s.substring(0,1) + s.substring(1).toLowerCase();

        System.out.println(word + " is " + calendar.get(s) + " month");
    }

}

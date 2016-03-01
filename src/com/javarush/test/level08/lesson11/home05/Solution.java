package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        ArrayList<Character> list = new ArrayList<>();
        char[] array = s.toCharArray();
        for (char c : array)
        {
            list.add(c);
        }

        for (int i = 0; i < list.size()-1; i++)
        {
            if (!list.get(i + 1).equals(' ') && i==0)
            {
                list.set(i, list.get(i).toString().toUpperCase().charAt(0));
            }

            if ((list.get(i).equals(' ') && !list.get(i + 1).equals(' ')))
            {
                list.set(i + 1, list.get(i + 1).toString().toUpperCase().charAt(0));
            }
        }


        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        String finalString =  builder.toString();

        System.out.println(finalString);

    }


}

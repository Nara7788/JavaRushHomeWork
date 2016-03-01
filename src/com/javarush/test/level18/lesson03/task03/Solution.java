package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> listOfBiggest = new ArrayList<>();
        int current;
        int biggest = 0;

        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read();
            if (map.containsKey(current))
                map.put(current, map.get(current)+1);
            else
                map.put(current, 1);
        }

        for (Integer values : map.values())
        {
            if (biggest < values)
                biggest = values;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == biggest)
                listOfBiggest.add(entry.getKey());
        }

        for (Integer i : listOfBiggest)
            System.out.println((char)i.intValue() + " ");

        reader.close();
        fileInputStream.close();
    }
}

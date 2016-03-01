package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());


        Set<Integer> map = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int current;
        int smallest = 255;

        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read();
            map.add(current);
        }

        list.addAll(map);
        Collections.sort(list);
        for (Integer i : list)
            System.out.print(i + " ");

        reader.close();
        fileInputStream.close();
    }
}

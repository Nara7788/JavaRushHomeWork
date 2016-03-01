package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int current;
        int smallest = fileInputStream.read();

        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read();
            if (current < smallest)
            {
                smallest = current;
            }
        }

        System.out.println(smallest);
        reader.close();
        fileInputStream.close();
    }
}

package com.javarush.test.level18.lesson03.task01;


/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int current = 0;
        int biggest = 0;

        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read();
            if (current > biggest)
            {
                biggest = current;
            }
        }

        System.out.println(biggest);
        System.out.println((char)biggest);
    }
}

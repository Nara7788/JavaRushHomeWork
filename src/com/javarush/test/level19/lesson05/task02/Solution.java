package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readFromFile = new BufferedReader(new FileReader(reader.readLine()));

        String currentLine;
        String[] wordsArray;
        int worldCount = 0;

        while ((currentLine = readFromFile.readLine()) != null)
        {
             wordsArray = currentLine.split("[,.;!()'\"{} -]+");
            for (String word : wordsArray)
            {
                if ("world".equals(word))
                    worldCount++;
            }
        }
        System.out.println(worldCount);

        reader.close();
        readFromFile.close();
    }
}

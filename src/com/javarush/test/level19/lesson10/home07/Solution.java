package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String currentLine;
        ArrayList<String> list = new ArrayList<String>();

        while ((currentLine = reader.readLine()) != null) {
            String[] splitLine = currentLine.split(" ");

            for (int i = 0; i < splitLine.length; i++) {
                if (splitLine[i].length() > 6) {
                    list.add(splitLine[i]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
            if (i < list.size() - 1) {
                writer.write(",");
            }
        }

        reader.close();
        writer.close();
    }
}

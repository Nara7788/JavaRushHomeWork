package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String readedString;

        while ((readedString = fileReader.readLine()) != null)
        {
            String[] splittedValues = readedString.split(" ");
            for (int i = 0; i < splittedValues.length; i++)
            {
                bufferedWriter.write(String.valueOf(Math.round(Double.parseDouble(splittedValues[i]))));
                bufferedWriter.write(" ");
            }
        }
        fileReader.close();
        bufferedWriter.close();
    }
}

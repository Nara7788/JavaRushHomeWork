package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1Reader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter file2Writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String readLine;
        while ((readLine = file1Reader.readLine()) != null)
        {
            String[] line = readLine.split(" ");
            for (String s : line)
            {
                if (isNumber(s))
                {
                    System.out.println(s + " writing...");
                    file2Writer.write(s,0,s.length());
                    file2Writer.write(" ",0,1);
                }

            }
            file2Writer.newLine();
        }
        file2Writer.flush();
        file1Reader.close();
        file2Writer.close();
    }

    public static boolean isNumber(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}

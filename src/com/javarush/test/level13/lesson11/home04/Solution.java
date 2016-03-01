package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileDestination = reader.readLine();

        ArrayList<String> list = new ArrayList<>();


        while (true)
        {
            String s = reader.readLine();
            if (s.equals("exit"))
            {
                list.add(list.size(), s);
                break;
            }
            list.add(list.size(), s);
        }

        FileOutputStream outStream = new FileOutputStream(fileDestination);
        while (!list.isEmpty())
        {
            outStream.write((list.get(0)).getBytes());
            outStream.write("\r\n".getBytes());
            list.remove(0);
        }
        outStream.close();
    }
}

package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File from = new File(reader.readLine());
        File to = new File(reader.readLine());
        reader.close();

        InputStream in = new FileInputStream(from);
        OutputStream out = new FileOutputStream(to);

        int current;
        int num = 1;
        while ((current = in.read()) != -1)
        {
            if (num % 2 == 0)
                out.write(current);
            num++;
        }

        in.close();
        out.close();
    }
}

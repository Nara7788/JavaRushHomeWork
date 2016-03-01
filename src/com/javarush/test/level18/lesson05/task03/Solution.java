package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
        int bytesCount = fileInputStream.available();
        int part1;
        int part2;


        if (bytesCount % 2 == 1)
        {
            part2 = bytesCount / 2;
            part1 = part2 + 1;
        } else
        {
            part1 = part2 = bytesCount / 2;
        }

        byte[] buffer1 = new byte[part1];
        byte[] buffer2 = new byte[part2];


        fileInputStream.read(buffer1);
        fileInputStream.read(buffer2);

        fileOutputStream1.write(buffer1);
        fileOutputStream2.write(buffer2);

        reader.close();
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}

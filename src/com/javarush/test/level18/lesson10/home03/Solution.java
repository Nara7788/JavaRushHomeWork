package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream file1OS = new FileOutputStream(file1);
        FileInputStream file2IS = new FileInputStream(file2);
        FileInputStream file3IS = new FileInputStream(file3);

        byte[] buffer2 = new byte[file2IS.available()];
        byte[] buffer3 = new byte[file3IS.available()];

        file2IS.read(buffer2);
        file3IS.read(buffer3);

        file1OS.write(buffer2);
        file1OS.close();
        file1OS = new FileOutputStream(file1, true);
        file1OS.write(buffer3);
        file1OS.close();
        file2IS.close();
        file3IS.close();
        reader.close();
    }
}

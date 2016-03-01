package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File from = new File(args[1]);
        File to = new File(args[2]);
        if (!to.exists())
            to.createNewFile();
        InputStream inStream = new FileInputStream(from);
        OutputStream outStream = new FileOutputStream(to);
        byte[] buff = new byte[512];
        int allBytesInFile = 0;

        if ("-e".equals(args[0]))
        {
            while (true)
            {
                int count = inStream.read(buff);
                if (count != -1)
                {
                    for (int i = 0; i < buff.length; i++)
                    {
                        buff[i] = (byte)(buff[i] + 10);
                    }

                    outStream.write(buff, 0, count);
                    allBytesInFile = allBytesInFile + count;
                }
                else
                    break;
            }
            System.out.println(from.getAbsolutePath() + " --> " + to.getAbsolutePath() + " : success encoding");
            System.out.println("Count of all bytes encoded: " + allBytesInFile);
        }

        if ("-d".equals(args[0]))
        {
            while (true)
            {
                int count = inStream.read(buff);
                if (count != -1)
                {
                    for (int i = 0; i < count; i++)
                    {
                        buff[i] = (byte)(buff[i] - 10);
                    }
                    outStream.write(buff, 0, count);
                    allBytesInFile = allBytesInFile + count;
                }
                else
                    break;
            }
            System.out.println(from.getAbsolutePath() + " --> " + to.getAbsolutePath() + " : success decoding");
            System.out.println("Count of all bytes decoded: " + allBytesInFile);
        }

        inStream.close();
        outStream.close();
    }

}

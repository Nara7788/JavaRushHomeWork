package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();


        if ("-c".equals(args[0]))
        {
            String line = getLastIdFromFile(fileName) + setParameterLength(args[1], 30) + setParameterLength(args[2], 8) + setParameterLength(args[3], 4);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(line);
            writer.newLine();
            writer.close();
        }
        if ("-u".equals(args[0]))
        {
            BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
            String currentLine;
            Map<String, String> fileMap = new TreeMap<>();

            while ((currentLine = reader1.readLine()) != null)
            {
                fileMap.put(currentLine.substring(0,8), currentLine.substring(8));
            }

            for (Map.Entry<String, String> entry : fileMap.entrySet())
            {
                if (entry.getKey().equals(setParameterLength(args[1], 8)))
                {
                    String value = setParameterLength(args[2], 30) + setParameterLength(args[3], 8) + setParameterLength(args[4], 4);
                    fileMap.put(entry.getKey(), value);
                    break;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (Map.Entry<String, String> entry : fileMap.entrySet())
            {
                writer.write(entry.getKey() + entry.getValue());
                writer.newLine();
            }
            writer.close();
            reader1.close();
        }
        if ("-d".equals(args[0]))
        {
            BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
            String currentLine;
            Map<String, String> fileMap = new TreeMap<>();

            while ((currentLine = reader1.readLine()) != null)
            {
                fileMap.put(currentLine.substring(0,8), currentLine.substring(8));
            }

            for (Map.Entry<String, String> entry : fileMap.entrySet())
            {
                if (entry.getKey().equals(setParameterLength(args[1], 8)))
                {
                    fileMap.remove(entry.getKey());
                    break;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (Map.Entry<String, String> entry : fileMap.entrySet())
            {
                writer.write(entry.getKey() + entry.getValue());
                writer.newLine();
            }
            writer.close();
            reader1.close();
        }
    }

    public static String setParameterLength(String param, int len)
    {
        String result = null;
        if (param.length() == len)
            result = param;
        if (param.length() > len)
            result = param.substring(0, len);
        if (param.length() < len)
        {
            StringBuilder sb = new StringBuilder(param);
            for (int i = 0; i < len - param.length(); i++)
            {
                sb.append(" ");
            }
            result = sb.toString();
        }

        return result;
    }

    public static String getLastIdFromFile(String fileName) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String currentLine = null;
        int biggestId = 0;
        while ((currentLine = reader.readLine()) != null)
        {
            int currentId = Integer.parseInt(currentLine.substring(0, 8).replaceAll(" ", ""));
            if (currentId > biggestId)
                biggestId = currentId;
        }
        biggestId++;

        return setParameterLength(String.valueOf(biggestId), 8);
    }
}

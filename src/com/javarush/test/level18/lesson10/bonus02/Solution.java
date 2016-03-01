package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        StringBuilder sb = new StringBuilder();
        sb.append(getLastIdFromFile(fileName)); //id
        sb.append(setParameterLength(args[1], 30));  //productName
        sb.append(setParameterLength(args[2], 8));  //price
        sb.append(setParameterLength(args[3], 4));  //price

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(sb.toString());
        writer.newLine();
        writer.close();

    }

    public static String setParameterLength(String param, int len)
    {
        String result = null;
        if (param.length() == len)
            result = param;
        if (param.length() > len)
            result = param.substring(0,len);
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

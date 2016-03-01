package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!"exit".equals(line = reader.readLine()))
        {
            new ReadThread(line).start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(getName());
                int currentByte;
                Map<Integer,Integer> map = new HashMap<>();


                while (fileInputStream.available()>0)
                {
                    currentByte = fileInputStream.read();
                    if (map.containsKey(currentByte))
                    {
                        map.put(currentByte, map.get(currentByte) + 1);
                    }
                    else
                        map.put(currentByte, 1);
                }

                int biggest = 0;

                for (Map.Entry<Integer, Integer> entry : map.entrySet())
                {
                    if (entry.getValue() > biggest)
                        biggest = entry.getValue();
                }

                for (Map.Entry<Integer, Integer> entry : map.entrySet())
                {
                    if (entry.getValue() == biggest)
                    {
                        resultMap.put(getName(), entry.getKey());
                        break;
                    }
                }

                fileInputStream.close();


            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

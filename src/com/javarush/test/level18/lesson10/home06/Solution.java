package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        /*HashMap<Integer, Integer> map = new HashMap<>();
        int current;
        ArrayList<Byte> arrayList = new ArrayList<>();

        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read();
            if (map.containsKey(current))
                map.put(current, map.get(current) + 1);
            else
                map.put(current, 1);
            arrayList.add((byte)current);
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(map);


        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet())
        {
            b[0] = (byte)entry.getKey().intValue();
            String s = new String(b, "UTF-8");
            System.out.println(s + " " + entry.getValue());

        }*/

        /*byte[] bytes = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++)
        {
            bytes[i] = arrayList.get(i);
        }

        System.out.print(new String(bytes, "UTF-8"));*/

        String s = "慢";
        byte[] b = (s.getBytes("utf-8"));
        System.out.println(Arrays.toString(b));
        System.out.println((char)156002);

            fileInputStream.close();
    }
}

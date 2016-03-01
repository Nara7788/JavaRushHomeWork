package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone1", new Date("JUNE 1 1980"));
        map.put("Stallone2", new Date("JUNE 1 1980"));
        map.put("Stallone3", new Date("JULY 1 1980"));
        map.put("Stallone4", new Date("JULY 1 1980"));
        map.put("Stallone5", new Date("NOV 1 1980"));
        map.put("Stallone6", new Date("OCT 1 1980"));
        map.put("Stallone7", new Date("SEP 1 1980"));
        map.put("Stallone8", new Date("APR 1 1980"));
        map.put("Stallone9", new Date("MAY 1 1980"));
        map.put("Stallone10", new Date("AUG 1 1980"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth() >= 5 & pair.getValue().getMonth() <=7)
                iterator.remove();
        }

    }
}

package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getCountTheSameFirstName(createMap(), "Имя3"));
        System.out.println(getCountTheSameLastName(createMap(), "Фам1"));
    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> name = new HashMap<>();
        name.put("Фам1", "Имя1");
        name.put("Фам2", "Имя2");
        name.put("Фам3", "Имя3");
        name.put("Фам4", "Имя1");
        name.put("Фам5", "Имя4");
        name.put("Фам6", "Имя3");
        name.put("Фам7", "Имя6");
        name.put("Фам8", "Имя5");
        name.put("Фам9", "Имя2");
        name.put("Фам10", "Имя2");

        return name;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int counter = 0;

        for (String s : map.values())
        {
            if (s.equals(name))
                counter++;
        }

        return counter;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int counter = 0;

        for (String s : map.keySet())
        {
            if (s.equals(familiya))
                counter++;
        }

        return counter;

    }
}

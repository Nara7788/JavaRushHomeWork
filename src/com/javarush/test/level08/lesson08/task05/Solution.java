package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        HashMap<String, Integer> unicalNames = new HashMap<>();
        while (iterator.hasNext())
        {
            String name = iterator.next().getValue();
            if (!unicalNames.containsKey(name))
            {
                unicalNames.put(name, 1);
            }
            else
            {
                unicalNames.put(name, unicalNames.get(name) + 1);
            }
        }

        for (Map.Entry<String, Integer> pair : unicalNames.entrySet())
        {
            if (pair.getValue() > 1)
                removeItemFromMapByValue(map, pair.getKey());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}

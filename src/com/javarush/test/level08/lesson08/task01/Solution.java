package com.javarush.test.level08.lesson08.task01;

import java.util.Arrays;
import java.util.HashSet;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        String[] list = {"Лук", "Локоть", "Лоб", "Личинка", "Луч", "Левша", "Ласка", "Любовь", "Лувр", "Лиана", "Лощина", "Лань", "Лиса", "Ландыш", "Леска", "Лебедь", "Лайка", "Ларец", "Лилия", "Лотос"};
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(list));
        return set;
    }
}

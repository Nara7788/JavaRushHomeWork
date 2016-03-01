package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(1d,"2g");
        labels.put(2d,"2f");
        labels.put(3d,"2e");
        labels.put(4d,"2d");
        labels.put(5d,"2s");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}

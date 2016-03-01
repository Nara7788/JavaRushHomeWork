package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> fileMap = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String currentLine;
        String[] currentLineSplit;

        while ((currentLine = reader.readLine()) != null) {
            currentLineSplit = currentLine.split(" ");
            if (fileMap.containsKey(currentLineSplit[0])) {
                fileMap.put(currentLineSplit[0], fileMap.get(currentLineSplit[0]) + Double.parseDouble(currentLineSplit[1]));
            } else {
                fileMap.put(currentLineSplit[0], Double.parseDouble(currentLineSplit[1]));
            }
        }

        Double madDouble = 0D;

        for (Double d : fileMap.values()) {
            if (d > madDouble) {
                madDouble = d;
            }
        }

        for (Map.Entry<String, Double> entry : fileMap.entrySet()) {
            if (entry.getValue().equals(madDouble)) {
                System.out.println(entry.getKey());
            }
        }

        reader.close();
    }
}

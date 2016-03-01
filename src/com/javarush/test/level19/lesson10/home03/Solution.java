package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String currentLine;
        String[] currentLineSplit;
        Calendar calendar = new GregorianCalendar();

        while ((currentLine = reader.readLine()) != null) {
            currentLineSplit = currentLine.split(" ");
            int nameLen = currentLineSplit.length - 3;
            String name = "";

            for (int i = 0; i < nameLen; i++) {
                name = name.concat(currentLineSplit[i]);
                name = name.concat(" ");
            }
            name = name.trim();

            calendar.set(
                    Integer.parseInt(currentLineSplit[nameLen + 2]),
                    Integer.parseInt(currentLineSplit[nameLen + 1]) - 1,
                    Integer.parseInt(currentLineSplit[nameLen]), 0, 0);

            Date birthday = calendar.getTime();

            PEOPLE.add(new Person(name, birthday));
        }

        for (Person p : PEOPLE) {
            System.out.println(p.getName() + " " + p.getBirthday());
        }

        reader.close();
    }

}

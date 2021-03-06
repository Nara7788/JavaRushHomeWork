package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static void main(String[] args)
    {

    }
    public static class PersonScannerAdapter implements PersonScanner{
        Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String line[] = scanner.nextLine().split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(line[5]), Integer.parseInt(line[4]) - 1, Integer.parseInt(line[3]));
            Date date = calendar.getTime();

            return new Person(line[1], line[2], line[0], date);
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}

package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("JAN 2 2020");
    }

    public static boolean isDateOdd(String date)
    {
        Date endTime = new Date(date);
        endTime.setSeconds(1);
        Date yearStartTime = new Date();
        yearStartTime.setSeconds(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setHours(0);
        yearStartTime.setDate(0);
        yearStartTime.setMonth(0);
        yearStartTime.setYear(endTime.getYear());

        long deduction = endTime.getTime() - yearStartTime.getTime();
        long daysFromBeginYear = (deduction / (1000*60*60*24));

        return (daysFromBeginYear % 2 != 0);
    }
}

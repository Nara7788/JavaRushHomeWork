package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sNum1 = reader.readLine();
        String sNum2 = reader.readLine();
        String sNum3 = reader.readLine();
        String sNum4 = reader.readLine();

        int nNum1 = Integer.parseInt(sNum1);
        int nNum2 = Integer.parseInt(sNum2);
        int nNum3 = Integer.parseInt(sNum3);
        int nNum4 = Integer.parseInt(sNum4);

        System.out.println(maxFromTwo(maxFromTwo(nNum1, nNum2), maxFromTwo(nNum3, nNum4)));
    }

    static int maxFromTwo(int num1, int num2)
    {
        if (num1 > num2)
            return num1;
        else
            return num2;
    }
}

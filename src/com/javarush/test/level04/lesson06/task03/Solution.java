package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        int nNum1 = Integer.parseInt(sNum1);
        int nNum2 = Integer.parseInt(sNum2);
        int nNum3 = Integer.parseInt(sNum3);

        int maxNum = maxFromTwo(maxFromTwo(nNum1, nNum2), nNum3);
        int minNum = minFromTwo(minFromTwo(nNum1, nNum2), nNum3);
        int midNum;
        if (nNum1 != maxNum && nNum1 != minNum)
            midNum = nNum1;
        else if (nNum2 != maxNum && nNum2 != minNum)
            midNum = nNum2;
        else midNum = nNum3;

        System.out.println(maxNum);
        System.out.println(midNum);
        System.out.println(minNum);
    }

    static int maxFromTwo(int num1, int num2)
    {
        if (num1 > num2)
            return num1;
        else
            return num2;
    }

    static int minFromTwo(int num1, int num2)
    {
        if (num1 < num2)
            return num1;
        else
            return num2;
    }
}

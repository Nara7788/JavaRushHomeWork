package com.javarush.test.level04.lesson16.home02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

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

        System.out.println(middleFromThree(nNum1, nNum2, nNum3));
    }

    static int middleFromThree(int num1, int num2, int num3)
    {
        if (num1 >= num2 && num1 <= num3 || num1 >= num3 && num1 <= num2)
            return num1;
        else if (num2 >= num1 && num2 <= num3 || num2 >= num3 && num2 <= num1)
            return num2;
        else
            return num3;
    }


}

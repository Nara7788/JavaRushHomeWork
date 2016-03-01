package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());

        new Solution().nod(num1, num2);
    }

    public void nod(int num1, int num2)
    {
        int smallest;
        int result = 0;
        if (num1 > num2)
            smallest = num2;
        else
            smallest = num1;

        for (int i = smallest; i >= 0; i--)
        {
            if (num1 % i == 0 && num2 % i == 0)
            {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}

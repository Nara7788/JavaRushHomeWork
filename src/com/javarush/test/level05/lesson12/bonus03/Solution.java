package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int count = Integer.parseInt(reader.readLine());
        int[] arr = new int[count];

        for (int i = 0; i < count; i++)
        {
            if (i == 0){
                arr[i] = Integer.parseInt(reader.readLine());
                maximum = arr[i];
                continue;
            }
            arr[i] = Integer.parseInt(reader.readLine());
            if (maximum < arr[i])
            {
                maximum = arr[i];
            }
        }


        System.out.println(maximum);
    }

}

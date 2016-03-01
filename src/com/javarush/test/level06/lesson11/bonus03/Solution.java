package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++)
        {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        bubleSort(arr);
        for(int num : arr)
        {
            System.out.println(num);
        }
    }

    static int[] bubleSort(int[] arr)
    {
        int tempNum = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    tempNum = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tempNum;
                }
            }
        }

        return arr;
    }
}

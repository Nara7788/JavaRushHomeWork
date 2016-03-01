package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new CharConversionException();
        }
        catch (CharConversionException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new FileNotFoundException();
        }
        catch (FileNotFoundException e)
        {
            exceptions.add(e);
        }


        try
        {
            throw new InterruptedException();
        }
        catch (InterruptedException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalAccessException();
        }
        catch (IllegalAccessException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NotSerializableException();
        }
        catch (NotSerializableException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new StreamCorruptedException();
        }
        catch (StreamCorruptedException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new UnsupportedEncodingException();
        }
        catch (UnsupportedEncodingException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new UTFDataFormatException();
        }
        catch (UTFDataFormatException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }

    }
}

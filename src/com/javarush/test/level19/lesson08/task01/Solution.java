package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
Вывести модифицированную строку в консоль.
*/


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        PrintStream original = System.out;
        ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
        PrintStream fake = new MyPrintStream(new PrintStream(byteArr));
        System.setOut(fake);

        testString.printSomething();
        String s = byteArr.toString();

        System.out.println("sdadasda");
        String s2 = byteArr.toString();


        System.setOut(original);
        System.out.println(s);
        System.out.println(s2);

        byteArr.close();
        fake.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }

    static class MyPrintStream extends PrintStream
    {
        PrintStream printStream;

        public MyPrintStream(PrintStream stream)
        {
            super(stream);
            this.printStream = stream;
        }

        @Override
        public void println(String x)
        {
            printStream.println(x.toUpperCase());
        }

        @Override
        public void close()
        {
            printStream.close();
        }
    }
}

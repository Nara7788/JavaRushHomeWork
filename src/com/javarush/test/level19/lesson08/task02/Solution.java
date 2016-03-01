package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream origin = System.out;

        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        PrintStream myPS = new MyPrintStream(new PrintStream(byteArrayOS));
        System.setOut(myPS);

        testString.printSomething();

        System.setOut(origin);

        System.out.println(byteArrayOS);

        byteArrayOS.close();
        myPS.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }

    public static class MyPrintStream extends PrintStream{
        PrintStream printStream;

        public MyPrintStream(PrintStream out) {
            super(out);
            this.printStream = out;
        }

        @Override
        public void println(String x) {
            String newString = x.replaceAll("te", "??");
            printStream.println(newString);
        }
    }
}

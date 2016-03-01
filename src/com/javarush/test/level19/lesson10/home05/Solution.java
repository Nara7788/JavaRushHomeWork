package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader from = new BufferedReader(new FileReader(args[0]));
        BufferedWriter to = new BufferedWriter(new FileWriter(args[1]));
        String currentLine;

        while ((currentLine = from.readLine()) != null) {
            String[] wordsArray = currentLine.split(" ");
            for (String word : wordsArray) {
                if (isHasNum(word))
                    to.write(word + " ");
            }
        }
        from.close();
        to.close();
    }

    public static boolean isHasNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                return true;
        }
        return false;
    }
}

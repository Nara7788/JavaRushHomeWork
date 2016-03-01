package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        for (Word w : detectAllWords(crossword, "home", "same", "prom")) {
            System.out.println(w);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Set<Word> resultList = new HashSet<>();
        for (String word : words) {
            findAllWords(word, crossword, resultList);
        }

        return new ArrayList<Word>(resultList);
    }

    public static void findAllWords(String word, int[][] matrix, Set<Word> resultList) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (word.charAt(0) == matrix[y][x]) {
                    List<Coords> alreadyUsedChars = new ArrayList<>();
                    alreadyUsedChars.add(new Coords(x, y));
                    findWord(word, 1, new Coords(x, y), matrix, new Coords(x, y), alreadyUsedChars, resultList);
                }
            }
        }
    }


    public static void findWord(String word, int num, Coords charCoord, int[][] matrix,
                                Coords firstLetter, List<Coords> alreadyUsedChars, Set<Word> resultList) {
        for (Coords cor : getCharsAround(matrix, charCoord.getX(), charCoord.getY())) {
            if (matrix[cor.getY()][cor.getX()] == word.charAt(num) && !alreadyUsedChars.contains(cor)) {
                //if char is last
                if (num == word.length() - 1) {
                    Word w = new Word(word);
                    w.setStartPoint(firstLetter.getX(), firstLetter.getY());
                    w.setEndPoint(cor.getX(),cor.getY());
                    resultList.add(w);
                } else { //go deeper
                    findWord(word, num + 1, cor, matrix, firstLetter, alreadyUsedChars, resultList);
                }
            }
        }
    }

    public static List<Coords> getCharsAround(int[][] a, int x, int y) {
        List<Coords> list = new ArrayList<>();

        // looking for coords around our start point
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {

                if (isExist(j, i, a)) {  // if coords inside matrix
                    Coords c = new Coords(j, i);
                    list.add(c);
                }
            }
        }
        return list;
    }

    public static boolean isExist(int x, int y, int[][] a) {
        try {
            int i = a[y][x];
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            if (endX != word.endX) return false;
            if (endY != word.endY) return false;
            if (startX != word.startX) return false;
            if (startY != word.startY) return false;
            if (text != null ? !text.equals(word.text) : word.text != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = text != null ? text.hashCode() : 0;
            result = 31 * result + startX;
            result = 31 * result + startY;
            result = 31 * result + endX;
            result = 31 * result + endY;
            return result;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

class Coords {
    int x, y;

    Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coords coords = (Coords) o;

        if (x != coords.x) return false;
        if (y != coords.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static List<Coords> list = new ArrayList<>();
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        Coords startPoint;
        int counter = 0;
        while ((startPoint = findOne(a)) != null) {
            addAroundCoordsToList(a, startPoint);
            while (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    addAroundCoordsToList(a, list.get(i));
                }
                list.clear();
            }
            counter++;
        }

        return counter;
    }

    //find another not null element in matrix
    public static Coords findOne(byte[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    return new Coords(j, i);
                }
            }
        }
        return null;
    }

    public static boolean addAroundCoordsToList(byte[][] a, Coords startPoint) {
        int x = startPoint.getX();
        int y = startPoint.getY();
        int counter = 0;
        a[y][x] = 0;

        // looking for coords around our start point
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {

                if (hasNumber(i, j, a)) {  // if coords inside matrix
                    if (a[i][j] != 0) {    // and if not null
                        Coords c = new Coords(j, i);

                        if (!list.contains(c)) { // check if coords is not already in list
                            list.add(c);
                            a[i][j] = 0;
                            counter++;
                        }
                    }
                }
            }
        }


        if (counter == 0)
            return false;
        else
            return true;
    }

    public static boolean hasNumber(int x, int y, byte[][] a) {
        try {
            byte b = a[y][x];
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
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

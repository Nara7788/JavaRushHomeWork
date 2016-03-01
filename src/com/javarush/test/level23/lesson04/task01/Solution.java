package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] solArray = new Solution[2];
        Solution sol1 = new Solution();
        Solution sol2 = new Solution();

        sol1.innerClasses[0] = new Solution().new InnerClass();
        sol1.innerClasses[1] = new Solution().new InnerClass();
        sol2.innerClasses[0] = new Solution().new InnerClass();
        sol2.innerClasses[1] = new Solution().new InnerClass();

        solArray[0] = sol1;
        solArray[1] = sol2;

        return solArray;
    }
}

package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(int i){}
    public Solution(String s){}
    public Solution(Object o){}

    private Solution(double i){}
    private Solution(short s){}
    private Solution(byte o){}

    protected Solution(char i){}
    protected Solution(boolean s){}
    protected Solution(float o){}

    Solution(Double i){}
    Solution(Float s){}
    Solution(Integer o){}
}


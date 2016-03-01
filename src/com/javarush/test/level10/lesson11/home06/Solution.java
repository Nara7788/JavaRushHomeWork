package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private String surname;
        private String adress;
        private int age;
        private int weight;
        private int height;


        public Human(int weight, String surname, String name)
        {
            this.weight = weight;
            this.surname = surname;
            this.name = name;
        }

        public Human(String name, int age, int height)
        {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public Human(String name, String adress, int weight)
        {

            this.name = name;
            this.adress = adress;
            this.weight = weight;
        }

        public Human(String name)
        {

            this.name = name;
        }

        public Human(String name, String surname)
        {

            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, String adress)
        {

            this.name = name;
            this.surname = surname;
            this.adress = adress;
        }

        public Human(String name, String surname, String adress, int age)
        {

            this.name = name;
            this.surname = surname;
            this.adress = adress;
            this.age = age;
        }

        public Human(String name, String surname, String adress, int age, int weight)
        {

            this.name = name;
            this.surname = surname;
            this.adress = adress;
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, int height)
        {
            this.name = name;
            this.height = height;
        }

        public Human(String name, String surname, String adress, int age, int weight, int height)
        {

            this.name = name;
            this.surname = surname;
            this.adress = adress;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }
    }
}

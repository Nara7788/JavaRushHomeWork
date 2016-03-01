package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human kid1 = new Human("Васька", true, 12, null);
        Human kid2 = new Human("Гаська", true, 13, null);
        Human kid3 = new Human("Муська", false, 14, null);
        ArrayList<Human> kids = new ArrayList<>();
        kids.add(kid1);
        kids.add(kid2);
        kids.add(kid3);
        Human father = new Human("Николай", true, 40, kids);
        Human mother = new Human("Жанная", false, 43, kids);
        ArrayList<Human> kids2 = new ArrayList<>();
        kids2.add(father);
        ArrayList<Human> kids3 = new ArrayList<>();
        kids3.add(mother);
        Human gFather1 = new Human("Пётр", true, 67, kids2);
        Human gMother1 = new Human("Ирина", false, 65, kids2);
        Human gFather2 = new Human("Пётр2", true, 67, kids3);
        Human gMother2 = new Human("Ирина2", false, 65, kids3);

        System.out.println(gFather1);
        System.out.println(gMother1);
        System.out.println(gFather2);
        System.out.println(gMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(kid1);
        System.out.println(kid2);
        System.out.println(kid3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (children!=null)
            this.children.addAll(children);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

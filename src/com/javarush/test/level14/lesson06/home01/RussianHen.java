package com.javarush.test.level14.lesson06.home01;


class RussianHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 5;
    }

    @Override
    String getDescription()
    {
        String s = super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }
}

package com.javarush.test.level14.lesson06.home01;

class BelarusianHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 8;
    }

    String getDescription()
    {
        String s = super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }
}

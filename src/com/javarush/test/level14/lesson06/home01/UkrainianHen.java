package com.javarush.test.level14.lesson06.home01;

class UkrainianHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 7;
    }

    String getDescription()
    {
        String s = super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }
}

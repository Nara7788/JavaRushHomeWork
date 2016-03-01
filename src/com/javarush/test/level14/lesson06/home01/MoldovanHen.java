package com.javarush.test.level14.lesson06.home01;

class MoldovanHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 4;
    }

    String getDescription()
    {
        String s = super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }
}
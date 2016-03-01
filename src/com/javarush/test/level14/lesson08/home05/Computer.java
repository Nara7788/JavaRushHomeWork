package com.javarush.test.level14.lesson08.home05;

public class Computer
{
    private Monitor monitor;
    private Mouse mouse;
    private Keyboard keyboard;

    public Computer()
    {
        this.monitor = new Monitor();
        this.mouse = new Mouse();
        this.keyboard = new Keyboard();
    }

    public Computer(Monitor monitor, Mouse mouse, Keyboard keyboard)
    {
        this.monitor = monitor;
        this.mouse = mouse;
        this.keyboard = keyboard;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }
}

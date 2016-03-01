package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Молния", 3, 0));
        game.getHorses().add(new Horse("Счастливец", 3, 0));
        game.getHorses().add(new Horse("Угрюмый", 3, 0));
        game.run();
        game.printWinner();
    }

    public Horse getWinner() {
        int winner = 0;
        double maxDistance = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > maxDistance) {
                maxDistance = horses.get(i).getDistance();
                winner = i;
            }
        }
        return horses.get(winner);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        System.out.println();
        System.out.println();
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }
}

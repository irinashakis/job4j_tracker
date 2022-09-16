package ru.job4j.poly;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по трассе");
    }

    @Override
    public void traffic() {
        System.out.println(getClass().getSimpleName() + " ходит несколько раз в день");
    }
}

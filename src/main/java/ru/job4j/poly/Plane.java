package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }

    @Override
    public void traffic() {
        System.out.println(getClass().getSimpleName() + " летает каждый день");
    }
}

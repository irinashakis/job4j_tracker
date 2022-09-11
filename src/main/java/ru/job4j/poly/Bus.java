package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус везет пассажиров.");
    }

    @Override
    public void passengers(int people) {
        System.out.println("Пассажиров " + people + " человек.");
    }

    @Override
    public double refuel(double fuel) {
        double price = 47.15;
        return fuel * price;
    }
}

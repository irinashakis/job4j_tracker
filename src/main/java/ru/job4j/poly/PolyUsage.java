package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Autobus();
        Vehicle plane = new Plane();
        Vehicle train = new Train();

        Vehicle[] vehicle = new Vehicle[]{bus, plane, train};
        for (Vehicle v : vehicle) {
            v.move();
            v.traffic();
        }
    }
}

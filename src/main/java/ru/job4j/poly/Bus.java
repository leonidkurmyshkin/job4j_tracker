package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Go !");
    }

    @Override
    public void passengers(int numbers) {
        System.out.println("There are " + numbers + " passengers on the bus now");
    }

    @Override
    public double refuel(int numbers) {
        double price = 45.4;
        return price * numbers;
    }
}

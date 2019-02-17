package by.itacademy.jd1.lesson10.homework.task2;

import java.util.Objects;

public class SportCar extends Car {

    private double clearance;

    public SportCar(String producer, String model, int year, Engine engine, Color color, double clearance) {
        super(producer, model, year, engine, color);
        this.clearance = clearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportCar)) return false;
        if (!super.equals(o)) return false;
        SportCar sportCar = (SportCar) o;
        return Double.compare(sportCar.clearance, clearance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clearance);
    }

    @Override
    public String toString() {
        return "[" + getProducer() + "-" + getModel() + ", " + getEngine() +
                ", " + getColor() + ", " + clearance + "]";
    }
}

package by.itacademy.jd1.lesson10.homework.task2;

import java.util.Objects;

public class OffRoadCar extends Car {

    private String wheelFormula;

    public OffRoadCar(String producer, String model, int year, Engine engine, Color color, String wheelFormula) {
        super(producer, model, year, engine, color);
        this.wheelFormula = wheelFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OffRoadCar)) return false;
        if (!super.equals(o)) return false;
        OffRoadCar that = (OffRoadCar) o;
        return Objects.equals(wheelFormula, that.wheelFormula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wheelFormula);
    }

    @Override
    public String toString() {
        return "[" + getProducer() + "-" + getModel() + ", " + getEngine() +
                ", " + getColor() + ", " + wheelFormula + "]";
    }
}

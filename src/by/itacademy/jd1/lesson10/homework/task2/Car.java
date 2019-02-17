package by.itacademy.jd1.lesson10.homework.task2;

import java.util.Objects;

public abstract class Car {

    private String producer;
    private String model;
    private int year;
    private Engine engine;
    private Color color;

    public Car(String producer, String model, int year, Engine engine, Color color) {
        this.producer = producer;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.color = color;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.getProducer()) &&
                Objects.equals(model, car.getModel()) &&
                Objects.equals(engine, car.getEngine()) &&
                color == car.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, engine, color);
    }

    @Override
    public String toString() {
        return "[" + producer + "-" + model + ", " + engine + ", " + color + "]";
    }
}

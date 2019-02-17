package by.itacademy.jd1.lesson10.homework.task2;

import java.util.Objects;

public class Truck extends Car {

    private Trailer trailer;

    public Truck(String producer, String model, int year, Engine engine, Color color) {
        super(producer, model, year, engine, color);
    }

    public Truck(String producer, String model, int year, Engine engine, Color color, Trailer trailer) {
        super(producer, model, year, engine, color);
        this.trailer = trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public void removeTrailer() {
        trailer = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}

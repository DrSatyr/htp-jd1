package by.itacademy.jd1.lesson10.homework.task2;

import java.util.Objects;

public class Trailer {

    private double loadCapacity;

    public Trailer(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trailer)) return false;
        Trailer trailer = (Trailer) o;
        return Double.compare(trailer.getLoadCapacity(), loadCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadCapacity);
    }
}

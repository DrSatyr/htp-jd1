package by.itacademy.jd1.lesson10.homework.task2;

import java.util.Objects;

class Engine {

    private String producer;
    private Type type;
    private double volume;

    public Engine(String producer, Engine.Type type, double volume) {
        this.producer = producer;
        this.type = type;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return type + "-" + volume;
    }

    public String getProducer() {
        return producer;
    }

    public Type getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        Engine engine = (Engine) o;
        return Double.compare(engine.getVolume(), volume) == 0 &&
                Objects.equals(producer, engine.getProducer()) &&
                type == engine.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, type, volume);
    }

    protected enum Type {

        DIESEL,
        GASOLINE
    }
}

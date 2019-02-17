package by.itacademy.jd1.lesson10.homework.task2;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Garage {

    private Map<Car, Integer> carCounter;
    private List<Car> cars;

    public Garage() {
        cars = new LinkedList<>();
        carCounter = new HashMap<>();
    }

    /**
     * Put given car to the garage.
     *
     * @param car
     * @return - parking place number, used to pick up car back! If this car is
     * already in the garage - return -1
     */
    public int putCar(@NotNull Car car) {
        int parkingNumber = -1;
        if (findExactlyThisCar(car) == null) {
            cars.add(car);
            increaseCarCounter(car);
            parkingNumber = cars.size() - 1;
        }
        return parkingNumber;
    }

    /**
     * PickUp car from parking by parking number
     *
     * @param parkingNumber
     * @return Car object
     */
    public Car pickUpCar(int parkingNumber) {
        Car car = null;
        if (parkingNumber >= 0 && cars.size() - 1 >= parkingNumber) {
            car = cars.get(parkingNumber);
            cars.remove(parkingNumber);
            reduceCarCounter(car);
        }
        return car;
    }

    public int getNumberOfEqualsCars(Car car) {
        return Objects.nonNull(carCounter.get(car)) ? carCounter.get(car) : 0;
    }

    @Override
    public String toString() {
        return "Garage{" + carCounter + '}';
    }

    private void increaseCarCounter(@NotNull Car car) {
        if (carCounter.containsKey(car)) {
            carCounter.put(car, carCounter.get(car) + 1);
        } else {
            carCounter.put(car, 1);
        }
    }

    private void reduceCarCounter(@NotNull Car car) {
        if (carCounter.containsKey(car)) {
            if (carCounter.get(car) > 1) {
                carCounter.put(car, carCounter.get(car) - 1);
            } else {
                carCounter.remove(car);
            }
        }
    }

    private Car findExactlyThisCar(Car car) {
        Car findedCar = null;
        for (Car currentCar : cars) {
            if (car == currentCar) {
                findedCar = car;
                break;
            }
        }
        return findedCar;
    }
}

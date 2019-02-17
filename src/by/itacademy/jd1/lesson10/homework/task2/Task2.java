package by.itacademy.jd1.lesson10.homework.task2;

public class Task2 {

    public static void main(String[] args) {
        Garage garage = new Garage();
        Truck ford1 = new Truck("Ford", "A1", 2019,
                new Engine("Ford", Engine.Type.DIESEL, 5.0),
                Color.BLACK, new Trailer(20));
        Truck ford2 = new Truck("Ford", "A1", 2018,
                new Engine("Ford", Engine.Type.DIESEL, 5.0),
                Color.BLACK, new Trailer(40));
        SportCar porsche1 = new SportCar("Porsche", "Q100", 2000,
                new Engine("Porsche", Engine.Type.GASOLINE, 4.0),
                Color.GREEN, 20);
        SportCar porsche2 = new SportCar("Porsche", "Q100", 1999,
                new Engine("Porsche", Engine.Type.GASOLINE, 4.0),
                Color.GREEN, 30);
        SportCar porsche3 = new SportCar("Porsche", "Q100", 1999,
                new Engine("Porsche", Engine.Type.GASOLINE, 4.0),
                Color.GREEN, 20);
        OffRoadCar hilux = new OffRoadCar("Toyota", "Hilux", 2015,
                new Engine("Toyota", Engine.Type.DIESEL, 4.0),
                Color.GRAY, "4X4");

        int parkingNumber1 = garage.putCar(ford1);
        int parkingNumber2 = garage.putCar(ford2);
        int parkingNumber3 = garage.putCar(porsche1);
        int parkingNumber4 = garage.putCar(porsche2);
        int parkingNumber5 = garage.putCar(porsche3);
        int parkingNumber6 = garage.putCar(hilux);

        System.out.println("Arrived 6 cars: \n" + garage);
        System.out.println();

        Car car = garage.pickUpCar(parkingNumber4);
        Car car2 = garage.pickUpCar(parkingNumber3);
        Car car3 = garage.pickUpCar(parkingNumber3);
        System.out.println("Picked Up 3 cars: " + car + " " + car2);
        System.out.println("Current garage state: \n" + garage);
        System.out.println();

        System.out.println("How much Toyota Hilux in garage now: " + garage.getNumberOfEqualsCars(hilux));
        System.out.println("How much Porsche Q100 in garage now: " + garage.getNumberOfEqualsCars(car3));
    }
}

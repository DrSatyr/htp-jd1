package by.itacademy.jd1.lesson16.homework;

import by.itacademy.jd1.common.utils.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Servant implements Runnable {

    private final PlaygroundState state;
    private MadScientist owner;
    private String name;
    private long speed;
    private final int cargoCapacity;

    public Servant(PlaygroundState state, MadScientist owner, String name) {
        this.name = name;
        this.owner = owner;
        this.state = state;
        this.speed = RandomUtils.nextInt(9) + 1;
        this.cargoCapacity = 4;
    }

    @Override
    public void run() {
        synchronized (state) {
            while (state.getDaysCounter() <= state.getTotalDays()) {
                int partsToCatch = RandomUtils.nextInt(cargoCapacity - 1) + 1;
                while (partsToCatch > 0 && state.getDump().size() > 0) {
                    RobotParts part = state.getDump().pop();
                    System.out.println(name + " catch the " + part);
                    transferPart(part);
                    partsToCatch--;
                }
                System.out.println(name + " awaiting next day!");
                waitNextDay();
            }
        }
    }

    private void waitNextDay() {
        try {
            state.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void transferPart(RobotParts part) {
        try {
            state.wait(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        owner.receivePart(part);
        System.out.printf("%s transfer %s to the %s in %d ms%s",
                name, part, owner.getName(), speed, System.lineSeparator());
    }
}

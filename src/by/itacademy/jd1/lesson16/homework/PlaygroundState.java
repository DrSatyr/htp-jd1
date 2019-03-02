package by.itacademy.jd1.lesson16.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.Stack;

@AllArgsConstructor
@Getter
public class PlaygroundState {

    private final int totalDays;
    private final long delay;
    private final int initialDumpCapacity;
    private final int maxRefill;
    private final Stack<RobotParts> dump = new Stack<>();
    private int daysCounter = 1;

    public PlaygroundState() {
        this.totalDays = 100;
        this.delay = 100L;
        this.initialDumpCapacity = 20;
        this.maxRefill = 4;
    }

    public void countNextDay() {
        daysCounter++;
    }

    public void start(Plant plant, Servant firstServant, Servant secondServant) throws InterruptedException {
        Thread plantTread = new Thread(plant);
        Thread firstServantThread = new Thread(firstServant);
        Thread secondServantThread = new Thread(secondServant);
        plantTread.start();
        firstServantThread.start();
        secondServantThread.start();
        firstServantThread.join();
        secondServantThread.join();
        plantTread.join();
    }

    public Optional<MadScientist> whoWins(MadScientist first, MadScientist second) {
        Optional<MadScientist> winner = Optional.empty();
        if (first.countRobots() > second.countRobots()) {
            winner = Optional.of(first);
        }
        if (first.countRobots() < second.countRobots()) {
            winner = Optional.of(second);
        }
        return winner;
    }
}

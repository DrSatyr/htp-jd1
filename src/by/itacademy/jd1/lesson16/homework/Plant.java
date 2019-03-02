package by.itacademy.jd1.lesson16.homework;

import by.itacademy.jd1.common.utils.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.IntStream;

@AllArgsConstructor
public class Plant implements Runnable {

    private final PlaygroundState state;
    @Getter
    private String name;

    @Override
    public void run() {
        synchronized (state) {
            fillDump(state.getInitialDumpCapacity());
            while (state.getDaysCounter() <= state.getTotalDays()) {
                System.out.println("Day: " + state.getDaysCounter());
                int random = RandomUtils.nextInt(state.getMaxRefill());
                fillDump(random);
                System.out.println(name + ": drops to the dump " + random + " parts");
                System.out.println("Dump contains " + state.getDump().size() + " parts");
                state.notifyAll();
                waitingNextDay();
                state.countNextDay();
                System.out.println("**********************************");
            }
            state.notifyAll();
        }
    }

    private void waitingNextDay() {
        try {
            state.wait(state.getDelay());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fillDump(int count) {
        IntStream.range(0, count)
                .mapToObj(it -> getRandomPart())
                .forEach(state.getDump()::add);
    }

    private RobotParts getRandomPart() {
        return RobotParts.values()[RandomUtils.nextInt(RobotParts.size())];
    }
}

package by.itacademy.jd1.lesson16.homework;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        PlaygroundState state = new PlaygroundState();
        Plant plant = new Plant(state, "Plant");
        MadScientist firstScientist = new MadScientist("FirstScientist");
        MadScientist secondScientist = new MadScientist("SecondScientist");
        Servant firstServant = new Servant(state, firstScientist, "FirstServant");
        Servant secondServant = new Servant(state, secondScientist, "SecondServant");

        try {
            state.start(plant, firstServant, secondServant);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(firstScientist.getName() + " have " + firstScientist.countRobots() + " robots");
        System.out.println(secondScientist.getName() + " have " + secondScientist.countRobots() + " robots");
        Optional<MadScientist> winner = state.whoWins(firstScientist, secondScientist);
        System.out.println(winner.map(it -> "Winner is: " + it.getName()).orElse("no winners"));
    }
}

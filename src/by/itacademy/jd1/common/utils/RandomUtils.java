package by.itacademy.jd1.common.utils;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtils {

    private Random rand = new Random();

    public int nextInt(int bound){
        return rand.nextInt(bound);
    }
}

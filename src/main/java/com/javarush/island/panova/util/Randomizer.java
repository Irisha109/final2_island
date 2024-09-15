package com.javarush.island.panova.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    private Randomizer(){}

    public static int createRandomNumber(int upperBound){
       return ThreadLocalRandom.current().nextInt(upperBound);

    }
}

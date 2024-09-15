package com.javarush.island.panova;


import com.javarush.island.panova.entities.territory.Island;
import com.javarush.island.panova.entities.territory.Location;
import com.javarush.island.panova.services.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class App {
    private static Semaphore semaphore = new Semaphore(1);
    private static final Integer NUMBER_OF_CORE = 4;
    private static final Integer COUNT_DAYS = 5;

    public static void main(String[] args) {
        start(COUNT_DAYS);


    }

    public static void start(int countDays) {
        Island island = Island.getIsland();
        for (int i = 0; i < countDays; i++) {
            doTasks(island, semaphore);

        }

    }


    public static void doTasks(Island island, Semaphore semaphore) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_CORE);
        for (Location[] location : island.getLocations()) {
            for (int j = 0; j < location.length; j++) {
                executorService.submit(new Task(location[j], semaphore));
            }
        }
        executorService.shutdown();
    }
}

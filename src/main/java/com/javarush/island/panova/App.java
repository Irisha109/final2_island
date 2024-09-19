package com.javarush.island.panova;


import com.javarush.island.panova.entities.territory.Island;
import com.javarush.island.panova.entities.territory.Location;
import com.javarush.island.panova.services.Task;
import com.javarush.island.panova.services.View;

import java.util.Iterator;
import java.util.concurrent.*;

public class App {
    private static Semaphore SEMAPHORE = new Semaphore(1);
    private static final Island ISLAND = Island.getIsland();
    private static final Integer NUMBER_OF_CORE = 4;
    private static final Integer COUNT_DAYS = 15;
    private static final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();


    public static void main(String[] args) {
        start();
    }


    public static void start() {
        for (int i = 0; i < COUNT_DAYS; i++) {
            createQueue();
            doTasks(ISLAND, SEMAPHORE);

        }
    }


    public static void doTasks(Island island, Semaphore semaphore) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_CORE);
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            executorService.submit((Runnable) iterator.next());
            iterator.remove();
        }
        executorService.shutdown();
    }


    public static void createQueue() {
        for (Location[] location : ISLAND.getLocations()) {
            for (int j = 0; j < location.length; j++) {
                queue.add(new Task(location[j], SEMAPHORE));
            }
        }
        queue.add(new View(ISLAND));
    }


}



package com.javarush.island.panova;


import com.javarush.island.panova.entities.territory.Island;
import com.javarush.island.panova.entities.territory.Location;
import com.javarush.island.panova.services.Task;
import com.javarush.island.panova.services.View;

import java.util.Iterator;
import java.util.concurrent.*;

public class App {
    private static final Semaphore SEMAPHORE = new Semaphore(1);
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
            doTasks();

        }
    }


    public static void doTasks() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_CORE);
        Iterator<Runnable> iterator = queue.iterator();
        while (iterator.hasNext()) {
            executorService.submit(iterator.next());
            iterator.remove();
        }
        executorService.shutdown();
    }


    public static void createQueue() {
        for (Location[] location : Island.getLocations()) {
            for (Location value : location) {
                queue.add(new Task(value, SEMAPHORE));
            }
        }
        queue.add(new View());
    }


}



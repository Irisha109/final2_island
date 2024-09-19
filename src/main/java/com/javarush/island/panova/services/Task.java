package com.javarush.island.panova.services;

import com.javarush.island.panova.config.LocationData;
import com.javarush.island.panova.entities.animals.Animal;
import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.enums.PlantType;
import com.javarush.island.panova.entities.plants.Plant;
import com.javarush.island.panova.entities.territory.Location;
import com.javarush.island.panova.util.Helper;
import com.javarush.island.panova.util.Randomizer;
import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;


public class Task implements Runnable {
    private final Location location;
    private final Semaphore semaphore;

    public Task(Location location, Semaphore semaphore) {
        this.location = location;
        this.semaphore = semaphore;

    }

    @SneakyThrows
    @Override
    public void run() {
        try {
            semaphore.acquire();
            animalsLocationEating();
            animalsLocationReproducing();
            plantsGrowing();
            animalsLocationMoving();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }

    public void animalsLocationEating() {
        for (Map.Entry<AnimalType, Set<Animal>> entry : location.getAnimals().entrySet()) {
            for (Animal animal : entry.getValue()) {
                animal.eat(location);
            }
        }
    }

    public void animalsLocationMoving() {
        Set<Animal> copySet = new HashSet<>();
        for (Map.Entry<AnimalType, Set<Animal>> entry : location.getAnimals().entrySet()) {
            copySet.addAll(entry.getValue());
            for (Animal animal : copySet) {
                animal.move(location);
            }
        }
    }

    public void animalsLocationReproducing() {
        for (Map.Entry<AnimalType, Set<Animal>> entry : location.getAnimals().entrySet()) {
            for (Animal animal : entry.getValue()) {
                animal.reproduce(location);
            }
        }
        location.mergeOffspringAndAnimals();
    }

    public void plantsGrowing() {
        int countForAdd =  Randomizer.createRandomNumber(
                LocationData.MAX_NUMBER_PLANT_ONE_SPECIES.get(PlantType.PLANT));
        for (int i = 0; i < countForAdd; i++) {
            if(! Helper.checkMaxNumberPlantOfOneSpecies(location, PlantType.PLANT)){
                return;
            }
            Plant.grow(location);
        }
    }


}

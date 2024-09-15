package com.javarush.island.panova.util;

import com.javarush.island.panova.entities.animals.Animal;
import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.enums.PlantType;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.territory.Island;
import com.javarush.island.panova.entities.territory.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Statistic {

    private Statistic() {
    }

    private static Map<Type, Integer> collectingDataIsland() {
        Island island = Island.getIsland();
        Map<Type, Integer> biomeMap = new HashMap<>();
        Location[][] locations = island.getLocations();

        for (Location[] location : locations) {
            for (int j = 0; j < location.length; j++) {
                for (Map.Entry<AnimalType, Set<Animal>> entry : location[j].getAnimals().entrySet()) {
                    if (biomeMap.containsKey(entry.getKey())) {
                       int oldValue = biomeMap.get(entry.getKey());
                       int newValue = oldValue + entry.getValue().size();
                       biomeMap.replace(entry.getKey(), oldValue, newValue);
                    } else {
                        biomeMap.put(entry.getKey(), Helper.countNumberAnimalOneSpecies(location[j], entry.getKey()));
                    }
                }
                biomeMap.put(PlantType.PLANT, location[j].getPlants().size());
            }

        }
        return biomeMap;
    }

    public static void showStatisticIsland() {
        Map<Type, Integer> statisticData = collectingDataIsland();
        System.out.println();
        statisticData.forEach((type, integer) -> System.out.print(type + ": " + integer + "; "));
        System.out.println();
        System.out.println("<".repeat(150));
    }

    private static Map<Type, Integer> collectingDataLocation(Location location) {

        Map<Type, Integer> biomeMap = new HashMap<>();
        for (AnimalType animalType : AnimalType.values()) {
            Integer count = Helper.countNumberAnimalOneSpecies(location, animalType);
            biomeMap.put(animalType, count);
        }
        biomeMap.put(PlantType.PLANT, location.getPlants().size());

        return biomeMap;
    }

    public static void showStatisticLocation(Location location) {
        Map<Type, Integer> statisticData = collectingDataLocation(location);
        System.out.println(">".repeat(150));
        System.out.print("Location_" + location.getX() + "_" + location.getY() + "-> ");
        statisticData.forEach((type, integer) -> System.out.print(type + ": " + integer + "; "));
        System.out.println();
        System.out.println("<".repeat(150));
    }

}



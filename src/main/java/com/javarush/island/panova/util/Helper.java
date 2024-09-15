package com.javarush.island.panova.util;

import com.javarush.island.panova.config.LocationData;
import com.javarush.island.panova.entities.animals.Animal;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.plants.Plant;
import com.javarush.island.panova.entities.territory.Island;
import com.javarush.island.panova.entities.territory.Location;
import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.impl.Food;
import com.javarush.island.panova.entities.enums.PlantType;

import java.util.*;

public class Helper {

    private Helper() {
    }

    public static boolean checkMaxNumberAnimalOneSpecies(Location location, AnimalType animalType) {
        Map<AnimalType, Set<Animal>> animals = location.getAnimals();
        Map<AnimalType, Set<Animal>> childrenAnimals = location.getOffspringOfAnimals();
        int countChildren = childrenAnimals.containsKey(animalType)? childrenAnimals.get(animalType).size() : 0;
        int countAnimalOfOneSpecies = animals.get(animalType).size() + countChildren;
        return countAnimalOfOneSpecies < LocationData.MAX_NUMBER_ANIMAL_ONE_SPECIES.get(animalType);
    }

    public static Integer countNumberAnimalOneSpecies(Location location, AnimalType animalType) {
        Map<AnimalType, Set<Animal>> animals = location.getAnimals();
        return animals.get(animalType).size();
    }

    public static Set<Animal> getAnimalOfOneSpecies(Location location, AnimalType animalType) {
        Map<AnimalType, Set<Animal>> animals = location.getAnimals();
        return animals.get(animalType);
    }

    public static Set<Food> getSetFoods(Location location, Animal currentAnimal) {
        Map<AnimalType, Set<Animal>> animals = location.getAnimals();
        Set<Plant> plantSet = location.getPlants();
        Set<Food> resultFoods = new HashSet<>();

        if (currentAnimal.getFoodMap().size() == 1 && currentAnimal.getFoodMap().containsKey(PlantType.PLANT)) {
            addPlantTypeInFoodMap(plantSet, resultFoods);
            return resultFoods;
        }

        if (currentAnimal.getFoodMap().containsKey(PlantType.PLANT)) {
            addPlantTypeInFoodMap(plantSet, resultFoods);
        }
        for (Map.Entry<AnimalType, Set<Animal>> entry : animals.entrySet()) {
            if (currentAnimal.getFoodMap().containsKey(entry.getKey())) {
                for (Animal animal : entry.getValue()) {
                    resultFoods.add((Food) animal);
                }
            }
        }

        return resultFoods;
    }

//    public static int countMaxNumberPossiblePlant(PlantType plantType) {
//        return Randomizer.createRandomNumber(
//                LocationData.MAX_NUMBER_PLANT_ONE_SPECIES.get(PlantType.PLANT));
//
//    }

    public static boolean checkMaxNumberPlantOfOneSpecies(Location location, PlantType plantType) {
        int currentNumberOfPlants = location.getPlants().size();
        return currentNumberOfPlants < LocationData.MAX_NUMBER_PLANT_ONE_SPECIES.get(plantType);

    }

    private static void addPlantTypeInFoodMap(Set<Plant> plants, Set<Food> resultFoods) {
        for (Plant plant : plants) {
            resultFoods.add(plant);
        }
    }


}

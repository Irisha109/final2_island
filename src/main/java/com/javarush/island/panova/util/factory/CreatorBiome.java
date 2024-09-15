package com.javarush.island.panova.util.factory;

import com.javarush.island.panova.config.CharacteristicBiome;
import com.javarush.island.panova.config.BiomeData;
import com.javarush.island.panova.config.LocationData;
import com.javarush.island.panova.entities.animals.Animal;


import com.javarush.island.panova.entities.animals.herbivores.*;
import com.javarush.island.panova.entities.animals.predators.*;
import com.javarush.island.panova.entities.plants.Plant;
import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.enums.PlantType;
import com.javarush.island.panova.util.Randomizer;

import java.util.*;


public class CreatorBiome {

    public static Plant createPlant(PlantType plantType) {
        CharacteristicBiome characteristic = BiomeData
                .characteristics
                .get(plantType);

        return new Plant(characteristic.getWeight(), plantType);
    }

    public static Animal createAnimal(AnimalType animalType) {
        CharacteristicBiome characteristic = BiomeData
                .characteristics.get(animalType);
        Animal animal = null;
        switch (animalType) {
            case BOAR:
                animal = new Boar(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case BUFFALO:
                animal = new Buffalo(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case CATERPILLAR:
                animal = new Caterpillar(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case DEER:
                animal = new Deer(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case DUCK:
                animal = new Duck(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case GOAT:
                animal = new Goat(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case HORSE:
                animal = new Horse(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case MOUSE:
                animal = new Mouse(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case RABBIT:
                animal = new Rabbit(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case SHEEP:
                animal = new Sheep(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case BEAR:
                animal = new Bear(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case BOA:
                animal = new Boa(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case EAGLE:
                animal = new Eagle(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case FOX:
                animal = new Fox(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;
            case WOLF:
                animal = new Wolf(animalType,
                        characteristic.getWeight(),
                        characteristic.getMaxSteps(),
                        characteristic.getFoodNeeds(),
                        characteristic.getFoodMap());
                break;

        }
        ;

        return animal;
    }

    public static Set<Animal> createAnimals(AnimalType animalType) {
        Set<Animal> animals = new HashSet<>();
        int numberAnimalOneSpecies = Randomizer.createRandomNumber(
                LocationData.MAX_NUMBER_ANIMAL_ONE_SPECIES.get(animalType));
        for (int i = 0; i < numberAnimalOneSpecies; i++) {
            animals.add(CreatorBiome.createAnimal(animalType));
        }

        return animals;
    }

    public static Set<Plant> createPlants() {
        Set<Plant> plants = new HashSet<>();
        int numberPlantsOneSpecies = Randomizer.createRandomNumber(
                LocationData.MAX_NUMBER_PLANT_ONE_SPECIES.get(PlantType.PLANT));
        for (int i = 0; i < numberPlantsOneSpecies; i++) {
            plants.add(CreatorBiome.createPlant(PlantType.PLANT));
        }
        return plants;
    }

    public static Map<AnimalType, Set<Animal>> createAnimalsMap() {
        Map<AnimalType, Set<Animal>> animalsMap = new HashMap<>();
        Set<Animal> animals = new HashSet<>();
        for (Map.Entry<AnimalType, Integer> entry : LocationData.MAX_NUMBER_ANIMAL_ONE_SPECIES.entrySet()) {
            animalsMap.put(entry.getKey(), createAnimals(entry.getKey()));
        }
        return animalsMap;
    }


}

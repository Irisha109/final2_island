package com.javarush.island.panova.config;

import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.enums.PlantType;


import java.util.HashMap;
import java.util.Map;

public class LocationData {
    private LocationData(){}
    private static final Integer MAX_NUMBER_OF_WOLF = 30;
    private static final Integer MAX_NUMBER_OF_BOA = 30;
    private static final Integer MAX_NUMBER_OF_FOX = 30;
    private static final Integer MAX_NUMBER_OF_BEAR =  5;
    private static final Integer MAX_NUMBER_OF_EAGLE = 20;
    private static final Integer MAX_NUMBER_OF_HORSE = 20;
    private static final Integer MAX_NUMBER_OF_DEER = 20;
    private static final Integer MAX_NUMBER_OF_RABBIT = 150;
    private static final Integer MAX_NUMBER_OF_MOUSE = 500;
    private static final Integer MAX_NUMBER_OF_GOAT = 140;
    private static final Integer MAX_NUMBER_OF_SHEEP = 140;
    private static final Integer MAX_NUMBER_OF_BOAR = 50;
    private static final Integer MAX_NUMBER_OF_BUFFALO = 10;
    private static final Integer MAX_NUMBER_OF_DUCK = 200;
    private static final Integer MAX_NUMBER_OF_CATERPILLAR = 1000;
    private static final Integer MAX_NUMBER_OF_PLANT = 200;

    public static final Integer WIDTH_OF_LOCATIONS = 2;
    public static final Integer HEIGHT_OF_LOCATIONS = 2;

    public static final Map<AnimalType, Integer> MAX_NUMBER_ANIMAL_ONE_SPECIES = new HashMap<>();
    public static final Map<PlantType, Integer> MAX_NUMBER_PLANT_ONE_SPECIES = new HashMap<>();
    static {

        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.WOLF, MAX_NUMBER_OF_WOLF);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.BOA, MAX_NUMBER_OF_BOA);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.FOX, MAX_NUMBER_OF_FOX);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.BEAR, MAX_NUMBER_OF_BEAR);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.EAGLE, MAX_NUMBER_OF_EAGLE);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.HORSE, MAX_NUMBER_OF_HORSE);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.DEER, MAX_NUMBER_OF_DEER);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.RABBIT, MAX_NUMBER_OF_RABBIT);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.MOUSE, MAX_NUMBER_OF_MOUSE);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.GOAT, MAX_NUMBER_OF_GOAT);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.SHEEP, MAX_NUMBER_OF_SHEEP);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.BOAR, MAX_NUMBER_OF_BOAR);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.BUFFALO, MAX_NUMBER_OF_BUFFALO);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.DUCK, MAX_NUMBER_OF_DUCK);
        MAX_NUMBER_ANIMAL_ONE_SPECIES.put(AnimalType.CATERPILLAR, MAX_NUMBER_OF_CATERPILLAR);

        MAX_NUMBER_PLANT_ONE_SPECIES.put(PlantType.PLANT, MAX_NUMBER_OF_PLANT);
    }


}

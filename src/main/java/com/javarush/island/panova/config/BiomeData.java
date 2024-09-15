package com.javarush.island.panova.config;

import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.enums.PlantType;

import java.util.HashMap;
import java.util.Map;

public class BiomeData {
    private BiomeData(){}
    public static Map<Type, CharacteristicBiome> characteristics = new HashMap<>();
    static {
        ////////////////WOLF////////////////////////////////////
        Map<Type, Integer> wolfFoodMap = new HashMap<>();
        wolfFoodMap.put(AnimalType.HORSE, 10);
        wolfFoodMap.put(AnimalType.DEER, 15);
        wolfFoodMap.put(AnimalType.RABBIT, 60);
        wolfFoodMap.put(AnimalType.MOUSE, 80);
        wolfFoodMap.put(AnimalType.GOAT, 60);
        wolfFoodMap.put(AnimalType.SHEEP, 70);
        wolfFoodMap.put(AnimalType.BOAR, 15);
        wolfFoodMap.put(AnimalType.BUFFALO, 10);
        wolfFoodMap.put(AnimalType.DUCK, 40);
        CharacteristicBiome wolf = new CharacteristicBiome(AnimalType.WOLF,50d, 3, 8, wolfFoodMap);

        characteristics.put(AnimalType.WOLF, wolf);

        ////////////////BOA////////////////////////////////////
        Map<Type, Integer> boaFoodMap = new HashMap<>();
        boaFoodMap.put(AnimalType.FOX, 15);
        boaFoodMap.put(AnimalType.RABBIT, 20);
        boaFoodMap.put(AnimalType.MOUSE, 40);
        boaFoodMap.put(AnimalType.DUCK, 10);
        CharacteristicBiome boa = new CharacteristicBiome(AnimalType.BOA, 15d, 1, 3, boaFoodMap);

        characteristics.put(AnimalType.BOA, boa);

        ////////////////FOX////////////////////////////////////
        Map<Type, Integer> foxFoodMap = new HashMap<>();
        foxFoodMap.put(AnimalType.RABBIT, 70);
        foxFoodMap.put(AnimalType.MOUSE, 90);
        foxFoodMap.put(AnimalType.DUCK, 60);
        foxFoodMap.put(AnimalType.CATERPILLAR, 40);
        CharacteristicBiome fox = new CharacteristicBiome(AnimalType.FOX, 8d, 2,2, foxFoodMap);

        characteristics.put(AnimalType.FOX, fox);

        ////////////////BEAR////////////////////////////////////
        Map<Type, Integer> bearFoodMap = new HashMap<>();
        bearFoodMap.put(AnimalType.BOA, 80);
        bearFoodMap.put(AnimalType.HORSE, 40);
        bearFoodMap.put(AnimalType.DEER, 80);
        bearFoodMap.put(AnimalType.RABBIT, 80);
        bearFoodMap.put(AnimalType.MOUSE, 90);
        bearFoodMap.put(AnimalType.GOAT, 70);
        bearFoodMap.put(AnimalType.SHEEP, 70);
        bearFoodMap.put(AnimalType.BOAR, 50);
        bearFoodMap.put(AnimalType.BUFFALO, 20);
        boaFoodMap.put(AnimalType.DUCK, 10);
        CharacteristicBiome bear = new CharacteristicBiome(AnimalType.BEAR, 500d, 2, 80, bearFoodMap);

        characteristics.put(AnimalType.BEAR, bear);

        ////////////////EAGLE////////////////////////////////////
        Map<Type, Integer> eagleFoodMap = new HashMap<>();
        eagleFoodMap.put(AnimalType.FOX, 10);
        eagleFoodMap.put(AnimalType.RABBIT, 90);
        eagleFoodMap.put(AnimalType.MOUSE, 90);
        eagleFoodMap.put(AnimalType.DUCK, 80);
        CharacteristicBiome eagle = new CharacteristicBiome(AnimalType.EAGLE, 6d, 3, 1, eagleFoodMap);

        characteristics.put(AnimalType.EAGLE, eagle);

        ////////////////HORSE////////////////////////////////////
        Map<Type, Integer> horseFoodMap = new HashMap<>();
        horseFoodMap.put(PlantType.PLANT, 100);
        CharacteristicBiome horse = new CharacteristicBiome(AnimalType.HORSE, 400d, 4, 60, horseFoodMap);

        characteristics.put(AnimalType.HORSE, horse);

        ////////////////DEER////////////////////////////////////
        Map<Type, Integer> deerFoodMap = new HashMap<>();
        deerFoodMap.put(PlantType.PLANT, 100);
        CharacteristicBiome deer = new CharacteristicBiome(AnimalType.DEER, 300d, 4, 50, deerFoodMap);

        characteristics.put(AnimalType.DEER, deer);

        ////////////////RABBIT////////////////////////////////////
        Map<Type, Integer> rabbitFoodMap = new HashMap<>();
        rabbitFoodMap.put(PlantType.PLANT, 100);
        CharacteristicBiome rabbit = new CharacteristicBiome(AnimalType.RABBIT, 2d, 2, 0.45d, rabbitFoodMap);

        characteristics.put(AnimalType.RABBIT, rabbit);

        ////////////////MOUSE////////////////////////////////////
        Map<Type, Integer> mouseFoodMap = new HashMap<>();
        mouseFoodMap.put(PlantType.PLANT, 100);
        mouseFoodMap.put(AnimalType.CATERPILLAR, 90);
        CharacteristicBiome mouse = new CharacteristicBiome(AnimalType.MOUSE, 0.05d, 1, 0.01, mouseFoodMap);

        characteristics.put(AnimalType.MOUSE, mouse);

        ////////////////GOAT////////////////////////////////////
        Map<Type, Integer> goatFoodMap = new HashMap<>();
        goatFoodMap.put(PlantType.PLANT, 100);
        CharacteristicBiome goat = new CharacteristicBiome(AnimalType.GOAT, 60d, 3, 10, goatFoodMap);

        characteristics.put(AnimalType.GOAT, goat);

        ////////////////SHEEP////////////////////////////////////
        Map<Type, Integer> sheepFoodMap = new HashMap<>();
        sheepFoodMap.put(PlantType.PLANT, 100);
        CharacteristicBiome sheep = new CharacteristicBiome(AnimalType.SHEEP, 70d, 3, 15, sheepFoodMap);

        characteristics.put(AnimalType.SHEEP, sheep);

        ////////////////BOAR////////////////////////////////////
        Map<Type, Integer> boarFoodMap = new HashMap<>();
        boarFoodMap.put(PlantType.PLANT, 100);
        boarFoodMap.put(AnimalType.MOUSE, 50);
        boarFoodMap.put(AnimalType.CATERPILLAR, 90);
        CharacteristicBiome boar = new CharacteristicBiome(AnimalType.BOAR, 400d, 2, 50, boarFoodMap);

        characteristics.put(AnimalType.BOAR, boar);

        ////////////////BUFFALO////////////////////////////////////
        Map<Type, Integer> buffaloFoodMap = new HashMap<>();
        buffaloFoodMap.put(PlantType.PLANT, 100);
        CharacteristicBiome buffalo = new CharacteristicBiome(AnimalType.BUFFALO, 700d, 3, 100, buffaloFoodMap);

        characteristics.put(AnimalType.BUFFALO, buffalo);

        ////////////////DUCK////////////////////////////////////
        Map<Type, Integer> duckFoodMap = new HashMap<>();
        duckFoodMap.put(PlantType.PLANT, 100);
        duckFoodMap.put(AnimalType.CATERPILLAR, 90);
        CharacteristicBiome duck = new CharacteristicBiome(AnimalType.DUCK, 1d, 4, 0.15, duckFoodMap);

        characteristics.put(AnimalType.DUCK, duck);

        ////////////////CATERPILLAR////////////////////////////////////
        Map<Type, Integer> caterpillarFoodMap = new HashMap<>();
        caterpillarFoodMap.put(PlantType.PLANT, 100);
        CharacteristicBiome caterpillar = new CharacteristicBiome(AnimalType.CATERPILLAR, 0.01, 0, 0, caterpillarFoodMap);

        characteristics.put(AnimalType.CATERPILLAR, caterpillar);

        ////////////////PLANT////////////////////////////////////

        CharacteristicBiome plant = new CharacteristicBiome(PlantType.PLANT, 1d);
        characteristics.put(PlantType.PLANT, plant);




    }

}

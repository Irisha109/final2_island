package com.javarush.island.panova.config;

import com.javarush.island.panova.entities.impl.Type;
import lombok.Getter;

import java.util.Map;

@Getter
public class CharacteristicBiome {
    private final Type type;
    private final double weight;
    private int maxSteps;
    private  double foodNeeds;
    private Map<Type, Integer> foodMap;

    public CharacteristicBiome(Type animalType,
                               Double weight,
                               int maxSteps,
                               double foodNeeds,
                               Map<Type, Integer> foodMap) {
        this.type = animalType;
        this.weight = weight;
        this.maxSteps = maxSteps;
        this.foodNeeds = foodNeeds;
        this.foodMap = foodMap;
    }

    public CharacteristicBiome(Type type, double weight) {
        this.type = type;
        this.weight = weight;
    }




}

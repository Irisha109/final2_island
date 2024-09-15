package com.javarush.island.panova.entities.animals;

import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.impl.Food;
import com.javarush.island.panova.entities.impl.Type;

import java.util.*;

public abstract class Herbivore extends Animal implements Food {
    private final double weight;

    public Herbivore(AnimalType animalType, Double weight, int steps, double foodNeeds, Map<Type, Integer> foodMap) {
        super(animalType, weight, steps, foodNeeds, foodMap);
        this.weight = weight;

    }

    @Override
    public Type getType() {
        return getAnimalType();
    }
    @Override
    public double getWeight(){
        return weight;
    }
}

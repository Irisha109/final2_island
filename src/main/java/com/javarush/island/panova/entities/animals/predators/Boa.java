package com.javarush.island.panova.entities.animals.predators;

import com.javarush.island.panova.entities.animals.Predator;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.impl.Food;


import java.util.Map;

public class Boa extends Predator implements Food {

    public Boa(AnimalType animalType, Double weight, int steps, double foodNeeds, Map<Type, Integer> foodMap) {
        super(animalType, weight, steps, foodNeeds, foodMap);

    }
    @Override
    public Type getType() {
        return getAnimalType();
    }



}

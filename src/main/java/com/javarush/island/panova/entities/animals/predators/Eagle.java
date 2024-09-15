package com.javarush.island.panova.entities.animals.predators;

import com.javarush.island.panova.entities.animals.Predator;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.enums.AnimalType;


import java.util.Map;

public class Eagle extends Predator {
    public Eagle(AnimalType animalType, Double weight, int steps, double foodNeeds, Map<Type, Integer> foodMap) {
        super(animalType, weight, steps, foodNeeds, foodMap);
    }


}

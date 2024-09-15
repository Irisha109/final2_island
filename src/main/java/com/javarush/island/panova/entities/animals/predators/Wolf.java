package com.javarush.island.panova.entities.animals.predators;

import com.javarush.island.panova.entities.animals.Predator;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.enums.AnimalType;


import java.util.Map;

public class Wolf extends Predator {
    public Wolf(AnimalType animalType, Double weight, int steps,  double foodNeeds, Map<Type, Integer> foodMap) {
        super(animalType, weight, steps, foodNeeds, foodMap);
    }


}

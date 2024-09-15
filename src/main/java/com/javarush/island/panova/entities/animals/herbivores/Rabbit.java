package com.javarush.island.panova.entities.animals.herbivores;

import com.javarush.island.panova.entities.animals.Herbivore;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.enums.AnimalType;


import java.util.Map;

public class Rabbit extends Herbivore {
    public Rabbit(AnimalType animalType, Double weight, int steps,  double foodNeeds, Map<Type, Integer> foodMap) {
        super(animalType, weight, steps, foodNeeds, foodMap);
    }
}

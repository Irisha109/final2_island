package com.javarush.island.panova.entities.animals;

import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.impl.Type;


import java.util.*;


public abstract class Predator extends Animal  {

    public Predator(AnimalType animalType, Double weight, int steps, double foodNeeds, Map<Type, Integer> foodMap) {
        super(animalType, weight, steps, foodNeeds, foodMap);

    }





}

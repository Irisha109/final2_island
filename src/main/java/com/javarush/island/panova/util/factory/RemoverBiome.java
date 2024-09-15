package com.javarush.island.panova.util.factory;

import com.javarush.island.panova.entities.animals.Animal;
import com.javarush.island.panova.entities.plants.Plant;

public class RemoverBiome {
    public static void removeAnimal(Animal animal){
        animal = null;
    }
    public static void removePlant(Plant plant){
        plant = null;
    }
}

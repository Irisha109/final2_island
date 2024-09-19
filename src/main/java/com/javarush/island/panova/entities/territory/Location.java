package com.javarush.island.panova.entities.territory;

import com.javarush.island.panova.entities.animals.Animal;
import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.plants.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



@Getter
@Setter
public class Location {
    private int x;
    private int y;
    private Map<AnimalType, Set<Animal>> animals;
    private Map<AnimalType, Set<Animal>> offspringOfAnimals;
    private Set<Plant> plants;

    public Location(int x, int y, Map<AnimalType, Set<Animal>> animals, Set<Plant> plants) {
        this.x = x;
        this.y = y;
        this.animals = animals;
        this.plants = plants;
        this.offspringOfAnimals = new HashMap<>();

    }
    public void mergeOffspringAndAnimals(){
        for(Map.Entry<AnimalType, Set<Animal>> entry: offspringOfAnimals.entrySet()){
            animals.get(entry.getKey()).addAll(entry.getValue());
            entry.getValue().clear();
        }
    }
}

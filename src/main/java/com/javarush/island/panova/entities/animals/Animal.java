package com.javarush.island.panova.entities.animals;


import com.javarush.island.panova.config.LocationData;
import com.javarush.island.panova.entities.enums.AnimalType;
import com.javarush.island.panova.entities.enums.Direction;
import com.javarush.island.panova.entities.enums.Gender;
import com.javarush.island.panova.entities.impl.Food;
import com.javarush.island.panova.entities.impl.Type;
import com.javarush.island.panova.entities.territory.Island;
import com.javarush.island.panova.entities.territory.Location;
import com.javarush.island.panova.util.*;
import com.javarush.island.panova.util.factory.CreatorBiome;
import com.javarush.island.panova.util.factory.RemoverBiome;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public abstract class Animal {
    public static final double EXPENSE_ENERGY_PERCENT = 30;
    public final double expenseEnergyForStep;
    private final AnimalType animalType;
    private final double weight;
    private final int maxSteps;
    private final double foodNeeds;
    private final Map<Type, Integer> foodMap;
    @Setter
    private Gender gender;
    @Setter
    private double healthPoint;

    public Animal(AnimalType animalType, Double weight, int steps, double foodNeeds, Map<Type, Integer> foodMap) {
        this.animalType = animalType;
        this.weight = weight;
        this.maxSteps = steps;
        this.foodNeeds = foodNeeds;
        setGender(Gender.values()[Randomizer.createRandomNumber(Gender.values().length)]);
        healthPoint = foodNeeds;
        this.foodMap = foodMap;
        expenseEnergyForStep = foodNeeds * EXPENSE_ENERGY_PERCENT / 100;
    }


    public void move(Location currentLocation) {
        if (healthPoint <= 0) {
            die();
            return;
        }
        Location nextLocation = chooseDirection(currentLocation);
        if (!currentLocation.equals(nextLocation)
                && Helper.checkMaxNumberAnimalOneSpecies(nextLocation, this.getAnimalType())) {
            nextLocation.getAnimals().get(this.getAnimalType()).add(this);
            currentLocation.getAnimals().get(this.getAnimalType()).remove(this);
            healthPoint -= expenseEnergyForStep;
        } else {
            currentLocation.getAnimals().get(this.getAnimalType()).remove(this);
        }

    }

    public void reproduce(Location location) {
        Set<Animal> animalsOfOneSpecies = Helper.getAnimalOfOneSpecies(location, this.getAnimalType());
        Set<Animal> selectionForReproduce = new HashSet<>();
        for (Animal animal : animalsOfOneSpecies) {
            if (!animal.equals(this)) {
                selectionForReproduce.add(animal);
            }
        }

        Animal child = null;
        boolean isChild = false;
        for (Animal animal : selectionForReproduce) {
            if (this.getGender() != animal.getGender()) {
                child = CreatorBiome.createAnimal(animal.getAnimalType());
                child.setGender(Gender.values()[Randomizer.createRandomNumber(Gender.values().length)]);
                isChild = true;
                healthPoint = healthPoint - expenseEnergyForStep;
                break;
            }
        }

        if (Helper.checkMaxNumberAnimalOneSpecies(location, this.getAnimalType()) && isChild) {
            if (location.getOffspringOfAnimals().containsKey(this.getAnimalType())) {
                location.getOffspringOfAnimals().get(this.getAnimalType()).add(child);
            } else {
                Set<Animal> childSet = new HashSet<>();
                childSet.add(child);
                location.getOffspringOfAnimals().put(this.getAnimalType(), childSet);
            }
        }
    }

    public void eat(Location location) {
        List<Food> foodEaten = new ArrayList<>();
        if (getHealthPoint() == getFoodNeeds()) {
            return;
        }
        Set<Food> foods = Helper.getSetFoods(location, this);
        if (foods.isEmpty()) {
           return;
        }
        double newHealthPoint = getHealthPoint();
        Iterator<Food> iterator = foods.iterator();
        while (newHealthPoint < getFoodNeeds() && iterator.hasNext()) {
            Food food = iterator.next();
            if (foodMap.get(food.getType()) >= Randomizer.createRandomNumber(100)) {
                newHealthPoint += food.getWeight();
                foodEaten.add(food);
            }
        }
        setHealthPoint(Math.min(newHealthPoint, getFoodNeeds()));

        if (!foodEaten.isEmpty()) {
            for (Food food : foodEaten) {
                if (location.getAnimals().containsKey(food.getType())) {
                    location.getAnimals().get(food.getType()).remove((Animal) food);
                }
                if (location.getPlants().contains(food)) {
                    location.getPlants().remove(food);
                }
            }
        }
    }

    public void die() {
        RemoverBiome.removeAnimal(this);
    }

    private Location chooseDirection(Location location) {
        int index = Randomizer.createRandomNumber(Direction.values().length);
        Direction direction = Direction.values()[index];
        int step = Randomizer.createRandomNumber(maxSteps + 1);

        int newX = location.getX();
        int newY = location.getY();
        switch (direction) {
            case UP:
                newY += step;
                break;
            case DOWN:
                newY -= step;
                break;
            case LEFT:
                newX -= step;
                break;
            case RIGHT:
                newX += step;
                break;
            case STAND_STILL:
                break;

        }
        if (newX < 0 || newX >= LocationData.WIDTH_OF_LOCATIONS
                || newY < 0 || newY >= LocationData.HEIGHT_OF_LOCATIONS) {
            return location;
        } else {
            return Island.getIsland().locationAt(newX, newY);
        }
    }

}




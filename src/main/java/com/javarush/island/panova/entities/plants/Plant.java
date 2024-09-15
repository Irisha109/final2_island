package com.javarush.island.panova.entities.plants;

import com.javarush.island.panova.entities.impl.Food;
import com.javarush.island.panova.entities.territory.Location;
import com.javarush.island.panova.util.Helper;
import com.javarush.island.panova.util.factory.CreatorBiome;
import com.javarush.island.panova.entities.enums.PlantType;
import com.javarush.island.panova.util.factory.RemoverBiome;
import com.javarush.island.panova.entities.impl.Type;
import lombok.Getter;

@Getter
public class Plant implements Food {
    private final PlantType plantType;
    private final double weight;


    public Plant(Double weight, PlantType plantType) {
        this.weight = weight;
        this.plantType = plantType;

    }

    public static void grow(Location location) {
         location.getPlants().add(CreatorBiome.createPlant(PlantType.PLANT));
    }

    public void beEaten() {
        RemoverBiome.removePlant(this);
    }

    @Override
    public Type getType() {
        return plantType;
    }


}

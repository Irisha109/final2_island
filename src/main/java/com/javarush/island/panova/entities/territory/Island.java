package com.javarush.island.panova.entities.territory;

import com.javarush.island.panova.config.LocationData;
import com.javarush.island.panova.util.factory.CreatorBiome;
import lombok.Getter;


public class Island {
    private static final Island ISLAND = new Island();
    @Getter
    private static Location[][] locations = createLocations();

    private Island() { }

    private static Location[][] createLocations() {
        Location[][] locations = new Location[LocationData.WIDTH_OF_LOCATIONS][LocationData.HEIGHT_OF_LOCATIONS];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location(i, j, CreatorBiome.createAnimalsMap(), CreatorBiome.createPlants());
            }
        }
        return locations;

    }

    public Location locationAt(int x, int y) {
        return locations[x][y];
    }

    public static Island getIsland() {
        return ISLAND;
    }

}

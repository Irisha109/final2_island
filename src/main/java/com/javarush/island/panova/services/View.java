package com.javarush.island.panova.services;

import com.javarush.island.panova.entities.territory.Island;
import com.javarush.island.panova.util.Statistic;

public class View implements Runnable{
    private Island island;

    public View(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        Statistic.showStatisticIsland(island);
    }
}

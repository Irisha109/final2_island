package com.javarush.island.panova.services;

import com.javarush.island.panova.util.Statistic;

public class View implements Runnable{


    @Override
    public void run() {
        Statistic.showStatisticIsland();
    }
}

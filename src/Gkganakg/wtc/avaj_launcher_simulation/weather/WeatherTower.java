package Gkganakg.wtc.avaj_launcher_simulation.weather;

import Gkganakg.wtc.avaj_launcher_simulation.Aircraft.Coordinates;

import java.lang.String;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){

        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        this.conditionsChanged();

    }



}
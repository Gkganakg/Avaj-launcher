package Gkganakg.wtc.avaj_launcher_simulation;

import java.lang.String;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){

        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        this.conditionsChanged();

    }



}
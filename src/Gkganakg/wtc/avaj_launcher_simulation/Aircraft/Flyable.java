package Gkganakg.wtc.avaj_launcher_simulation.Aircraft;

import Gkganakg.wtc.avaj_launcher_simulation.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
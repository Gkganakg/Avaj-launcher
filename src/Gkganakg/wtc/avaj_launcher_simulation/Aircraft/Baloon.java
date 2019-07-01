package Gkganakg.wtc.avaj_launcher_simulation.Aircraft;

import Gkganakg.wtc.avaj_launcher_simulation.*;
import Gkganakg.wtc.avaj_launcher_simulation.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String type = weatherTower.getWeather(coordinates);

        switch (type) {
            case "SUN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): Its too hot we have to hurry up and get to the destination melts"));
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case "RAIN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): Its raining the baloon will be messed up "));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);


                break;
            case "FOG":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): oh here we go again the Fog is back"));
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): Its so cold cause of this Snow we have to land no long "));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);


                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
            MessageLog.pushMessage(("Tower Says: "+ this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id +")" + " Landing"));
            MessageLog.pushMessage(("Tower Says: "+ this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id +")" + " Unregistered from  weather tower"));
        }

    }

    public void registerTower(WeatherTower weatherTower) {
        MessageLog.pushMessage(("Tower Says: "+ this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id +")" + " Registered to weather tower"));
        this.weatherTower = weatherTower;
        weatherTower.register(this);

    }


}

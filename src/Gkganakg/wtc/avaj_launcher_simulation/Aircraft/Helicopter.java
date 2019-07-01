package Gkganakg.wtc.avaj_launcher_simulation.Aircraft;


import Gkganakg.wtc.avaj_launcher_simulation.MessageLog;
import Gkganakg.wtc.avaj_launcher_simulation.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name,coordinates);

    }


    public void updateConditions() {

        String type = weatherTower.getWeather(coordinates);

        switch (type) {
            case "SUN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): Well sunny day today, Soon as we land im going to the beach "));
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): OH here we go again Its raining and the turbulence is too much to handle"));
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): Im going to become disoriented and lose control of the aircraft thi fog is too much"));
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW":
                MessageLog.pushMessage(this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): I cannot see anything outside we have to be careful or we will hit a mountain");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

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



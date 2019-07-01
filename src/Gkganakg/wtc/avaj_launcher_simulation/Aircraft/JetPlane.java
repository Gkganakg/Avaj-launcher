package Gkganakg.wtc.avaj_launcher_simulation.Aircraft;


import Gkganakg.wtc.avaj_launcher_simulation.*;
import Gkganakg.wtc.avaj_launcher_simulation.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;


    JetPlane(String name, Coordinates coordinates){
        super(name,coordinates);

    }

    public void updateConditions()
    {
        String type = weatherTower.getWeather(coordinates);

        switch (type) {
            case "SUN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): Today its clear we can take off as fast as we can "));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break;
            case "RAIN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): I thought today was gonna be a cool windy day but turns out ... it was always gonna rain"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());


                break;
            case "FOG":

                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): We should proceed carefully its not that visible outside"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());

                break;
            case "SNOW":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(47) +"#" + this.name + "(" + this.id + "): We have to head back to base we cannot see anything out here"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);


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
        MessageLog.pushMessage(("Tower Says: "+ this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id +")" + " Registered to weather tower"));
        this.weatherTower = weatherTower;
        weatherTower.register(this);

    }


}


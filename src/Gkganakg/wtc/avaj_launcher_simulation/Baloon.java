package Gkganakg.wtc.avaj_launcher_simulation;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String type = weatherTower.getWeather(coordinates);

        switch (type) {
            case "SUN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): Its too hot we have to hurry up and get to the destination melts"));
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case "RAIN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): Its raining the baloon ill be messed up "));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);


                break;
            case "FOG":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): This shit so hot Take it to the head "));
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): This shit so hot Take it to the head "));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);


                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
            MessageLog.pushMessage(("Tower Says: "+ this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id +")" + " Unregistered from  weather tower"));

        }
    }

    public void registerTower(WeatherTower weatherTower) {
        MessageLog.pushMessage(("Tower Says: "+ this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id +")" + " Registered to weather tower"));
        this.weatherTower = weatherTower;
        weatherTower.register(this);

    }


}

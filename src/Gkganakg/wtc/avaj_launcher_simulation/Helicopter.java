package Gkganakg.wtc.avaj_launcher_simulation;



public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name,coordinates);

    }


    public void updateConditions() {

//
        String type = weatherTower.getWeather(coordinates);

        switch (type) {
            case "SUN":
                MessageLog.pushMessage(MessageLog.getHelicopterMessage(this,"This shit so hot"));
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN":
                MessageLog.pushMessage(MessageLog.getHelicopterMessage(this,"oOH here we go again It fucking raining"));

                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());


                break;
            case "FOG":

                MessageLog.pushMessage(MessageLog.getHelicopterMessage(this,"Requesting to DROP down 1000 meters i cant see shit"));

                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());


                break;
            case "SNOW":
                MessageLog.pushMessage(MessageLog.getHelicopterMessage(this,"Damn its fucking cold in this sghit and the windscreen is fiiled with coldi cannot see shit"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);


                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {

        MessageLog.pushMessage(MessageLog.HelicopterTower(this,"Registered to the tower"));
        weatherTower.register(this);
        this.weatherTower = weatherTower;






    }

}

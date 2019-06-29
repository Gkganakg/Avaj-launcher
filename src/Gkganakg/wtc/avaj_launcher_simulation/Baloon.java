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
                MessageLog.pushMessage(MessageLog.getBaloonMessage(this,"Damn its hot we have to Lan soon else this thing will melt"));
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case "RAIN":
                MessageLog.pushMessage(MessageLog.getBaloonMessage(this,"Its raining lets drop 5 meters down else we womt be able o control the  ballon "));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);


                break;
            case "FOG":
                MessageLog.pushMessage(MessageLog.getBaloonMessage(this,"We have to go Down by few meters maybe by 3m  we cant see well here "));
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW":
                MessageLog.pushMessage(MessageLog.getBaloonMessage(this,"Its snowing again so lets Drop don by 1500 meters "));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);


                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
            MessageLog.pushMessage(MessageLog.BaloonTower(this,"DeRegistered  from the tower"));

        }
    }


    public void registerTower(WeatherTower weatherTower) {
        MessageLog.pushMessage(MessageLog.BaloonTower(this,"Registered to the tower"));
        this.weatherTower = weatherTower;
        weatherTower.register(this);

    }


}

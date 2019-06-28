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
                System.out.println("Sun coordintaes befor : "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
               System.out.println("Sun coordintaes after: "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                break;
            case "RAIN":

                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW":
                System.out.println("Snow coordintaes befor : "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);

                System.out.println("Snow coordintaes after: "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;

                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {

        weatherTower.register(this);
        this.weatherTower = weatherTower;





    }

}

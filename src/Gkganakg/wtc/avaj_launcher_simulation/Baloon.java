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
//                System.out.println("AFA Sun coordintaes befor : "+  coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
//                System.out.println(" AFA Sun coordintaes after: "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            case "FOG":
//                System.out.println(" AFA Snow coordintaes befor : "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
//                System.out.println(" AFA Snow coordintaes after: "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                break;
            case "SNOW":
//                System.out.println(" AFA Snow coordintaes befor : "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);

//                System.out.println(" AFA Snow coordintaes after: "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;

                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
        }
    }


    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);

    }


}

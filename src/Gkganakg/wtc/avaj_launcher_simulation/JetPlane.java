package Gkganakg.wtc.avaj_launcher_simulation;



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
               // System.out.println("JetPlane Sun coordintaes befor : "+  coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
             //   System.out.println(" JetPlane Sun coordintaes after: "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight() + 1, coordinates.getHeight());
                break;
            case "SNOW":
             //   System.out.println(" JetPlane Snow coordintaes befor : "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);

              //  System.out.println(" JetPlane Snow coordintaes after: "+ coordinates.getLongitude() + " "+ coordinates.getLatitude() + " "+ coordinates.getHeight());;

                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
        }
    }


    public void registerTower(WeatherTower weatherTower){

        weatherTower.register(this);
        this.weatherTower = weatherTower;


    }

}


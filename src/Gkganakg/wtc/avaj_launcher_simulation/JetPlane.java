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
                MessageLog.pushMessage(MessageLog.getJetPlaneMessage(this,"Fuck this sun in reflecting on my windshield"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break;
            case "RAIN":
                MessageLog.pushMessage(MessageLog.getJetPlaneMessage(this,"Its raining  hope they did plough crops at home if not hunger will kill us"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());


                break;
            case "FOG":

                MessageLog.pushMessage(MessageLog.getJetPlaneMessage(this,"We should be careful or we will end up colliding with other planes"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());

                break;
            case "SNOW":
                MessageLog.pushMessage(MessageLog.getJetPlaneMessage(this,"Remmber last time it snowed charlie brown iii was trying to fly a kite"));

                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);


                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
            MessageLog.pushMessage(MessageLog.JetPlaneTower(this,"deRegistered FROM the tower"));

        }
    }


    public void registerTower(WeatherTower weatherTower){
        MessageLog.pushMessage(MessageLog.JetPlaneTower(this,"Registered to the tower"));

        weatherTower.register(this);
        this.weatherTower = weatherTower;


    }

}


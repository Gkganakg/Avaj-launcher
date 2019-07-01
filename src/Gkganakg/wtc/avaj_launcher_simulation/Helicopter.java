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
                MessageLog.pushMessage((this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): This shit so hot Take it to the head "));
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): oOH here we go again It fucking raining "));
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG":
                MessageLog.pushMessage((this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): Requesting to DROP down 1000 meters i cant see shit"));
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW":
                MessageLog.pushMessage(this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id + "): Damn its fucking cold in this shit and the windscreen is filled with cold i cannot see shit");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
            default:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregistered(this);
            MessageLog.pushMessage(("Tower Says:"+ this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id +")" + "  Unregistered from  weather tower"));


        }
    }

    public void registerTower(WeatherTower weatherTower) {

        MessageLog.pushMessage(("Tower Says: "+ this.getClass().getTypeName().substring(38) +"#" + this.name + "(" + this.id +")" + " Registered to weather tower"));
        weatherTower.register(this);
        this.weatherTower = weatherTower;






    }

}

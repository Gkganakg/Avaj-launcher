package Gkganakg.wtc.avaj_launcher_simulation;



public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name,coordinates);

    }

    @Override
    public void updateConditions() {


    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Added new "+ this.id);





    }

}

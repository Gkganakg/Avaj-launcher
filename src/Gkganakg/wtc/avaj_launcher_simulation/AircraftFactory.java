package Gkganakg.wtc.avaj_launcher_simulation;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Flyable aircraft;

        if(latitude < 0 || longitude < 0){
            throw new IllegalArgumentException("Longitude and Latitude cannot be less yhan Zero");
        }
        switch (type){
            case "Baloon":
                aircraft = new Baloon(name,new Coordinates(latitude,latitude,height));
                break;

            case "JetPlane":
                aircraft = new JetPlane(name,new Coordinates(latitude,latitude,height));
                break;
            case "Helicopter":
                aircraft = new Helicopter(name,new Coordinates(latitude,latitude,height));
                break;
            default:
                throw new IllegalArgumentException("Type of Aircraft does not Exist!!");
        }
        return aircraft;
    }
}
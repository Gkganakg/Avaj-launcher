package Gkganakg.wtc.avaj_launcher_simulation.Aircraft;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Flyable aircraft;

        if(latitude < 0 || longitude < 0){
            throw new IllegalArgumentException("Longitude and Latitude cannot be less yhan Zero");
        }
        switch (type){
            case "Baloon":
                aircraft = new Baloon(name,new Coordinates(longitude,latitude,height));
                return aircraft;

            case "JetPlane":
                aircraft = new JetPlane(name,new Coordinates(longitude,latitude,height));
                return aircraft;
            case "Helicopter":
                aircraft = new Helicopter(name,new Coordinates(longitude,latitude,height));
                return aircraft;
            default:
                return null;
        }

    }
}
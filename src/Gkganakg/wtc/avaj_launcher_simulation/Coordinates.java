package Gkganakg.wtc.avaj_launcher_simulation;


public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;


    Coordinates(int longitude, int latitude, int height){
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public int getLongitude() {

        return longitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {

        return latitude;
    }
}
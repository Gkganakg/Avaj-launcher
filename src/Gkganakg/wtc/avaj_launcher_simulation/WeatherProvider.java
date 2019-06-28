package Gkganakg.wtc.avaj_launcher_simulation;


import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN","FOG","SNOW", "RAIN"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){


        Random indexer = new Random();
        int index = indexer.nextInt(4);
        return this.weather[index];
    }

}


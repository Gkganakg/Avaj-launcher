package Gkganakg.wtc.avaj_launcher_simulation;
import java.io.BufferedReader;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyable = new ArrayList<>();
    AircraftFactory aircraftFactory = new AircraftFactory();

    public  void main(String[] args) throws Exception {
        try {
            File file = new File(args[0]);
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);

            int simulations = checkNumber(buffer.readLine(),"Simulation Number");

            Flyable flyable;
            String line;
            String splitLine[];

            while((line = buffer.readLine()) != null){
                splitLine = line.split(" ");
                flyable = aircraftFactory.newAircraft(splitLine[0],splitLine[1],checkNumber(splitLine[2],"longitude"),checkNumber(splitLine[3],"latitide"),checkNumber(splitLine[4],"Height"));
                flyable.registerTower(weatherTower);
            }
            for (int i = 0; i <= simulations; i++){
                weatherTower.changeWeather();
            }


        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());

        }


    }


    private static int checkNumber(String line,String name) throws InvalidNumberException  {
        int number;
        try {
            number = Integer.parseInt(line);
            if (number < 0){
                throw new  InvalidNumberException("Invalid number of : "+name + " should be a Positive number");
            }
        }
        catch(NumberFormatException e){
            throw  new InvalidNumberException("Invalid type provided : "+name + " Should provide a Integer number ");

        }

        return number;
    }
}
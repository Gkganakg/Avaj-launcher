package Gkganakg.wtc.avaj_launcher_simulation;
import java.io.BufferedReader;


import java.io.*;


public class Simulator {



    public  static  void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();

        if (args.length == 1) {
            try {
                File file = new File(args[0]);
                if(file.length()== 0){
                    throw new Exception("The file is empty");
                }

                FileReader fileReader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(fileReader);


                int simulations = checkNumber(buffer.readLine(),"Simulation Number");

                Flyable flyable;
                String line;
                String splitLine[];

                while((line = buffer.readLine()) != null){
                    splitLine = line.split(" ");
                    if (splitLine.length != 5) {
                        throw new Exception("5 parameters needed");
                    }
                    if (splitLine[0].toLowerCase().equals("jetplane") || splitLine[0].toLowerCase().equals("helicopter") || splitLine[0].toLowerCase().equals("baloon")) {
                        flyable = AircraftFactory.newAircraft(splitLine[0],splitLine[1],checkNumber(splitLine[2],"longitude"),checkNumber(splitLine[3],"latitide"),checkNumber(splitLine[4],"Height"));
                        flyable.registerTower(weatherTower);
                    } else  {
                        throw new Exception("Type does not exist");
                    }
                }
                for (int i = 0; i <= simulations; i++){
                    weatherTower.changeWeather();
                    MessageLog.DisplayMessages();
                }
                buffer.close();
            } catch (Exception e ) {
                //e.getMessage();
                //e.printStackTrace();
                System.out.println("ERROR: " + e.getMessage());

            }
        } else {
            System.out.println("File not found!");
        }
    }


    private static int checkNumber(String line,String name) throws InvalidNumberException  {
        int number;
        try {
            number = Integer.parseInt(line);
            if (number < 0){
                throw new  InvalidNumberException(name + " : should be a Positive number");
            }
        }
        catch(NumberFormatException e){
            throw  new InvalidNumberException(name + " : Should provide an Integer number ");

        }

        return number;
    }
}
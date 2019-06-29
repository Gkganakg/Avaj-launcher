package Gkganakg.wtc.avaj_launcher_simulation;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.*;


public class MessageLog {
    private static List<String> messages = new ArrayList<>();

    public static String getHelicopterMessage(Helicopter flyable, String info) {
        return (flyable.getClass().getTypeName().substring(38) +"#" + flyable.name + "(" + flyable.id + "): " + info);


    }
    public static String getJetPlaneMessage(JetPlane flyable, String info) {
        return ( flyable.getClass().getTypeName().substring(38) +"#" + flyable.name + "(" + flyable.id + "): " + info);
    }

    public static String getBaloonMessage(Baloon flyable, String info) {
        return ( flyable.getClass().getTypeName().substring(38) +"#" + flyable.name + "(" + flyable.id + "): " + info);
    }

    public static String BaloonTower(Baloon flyable, String info) {
        return ("Tower says: " +flyable.getClass().getTypeName().substring(38) +"#" + flyable.name + "(" + flyable.id + "): " + info);
    }
    public static String HelicopterTower(Helicopter flyable, String info) {
        return ("Tower says: " +flyable.getClass().getTypeName().substring(38) +"#" + flyable.name + "(" + flyable.id + "): " + info);
    }
    public static String JetPlaneTower(JetPlane flyable, String info) {
        return ("Tower says: " +flyable.getClass().getTypeName().substring(38) +"#" + flyable.name + "(" + flyable.id + "): " + info);
    }

    public static void pushMessage(String message) {
        messages.add(message);
    }
    public static void DisplayMessages() {
        try {
            PrintWriter writer = new PrintWriter("simulation.txt", "UTF-8");
            for (int i = 0; i < messages.size(); i++)
                writer.println(messages.get(i));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


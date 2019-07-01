package Gkganakg.wtc.avaj_launcher_simulation;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.*;


public class MessageLog {
    private static List<String> messages = new ArrayList<>();

    public static void pushMessage(String message) {
        messages.add(message);
    }

    public static void DisplayMessages() {
        try {
            if(messages.size() != 0) {
                PrintWriter writer = new PrintWriter("simulation.txt", "UTF-8");
                for (int i = 0; i < messages.size(); i++)
                    writer.println(messages.get(i));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


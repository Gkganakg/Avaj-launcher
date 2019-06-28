package Gkganakg.wtc.avaj_launcher_simulation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MessageLog {
    private static List<String> messages = new ArrayList<>();

    public static void pushMessage(String message){
        messages.add(message);
    }

}

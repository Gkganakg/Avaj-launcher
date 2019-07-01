package Gkganakg.wtc.avaj_launcher_simulation.weather;


import Gkganakg.wtc.avaj_launcher_simulation.Aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract  class Tower {
    private static List<Flyable> observers = new ArrayList<>();
    public void register(Flyable flyable){
        observers.add(flyable);

    }
    public void unregistered(Flyable flyable){
        observers.remove(flyable);


    }
    protected void conditionsChanged(){
        for(int i = 0; i< observers.size();i++){
            observers.get(i).updateConditions();
        }

    }



}

package Gkganakg.wtc.avaj_launcher_simulation;


public class Aircraft {
    protected long id;
    protected String name;
    protected  Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates){

    }
    private long nextId() {
        return 1;
    }
    public Aircraft(){}
}





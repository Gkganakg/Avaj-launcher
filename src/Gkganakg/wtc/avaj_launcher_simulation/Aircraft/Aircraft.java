package Gkganakg.wtc.avaj_launcher_simulation.Aircraft;

abstract class   Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates){
       this.name = name;
       this.coordinates = coordinates;
       this.id = nextId();

    }
    private long nextId() {
        return idCounter++;
    }
    public Aircraft(){}
}




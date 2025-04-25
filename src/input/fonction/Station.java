package fonction;

public class Station {
    String nom;
    Cuve[] lc;
    public Cuve[] getLc() {
        return lc;
    }
    public Station(String name,Cuve[] lc){
        nom=name;
        this.lc=lc;
    }
}

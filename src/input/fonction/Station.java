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
    public int get_taille_lc(){
        int i=0;
       while (true) {
        if(lc[i]==null){
            return i;
        }
       }
    }
}

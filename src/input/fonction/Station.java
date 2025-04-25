package fonction;

public class Station {
    String nom;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    Cuve[] lc;
    public void setLc(Cuve[] lc) {
        this.lc = lc;
    }
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
        i++;
       }
    }
    public Station(){
        
    }
}

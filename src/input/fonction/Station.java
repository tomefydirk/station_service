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
    public Carburant get_carburant(String cuve_name){
        int limit=get_taille_lc();
        for(int i=0;i<limit;i++){
            if(lc[i].getNom().equalsIgnoreCase(cuve_name)){
                    return lc[i].getCarb();
            }
        }
        return null;
    }
    public int get_pA(String cuve_name){
        Carburant c=get_carburant(cuve_name);
        if(c==null){
            return 0;
        }else{
            return c.pA;
        }
    }
    public int get_pV(String cuve_name){
        Carburant c=get_carburant(cuve_name);
        if(c==null){
            return 0;
        }else{
            return c.pV;
        }
    }
    public Station(){

    }
}

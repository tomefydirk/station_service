package fonction;
public class Cuve {
    String nom;
    public String getNom() {
        return nom;
    }
    int capacite;
    Carburant carb;
    public Cuve(String nom){
        this.nom=nom;
    }
    public void insert_into(Cuve[] list){
        int i=0;
       while (true) {
            if(list[i]==null){
                list[i]=this;
                break;
            }
            i++;
       }
    }
     
}
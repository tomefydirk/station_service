package fonction;
public class Cuve {
    String nom;
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    int capacite;
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    Carburant carb;
    public Carburant getCarb() {
        return carb;
    }
    public void setCarb(Carburant carb) {
        this.carb = carb;
    }
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
     public Cuve(){
        
     }
}
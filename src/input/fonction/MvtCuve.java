package fonction;

import java.util.Date;

public class MvtCuve {
    Date Mvt;
    public Date getMvt() {
        return Mvt;
    }
    public void setMvt(Date mvt) {
        Mvt = mvt;
    }
    int entree;
    public int getEntree() {
        return entree;
    }
    public void setEntree(int entree) {
        this.entree = entree;
    }
    int sortie;
    public int getSortie() {
        return sortie;
    }
    public void setSortie(int sortie) {
        this.sortie = sortie;
    }
    Cuve c;
    public Cuve getC() {
        return c;
    }
    public void setC(Cuve c) {
        this.c = c;
    }  
}

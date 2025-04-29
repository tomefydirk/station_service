package fonction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lecture.FLoader;

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
    public static MvtCuve from_row(String[] row,Station s){
        MvtCuve retour=new MvtCuve();
        retour.Mvt=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = formatter.parse(row[1].trim());
            System.out.println("Date parsée : " + date);
        } catch (ParseException e) {
            System.out.println("Erreur de parsing : " + e.getMessage());
        }

        retour.c=s.get_cuve(row[0]);
        retour.entree=Integer.parseInt(row[2]);
        retour.entree=Integer.parseInt(row[3]);
        return retour;
    }
   public static MvtCuve[] from_donnee(String input,Station s){
       
        String[][] donnee=FLoader.get_all_data(input);
        MvtCuve[] retour=new MvtCuve[donnee.length];
        for(int i=0;i<donnee.length;i++){
            retour[i]=from_row(donnee[i],s);
        }   
            return retour;
    } 
}

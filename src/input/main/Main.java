package main;

import aff.Mafenetre;
import fonction.Cuve;
import fonction.Station;

public class Main {
            public static void main(String[] args) throws Exception{

                Cuve c1=new Cuve("A");
                Cuve c2=new Cuve("B");
                Cuve c3=new Cuve("C");
                Cuve[] lc=new Cuve[4];
                c1.insert_into(lc);
                c2.insert_into(lc);
                c3.insert_into(lc);
                Station s=new Station("nom", lc);
                        Mafenetre a=new Mafenetre(s);        
                        a.make_success();
            }
}

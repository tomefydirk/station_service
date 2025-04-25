package main;

import aff.Mafenetre;

public class Main {
            public static String file_path(String file){
                return "/home/tomefy/Documents/prog/java/station_service/save/info_station/"+file+".txt";
            } 
            public static void main(String[] args) throws Exception{

                        Mafenetre a=new Mafenetre("total");        
                        a.make_success();
            }
}

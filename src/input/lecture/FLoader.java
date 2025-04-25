package lecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import fonction.Cuve;

public class FLoader {
     //-where return::String{
        public static String enlever(String phrase,String regex){
            return phrase.replaceAll(regex,"");
        }
        //get_path<Real>{
        public static String path_saved(String a){
            String contenu="";
            try {
                 contenu = Files.readString(Path.of("/home/tomefy/Documents/prog/java/station_service/save/"+a+".txt"));
               // System.out.println(contenu);
                return contenu;
            } catch (IOException e) {
                e.printStackTrace();
            }
          
            return "/home/tomefy/Documents/prog/java/station_service/save/default_save.txt";
        }
        // }
    //}
    
    //-where return::String[]{
        public static String[] decomp_block(String phrase,String regex){
            String[] s=phrase.split(regex);
            for(int i=0;i<s.length;i++){
                s[i]=s[i].trim();
                s[i]=s[i].replaceAll("\n", "");
            }
            return s;
        }
        public static String[] separation_par_break(String input){
            String[] block=decomp_block(input.trim(),"break;");
            for(int i=0;i<block.length;i++){
             block[i]=block[i].trim();
            }
            return block;
         }
         // }
         public static int count_data(String input){
            return separation_par_break(input).length;
         }
         public static String[] get_row(String input_line){
            input_line=input_line.trim();
            String[] perm=new String[4];
          
            perm=FLoader.decomp_block(input_line,";");
           
            perm[0]=FLoader.enlever(perm[0], "Date :");
            perm[1]=FLoader.enlever(perm[1], "Entrée :");
            perm[2]=FLoader.enlever(perm[2], "Sortie :");
            perm[3]=FLoader.enlever(perm[3], "Cuve :");
         

            /*---arrangement de l'affichage--*/
            String[] retour=new String[4];
            retour[0]=perm[3];
            retour[1]=perm[0];
            retour[2]=perm[1];
            retour[3]=perm[2];
           // debug(retour);
            return retour;
         }
         public static void debug(String[][] a){
                for(int i=0;i<a.length;i++){
                    for(int j=0;j<a[i].length;j++){
                        System.out.println(a[i][j]);
                    }
                    System.out.println("--->");

                }
         }
         public static void debug(String[] a){
            for(int j=0;j<a.length;j++){
                System.out.print("index "+j +" => ");
                System.out.println(a[j]);
            }
         }
         public static String[][] get_all_data(String input){
                int limit=count_data(input);
                String[][] donnee=new String[limit][];
                String[]a=separation_par_break(input);
               //FLoader.debug(a);
                for(int i=0;i<limit;i++){

                   donnee[i]=get_row(a[i]);
                }
             FLoader.debug(donnee);
                return donnee;
         }
         public static int get_somme_entree(String cuve_name,String[][] donnee){
            int retour=0;
            for(int i=0;i<donnee.length;i++){
                if(donnee[i][0].equalsIgnoreCase(cuve_name)){
                        retour+=Integer.parseInt(donnee[i][2]);
                }
            }
            return retour;
         }
         public static int get_somme_sortie(String cuve_name,String[][] donnee){
            int retour=0;
            for(int i=0;i<donnee.length;i++){
                if(donnee[i][0].equalsIgnoreCase(cuve_name)){
                        retour+=Integer.parseInt(donnee[i][3]);
                }
            }
            return retour;
         }
         public static int get_reste(String cuve_name,String[][] donnee){
            return get_somme_entree(cuve_name, donnee)-get_somme_sortie(cuve_name, donnee);
         }
         public static String[][] get_data_by_cuve(String[][] donnee,Cuve[] lc,int taille){
            String[][] retour=new String[taille][4];
            for(int i=0;i<taille;i++){
                retour[i][0]=lc[i].getNom();
                retour[i][1]=""+get_somme_entree(lc[i].getNom(), donnee);
                retour[i][2]=""+get_somme_sortie(lc[i].getNom(), donnee);
                retour[i][3]=""+get_reste(lc[i].getNom(), donnee);
            }
            return retour;
         }
         public static String[][] get_data_finance(String[][] donnee,Cuve[] lc,int taille){
            String[][] perm=get_data_by_cuve(donnee, lc, taille);
            String[][] retour=new String[taille][4];
            for(int i=0;i<taille;i++){
                retour[i][0]=perm[i][0];
                
                //---sortie et benef
                int a=Integer.parseInt(perm[i][2])*lc[i].getCarb().getpA();
                int s=Integer.parseInt(perm[i][2])*lc[i].getCarb().getpV();//sortie
                int b=s-a;//benef
                //---

                //--entree
                int e=Integer.parseInt(perm[i][1])*lc[i].getCarb().getpA();
                retour[i][1]=""+e;
                retour[i][2]=""+s;
                retour[i][3]=""+b;
            }
            return retour;
         }
         public static void main(String[] args){
            System.out.println("\n");
          /*   String [][] a=get_all_data("Date :blabla;\n" + //
                                "Entrée :0;\n" + //
                                "Sortie :0;\n" + //
                                "Cuve :1;\n" + //
                                "break;\n\n" + //
                                "Date :Bogosy;\n" + //
                                "Entrée :100;\n" + //
                                "Sortie :10;\n" + //
                                "Cuve :11;\n" + //
                                "break;\n" + //
                                "");*/
        
         }
}
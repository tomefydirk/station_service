package lecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
            String[] retour=new String[4];
          
            retour=FLoader.decomp_block(input_line,";");
           
            retour[0]=FLoader.enlever(retour[0], "Date :");
            retour[1]=FLoader.enlever(retour[1], "Entrée :");
            retour[2]=FLoader.enlever(retour[2], "Sortie :");
            retour[3]=FLoader.enlever(retour[3], "Cuve :");
         
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
         public static void main(String[] args){
            System.out.println("\n");
            String [][] a=get_all_data("Date :blabla;\n" + //
                                "Entrée :0;\n" + //
                                "Sortie :0;\n" + //
                                "Cuve :1;\n" + //
                                "break;\n\n" + //
                                "Date :Bogosy;\n" + //
                                "Entrée :100;\n" + //
                                "Sortie :10;\n" + //
                                "Cuve :11;\n" + //
                                "break;\n" + //
                                "");
         }
}
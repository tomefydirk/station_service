package lecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FLoader {
     //-where return::String{
        public static String enlever(String phrase,String regex){
            return phrase.replaceAll(regex,"");
        }
        public static String piece_as_string(String value){
            return value.replaceAll("Piece :","").trim();
        }
        public static String position_as_string(String value){
            return value.replaceAll("Position :","").trim();
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
    
}
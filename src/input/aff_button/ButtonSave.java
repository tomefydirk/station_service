package aff_button;

import javax.swing.JButton;

public class ButtonSave extends JButton{
    String val="";
    String init_field(String field_name,String input){
        String retour=new String("");
        retour+=field_name;
        retour+=" :";
        retour+=input;
        retour+=";\n";
        return retour;
    }
    void add_break(){
        val+="break;\n";
    }
    public ButtonSave(String[] input){
        super("Save 💾");
        addActionListener(_->{
            val="";
            val+=init_field("Date",input[0]);
            val+=init_field("Entrée",input[1]);
            val+=init_field("Sortie",input[2]);
            val+=init_field("Cuve",input[4]);
            
        });
    }
}
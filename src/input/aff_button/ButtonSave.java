package aff_button;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import aff.Formulaire;

public class ButtonSave extends JButton{
    String val="";
    void make_success(){
         
         ImageIcon icon = new ImageIcon(getClass().getResource("/img/util/chill.png"));

       
        JLabel imageLabel = new JLabel(icon);

        JLabel textLabel = new JLabel("La partie a été sauvegardé");
      

        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
        panel.add(textLabel);
        panel.add(imageLabel);

        
        JOptionPane.showMessageDialog(null, panel, "Enregistré", JOptionPane.INFORMATION_MESSAGE);
    } 
    String init_field(String field_name,String input){
        String retour=new String("");
        retour+=field_name;
        retour+=" :";
        retour+=input;
        retour+=";\n";
        return retour;
    }
    void add_break(){
        val+="break;\n\n";
    }
    public ButtonSave(Formulaire f,JTextField path){
        super("Save 💾");
        addActionListener(_->{
            HashMap<String,String> input=f.field_into_string();
            val="";
            val+=init_field("Date",input.get("Date"));
            val+=init_field("Entrée",input.get("Entrée"));
            val+=init_field("Sortie",input.get("Sortie"));
            val+=init_field("Cuve",input.get("Cuve"));
            add_break();
            System.out.println(val);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tomefy/Documents/prog/java/station_service/save/"+path.getText()+".txt"))) {
            writer.append(val);
            } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde du fichier : " + e.getMessage());
            }
        });
    }
}
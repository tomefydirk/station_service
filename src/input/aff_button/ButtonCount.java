package aff_button;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import aff.MaTable;
import lecture.FLoader;

public class ButtonCount extends JButton{
    String path;
    public void afficher_donnee(String[][]donnee){
            String[] colone={
                "Cuve","Date","Entrée","Sortie"
            };
          
           MaTable mt=new MaTable(donnee,colone);
        JOptionPane.showMessageDialog(null, mt, "Enregistré", JOptionPane.NO_OPTION);
    }
  
    public ButtonCount(JTextField a){
        super("Voir les comptes 📥");
        setBackground(new Color(240, 0, 0));
        addActionListener(_->{
            String[][]donne=FLoader.get_all_data(FLoader.path_saved(a.getText()));
            afficher_donnee(donne);
        });
    }
}

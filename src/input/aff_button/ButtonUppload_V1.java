package aff_button;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import aff.Formulaire;
import aff.MaTable;
import lecture.FLoader;

public class ButtonUppload_V1 extends JButton{
    String path;
    public void afficher_donnee(String[][]donnee){
            String[] colone={
                "Cuve","Date","Entrée","Sortie"
            };
          
           MaTable mt=new MaTable(donnee,colone);
        JOptionPane.showMessageDialog(null, mt, "Enregistré", JOptionPane.NO_OPTION);
    }
  
    public ButtonUppload_V1(Formulaire f,JTextField a){
        super("Voir les comptes 📥");

        addActionListener(_->{
            String path=FLoader.path_saved(a.getText());
            String[][]donne=FLoader.get_all_data(FLoader.path_saved(a.getText()));
            afficher_donnee(donne);
        });
    }
}

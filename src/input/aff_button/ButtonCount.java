package aff_button;



import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import aff.MaTable;
import lecture.FLoader;

public class ButtonCount extends JButton{

    public void afficher_donnee(String[][]donnee){
            String[] colone={
                "Cuve","Date","Entrée","Sortie"
            };
          
           MaTable mt=new MaTable(donnee,colone);
        JOptionPane.showMessageDialog(null, mt, "Enregistré", JOptionPane.NO_OPTION);
    }
  
    public ButtonCount(JTextField a){
        super("Voir les comptes 📥");
        StyleButton.ajust_color(this);
        addActionListener(_->{
            String path=main.Main.mvt_path(a.getText());
            System.out.println(path);
            if(FLoader.make_condition_parsing(path)){
                String[][]donne=FLoader.get_all_data(FLoader.path_saved(a.getText()));
                afficher_donnee(donne);      
            }
          
        });
    }
}

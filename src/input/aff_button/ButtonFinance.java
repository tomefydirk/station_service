package aff_button;



import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import aff.MaTable;
import fonction.Station;
import lecture.FLoader;
import lecture.FStream;
import main.Main;

public class ButtonFinance extends JButton{
    public void afficher_donnee(String[][]donnee){
        String[] colone={
            "Cuve","Entrée","Sortie","Benefice"
        };
      
       MaTable mt=new MaTable(donnee,colone);
    JOptionPane.showMessageDialog(null, mt, "Situation financière", JOptionPane.NO_OPTION);
}
    public ButtonFinance(JTextField a,String file){
        super("situation financière");
        StyleButton.ajust_color(this);
        addActionListener(_->{
            String path=main.Main.mvt_path(a.getText());
            System.out.println(path);
            if(FLoader.make_condition_parsing(path)){
              String[][]donne=FLoader.get_all_data(FLoader.path_saved(a.getText()));
              Station s=FStream.from_data(Main.file_path(file));
              int taille=s.get_taille_lc();
              System.out.println(taille);
              String [][] s_by_cuve=FLoader.get_data_finance(donne,s.getLc(),taille);
              afficher_donnee(s_by_cuve);}
        });
    }
}

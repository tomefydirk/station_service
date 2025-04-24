package aff;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire extends JPanel{
        JTextField Date;
        JTextField entree;
        JTextField sortie;
        JTextField cuve;
        void make_text_field(String s,JTextField t){
                JPanel p=new JPanel();
                JLabel l =new JLabel(s);
                p.add(l);
                p.add(t);      
                add(p);      
        }
        public Formulaire(){
                   super(); 
                   Date=new JTextField(10);
                   make_text_field("Date", Date);


                   entree=new JTextField(10);
                   make_text_field("Entrée", entree);

                   sortie=new JTextField(10);
                   make_text_field("Sortie", sortie);

                   cuve=new JTextField(10);
                   make_text_field("Cuve", cuve);



        }            
}

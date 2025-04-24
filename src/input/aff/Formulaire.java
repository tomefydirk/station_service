package aff;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
public class Formulaire extends JPanel{
        JTextField Date;
        JTextField entree;
        JTextField sortie;
        JTextField cuve;

        /*------panel------*/
        JPanel A;
        JPanel B;
        /*-------------*/
        void make_text_field(String s,JTextField t){

                JPanel p=new JPanel();
                JLabel l =new JLabel(s);
                p.add(l);
                p.add(t);      
                A.add(p);      
        }
        void init_panel(){
                A=new JPanel();
                B=new JPanel();
        }
        void init_layout(){
                this.setLayout(new GridLayout(2, 0));
                this.add(A);
                this.add(B);
        }    
        void init_text_field(){
                Date=new JTextField(10);
                make_text_field("Date", Date);


                entree=new JTextField(10);
                make_text_field("Entrée", entree);

                sortie=new JTextField(10);
                make_text_field("Sortie", sortie);

                cuve=new JTextField(10);
                make_text_field("Cuve", cuve);
        }   
        public Formulaire(){
                   super(); 
                 
                   init_panel(); 
                   init_text_field();
                   init_layout();


        }            
}

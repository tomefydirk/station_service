package aff;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import aff_util.B_panel;
import fonction.Station;

import java.awt.*;
import java.util.HashMap;
public class Formulaire extends JPanel{
        JTextField date;
        JTextField entree;
        JTextField sortie;
        JTextField cuve;

        JTextField save_line;
        /*------panel------*/
        JPanel A;
        JPanel B;
        /*-------------*/
        Station s;
        void make_text_field(String s,JTextField t){

                JPanel p=new JPanel();
                JLabel l =new JLabel(s);
                p.add(l);
                p.add(t);      
                A.add(p);      
        }
        void init_panel(){
                A=new JPanel();
              //  B=new JPanel();
        }
        void init_layout(){
                this.setLayout(new GridLayout(0, 2));
                this.add(A);
                this.add(B);
        }    
        void init_text_field(){
                A.setLayout(new GridLayout(4,0));
                date=new JTextField(10);
                make_text_field("Date", date);


                entree=new JTextField("0",10);
                make_text_field("Entrée", entree);

                sortie=new JTextField("0",10);
                make_text_field("Sortie", sortie);

                cuve=new JTextField(10);
                make_text_field("Cuve", cuve);
        }

        void init_bouton(String file){
                B=new B_panel(this,file);
        }   
        public  HashMap <String,String> field_into_string(){
                HashMap<String,String>  retour=new HashMap<>();  
                retour.put("Date",date.getText());
                retour.put("Entrée",entree.getText());
                retour.put("Sortie",sortie.getText());
                retour.put("Cuve", cuve.getText());
                System.out.println(retour.size());
                return retour;
        }
        public Formulaire(String file){
                   super(); 
                   init_panel(); 
                   init_text_field();
                   init_bouton(file);
                   init_layout();


        }            
}

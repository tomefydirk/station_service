package aff;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
public class Mafenetre extends JFrame{ 
    MaTable mt;
        void add_table(){
            String[][] donnee={
                {"1","Gerard","rose"},
                {"2","Claude","bleu"},
                {"3","Tony","bleu"},
            };
            String[] colone={
                "id","nom","couleur"
            };
          
            mt=new MaTable(donnee,colone);
            add(mt);
        }
        
        public Mafenetre(){
            super("Station service");
            this.setLayout(new GridLayout(0, 2));
            add(new Formulaire());
            add_table();
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setMinimumSize(new Dimension(1000,1000));
            this.setVisible(true);
          
        }     
        public void make_success(){
            System.out.println("Ma fenetre marche");
        }             
}
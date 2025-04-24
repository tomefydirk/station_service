package aff;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
public class Mafenetre extends JFrame{ 
        void add_table(){
            String[][] donnee={
                {"1","Gerard","bleu"},
                {"2","Claude","bleu"}
            };
            String[] colone={
                "id","nom","couleur"
            };
            JTable tableau=new JTable(donnee,colone);
            JScrollPane sp=new JScrollPane(tableau);
            add(sp);
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
}
package aff;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
public class Mafenetre extends JFrame{ 
  
        
        public Mafenetre(){
            super("Station service");
            this.setLayout(new GridLayout(0, 2));
            add(new Formulaire());
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setMinimumSize(new Dimension(1000,1000));
            this.setVisible(true);
          
        }     
        public void make_success(){
            System.out.println("Ma fenetre marche");
        }             
}
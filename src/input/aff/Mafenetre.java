package aff;
import java.awt.Dimension;

import javax.swing.*;
public class Mafenetre extends JFrame{ 
        public Mafenetre(){
            super("Station service");
            add(new Formulaire());
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setMinimumSize(new Dimension(1000,1000));
            this.setVisible(true);
          
        }                  
}
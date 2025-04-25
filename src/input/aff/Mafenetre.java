package aff;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
public class Mafenetre extends JFrame{ 
  
        void make_image(){
            JPanel p=new JPanel();
            p.setLayout(new GridLayout(2, 0));
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/station_service.png"));

           
            JLabel label = new JLabel(imageIcon);
            p.add(label);
            add(p);
        }
        public Mafenetre(){
            super("Station service");
            this.setLayout(new GridLayout(0, 2));
            add(new Formulaire());
            make_image();
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setMinimumSize(new Dimension(1000,1000));
            this.setVisible(true);
          
        }     
        public void make_success(){
            System.out.println("Ma fenetre marche");
        }             
}
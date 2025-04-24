package aff;
import javax.swing.*;
public class Mafenetre extends JFrame{ 
        public Mafenetre(){
            super("Station service");
            add(new Formulaire());
            setVisible(true);
        }                  
}
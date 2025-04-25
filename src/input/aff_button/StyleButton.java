package aff_button;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JButton;

public class StyleButton {
    public static void ajust_color(JButton b){
        b.setForeground(Color.WHITE); 
        b.setBackground(new Color(128, 0, 32)); 
        Dimension taille = b.getPreferredSize();
        b.setPreferredSize(new Dimension(200, taille.height));
       
    }
}

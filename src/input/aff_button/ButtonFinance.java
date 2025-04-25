package aff_button;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonFinance extends JButton{
    public ButtonFinance(JTextField a){
        super("Situtation financière");
        setForeground(Color.WHITE); 
        setBackground(new Color(240, 0, 0,150));
    }
}

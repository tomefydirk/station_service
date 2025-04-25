package aff_button;



import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonFinance extends JButton{
    public ButtonFinance(JTextField a){
        super("Situtation financière");
        StyleButton.ajust_color(this);
    }
}

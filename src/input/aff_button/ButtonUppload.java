package aff_button;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;


import aff.Mafenetre;
import lecture.FLoader;

public class ButtonUppload extends JButton{
    String path;
    public ButtonUppload(JTextField a,Mafenetre m){
        super("Upload 📥");

        addActionListener(_->{
            String path=FLoader.path_saved(a.getText());

        });
    }
}
